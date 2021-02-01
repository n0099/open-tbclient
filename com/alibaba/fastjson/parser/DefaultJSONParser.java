package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.common.others.IStringUtil;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    static {
        for (Class<?> cls : new Class[]{Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class}) {
            primitiveClasses.add(cls);
        }
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public String getInput() {
        return this.input instanceof char[] ? new String((char[]) this.input) : this.input.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [592=10] */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0277, code lost:
        r10.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0282, code lost:
        if (r10.token() != 13) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0284, code lost:
        r10.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x028a, code lost:
        r1 = r13.config.getDeserializer(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0292, code lost:
        if ((r1 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0294, code lost:
        r1 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r1;
        r5 = r1.createInstance(r13, r6);
        r8 = r2.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02a6, code lost:
        if (r8.hasNext() == false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02a8, code lost:
        r2 = (java.util.Map.Entry) r8.next();
        r3 = r2.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02b4, code lost:
        if ((r3 instanceof java.lang.String) == false) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02b6, code lost:
        r3 = r1.getFieldDeserializer((java.lang.String) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02bc, code lost:
        if (r3 == null) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02be, code lost:
        r3.setValue(r5, r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02c6, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02cf, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02d0, code lost:
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02d1, code lost:
        if (r1 != null) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02d5, code lost:
        if (r6 != java.lang.Cloneable.class) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02d7, code lost:
        r1 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02dc, code lost:
        setContext(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02e9, code lost:
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02eb, code lost:
        r1 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02f0, code lost:
        r1 = r6.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02f6, code lost:
        setResolveStatus(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02fb, code lost:
        if (r13.context == null) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02fd, code lost:
        if (r15 == null) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0301, code lost:
        if ((r15 instanceof java.lang.Integer) != false) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0309, code lost:
        if ((r13.context.fieldName instanceof java.lang.Integer) != false) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x030b, code lost:
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0312, code lost:
        if (r14.size() <= 0) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0314, code lost:
        r14 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r14, (java.lang.Class<java.lang.Object>) r6, r13.config);
        parseObject(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0630, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:?, code lost:
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:?, code lost:
        return r13.config.getDeserializer(r6).deserialze(r13, r6, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f9, code lost:
        if (r4 != null) goto L381;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseObject(Map map, Object obj) {
        ParseContext parseContext;
        Object parse;
        boolean z;
        Object obj2;
        Object obj3;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 13) {
            jSONLexer.nextToken();
            return map;
        } else if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + jSONLexer.tokenName() + ", " + jSONLexer.info());
        } else {
            ParseContext parseContext2 = this.context;
            try {
                Map<String, Object> innerMap = map instanceof JSONObject ? ((JSONObject) map).getInnerMap() : map;
                boolean z2 = false;
                while (true) {
                    jSONLexer.skipWhitespace();
                    char current = jSONLexer.getCurrent();
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (current == ',') {
                            jSONLexer.next();
                            jSONLexer.skipWhitespace();
                            current = jSONLexer.getCurrent();
                        }
                    }
                    boolean z3 = false;
                    if (current == '\"') {
                        parse = jSONLexer.scanSymbol(this.symbolTable, '\"');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos() + ", name " + parse);
                        }
                    } else if (current == '}') {
                        jSONLexer.next();
                        jSONLexer.resetStringPosition();
                        jSONLexer.nextToken();
                        if (!z2) {
                            parseContext = (this.context != null && obj == this.context.fieldName && map == this.context.object) ? this.context : setContext(map, obj);
                            setContext(parseContext);
                            return map;
                        }
                        parseContext = parseContext2;
                        setContext(parseContext);
                        return map;
                    } else if (current == '\'') {
                        if (!jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                            throw new JSONException("syntax error");
                        }
                        parse = jSONLexer.scanSymbol(this.symbolTable, '\'');
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + jSONLexer.pos());
                        }
                    } else if (current == 26) {
                        throw new JSONException("syntax error");
                    } else {
                        if (current == ',') {
                            throw new JSONException("syntax error");
                        }
                        if ((current >= '0' && current <= '9') || current == '-') {
                            jSONLexer.resetStringPosition();
                            jSONLexer.scanNumber();
                            try {
                                Object integerValue = jSONLexer.token() == 2 ? jSONLexer.integerValue() : jSONLexer.decimalValue(true);
                                if (jSONLexer.getCurrent() != ':') {
                                    throw new JSONException("parse number key error" + jSONLexer.info());
                                }
                                parse = integerValue;
                            } catch (NumberFormatException e) {
                                throw new JSONException("parse number key error" + jSONLexer.info());
                            }
                        } else if (current == '{' || current == '[') {
                            jSONLexer.nextToken();
                            parse = parse();
                            z3 = true;
                        } else if (!jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                            throw new JSONException("syntax error");
                        } else {
                            parse = jSONLexer.scanSymbolUnQuoted(this.symbolTable);
                            jSONLexer.skipWhitespace();
                            char current2 = jSONLexer.getCurrent();
                            if (current2 != ':') {
                                throw new JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current2);
                            }
                        }
                    }
                    if (!z3) {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                    }
                    char current3 = jSONLexer.getCurrent();
                    jSONLexer.resetStringPosition();
                    if (parse == JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        String scanSymbol = jSONLexer.scanSymbol(this.symbolTable, '\"');
                        if (!jSONLexer.isEnabled(Feature.IgnoreAutoType)) {
                            Class<?> checkAutoType = (map == null || !map.getClass().getName().equals(scanSymbol)) ? this.config.checkAutoType(scanSymbol, null, jSONLexer.getFeatures()) : map.getClass();
                            if (checkAutoType != null) {
                                break;
                            }
                            innerMap.put(JSON.DEFAULT_TYPE_KEY, scanSymbol);
                        } else {
                            continue;
                        }
                    } else if (parse == "$ref" && parseContext2 != null && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                        jSONLexer.nextToken(4);
                        if (jSONLexer.token() == 4) {
                            String stringVal = jSONLexer.stringVal();
                            jSONLexer.nextToken(13);
                            Object obj4 = null;
                            if ("@".equals(stringVal)) {
                                if (this.context != null) {
                                    ParseContext parseContext3 = this.context;
                                    Object obj5 = parseContext3.object;
                                    if ((obj5 instanceof Object[]) || (obj5 instanceof Collection)) {
                                        obj4 = obj5;
                                    } else if (parseContext3.parent != null) {
                                        obj4 = parseContext3.parent.object;
                                    }
                                    obj3 = obj4;
                                }
                                obj3 = null;
                            } else if (IStringUtil.TOP_PATH.equals(stringVal)) {
                                if (parseContext2.object != null) {
                                    obj3 = parseContext2.object;
                                } else {
                                    addResolveTask(new ResolveTask(parseContext2, stringVal));
                                    setResolveStatus(1);
                                    obj3 = null;
                                }
                            } else if ("$".equals(stringVal)) {
                                ParseContext parseContext4 = parseContext2;
                                while (parseContext4.parent != null) {
                                    parseContext4 = parseContext4.parent;
                                }
                                if (parseContext4.object != null) {
                                    obj4 = parseContext4.object;
                                } else {
                                    addResolveTask(new ResolveTask(parseContext4, stringVal));
                                    setResolveStatus(1);
                                }
                                obj3 = obj4;
                            } else {
                                addResolveTask(new ResolveTask(parseContext2, stringVal));
                                setResolveStatus(1);
                                obj3 = null;
                            }
                            if (jSONLexer.token() != 13) {
                                throw new JSONException("syntax error");
                            }
                            jSONLexer.nextToken(16);
                            return obj3;
                        }
                        throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token()));
                    } else {
                        if (z2) {
                            z = z2;
                        } else if (this.context != null && obj == this.context.fieldName && map == this.context.object) {
                            parseContext2 = this.context;
                            z = z2;
                        } else {
                            ParseContext context = setContext(map, obj);
                            if (parseContext2 == null) {
                                parseContext2 = context;
                            }
                            z = true;
                        }
                        String str = (map.getClass() == JSONObject.class && parse == null) ? "null" : parse;
                        if (current3 == '\"') {
                            jSONLexer.scanString();
                            String stringVal2 = jSONLexer.stringVal();
                            String str2 = stringVal2;
                            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                                JSONScanner jSONScanner = new JSONScanner(stringVal2);
                                Date date = stringVal2;
                                if (jSONScanner.scanISO8601DateIfMatch()) {
                                    date = jSONScanner.getCalendar().getTime();
                                }
                                jSONScanner.close();
                                str2 = date;
                            }
                            innerMap.put(str, str2);
                            obj2 = str2;
                        } else if ((current3 >= '0' && current3 <= '9') || current3 == '-') {
                            jSONLexer.scanNumber();
                            Number integerValue2 = jSONLexer.token() == 2 ? jSONLexer.integerValue() : jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
                            innerMap.put(str, integerValue2);
                            obj2 = integerValue2;
                        } else if (current3 == '[') {
                            jSONLexer.nextToken();
                            Collection jSONArray = new JSONArray();
                            if (obj == null || obj.getClass() == Integer.class) {
                            }
                            if (obj == null) {
                                setContext(parseContext2);
                            }
                            parseArray(jSONArray, str);
                            Object[] objArr = jSONArray;
                            if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                objArr = jSONArray.toArray();
                            }
                            innerMap.put(str, objArr);
                            if (jSONLexer.token() == 13) {
                                jSONLexer.nextToken();
                                return map;
                            } else if (jSONLexer.token() != 16) {
                                throw new JSONException("syntax error");
                            } else {
                                z2 = z;
                            }
                        } else if (current3 == '{') {
                            jSONLexer.nextToken();
                            boolean z4 = obj != null && obj.getClass() == Integer.class;
                            Map jSONObject = new JSONObject(jSONLexer.isEnabled(Feature.OrderedField));
                            ParseContext context2 = !z4 ? setContext(parseContext2, jSONObject, str) : null;
                            Object obj6 = null;
                            boolean z5 = false;
                            if (this.fieldTypeResolver != null) {
                                Type resolve = this.fieldTypeResolver.resolve(map, str != null ? str.toString() : null);
                                if (resolve != null) {
                                    obj6 = this.config.getDeserializer(resolve).deserialze(this, resolve, str);
                                    z5 = true;
                                }
                            }
                            if (!z5) {
                                obj6 = parseObject(jSONObject, str);
                            }
                            if (context2 != null && jSONObject != obj6) {
                                context2.object = map;
                            }
                            if (str != null) {
                                checkMapResolve(map, str.toString());
                            }
                            innerMap.put(str, obj6);
                            if (z4) {
                                setContext(obj6, str);
                            }
                            if (jSONLexer.token() == 13) {
                                jSONLexer.nextToken();
                                setContext(parseContext2);
                                return map;
                            } else if (jSONLexer.token() != 16) {
                                throw new JSONException("syntax error, " + jSONLexer.tokenName());
                            } else {
                                if (z4) {
                                    popContext();
                                    z2 = z;
                                } else {
                                    setContext(parseContext2);
                                    z2 = z;
                                }
                            }
                        } else {
                            jSONLexer.nextToken();
                            innerMap.put(str, parse());
                            if (jSONLexer.token() == 13) {
                                jSONLexer.nextToken();
                                return map;
                            } else if (jSONLexer.token() != 16) {
                                throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + str);
                            } else {
                                z2 = z;
                            }
                        }
                        jSONLexer.skipWhitespace();
                        char current4 = jSONLexer.getCurrent();
                        if (current4 != ',') {
                            if (current4 == '}') {
                                jSONLexer.next();
                                jSONLexer.resetStringPosition();
                                jSONLexer.nextToken();
                                setContext(obj2, str);
                                return map;
                            }
                            throw new JSONException("syntax error, position at " + jSONLexer.pos() + ", name " + str);
                        }
                        jSONLexer.next();
                        z2 = z;
                    }
                }
            } finally {
                setContext(parseContext2);
            }
        }
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            } else if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        Object deserialze;
        String obj2;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i != 14) {
            throw new JSONException("exepct '[', but " + JSONToken.name(i) + ", " + this.lexer.info());
        }
        if (Integer.TYPE == type) {
            deserializer = IntegerCodec.instance;
            this.lexer.nextToken(2);
        } else if (String.class == type) {
            deserializer = StringCodec.instance;
            this.lexer.nextToken(4);
        } else {
            deserializer = this.config.getDeserializer(type);
            this.lexer.nextToken(deserializer.getFastMatchToken());
        }
        ParseContext parseContext = this.context;
        setContext(collection, obj);
        int i2 = 0;
        while (true) {
            try {
                if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (this.lexer.token() == 16) {
                        this.lexer.nextToken();
                    }
                }
                if (this.lexer.token() != 15) {
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    } else if (String.class == type) {
                        if (this.lexer.token() == 4) {
                            obj2 = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object parse = parse();
                            obj2 = parse == null ? null : parse.toString();
                        }
                        collection.add(obj2);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                            deserialze = null;
                        } else {
                            deserialze = deserializer.deserialze(this, type, Integer.valueOf(i2));
                        }
                        collection.add(deserialze);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i2++;
                } else {
                    setContext(parseContext);
                    this.lexer.nextToken(16);
                    return;
                }
            } catch (Throwable th) {
                setContext(parseContext);
                throw th;
            }
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        } else if (this.lexer.token() != 14) {
            throw new JSONException("syntax error : " + this.lexer.tokenName());
        } else {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() != 15) {
                    throw new JSONException("syntax error");
                }
                this.lexer.nextToken(16);
                return new Object[0];
            }
            this.lexer.nextToken(2);
            for (int i = 0; i < typeArr.length; i++) {
                if (this.lexer.token() == 8) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (this.lexer.token() == 2) {
                            cast = Integer.valueOf(this.lexer.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            cast = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type == String.class) {
                        if (this.lexer.token() == 4) {
                            cast = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            cast = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else {
                        if (i == typeArr.length - 1 && (type instanceof Class)) {
                            Class cls2 = (Class) type;
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        } else {
                            cls = null;
                            z = false;
                        }
                        if (z && this.lexer.token() != 14) {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            int fastMatchToken = deserializer.getFastMatchToken();
                            if (this.lexer.token() != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, null));
                                    if (this.lexer.token() != 16) {
                                        break;
                                    }
                                    this.lexer.nextToken(fastMatchToken);
                                }
                                if (this.lexer.token() != 15) {
                                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                }
                            }
                            cast = TypeUtils.cast(arrayList, type, this.config);
                        } else {
                            cast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i));
                        }
                    }
                }
                objArr[i] = cast;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() != 16) {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                } else {
                    if (i == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                }
            }
            if (this.lexer.token() != 15) {
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(16);
            return objArr;
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                if (!this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
                this.lexer.nextTokenWithColon();
                parse();
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken();
                    return;
                }
            } else {
                Class<?> cls2 = fieldDeserializer.fieldInfo.fieldClass;
                Type type = fieldDeserializer.fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    deserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class) type2, (Collection) arrayList);
            return arrayList;
        } else if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (Object.class.equals(type3)) {
                if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                }
                throw new JSONException("not support type : " + type);
            }
            ArrayList arrayList2 = new ArrayList();
            parseArray((Class) type3, (Collection) arrayList2);
            return arrayList2;
        } else {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length != 1) {
                    throw new JSONException("not support : " + typeVariable);
                }
                Type type4 = bounds[0];
                if (type4 instanceof Class) {
                    ArrayList arrayList3 = new ArrayList();
                    parseArray((Class) type4, (Collection) arrayList3);
                    return arrayList3;
                }
            }
            if (type2 instanceof ParameterizedType) {
                ArrayList arrayList4 = new ArrayList();
                parseArray((ParameterizedType) type2, arrayList4);
                return arrayList4;
            }
            throw new JSONException("TODO : " + type);
        }
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        }
        if (str.equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken();
                return;
            }
            return;
        }
        throw new JSONException("type not match error");
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (collection instanceof List) {
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Boolean] */
    public final void parseArray(Collection collection, Object obj) {
        Object[] objArr;
        Number number;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() != 14) {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
        jSONLexer.nextToken(4);
        ParseContext parseContext = this.context;
        setContext(collection, obj);
        int i = 0;
        while (true) {
            try {
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (jSONLexer.token() == 16) {
                        jSONLexer.nextToken();
                    }
                }
                switch (jSONLexer.token()) {
                    case 2:
                        Number integerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        objArr = integerValue;
                        break;
                    case 3:
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            number = jSONLexer.decimalValue(true);
                        } else {
                            number = jSONLexer.decimalValue(false);
                        }
                        jSONLexer.nextToken(16);
                        objArr = number;
                        break;
                    case 4:
                        String stringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        objArr = stringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(stringVal);
                            Date date = stringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                date = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            objArr = date;
                            break;
                        }
                        break;
                    case 5:
                    case 9:
                    case 10:
                    case 11:
                    case 13:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 21:
                    case 22:
                    default:
                        objArr = parse();
                        break;
                    case 6:
                        ?? r0 = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        objArr = r0;
                        break;
                    case 7:
                        ?? r02 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        objArr = r02;
                        break;
                    case 8:
                        jSONLexer.nextToken(4);
                        objArr = null;
                        break;
                    case 12:
                        objArr = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                        break;
                    case 14:
                        Collection jSONArray = new JSONArray();
                        parseArray(jSONArray, Integer.valueOf(i));
                        objArr = jSONArray;
                        if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                            objArr = jSONArray.toArray();
                            break;
                        }
                        break;
                    case 15:
                        jSONLexer.nextToken(16);
                        return;
                    case 20:
                        throw new JSONException("unclosed jsonArray");
                    case 23:
                        jSONLexer.nextToken(4);
                        objArr = null;
                        break;
                }
                collection.add(objArr);
                checkListResolve(collection);
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
                i++;
            } finally {
                setContext(parseContext);
            }
        }
    }

    public ParseContext getContext() {
        return this.context;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(this.resolveTaskList.size() - 1);
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = parseContext;
        }
    }

    public void popContext() {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = this.context.parent;
            if (this.contextArrayIndex > 0) {
                this.contextArrayIndex--;
                this.contextArray[this.contextArrayIndex] = null;
            }
        }
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        this.context = new ParseContext(parseContext, obj, obj2);
        addContext(this.context);
        return this.context;
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        if (this.contextArray == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= this.contextArray.length) {
            ParseContext[] parseContextArr = new ParseContext[(this.contextArray.length * 3) / 2];
            System.arraycopy(this.contextArray, 0, parseContextArr, 0, this.contextArray.length);
            this.contextArray = parseContextArr;
        }
        this.contextArray[i] = parseContext;
    }

    public Object parse() {
        return parse(null);
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String stringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return stringVal;
        }
        return parse(null);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        switch (jSONLexer.token()) {
            case 2:
                Number integerValue = jSONLexer.integerValue();
                jSONLexer.nextToken();
                return integerValue;
            case 3:
                Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
                jSONLexer.nextToken();
                return decimalValue;
            case 4:
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                    JSONScanner jSONScanner = new JSONScanner(stringVal);
                    try {
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            return jSONScanner.getCalendar().getTime();
                        }
                        return stringVal;
                    } finally {
                        jSONScanner.close();
                    }
                }
                return stringVal;
            case 5:
            case 10:
            case 11:
            case 13:
            case 15:
            case 16:
            case 17:
            case 19:
            case 24:
            case 25:
            default:
                throw new JSONException("syntax error, " + jSONLexer.info());
            case 6:
                jSONLexer.nextToken();
                return Boolean.TRUE;
            case 7:
                jSONLexer.nextToken();
                return Boolean.FALSE;
            case 8:
                jSONLexer.nextToken();
                return null;
            case 9:
                jSONLexer.nextToken(18);
                if (jSONLexer.token() != 18) {
                    throw new JSONException("syntax error");
                }
                jSONLexer.nextToken(10);
                accept(10);
                long longValue = jSONLexer.integerValue().longValue();
                accept(2);
                accept(11);
                return new Date(longValue);
            case 12:
                return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
            case 14:
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                    return jSONArray.toArray();
                }
                return jSONArray;
            case 18:
                if ("NaN".equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    return null;
                }
                throw new JSONException("syntax error, " + jSONLexer.info());
            case 20:
                if (jSONLexer.isBlankInput()) {
                    return null;
                }
                throw new JSONException("unterminated json string, " + jSONLexer.info());
            case 21:
                jSONLexer.nextToken();
                HashSet hashSet = new HashSet();
                parseArray(hashSet, obj);
                return hashSet;
            case 22:
                jSONLexer.nextToken();
                TreeSet treeSet = new TreeSet();
                parseArray(treeSet, obj);
                return treeSet;
            case 23:
                jSONLexer.nextToken();
                return null;
            case 26:
                byte[] bytesValue = jSONLexer.bytesValue();
                jSONLexer.nextToken();
                return bytesValue;
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        for (int i = 0; i < this.contextArray.length && i < this.contextArrayIndex; i++) {
            ParseContext parseContext = this.contextArray[i];
            if (parseContext.toString().equals(str)) {
                return parseContext.object;
            }
        }
        return null;
    }

    public void handleResovleTask(Object obj) {
        Object obj2;
        if (this.resolveTaskList != null) {
            int size = this.resolveTaskList.size();
            for (int i = 0; i < size; i++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i);
                String str = resolveTask.referenceValue;
                Object obj3 = null;
                if (resolveTask.ownerContext != null) {
                    obj3 = resolveTask.ownerContext.object;
                }
                if (str.startsWith("$")) {
                    obj2 = getObject(str);
                    if (obj2 == null) {
                        try {
                            obj2 = JSONPath.eval(obj, str);
                        } catch (JSONPathException e) {
                        }
                    }
                } else {
                    obj2 = resolveTask.context.object;
                }
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    if (obj2 != null && obj2.getClass() == JSONObject.class && fieldDeserializer.fieldInfo != null && !Map.class.isAssignableFrom(fieldDeserializer.fieldInfo.fieldClass)) {
                        obj2 = JSONPath.eval(this.contextArray[0].object, str);
                    }
                    fieldDeserializer.setValue(obj3, obj2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public void parseExtra(Object obj, String str) {
        Object parseObject;
        this.lexer.nextTokenWithColon();
        Type type = null;
        if (this.extraTypeProviders != null) {
            for (ExtraTypeProvider extraTypeProvider : this.extraTypeProviders) {
                type = extraTypeProvider.getExtraType(obj, str);
            }
        }
        if (type == null) {
            parseObject = parse();
        } else {
            parseObject = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parseObject);
            return;
        }
        if (this.extraProcessors != null) {
            for (ExtraProcessor extraProcessor : this.extraProcessors) {
                extraProcessor.processExtra(obj, str, parseObject);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1709=6] */
    public Object parse(PropertyProcessable propertyProcessable, Object obj) {
        String scanSymbolUnQuoted;
        Object parseObject;
        if (this.lexer.token() != 12) {
            String str = "syntax error, expect {, actual " + this.lexer.tokenName();
            if (obj instanceof String) {
                str = (str + ", fieldName ") + obj;
            }
            String str2 = (str + ", ") + this.lexer.info();
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            if (jSONArray.size() == 1) {
                Object obj2 = jSONArray.get(0);
                if (obj2 instanceof JSONObject) {
                    return (JSONObject) obj2;
                }
            }
            throw new JSONException(str2);
        }
        ParseContext parseContext = this.context;
        int i = 0;
        while (true) {
            try {
                this.lexer.skipWhitespace();
                char current = this.lexer.getCurrent();
                if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current == ',') {
                        this.lexer.next();
                        this.lexer.skipWhitespace();
                        current = this.lexer.getCurrent();
                    }
                }
                if (current == '\"') {
                    scanSymbolUnQuoted = this.lexer.scanSymbol(this.symbolTable, '\"');
                    this.lexer.skipWhitespace();
                    if (this.lexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos());
                    }
                } else if (current == '}') {
                    this.lexer.next();
                    this.lexer.resetStringPosition();
                    this.lexer.nextToken(16);
                    return propertyProcessable;
                } else if (current == '\'') {
                    if (!this.lexer.isEnabled(Feature.AllowSingleQuotes)) {
                        throw new JSONException("syntax error");
                    }
                    scanSymbolUnQuoted = this.lexer.scanSymbol(this.symbolTable, '\'');
                    this.lexer.skipWhitespace();
                    if (this.lexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos());
                    }
                } else if (!this.lexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                    throw new JSONException("syntax error");
                } else {
                    scanSymbolUnQuoted = this.lexer.scanSymbolUnQuoted(this.symbolTable);
                    this.lexer.skipWhitespace();
                    char current2 = this.lexer.getCurrent();
                    if (current2 != ':') {
                        throw new JSONException("expect ':' at " + this.lexer.pos() + ", actual " + current2);
                    }
                }
                String str3 = scanSymbolUnQuoted;
                this.lexer.next();
                this.lexer.skipWhitespace();
                this.lexer.getCurrent();
                this.lexer.resetStringPosition();
                if (str3 != JSON.DEFAULT_TYPE_KEY || this.lexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    this.lexer.nextToken();
                    if (i != 0) {
                        setContext(parseContext);
                    }
                    Type type = propertyProcessable.getType(str3);
                    if (this.lexer.token() == 8) {
                        parseObject = null;
                        this.lexer.nextToken();
                    } else {
                        parseObject = parseObject(type, str3);
                    }
                    propertyProcessable.apply(str3, parseObject);
                    setContext(parseContext, parseObject, str3);
                    setContext(parseContext);
                    int i2 = this.lexer.token();
                    if (i2 == 20 || i2 == 15) {
                        break;
                    } else if (i2 == 13) {
                        this.lexer.nextToken();
                        return propertyProcessable;
                    }
                } else {
                    Class<?> checkAutoType = this.config.checkAutoType(this.lexer.scanSymbol(this.symbolTable, '\"'), null, this.lexer.getFeatures());
                    if (!Map.class.isAssignableFrom(checkAutoType)) {
                        ObjectDeserializer deserializer = this.config.getDeserializer(checkAutoType);
                        this.lexer.nextToken(16);
                        setResolveStatus(2);
                        if (parseContext != null && !(obj instanceof Integer)) {
                            popContext();
                        }
                        return (Map) deserializer.deserialze(this, checkAutoType, obj);
                    }
                    this.lexer.nextToken(16);
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return propertyProcessable;
                    }
                }
                i++;
            } finally {
                setContext(parseContext);
            }
        }
        return propertyProcessable;
    }
}
