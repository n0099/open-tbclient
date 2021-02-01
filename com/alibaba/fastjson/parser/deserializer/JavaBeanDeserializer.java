package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes4.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean));
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        HashMap hashMap = null;
        this.sortedFieldDeserializers = new FieldDeserializer[javaBeanInfo.sortedFields.length];
        int length = javaBeanInfo.sortedFields.length;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            String[] strArr = fieldInfo.alternateNames;
            for (String str : strArr) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        this.fieldDeserializers = new FieldDeserializer[javaBeanInfo.fields.length];
        int length2 = javaBeanInfo.fields.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedFieldDeserializers.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo > 0) {
                length = i2 - 1;
            } else if (isSetFlag(i2, iArr)) {
                return null;
            } else {
                return this.sortedFieldDeserializers[i2];
            }
        }
        if (this.alterNameFieldDeserializers != null) {
            return this.alterNameFieldDeserializers.get(str);
        }
        return null;
    }

    public FieldDeserializer getFieldDeserializer(long j) {
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            for (int i = 0; i < this.sortedFieldDeserializers.length; i++) {
                jArr[i] = TypeUtils.fnv1a_64(this.sortedFieldDeserializers[i].fieldInfo.name);
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            for (int i2 = 0; i2 < this.sortedFieldDeserializers.length; i2++) {
                int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(this.sortedFieldDeserializers[i2].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i2;
                }
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch];
        if (s != -1) {
            return this.sortedFieldDeserializers[s];
        }
        return null;
    }

    static boolean isSetFlag(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i2 = i / 32;
        return i2 < iArr.length && (iArr[i2] & (1 << (i % 32))) != 0;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        FieldInfo[] fieldInfoArr;
        Object obj = null;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        if (this.beanInfo.defaultConstructor == null && this.beanInfo.factoryMethod == null) {
            return null;
        }
        if (this.beanInfo.factoryMethod == null || this.beanInfo.defaultConstructorParameterSize <= 0) {
            try {
                Constructor<?> constructor = this.beanInfo.defaultConstructor;
                if (this.beanInfo.defaultConstructorParameterSize == 0) {
                    if (constructor != null) {
                        newInstance = constructor.newInstance(new Object[0]);
                    } else {
                        newInstance = this.beanInfo.factoryMethod.invoke(null, new Object[0]);
                    }
                } else {
                    ParseContext context = defaultJSONParser.getContext();
                    if (context == null || context.object == null) {
                        throw new JSONException("can't create non-static inner class instance.");
                    }
                    if (type instanceof Class) {
                        String name = ((Class) type).getName();
                        String substring = name.substring(0, name.lastIndexOf(36));
                        Object obj2 = context.object;
                        String name2 = obj2.getClass().getName();
                        if (name2.equals(substring)) {
                            obj = obj2;
                        } else {
                            ParseContext parseContext = context.parent;
                            if (parseContext != null && parseContext.object != null && (("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2)) && parseContext.object.getClass().getName().equals(substring))) {
                                obj = parseContext.object;
                            }
                        }
                        if (obj == null) {
                            throw new JSONException("can't create non-static inner class instance.");
                        }
                        newInstance = constructor.newInstance(obj);
                    } else {
                        throw new JSONException("can't create non-static inner class instance.");
                    }
                }
                if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            try {
                                fieldInfo.set(newInstance, "");
                            } catch (Exception e) {
                                throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                            }
                        }
                    }
                    return newInstance;
                }
                return newInstance;
            } catch (JSONException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
            }
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i, null);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> scanEnum;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 14) {
            throw new JSONException(BdStatsConstant.StatsType.ERROR);
        }
        T t = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i = 0;
        while (i < length) {
            char c = i == length + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
            Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
            if (cls == Integer.TYPE) {
                fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c));
            } else if (cls == String.class) {
                fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c));
            } else if (cls == Long.TYPE) {
                fieldDeserializer.setValue(t, jSONLexer.scanLong(c));
            } else if (cls.isEnum()) {
                char current = jSONLexer.getCurrent();
                if (current == '\"' || current == 'n') {
                    scanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                } else if (current >= '0' && current <= '9') {
                    scanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                } else {
                    scanEnum = scanEnum(jSONLexer, c);
                }
                fieldDeserializer.setValue(t, scanEnum);
            } else if (cls == Boolean.TYPE) {
                fieldDeserializer.setValue(t, jSONLexer.scanBoolean(c));
            } else if (cls == Float.TYPE) {
                fieldDeserializer.setValue(t, Float.valueOf(jSONLexer.scanFloat(c)));
            } else if (cls == Double.TYPE) {
                fieldDeserializer.setValue(t, Double.valueOf(jSONLexer.scanDouble(c)));
            } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                fieldDeserializer.setValue(t, new Date(jSONLexer.scanLong(c)));
            } else if (cls == BigDecimal.class) {
                fieldDeserializer.setValue(t, jSONLexer.scanDecimal(c));
            } else {
                jSONLexer.nextToken(14);
                fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType, fieldDeserializer.fieldInfo.name));
                if (jSONLexer.token() == 15) {
                    break;
                }
                check(jSONLexer, c == ']' ? 15 : 16);
            }
            i++;
        }
        jSONLexer.nextToken(16);
        return t;
    }

    protected void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    protected Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [898=16, 899=12, 901=12] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:498:0x0204 */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x06d7, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r11.token()));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ec A[Catch: all -> 0x04a8, TryCatch #5 {all -> 0x04a8, blocks: (B:99:0x019e, B:101:0x01a7, B:104:0x01bf, B:130:0x0235, B:142:0x026d, B:112:0x01ec, B:114:0x01f6, B:116:0x01fe, B:249:0x0466, B:129:0x022e, B:255:0x0478, B:257:0x0483, B:259:0x0490, B:260:0x0492, B:262:0x049f, B:263:0x04a7, B:288:0x052d, B:266:0x04ab, B:268:0x04b4, B:270:0x04ba, B:271:0x04bd, B:272:0x04cd, B:275:0x04d7, B:277:0x04db, B:278:0x04de, B:280:0x04e2, B:281:0x04e5, B:282:0x04f5, B:285:0x04ff, B:286:0x050f, B:287:0x052c, B:293:0x0548, B:297:0x0554, B:299:0x055f, B:301:0x0574, B:306:0x058c, B:308:0x059b, B:309:0x05b1, B:311:0x05bd, B:313:0x05c1, B:303:0x057e, B:305:0x0586, B:317:0x05d7, B:318:0x05df, B:295:0x0550, B:322:0x05e5, B:324:0x05eb, B:325:0x05f5, B:327:0x05ff, B:145:0x0280, B:150:0x0292, B:152:0x029a, B:155:0x02ad, B:160:0x02c0, B:163:0x02d3, B:168:0x02e6, B:171:0x02f9, B:174:0x0304, B:184:0x0336, B:194:0x0368, B:204:0x039a, B:206:0x03a0, B:209:0x03b2, B:211:0x03bc, B:213:0x03c0, B:217:0x03db, B:222:0x03ec, B:225:0x03ff, B:230:0x0410, B:233:0x0423, B:238:0x0434, B:241:0x0447, B:244:0x0452, B:198:0x0378, B:201:0x038f, B:188:0x0346, B:191:0x035d, B:178:0x0314, B:181:0x032b, B:134:0x0245, B:137:0x025b, B:108:0x01d5, B:126:0x0225), top: B:505:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x05eb A[Catch: all -> 0x04a8, TryCatch #5 {all -> 0x04a8, blocks: (B:99:0x019e, B:101:0x01a7, B:104:0x01bf, B:130:0x0235, B:142:0x026d, B:112:0x01ec, B:114:0x01f6, B:116:0x01fe, B:249:0x0466, B:129:0x022e, B:255:0x0478, B:257:0x0483, B:259:0x0490, B:260:0x0492, B:262:0x049f, B:263:0x04a7, B:288:0x052d, B:266:0x04ab, B:268:0x04b4, B:270:0x04ba, B:271:0x04bd, B:272:0x04cd, B:275:0x04d7, B:277:0x04db, B:278:0x04de, B:280:0x04e2, B:281:0x04e5, B:282:0x04f5, B:285:0x04ff, B:286:0x050f, B:287:0x052c, B:293:0x0548, B:297:0x0554, B:299:0x055f, B:301:0x0574, B:306:0x058c, B:308:0x059b, B:309:0x05b1, B:311:0x05bd, B:313:0x05c1, B:303:0x057e, B:305:0x0586, B:317:0x05d7, B:318:0x05df, B:295:0x0550, B:322:0x05e5, B:324:0x05eb, B:325:0x05f5, B:327:0x05ff, B:145:0x0280, B:150:0x0292, B:152:0x029a, B:155:0x02ad, B:160:0x02c0, B:163:0x02d3, B:168:0x02e6, B:171:0x02f9, B:174:0x0304, B:184:0x0336, B:194:0x0368, B:204:0x039a, B:206:0x03a0, B:209:0x03b2, B:211:0x03bc, B:213:0x03c0, B:217:0x03db, B:222:0x03ec, B:225:0x03ff, B:230:0x0410, B:233:0x0423, B:238:0x0434, B:241:0x0447, B:244:0x0452, B:198:0x0378, B:201:0x038f, B:188:0x0346, B:191:0x035d, B:178:0x0314, B:181:0x032b, B:134:0x0245, B:137:0x025b, B:108:0x01d5, B:126:0x0225), top: B:505:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x05ff A[Catch: all -> 0x04a8, TRY_LEAVE, TryCatch #5 {all -> 0x04a8, blocks: (B:99:0x019e, B:101:0x01a7, B:104:0x01bf, B:130:0x0235, B:142:0x026d, B:112:0x01ec, B:114:0x01f6, B:116:0x01fe, B:249:0x0466, B:129:0x022e, B:255:0x0478, B:257:0x0483, B:259:0x0490, B:260:0x0492, B:262:0x049f, B:263:0x04a7, B:288:0x052d, B:266:0x04ab, B:268:0x04b4, B:270:0x04ba, B:271:0x04bd, B:272:0x04cd, B:275:0x04d7, B:277:0x04db, B:278:0x04de, B:280:0x04e2, B:281:0x04e5, B:282:0x04f5, B:285:0x04ff, B:286:0x050f, B:287:0x052c, B:293:0x0548, B:297:0x0554, B:299:0x055f, B:301:0x0574, B:306:0x058c, B:308:0x059b, B:309:0x05b1, B:311:0x05bd, B:313:0x05c1, B:303:0x057e, B:305:0x0586, B:317:0x05d7, B:318:0x05df, B:295:0x0550, B:322:0x05e5, B:324:0x05eb, B:325:0x05f5, B:327:0x05ff, B:145:0x0280, B:150:0x0292, B:152:0x029a, B:155:0x02ad, B:160:0x02c0, B:163:0x02d3, B:168:0x02e6, B:171:0x02f9, B:174:0x0304, B:184:0x0336, B:194:0x0368, B:204:0x039a, B:206:0x03a0, B:209:0x03b2, B:211:0x03bc, B:213:0x03c0, B:217:0x03db, B:222:0x03ec, B:225:0x03ff, B:230:0x0410, B:233:0x0423, B:238:0x0434, B:241:0x0447, B:244:0x0452, B:198:0x0378, B:201:0x038f, B:188:0x0346, B:191:0x035d, B:178:0x0314, B:181:0x032b, B:134:0x0245, B:137:0x025b, B:108:0x01d5, B:126:0x0225), top: B:505:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x066c A[Catch: all -> 0x0664, TryCatch #3 {all -> 0x0664, blocks: (B:331:0x060f, B:332:0x0616, B:366:0x0697, B:368:0x069f, B:369:0x06a7, B:371:0x06af, B:373:0x06b6, B:374:0x06d7, B:336:0x0623, B:338:0x062c, B:339:0x0638, B:343:0x0642, B:345:0x0648, B:347:0x064e, B:349:0x0654, B:351:0x065a, B:353:0x0660, B:356:0x0668, B:357:0x066c, B:359:0x0678, B:361:0x0680, B:362:0x0686, B:364:0x068e, B:365:0x0696), top: B:502:0x060f }] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0697 A[Catch: all -> 0x0664, TryCatch #3 {all -> 0x0664, blocks: (B:331:0x060f, B:332:0x0616, B:366:0x0697, B:368:0x069f, B:369:0x06a7, B:371:0x06af, B:373:0x06b6, B:374:0x06d7, B:336:0x0623, B:338:0x062c, B:339:0x0638, B:343:0x0642, B:345:0x0648, B:347:0x064e, B:349:0x0654, B:351:0x065a, B:353:0x0660, B:356:0x0668, B:357:0x066c, B:359:0x0678, B:361:0x0680, B:362:0x0686, B:364:0x068e, B:365:0x0696), top: B:502:0x060f }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0176  */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r27v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v65, types: [java.lang.reflect.Method] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        Object obj3;
        JSONField jSONField;
        Class<?> cls;
        FieldInfo fieldInfo;
        Object obj4;
        boolean z;
        boolean z2;
        ParseContext parseContext;
        String str;
        ParseContext parseContext2;
        ParseContext parseContext3;
        Object[] objArr;
        int i2;
        boolean z3;
        if (type == JSON.class || type == JSONObject.class) {
            return (T) defaultJSONParser.parse();
        }
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        ParserConfig config = defaultJSONParser.getConfig();
        int i3 = jSONLexerBase.token();
        if (i3 == 8) {
            jSONLexerBase.nextToken(16);
            return null;
        }
        ParseContext context = defaultJSONParser.getContext();
        ParseContext parseContext4 = (obj2 == 0 || context == null) ? context : context.parent;
        ParseContext parseContext5 = null;
        Map<String, Object> map = null;
        try {
            if (i3 == 13) {
                jSONLexerBase.nextToken(16);
                T t = obj2;
                if (obj2 == 0) {
                    t = (T) createInstance((DefaultJSONParser) defaultJSONParser, type);
                }
                if (0 != 0) {
                    parseContext5.object = t;
                }
                defaultJSONParser.setContext(parseContext4);
                return t;
            }
            if (i3 == 14) {
                int i4 = Feature.SupportArrayToBean.mask;
                if (((this.beanInfo.parserFeatures & i4) == 0 && !jSONLexerBase.isEnabled(Feature.SupportArrayToBean) && (i4 & i) == 0) ? false : true) {
                    T t2 = (T) deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                    if (0 != 0) {
                        parseContext5.object = obj2;
                    }
                    defaultJSONParser.setContext(parseContext4);
                    return t2;
                }
            }
            if (i3 != 12 && i3 != 16) {
                if (jSONLexerBase.isBlankInput()) {
                    if (0 != 0) {
                        parseContext5.object = obj2;
                    }
                    defaultJSONParser.setContext(parseContext4);
                    return null;
                }
                if (i3 == 4) {
                    String stringVal = jSONLexerBase.stringVal();
                    if (stringVal.length() == 0) {
                        jSONLexerBase.nextToken();
                        if (0 != 0) {
                            parseContext5.object = obj2;
                        }
                        defaultJSONParser.setContext(parseContext4);
                        return null;
                    } else if (this.beanInfo.jsonType != null) {
                        Class<?>[] seeAlso = this.beanInfo.jsonType.seeAlso();
                        int length = seeAlso.length;
                        for (int i5 = 0; i5 < length; i5++) {
                            Class<?> cls2 = seeAlso[i5];
                            if (Enum.class.isAssignableFrom(cls2)) {
                                try {
                                    T t3 = (T) Enum.valueOf(cls2, stringVal);
                                    if (0 != 0) {
                                        parseContext5.object = obj2;
                                    }
                                    defaultJSONParser.setContext(parseContext4);
                                    return t3;
                                } catch (IllegalArgumentException e) {
                                }
                            }
                        }
                    }
                } else if (i3 == 5) {
                    jSONLexerBase.getCalendar();
                }
                if (i3 != 14 || jSONLexerBase.getCurrent() != ']') {
                    StringBuffer append = new StringBuffer().append("syntax error, expect {, actual ").append(jSONLexerBase.tokenName()).append(", pos ").append(jSONLexerBase.pos());
                    if (obj instanceof String) {
                        append.append(", fieldName ").append(obj);
                    }
                    append.append(", fastjson-version ").append(JSON.VERSION);
                    throw new JSONException(append.toString());
                }
                jSONLexerBase.next();
                jSONLexerBase.nextToken();
                if (0 != 0) {
                    parseContext5.object = obj2;
                }
                defaultJSONParser.setContext(parseContext4);
                return null;
            }
            if (defaultJSONParser.resolveStatus == 2) {
                defaultJSONParser.resolveStatus = 0;
            }
            String str2 = this.beanInfo.typeKey;
            int i6 = 0;
            int[] iArr2 = iArr;
            obj3 = obj2;
            while (true) {
                FieldDeserializer fieldDeserializer = null;
                try {
                    if (i6 < this.sortedFieldDeserializers.length) {
                        fieldDeserializer = this.sortedFieldDeserializers[i6];
                        FieldInfo fieldInfo2 = fieldDeserializer.fieldInfo;
                        Class<?> cls3 = fieldInfo2.fieldClass;
                        jSONField = fieldInfo2.getAnnotation();
                        cls = cls3;
                        fieldInfo = fieldInfo2;
                    } else {
                        jSONField = null;
                        cls = null;
                        fieldInfo = null;
                    }
                    boolean z4 = false;
                    if (fieldDeserializer != null) {
                        char[] cArr = fieldInfo.name_chars;
                        if (cls == Integer.TYPE || cls == Integer.class) {
                            Integer valueOf = Integer.valueOf(jSONLexerBase.scanFieldInt(cArr));
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = valueOf;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = valueOf;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                                str = jSONLexerBase.scanSymbol(defaultJSONParser.symbolTable);
                                if (str == null) {
                                    int i7 = jSONLexerBase.token();
                                    if (i7 == 13) {
                                        jSONLexerBase.nextToken(16);
                                        parseContext3 = parseContext5;
                                        break;
                                    } else if (i7 == 16 && jSONLexerBase.isEnabled(Feature.AllowArbitraryCommas)) {
                                        parseContext = parseContext5;
                                        i6++;
                                        parseContext5 = parseContext;
                                    }
                                }
                                if ("$ref" != str || parseContext4 == null) {
                                    if ((str2 != null && str2.equals(str)) || JSON.DEFAULT_TYPE_KEY == str) {
                                        jSONLexerBase.nextTokenWithColon(4);
                                        if (jSONLexerBase.token() != 4) {
                                            throw new JSONException("syntax error");
                                        }
                                        String stringVal2 = jSONLexerBase.stringVal();
                                        jSONLexerBase.nextToken(16);
                                        if (!stringVal2.equals(this.beanInfo.typeName) && !defaultJSONParser.isEnabled(Feature.IgnoreAutoType)) {
                                            ObjectDeserializer seeAlso2 = getSeeAlso(config, this.beanInfo, stringVal2);
                                            Class<?> cls4 = null;
                                            if (seeAlso2 == null) {
                                                cls4 = config.checkAutoType(stringVal2, TypeUtils.getClass(type), jSONLexerBase.getFeatures());
                                                seeAlso2 = defaultJSONParser.getConfig().getDeserializer(cls4);
                                            }
                                            T t4 = (T) seeAlso2.deserialze(defaultJSONParser, cls4, obj);
                                            if (seeAlso2 instanceof JavaBeanDeserializer) {
                                                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) seeAlso2;
                                                if (str2 != null) {
                                                    javaBeanDeserializer.getFieldDeserializer(str2).setValue((Object) t4, stringVal2);
                                                }
                                            }
                                            if (parseContext5 != null) {
                                                parseContext5.object = obj3;
                                            }
                                            defaultJSONParser.setContext(parseContext4);
                                            return t4;
                                        } else if (jSONLexerBase.token() == 13) {
                                            jSONLexerBase.nextToken();
                                            parseContext3 = parseContext5;
                                            break;
                                        }
                                    }
                                } else {
                                    jSONLexerBase.nextTokenWithColon(4);
                                    if (jSONLexerBase.token() == 4) {
                                        String stringVal3 = jSONLexerBase.stringVal();
                                        if ("@".equals(stringVal3)) {
                                            obj3 = parseContext4.object;
                                        } else if (IStringUtil.TOP_PATH.equals(stringVal3)) {
                                            ParseContext parseContext6 = parseContext4.parent;
                                            if (parseContext6.object != null) {
                                                obj3 = parseContext6.object;
                                            } else {
                                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext6, stringVal3));
                                                defaultJSONParser.resolveStatus = 1;
                                            }
                                        } else if ("$".equals(stringVal3)) {
                                            ParseContext parseContext7 = parseContext4;
                                            while (parseContext7.parent != null) {
                                                parseContext7 = parseContext7.parent;
                                            }
                                            if (parseContext7.object != null) {
                                                obj3 = parseContext7.object;
                                            } else {
                                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext7, stringVal3));
                                                defaultJSONParser.resolveStatus = 1;
                                            }
                                        } else {
                                            Object resolveReference = defaultJSONParser.resolveReference(stringVal3);
                                            if (resolveReference != null) {
                                                obj3 = resolveReference;
                                            } else {
                                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext4, stringVal3));
                                                defaultJSONParser.resolveStatus = 1;
                                            }
                                        }
                                        jSONLexerBase.nextToken(13);
                                        if (jSONLexerBase.token() != 13) {
                                            throw new JSONException("illegal ref");
                                        }
                                        jSONLexerBase.nextToken(16);
                                        defaultJSONParser.setContext(parseContext4, obj3, obj);
                                        if (parseContext5 != null) {
                                            parseContext5.object = obj3;
                                        }
                                        defaultJSONParser.setContext(parseContext4);
                                        return (T) obj3;
                                    }
                                    throw new JSONException("illegal ref, " + JSONToken.name(i2));
                                }
                            } else {
                                str = null;
                            }
                            if (obj3 == null && map == null) {
                                obj3 = createInstance((DefaultJSONParser) defaultJSONParser, type);
                                if (obj3 == null) {
                                    map = new HashMap<>(this.fieldDeserializers.length);
                                }
                                parseContext5 = defaultJSONParser.setContext(parseContext4, obj3, obj);
                                if (iArr2 == null) {
                                    iArr2 = new int[(this.fieldDeserializers.length / 32) + 1];
                                    parseContext2 = parseContext5;
                                    if (z2) {
                                        if (z) {
                                            if (obj3 == null) {
                                                map.put(fieldInfo.name, obj4);
                                            } else if (obj4 != null) {
                                                fieldDeserializer.setValue(obj3, obj4);
                                            } else if (cls != Integer.TYPE && cls != Long.TYPE && cls != Float.TYPE && cls != Double.TYPE && cls != Boolean.TYPE) {
                                                fieldDeserializer.setValue(obj3, obj4);
                                            }
                                            if (iArr2 != null) {
                                                int i8 = i6 / 32;
                                                iArr2[i8] = (1 >> (i6 % 32)) | iArr2[i8];
                                            }
                                            if (jSONLexerBase.matchStat == 4) {
                                                parseContext3 = parseContext2;
                                                break;
                                            }
                                        } else {
                                            try {
                                                fieldDeserializer.parseField(defaultJSONParser, obj3, type, map);
                                            } catch (Throwable th) {
                                                th = th;
                                                parseContext5 = parseContext2;
                                                if (parseContext5 != null) {
                                                    parseContext5.object = obj3;
                                                }
                                                defaultJSONParser.setContext(parseContext4);
                                                throw th;
                                            }
                                        }
                                        if (jSONLexerBase.token() != 16) {
                                            parseContext = parseContext2;
                                        } else if (jSONLexerBase.token() == 13) {
                                            jSONLexerBase.nextToken(16);
                                            parseContext3 = parseContext2;
                                            break;
                                        } else {
                                            if (jSONLexerBase.token() == 18 || jSONLexerBase.token() == 1) {
                                                break;
                                            }
                                            parseContext = parseContext2;
                                        }
                                    } else if (parseField(defaultJSONParser, str, obj3, type, map, iArr2)) {
                                        if (jSONLexerBase.token() == 17) {
                                            throw new JSONException("syntax error, unexpect token ':'");
                                        }
                                        if (jSONLexerBase.token() != 16) {
                                        }
                                    } else {
                                        if (jSONLexerBase.token() == 13) {
                                            jSONLexerBase.nextToken();
                                            parseContext3 = parseContext2;
                                            break;
                                        }
                                        parseContext = parseContext2;
                                    }
                                    i6++;
                                    parseContext5 = parseContext;
                                }
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls == Long.TYPE || cls == Long.class) {
                            Long valueOf2 = Long.valueOf(jSONLexerBase.scanFieldLong(cArr));
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = valueOf2;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = valueOf2;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                                obj3 = createInstance((DefaultJSONParser) defaultJSONParser, type);
                                if (obj3 == null) {
                                }
                                parseContext5 = defaultJSONParser.setContext(parseContext4, obj3, obj);
                                if (iArr2 == null) {
                                }
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls == String.class) {
                            String scanFieldString = jSONLexerBase.scanFieldString(cArr);
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = scanFieldString;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = scanFieldString;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls == Date.class && fieldInfo.format == null) {
                            Date scanFieldDate = jSONLexerBase.scanFieldDate(cArr);
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = scanFieldDate;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = scanFieldDate;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls == BigDecimal.class) {
                            BigDecimal scanFieldDecimal = jSONLexerBase.scanFieldDecimal(cArr);
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = scanFieldDecimal;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = scanFieldDecimal;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls == BigInteger.class) {
                            BigInteger scanFieldBigInteger = jSONLexerBase.scanFieldBigInteger(cArr);
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = scanFieldBigInteger;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = scanFieldBigInteger;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls == Boolean.TYPE || cls == Boolean.class) {
                            Boolean valueOf3 = Boolean.valueOf(jSONLexerBase.scanFieldBoolean(cArr));
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = valueOf3;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = valueOf3;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls == Float.TYPE || cls == Float.class) {
                            Float valueOf4 = Float.valueOf(jSONLexerBase.scanFieldFloat(cArr));
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = valueOf4;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = valueOf4;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls == Double.TYPE || cls == Double.class) {
                            Double valueOf5 = Double.valueOf(jSONLexerBase.scanFieldDouble(cArr));
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = valueOf5;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = valueOf5;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls.isEnum() && (defaultJSONParser.getConfig().getDeserializer(cls) instanceof EnumDeserializer) && (jSONField == null || jSONField.deserializeUsing() == Void.class)) {
                            if (fieldDeserializer instanceof DefaultFieldDeserializer) {
                                obj4 = scanEnum(jSONLexerBase, cArr, ((DefaultFieldDeserializer) fieldDeserializer).fieldValueDeserilizer);
                                if (jSONLexerBase.matchStat > 0) {
                                    z3 = true;
                                    z4 = true;
                                } else if (jSONLexerBase.matchStat == -2) {
                                    parseContext = parseContext5;
                                    i6++;
                                    parseContext5 = parseContext;
                                } else {
                                    z3 = false;
                                }
                                z = z3;
                                z2 = z4;
                                if (z2) {
                                }
                                if (obj3 == null) {
                                }
                                parseContext2 = parseContext5;
                                if (z2) {
                                }
                                i6++;
                                parseContext5 = parseContext;
                            }
                        } else if (cls == int[].class) {
                            int[] scanFieldIntArray = jSONLexerBase.scanFieldIntArray(cArr);
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = scanFieldIntArray;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = scanFieldIntArray;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else if (cls == float[].class) {
                            float[] scanFieldFloatArray = jSONLexerBase.scanFieldFloatArray(cArr);
                            if (jSONLexerBase.matchStat > 0) {
                                obj4 = scanFieldFloatArray;
                                z = true;
                                z2 = true;
                            } else if (jSONLexerBase.matchStat == -2) {
                                parseContext = parseContext5;
                                i6++;
                                parseContext5 = parseContext;
                            } else {
                                obj4 = scanFieldFloatArray;
                                z = false;
                                z2 = false;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        } else {
                            if (cls == float[][].class) {
                                float[][] scanFieldFloatArray2 = jSONLexerBase.scanFieldFloatArray2(cArr);
                                if (jSONLexerBase.matchStat > 0) {
                                    obj4 = scanFieldFloatArray2;
                                    z = true;
                                    z2 = true;
                                } else if (jSONLexerBase.matchStat == -2) {
                                    parseContext = parseContext5;
                                    i6++;
                                    parseContext5 = parseContext;
                                } else {
                                    obj4 = scanFieldFloatArray2;
                                    z = false;
                                    z2 = false;
                                }
                            } else if (jSONLexerBase.matchField(cArr)) {
                                obj4 = null;
                                z = false;
                                z2 = true;
                            }
                            if (z2) {
                            }
                            if (obj3 == null) {
                            }
                            parseContext2 = parseContext5;
                            if (z2) {
                            }
                            i6++;
                            parseContext5 = parseContext;
                        }
                        parseContext = parseContext5;
                        i6++;
                        parseContext5 = parseContext;
                    }
                    obj4 = null;
                    z = false;
                    z2 = false;
                    if (z2) {
                    }
                    if (obj3 == null) {
                    }
                    parseContext2 = parseContext5;
                    if (z2) {
                    }
                    i6++;
                    parseContext5 = parseContext;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            try {
                if (obj3 == null) {
                    try {
                        if (map == null) {
                            T t5 = (T) createInstance((DefaultJSONParser) defaultJSONParser, type);
                            ParseContext context2 = parseContext3 == null ? defaultJSONParser.setContext(parseContext4, t5, obj) : parseContext3;
                            if (context2 != null) {
                                context2.object = t5;
                            }
                            defaultJSONParser.setContext(parseContext4);
                            return t5;
                        }
                        String[] strArr = this.beanInfo.creatorConstructorParameters;
                        if (strArr != null) {
                            objArr = new Object[strArr.length];
                            for (int i9 = 0; i9 < strArr.length; i9++) {
                                long remove = map.remove(strArr[i9]);
                                if (remove == null) {
                                    Type type2 = this.beanInfo.creatorConstructorParameterTypes[i9];
                                    FieldInfo fieldInfo3 = this.beanInfo.fields[i9];
                                    if (type2 == Byte.TYPE) {
                                        remove = (byte) 0;
                                    } else if (type2 == Short.TYPE) {
                                        remove = (short) 0;
                                    } else if (type2 == Integer.TYPE) {
                                        remove = 0;
                                    } else if (type2 == Long.TYPE) {
                                        remove = 0L;
                                    } else if (type2 == Float.TYPE) {
                                        remove = Float.valueOf(0.0f);
                                    } else if (type2 == Double.TYPE) {
                                        remove = Double.valueOf(0.0d);
                                    } else if (type2 == Boolean.TYPE) {
                                        remove = Boolean.FALSE;
                                    } else if (type2 == String.class && (fieldInfo3.parserFeatures & Feature.InitStringFieldAsEmpty.mask) != 0) {
                                        remove = "";
                                    }
                                }
                                objArr[i9] = remove;
                            }
                        } else {
                            FieldInfo[] fieldInfoArr = this.beanInfo.fields;
                            int length2 = fieldInfoArr.length;
                            objArr = new Object[length2];
                            for (int i10 = 0; i10 < length2; i10++) {
                                FieldInfo fieldInfo4 = fieldInfoArr[i10];
                                long j = map.get(fieldInfo4.name);
                                if (j == null) {
                                    Type type3 = fieldInfo4.fieldType;
                                    if (type3 == Byte.TYPE) {
                                        j = (byte) 0;
                                    } else if (type3 == Short.TYPE) {
                                        j = (short) 0;
                                    } else if (type3 == Integer.TYPE) {
                                        j = 0;
                                    } else if (type3 == Long.TYPE) {
                                        j = 0L;
                                    } else if (type3 == Float.TYPE) {
                                        j = Float.valueOf(0.0f);
                                    } else if (type3 == Double.TYPE) {
                                        j = Double.valueOf(0.0d);
                                    } else if (type3 == Boolean.TYPE) {
                                        j = Boolean.FALSE;
                                    } else if (type3 == String.class && (fieldInfo4.parserFeatures & Feature.InitStringFieldAsEmpty.mask) != 0) {
                                        j = "";
                                    }
                                }
                                objArr[i10] = j;
                            }
                        }
                        if (this.beanInfo.creatorConstructor != null) {
                            try {
                                obj3 = this.beanInfo.creatorConstructor.newInstance(objArr);
                                if (strArr != null) {
                                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                                        FieldDeserializer fieldDeserializer2 = getFieldDeserializer(entry.getKey());
                                        if (fieldDeserializer2 != null) {
                                            fieldDeserializer2.setValue(obj3, entry.getValue());
                                        }
                                    }
                                }
                                parseContext3.object = obj3;
                            } catch (Exception e2) {
                                throw new JSONException("create instance error, " + strArr + ", " + this.beanInfo.creatorConstructor.toGenericString(), e2);
                            }
                        } else {
                            if (this.beanInfo.factoryMethod != null) {
                                try {
                                    obj3 = this.beanInfo.factoryMethod.invoke(null, objArr);
                                } catch (Exception e3) {
                                    throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e3);
                                }
                            }
                            parseContext3.object = obj3;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        parseContext5 = parseContext3;
                        if (parseContext5 != null) {
                        }
                        defaultJSONParser.setContext(parseContext4);
                        throw th;
                    }
                }
                obj2 = (T) obj3;
                ?? r4 = this.beanInfo.buildMethod;
                if (r4 == 0) {
                    if (parseContext3 != null) {
                        parseContext3.object = obj2;
                    }
                    defaultJSONParser.setContext(parseContext4);
                    return obj2;
                }
                try {
                    T t6 = (T) r4.invoke(obj2, new Object[0]);
                    if (parseContext3 != null) {
                        parseContext3.object = obj2;
                    }
                    defaultJSONParser.setContext(parseContext4);
                    return t6;
                } catch (Exception e4) {
                    throw new JSONException("build object error", e4);
                }
            } catch (Throwable th4) {
                th = th4;
                parseContext5 = parseContext3;
                obj3 = obj2;
            }
        } catch (Throwable th5) {
            th = th5;
            obj3 = obj2;
        }
    }

    protected Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanFieldSymbol = jSONLexerBase.scanFieldSymbol(cArr);
        if (jSONLexerBase.matchStat > 0) {
            return enumDeserializer.getEnumByHashCode(scanFieldSymbol);
        }
        return null;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        DefaultFieldDeserializer defaultFieldDeserializer;
        FieldDeserializer[] fieldDeserializerArr;
        Field[] declaredFields;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = Feature.DisableFieldSmartMatch.mask;
        if (jSONLexer.isEnabled(i) || (i & this.beanInfo.parserFeatures) != 0) {
            fieldDeserializer = getFieldDeserializer(str);
        } else {
            fieldDeserializer = smartMatch(str, iArr);
        }
        int i2 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && (jSONLexer.isEnabled(i2) || (i2 & this.beanInfo.parserFeatures) != 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Class<? super Object> cls = this.clazz; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
                    for (Field field : cls.getDeclaredFields()) {
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    defaultFieldDeserializer = (FieldDeserializer) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    DefaultFieldDeserializer defaultFieldDeserializer2 = new DefaultFieldDeserializer(defaultJSONParser.getConfig(), this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0, 0));
                    this.extraFieldDeserializers.put(str, defaultFieldDeserializer2);
                    defaultFieldDeserializer = defaultFieldDeserializer2;
                }
                if (defaultFieldDeserializer != null) {
                    if (!jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
                        throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
                    }
                    for (FieldDeserializer fieldDeserializer2 : this.sortedFieldDeserializers) {
                        FieldInfo fieldInfo = fieldDeserializer2.fieldInfo;
                        if (fieldInfo.unwrapped && (fieldDeserializer2 instanceof DefaultFieldDeserializer)) {
                            if (fieldInfo.field != null) {
                                DefaultFieldDeserializer defaultFieldDeserializer3 = (DefaultFieldDeserializer) fieldDeserializer2;
                                ObjectDeserializer fieldValueDeserilizer = defaultFieldDeserializer3.getFieldValueDeserilizer(defaultJSONParser.getConfig());
                                if (fieldValueDeserilizer instanceof JavaBeanDeserializer) {
                                    FieldDeserializer fieldDeserializer3 = ((JavaBeanDeserializer) fieldValueDeserilizer).getFieldDeserializer(str);
                                    if (fieldDeserializer3 != null) {
                                        try {
                                            Object obj3 = fieldInfo.field.get(obj);
                                            if (obj3 == null) {
                                                obj3 = ((JavaBeanDeserializer) fieldValueDeserilizer).createInstance(defaultJSONParser, fieldInfo.fieldType);
                                                fieldDeserializer2.setValue(obj, obj3);
                                            }
                                            jSONLexer.nextTokenWithColon(defaultFieldDeserializer3.getFastMatchToken());
                                            fieldDeserializer3.parseField(defaultJSONParser, obj3, type, map);
                                            return true;
                                        } catch (Exception e) {
                                            throw new JSONException("parse unwrapped field error.", e);
                                        }
                                    }
                                } else if (fieldValueDeserilizer instanceof MapDeserializer) {
                                    MapDeserializer mapDeserializer = (MapDeserializer) fieldValueDeserilizer;
                                    try {
                                        Map<Object, Object> map2 = (Map) fieldInfo.field.get(obj);
                                        if (map2 == null) {
                                            map2 = mapDeserializer.createMap(fieldInfo.fieldType);
                                            fieldDeserializer2.setValue(obj, map2);
                                        }
                                        jSONLexer.nextTokenWithColon();
                                        map2.put(str, defaultJSONParser.parse(str));
                                        return true;
                                    } catch (Exception e2) {
                                        throw new JSONException("parse unwrapped field error.", e2);
                                    }
                                }
                            } else if (fieldInfo.method.getParameterTypes().length == 2) {
                                jSONLexer.nextTokenWithColon();
                                try {
                                    fieldInfo.method.invoke(obj, str, defaultJSONParser.parse(str));
                                    return true;
                                } catch (Exception e3) {
                                    throw new JSONException("parse unwrapped field error.", e3);
                                }
                            }
                        }
                    }
                    defaultJSONParser.parseExtra(obj, str);
                    return false;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= this.sortedFieldDeserializers.length) {
                        i3 = -1;
                        break;
                    } else if (this.sortedFieldDeserializers[i3] == defaultFieldDeserializer) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1 && iArr != null && str.startsWith(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) && isSetFlag(i3, iArr)) {
                    defaultJSONParser.parseExtra(obj, str);
                    return false;
                }
                jSONLexer.nextTokenWithColon(defaultFieldDeserializer.getFastMatchToken());
                defaultFieldDeserializer.parseField(defaultJSONParser, obj, type, map);
                return true;
            }
        }
        defaultFieldDeserializer = fieldDeserializer;
        if (defaultFieldDeserializer != null) {
        }
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FieldDeserializer smartMatch(String str, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        boolean z;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer2 = getFieldDeserializer(str, iArr);
        if (fieldDeserializer2 == null) {
            long fnv1a_64_lower = TypeUtils.fnv1a_64_lower(str);
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                for (int i = 0; i < this.sortedFieldDeserializers.length; i++) {
                    jArr[i] = TypeUtils.fnv1a_64_lower(this.sortedFieldDeserializers[i].fieldInfo.name);
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv1a_64_lower);
            if (binarySearch < 0) {
                boolean startsWith = str.startsWith("is");
                if (startsWith) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str.substring(2)));
                    z = startsWith;
                } else {
                    z = startsWith;
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, (short) -1);
                    for (int i2 = 0; i2 < this.sortedFieldDeserializers.length; i2++) {
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(this.sortedFieldDeserializers[i2].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i2;
                        }
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s = this.smartMatchHashArrayMapping[binarySearch];
                if (s != -1 && !isSetFlag(s, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s];
                    if (fieldDeserializer != null) {
                        FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                        if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                            return null;
                        }
                        Class<?> cls = fieldInfo.fieldClass;
                        if (z && cls != Boolean.TYPE && cls != Boolean.class) {
                            fieldDeserializer = null;
                        }
                    }
                }
            }
            fieldDeserializer = fieldDeserializer2;
            if (fieldDeserializer != null) {
            }
        } else {
            fieldDeserializer = fieldDeserializer2;
        }
        return fieldDeserializer;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        if (this.beanInfo.creatorConstructor == null && this.beanInfo.factoryMethod == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                FieldDeserializer smartMatch = smartMatch(entry.getKey());
                if (smartMatch != null) {
                    smartMatch.setValue(createInstance, TypeUtils.cast(value, smartMatch.fieldInfo.fieldType, parserConfig));
                }
            }
            if (this.beanInfo.buildMethod != null) {
                try {
                    return this.beanInfo.buildMethod.invoke(createInstance, new Object[0]);
                } catch (Exception e) {
                    throw new JSONException("build object error", e);
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = this.beanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = fieldInfoArr[i];
            boolean z = map.get(fieldInfo.name);
            if (z == null) {
                Class<?> cls = fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    z = 0;
                } else if (cls == Long.TYPE) {
                    z = 0L;
                } else if (cls == Short.TYPE) {
                    z = (short) 0;
                } else if (cls == Byte.TYPE) {
                    z = (byte) 0;
                } else if (cls == Float.TYPE) {
                    z = Float.valueOf(0.0f);
                } else if (cls == Double.TYPE) {
                    z = Double.valueOf(0.0d);
                } else if (cls == Character.TYPE) {
                    z = '0';
                } else if (cls == Boolean.TYPE) {
                    z = false;
                }
            }
            objArr[i] = z;
        }
        if (this.beanInfo.creatorConstructor != null) {
            try {
                return this.beanInfo.creatorConstructor.newInstance(objArr);
            } catch (Exception e2) {
                throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e2);
            }
        } else if (this.beanInfo.factoryMethod != null) {
            try {
                return this.beanInfo.factoryMethod.invoke(null, objArr);
            } catch (Exception e3) {
                throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e3);
            }
        } else {
            return null;
        }
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    protected JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        if (javaBeanInfo.jsonType == null) {
            return null;
        }
        for (Class<?> cls : javaBeanInfo.jsonType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (!javaBeanInfo2.typeName.equals(str)) {
                    JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                    if (seeAlso != null) {
                        return seeAlso;
                    }
                } else {
                    return javaBeanDeserializer;
                }
            }
        }
        return null;
    }

    protected static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            } else if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
            return;
        }
        jSONLexerBase.nextToken(16);
    }
}
