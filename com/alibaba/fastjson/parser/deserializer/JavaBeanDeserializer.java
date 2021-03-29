package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
/* loaded from: classes.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    public final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    public final Class<?> clazz;
    public ConcurrentMap<String, Object> extraFieldDeserializers;
    public final FieldDeserializer[] fieldDeserializers;
    public transient long[] hashArray;
    public transient short[] hashArrayMapping;
    public transient long[] smartMatchHashArray;
    public transient short[] smartMatchHashArrayMapping;
    public final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    public static boolean isSetFlag(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i2 = i / 32;
        int i3 = i % 32;
        if (i2 < iArr.length) {
            if (((1 << i3) & iArr[i2]) != 0) {
                return true;
            }
        }
        return false;
    }

    public static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
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

    public void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        FieldInfo[] fieldInfoArr;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Object obj = null;
        if (javaBeanInfo.defaultConstructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        JavaBeanInfo javaBeanInfo2 = this.beanInfo;
        if (javaBeanInfo2.factoryMethod == null || javaBeanInfo2.defaultConstructorParameterSize <= 0) {
            try {
                Constructor<?> constructor = this.beanInfo.defaultConstructor;
                if (this.beanInfo.defaultConstructorParameterSize != 0) {
                    ParseContext context = defaultJSONParser.getContext();
                    if (context != null && context.object != null) {
                        if (type instanceof Class) {
                            String name = ((Class) type).getName();
                            String substring = name.substring(0, name.lastIndexOf(36));
                            Object obj2 = context.object;
                            String name2 = obj2.getClass().getName();
                            if (!name2.equals(substring)) {
                                ParseContext parseContext = context.parent;
                                if (parseContext != null && parseContext.object != null && (("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2)) && parseContext.object.getClass().getName().equals(substring))) {
                                    obj = parseContext.object;
                                }
                                obj2 = obj;
                            }
                            if (obj2 != null) {
                                newInstance = constructor.newInstance(obj2);
                            } else {
                                throw new JSONException("can't create non-static inner class instance.");
                            }
                        } else {
                            throw new JSONException("can't create non-static inner class instance.");
                        }
                    } else {
                        throw new JSONException("can't create non-static inner class instance.");
                    }
                } else if (constructor != null) {
                    newInstance = constructor.newInstance(new Object[0]);
                } else {
                    newInstance = this.beanInfo.factoryMethod.invoke(null, new Object[0]);
                }
                if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            try {
                                fieldInfo.set(newInstance, "");
                            } catch (Exception e2) {
                                throw new JSONException("create instance error, class " + this.clazz.getName(), e2);
                            }
                        }
                    }
                }
                return newInstance;
            } catch (JSONException e3) {
                throw e3;
            } catch (Exception e4) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e4);
            }
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> scanEnum;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            T t = (T) createInstance(defaultJSONParser, type);
            int i = 0;
            int length = this.sortedFieldDeserializers.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                char c2 = i == length + (-1) ? ']' : ',';
                FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
                Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c2));
                } else if (cls == String.class) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c2));
                } else if (cls == Long.TYPE) {
                    fieldDeserializer.setValue(t, jSONLexer.scanLong(c2));
                } else if (cls.isEnum()) {
                    char current = jSONLexer.getCurrent();
                    if (current == '\"' || current == 'n') {
                        scanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c2);
                    } else if (current >= '0' && current <= '9') {
                        scanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c2));
                    } else {
                        scanEnum = scanEnum(jSONLexer, c2);
                    }
                    fieldDeserializer.setValue(t, scanEnum);
                } else if (cls == Boolean.TYPE) {
                    fieldDeserializer.setValue(t, jSONLexer.scanBoolean(c2));
                } else if (cls == Float.TYPE) {
                    fieldDeserializer.setValue(t, Float.valueOf(jSONLexer.scanFloat(c2)));
                } else if (cls == Double.TYPE) {
                    fieldDeserializer.setValue(t, Double.valueOf(jSONLexer.scanDouble(c2)));
                } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                    fieldDeserializer.setValue(t, new Date(jSONLexer.scanLong(c2)));
                } else if (cls == BigDecimal.class) {
                    fieldDeserializer.setValue(t, jSONLexer.scanDecimal(c2));
                } else {
                    jSONLexer.nextToken(14);
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldInfo.fieldType, fieldInfo.name));
                    if (jSONLexer.token() == 15) {
                        break;
                    }
                    check(jSONLexer, c2 == ']' ? 15 : 16);
                }
                i++;
            }
            jSONLexer.nextToken(16);
            return t;
        }
        throw new JSONException("error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    public Enum<?> scanEnum(JSONLexer jSONLexer, char c2) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i, null);
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
            } else if (compareTo <= 0) {
                if (isSetFlag(i2, iArr)) {
                    return null;
                }
                return this.sortedFieldDeserializers[i2];
            } else {
                length = i2 - 1;
            }
        }
        Map<String, FieldDeserializer> map = this.alterNameFieldDeserializers;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b1  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        JSONLexer jSONLexer;
        ?? r17;
        JSONLexer jSONLexer2;
        FieldDeserializer[] fieldDeserializerArr;
        Field[] declaredFields;
        JSONLexer jSONLexer3 = defaultJSONParser.lexer;
        int i = Feature.DisableFieldSmartMatch.mask;
        if (!jSONLexer3.isEnabled(i) && (i & this.beanInfo.parserFeatures) == 0) {
            fieldDeserializer = smartMatch(str, iArr);
        } else {
            fieldDeserializer = getFieldDeserializer(str);
        }
        int i2 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && (jSONLexer3.isEnabled(i2) || (i2 & this.beanInfo.parserFeatures) != 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Class<?> cls = this.clazz; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
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
                    fieldDeserializer = (FieldDeserializer) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    r17 = 1;
                    jSONLexer = jSONLexer3;
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.getConfig(), this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer);
                    if (fieldDeserializer != null) {
                        if (jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
                            for (FieldDeserializer fieldDeserializer2 : this.sortedFieldDeserializers) {
                                FieldInfo fieldInfo = fieldDeserializer2.fieldInfo;
                                if (fieldInfo.unwrapped && (fieldDeserializer2 instanceof DefaultFieldDeserializer)) {
                                    if (fieldInfo.field != null) {
                                        DefaultFieldDeserializer defaultFieldDeserializer = (DefaultFieldDeserializer) fieldDeserializer2;
                                        ObjectDeserializer fieldValueDeserilizer = defaultFieldDeserializer.getFieldValueDeserilizer(defaultJSONParser.getConfig());
                                        if (fieldValueDeserilizer instanceof JavaBeanDeserializer) {
                                            FieldDeserializer fieldDeserializer3 = ((JavaBeanDeserializer) fieldValueDeserilizer).getFieldDeserializer(str);
                                            if (fieldDeserializer3 != null) {
                                                try {
                                                    Object obj3 = fieldInfo.field.get(obj);
                                                    if (obj3 == null) {
                                                        obj3 = ((JavaBeanDeserializer) fieldValueDeserilizer).createInstance(defaultJSONParser, fieldInfo.fieldType);
                                                        fieldDeserializer2.setValue(obj, obj3);
                                                    }
                                                    jSONLexer.nextTokenWithColon(defaultFieldDeserializer.getFastMatchToken());
                                                    fieldDeserializer3.parseField(defaultJSONParser, obj3, type, map);
                                                    return r17;
                                                } catch (Exception e2) {
                                                    throw new JSONException("parse unwrapped field error.", e2);
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
                                                return r17;
                                            } catch (Exception e3) {
                                                throw new JSONException("parse unwrapped field error.", e3);
                                            }
                                        }
                                    } else if (fieldInfo.method.getParameterTypes().length == 2) {
                                        jSONLexer.nextTokenWithColon();
                                        Object parse = defaultJSONParser.parse(str);
                                        try {
                                            Method method = fieldInfo.method;
                                            Object[] objArr = new Object[2];
                                            objArr[0] = str;
                                            objArr[r17] = parse;
                                            method.invoke(obj, objArr);
                                            return r17;
                                        } catch (Exception e4) {
                                            throw new JSONException("parse unwrapped field error.", e4);
                                        }
                                    }
                                }
                            }
                            defaultJSONParser.parseExtra(obj, str);
                            return false;
                        }
                        throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
                    }
                    int i3 = 0;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i3 >= fieldDeserializerArr2.length) {
                            i3 = -1;
                            break;
                        } else if (fieldDeserializerArr2[i3] == fieldDeserializer) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i3 != -1) {
                        jSONLexer2 = jSONLexer;
                        if (iArr != null && str.startsWith("_") && isSetFlag(i3, iArr)) {
                            defaultJSONParser.parseExtra(obj, str);
                            return false;
                        }
                    } else {
                        jSONLexer2 = jSONLexer;
                    }
                    jSONLexer2.nextTokenWithColon(fieldDeserializer.getFastMatchToken());
                    fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
                    return r17;
                }
            }
        }
        jSONLexer = jSONLexer3;
        r17 = 1;
        if (fieldDeserializer != null) {
        }
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
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

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        boolean z;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            long fnv1a_64_lower = TypeUtils.fnv1a_64_lower(str);
            int i = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i2 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i2 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i2] = TypeUtils.fnv1a_64_lower(fieldDeserializerArr[i2].fieldInfo.name);
                    i2++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv1a_64_lower);
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s = this.smartMatchHashArrayMapping[binarySearch];
                if (s != -1 && !isSetFlag(s, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s];
                }
            }
            if (fieldDeserializer != null) {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class<?> cls = fieldInfo.fieldClass;
                if (z && cls != Boolean.TYPE && cls != Boolean.class) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:525:0x054c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:536:0x0536 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:565:0x0645 */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x02b4, code lost:
        if (r12.matchStat == (-2)) goto L436;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x041a, code lost:
        r14 = r7;
        r0 = r18;
        r30 = 0;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0530, code lost:
        r0 = r17;
        r5 = r18;
        r1 = (T) r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0536, code lost:
        if (r1 != null) goto L345;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x0538, code lost:
        if (r0 != null) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x053a, code lost:
        r1 = (T) createInstance(r26, r27);
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x053e, code lost:
        if (r5 != null) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0540, code lost:
        r5 = r26.setContext(r14, r1, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0544, code lost:
        if (r5 == null) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0546, code lost:
        r5.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0548, code lost:
        r26.setContext(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x054b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x054c, code lost:
        r2 = r25.beanInfo.creatorConstructorParameters;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0554, code lost:
        if (r2 == null) goto L298;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0556, code lost:
        r12 = new java.lang.Object[r2.length];
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x055b, code lost:
        if (r13 >= r2.length) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x055d, code lost:
        r15 = r0.remove(r2[r13]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x0563, code lost:
        if (r15 != null) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x0565, code lost:
        r6 = r25.beanInfo.creatorConstructorParameterTypes[r13];
        r7 = r25.beanInfo.fields[r13];
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x0573, code lost:
        if (r6 != java.lang.Byte.TYPE) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0575, code lost:
        r15 = java.lang.Byte.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0579, code lost:
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x057e, code lost:
        if (r6 != java.lang.Short.TYPE) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0580, code lost:
        r15 = java.lang.Short.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0587, code lost:
        if (r6 != java.lang.Integer.TYPE) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0589, code lost:
        r15 = java.lang.Integer.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0590, code lost:
        if (r6 != java.lang.Long.TYPE) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0592, code lost:
        r15 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0599, code lost:
        if (r6 != java.lang.Float.TYPE) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x059b, code lost:
        r15 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x05a3, code lost:
        if (r6 != java.lang.Double.TYPE) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x05a5, code lost:
        r15 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x05ae, code lost:
        if (r6 != java.lang.Boolean.TYPE) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x05b0, code lost:
        r15 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x05b3, code lost:
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x05b5, code lost:
        if (r6 != r4) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x05be, code lost:
        if ((r7.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x05c0, code lost:
        r15 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x05c1, code lost:
        r12[r13] = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x05c3, code lost:
        r13 = r13 + 1;
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x05c8, code lost:
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x05ca, code lost:
        r6 = r25.beanInfo.fields;
        r7 = r6.length;
        r12 = new java.lang.Object[r7];
        r13 = 0;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x05d2, code lost:
        if (r13 >= r7) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x05d4, code lost:
        r15 = r6[r13];
        r10 = r0.get(r15.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x05dc, code lost:
        if (r10 != null) goto L340;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x05de, code lost:
        r11 = r15.fieldType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x05e0, code lost:
        r31 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x05e4, code lost:
        if (r11 != java.lang.Byte.TYPE) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x05e6, code lost:
        r10 = java.lang.Byte.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x05ea, code lost:
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x05f1, code lost:
        if (r11 != java.lang.Short.TYPE) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x05f3, code lost:
        r10 = java.lang.Short.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x05fa, code lost:
        if (r11 != java.lang.Integer.TYPE) goto L319;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x05fc, code lost:
        r10 = java.lang.Integer.valueOf(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x0603, code lost:
        if (r11 != java.lang.Long.TYPE) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x0605, code lost:
        r17 = 0;
        r10 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x060c, code lost:
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x0610, code lost:
        if (r11 != java.lang.Float.TYPE) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x0612, code lost:
        r10 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x061a, code lost:
        if (r11 != java.lang.Double.TYPE) goto L329;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x061c, code lost:
        r10 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x0627, code lost:
        if (r11 != java.lang.Boolean.TYPE) goto L333;
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x0629, code lost:
        r10 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x062c, code lost:
        if (r11 != r4) goto L339;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x0635, code lost:
        if ((r15.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L338;
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x0637, code lost:
        r10 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x0639, code lost:
        r31 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:452:0x063c, code lost:
        r12[r13] = r10;
        r13 = r13 + 1;
        r1 = (T) r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:453:0x0645, code lost:
        r31 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x064b, code lost:
        if (r25.beanInfo.creatorConstructor == null) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x064d, code lost:
        r1 = r25.beanInfo.creatorConstructor.newInstance(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x0655, code lost:
        if (r2 == null) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:457:0x0657, code lost:
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:459:0x0663, code lost:
        if (r0.hasNext() == false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x0665, code lost:
        r2 = r0.next();
        r3 = getFieldDeserializer(r2.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x0675, code lost:
        if (r3 == null) goto L292;
     */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x0677, code lost:
        r3.setValue(r1, r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x067f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x06a6, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r2 + com.baidu.android.common.others.lang.StringUtil.ARRAY_ELEMENT_SEPARATOR + r25.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x06ab, code lost:
        if (r25.beanInfo.factoryMethod == null) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:470:0x06b6, code lost:
        r1 = (T) r25.beanInfo.factoryMethod.invoke(null, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x06b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x06d7, code lost:
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r25.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:474:0x06d8, code lost:
        r1 = (T) r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x06da, code lost:
        r5.object = r1;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x06dd, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x06de, code lost:
        r1 = (T) r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x06e2, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x06e3, code lost:
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x06e7, code lost:
        r1 = r1;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x06e9, code lost:
        r0 = r25.beanInfo.buildMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x06ed, code lost:
        if (r0 != null) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x06ef, code lost:
        if (r5 == null) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x06f1, code lost:
        r5.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x06f3, code lost:
        r26.setContext(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x06f6, code lost:
        return (T) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:0x06f8, code lost:
        r0 = (T) r0.invoke(r1, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:0x06fe, code lost:
        if (r5 == null) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:490:0x0700, code lost:
        r5.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x0702, code lost:
        r26.setContext(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:492:0x0705, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x0706, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x070e, code lost:
        throw new com.alibaba.fastjson.JSONException("build object error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x070f, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:506:0x0757, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r12.token()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x0768, code lost:
        r15 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02c5 A[Catch: all -> 0x0141, TryCatch #1 {all -> 0x0141, blocks: (B:87:0x0134, B:92:0x014c, B:97:0x015d, B:103:0x0169, B:228:0x02c5, B:230:0x02cf, B:232:0x02db, B:235:0x02e6, B:242:0x02f9, B:244:0x0303, B:246:0x030f, B:267:0x0366, B:269:0x0371, B:274:0x0381, B:275:0x0388, B:247:0x0313, B:249:0x031b, B:251:0x0321, B:252:0x0324, B:253:0x0330, B:256:0x0339, B:258:0x033d, B:259:0x0340, B:261:0x0344, B:262:0x0347, B:263:0x0353, B:266:0x035b, B:276:0x0389, B:277:0x03a3, B:279:0x03a6, B:283:0x03b0, B:285:0x03ba, B:287:0x03cd, B:290:0x03d6, B:292:0x03de, B:294:0x03f4, B:296:0x03fc, B:298:0x0400, B:303:0x040f, B:305:0x0417, B:308:0x0437, B:309:0x043e, B:281:0x03ac, B:314:0x044f, B:316:0x0455, B:317:0x045f, B:319:0x0465, B:106:0x0173, B:111:0x017d, B:113:0x0181, B:116:0x018b, B:121:0x0195, B:124:0x019f, B:129:0x01a9, B:132:0x01b3, B:135:0x01b9, B:140:0x01c3, B:145:0x01cd, B:150:0x01d7, B:152:0x01dd, B:155:0x01eb, B:157:0x01f3, B:159:0x01f7, B:162:0x0206, B:167:0x0211, B:170:0x021b, B:175:0x0226, B:178:0x0230, B:183:0x023b, B:186:0x0245, B:189:0x024c, B:192:0x0256, B:195:0x0263, B:198:0x0269, B:201:0x0276, B:204:0x027c, B:207:0x0289, B:210:0x028f, B:213:0x029c, B:216:0x02a2, B:219:0x02b1), top: B:524:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x044d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0455 A[Catch: all -> 0x0141, TryCatch #1 {all -> 0x0141, blocks: (B:87:0x0134, B:92:0x014c, B:97:0x015d, B:103:0x0169, B:228:0x02c5, B:230:0x02cf, B:232:0x02db, B:235:0x02e6, B:242:0x02f9, B:244:0x0303, B:246:0x030f, B:267:0x0366, B:269:0x0371, B:274:0x0381, B:275:0x0388, B:247:0x0313, B:249:0x031b, B:251:0x0321, B:252:0x0324, B:253:0x0330, B:256:0x0339, B:258:0x033d, B:259:0x0340, B:261:0x0344, B:262:0x0347, B:263:0x0353, B:266:0x035b, B:276:0x0389, B:277:0x03a3, B:279:0x03a6, B:283:0x03b0, B:285:0x03ba, B:287:0x03cd, B:290:0x03d6, B:292:0x03de, B:294:0x03f4, B:296:0x03fc, B:298:0x0400, B:303:0x040f, B:305:0x0417, B:308:0x0437, B:309:0x043e, B:281:0x03ac, B:314:0x044f, B:316:0x0455, B:317:0x045f, B:319:0x0465, B:106:0x0173, B:111:0x017d, B:113:0x0181, B:116:0x018b, B:121:0x0195, B:124:0x019f, B:129:0x01a9, B:132:0x01b3, B:135:0x01b9, B:140:0x01c3, B:145:0x01cd, B:150:0x01d7, B:152:0x01dd, B:155:0x01eb, B:157:0x01f3, B:159:0x01f7, B:162:0x0206, B:167:0x0211, B:170:0x021b, B:175:0x0226, B:178:0x0230, B:183:0x023b, B:186:0x0245, B:189:0x024c, B:192:0x0256, B:195:0x0263, B:198:0x0269, B:201:0x0276, B:204:0x027c, B:207:0x0289, B:210:0x028f, B:213:0x029c, B:216:0x02a2, B:219:0x02b1), top: B:524:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0465 A[Catch: all -> 0x0141, TRY_LEAVE, TryCatch #1 {all -> 0x0141, blocks: (B:87:0x0134, B:92:0x014c, B:97:0x015d, B:103:0x0169, B:228:0x02c5, B:230:0x02cf, B:232:0x02db, B:235:0x02e6, B:242:0x02f9, B:244:0x0303, B:246:0x030f, B:267:0x0366, B:269:0x0371, B:274:0x0381, B:275:0x0388, B:247:0x0313, B:249:0x031b, B:251:0x0321, B:252:0x0324, B:253:0x0330, B:256:0x0339, B:258:0x033d, B:259:0x0340, B:261:0x0344, B:262:0x0347, B:263:0x0353, B:266:0x035b, B:276:0x0389, B:277:0x03a3, B:279:0x03a6, B:283:0x03b0, B:285:0x03ba, B:287:0x03cd, B:290:0x03d6, B:292:0x03de, B:294:0x03f4, B:296:0x03fc, B:298:0x0400, B:303:0x040f, B:305:0x0417, B:308:0x0437, B:309:0x043e, B:281:0x03ac, B:314:0x044f, B:316:0x0455, B:317:0x045f, B:319:0x0465, B:106:0x0173, B:111:0x017d, B:113:0x0181, B:116:0x018b, B:121:0x0195, B:124:0x019f, B:129:0x01a9, B:132:0x01b3, B:135:0x01b9, B:140:0x01c3, B:145:0x01cd, B:150:0x01d7, B:152:0x01dd, B:155:0x01eb, B:157:0x01f3, B:159:0x01f7, B:162:0x0206, B:167:0x0211, B:170:0x021b, B:175:0x0226, B:178:0x0230, B:183:0x023b, B:186:0x0245, B:189:0x024c, B:192:0x0256, B:195:0x0263, B:198:0x0269, B:201:0x0276, B:204:0x027c, B:207:0x0289, B:210:0x028f, B:213:0x029c, B:216:0x02a2, B:219:0x02b1), top: B:524:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0527 A[Catch: all -> 0x0760, TryCatch #0 {all -> 0x0760, blocks: (B:504:0x0728, B:364:0x051b, B:367:0x0527, B:369:0x052d, B:499:0x0715, B:501:0x071d, B:505:0x0739, B:506:0x0757, B:355:0x04fa, B:357:0x0500, B:359:0x0506, B:362:0x0513, B:507:0x0758, B:508:0x075f), top: B:523:0x0728 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #6 {all -> 0x004b, blocks: (B:17:0x003b, B:19:0x0040, B:29:0x0056, B:31:0x0061, B:33:0x0069, B:39:0x0073, B:45:0x0082, B:50:0x008e, B:52:0x0098, B:55:0x009f, B:57:0x00a5, B:59:0x00b0, B:61:0x00ba, B:69:0x00cd, B:71:0x00d5, B:74:0x00df, B:76:0x0100, B:77:0x0108, B:78:0x011b, B:67:0x00c8, B:82:0x0121), top: B:533:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0771  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        Object obj3;
        ParseContext parseContext;
        FieldDeserializer fieldDeserializer;
        FieldInfo fieldInfo;
        Class<?> cls;
        JSONField annotation;
        int[] iArr2;
        int i2;
        Object obj4;
        boolean z;
        boolean z2;
        Object obj5;
        String str;
        Type type2;
        Class<String> cls2;
        int[] iArr3;
        Class<String> cls3;
        Object obj6;
        Class<?> cls4;
        String str2;
        HashMap hashMap;
        byte b2;
        int i3;
        Class<?> cls5;
        int i4;
        Class<?>[] seeAlso;
        boolean z3;
        Class<String> cls6 = String.class;
        if (type != JSON.class && type != JSONObject.class) {
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            ParserConfig config = defaultJSONParser.getConfig();
            int i5 = jSONLexerBase.token();
            ParseContext parseContext2 = null;
            if (i5 == 8) {
                jSONLexerBase.nextToken(16);
                return null;
            }
            ParseContext context = defaultJSONParser.getContext();
            if (obj2 != null && context != null) {
                context = context.parent;
            }
            ParseContext parseContext3 = context;
            try {
                if (i5 == 13) {
                    jSONLexerBase.nextToken(16);
                    T t = obj2 == null ? (T) createInstance(defaultJSONParser, type) : (T) obj2;
                    defaultJSONParser.setContext(parseContext3);
                    return t;
                }
                if (i5 == 14) {
                    int i6 = Feature.SupportArrayToBean.mask;
                    if ((this.beanInfo.parserFeatures & i6) == 0 && !jSONLexerBase.isEnabled(Feature.SupportArrayToBean) && (i & i6) == 0) {
                        z3 = false;
                        if (z3) {
                            T t2 = (T) deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                            defaultJSONParser.setContext(parseContext3);
                            return t2;
                        }
                    }
                    z3 = true;
                    if (z3) {
                    }
                }
                if (i5 != 12 && i5 != 16) {
                    if (jSONLexerBase.isBlankInput()) {
                        defaultJSONParser.setContext(parseContext3);
                        return null;
                    }
                    if (i5 == 4) {
                        String stringVal = jSONLexerBase.stringVal();
                        if (stringVal.length() == 0) {
                            jSONLexerBase.nextToken();
                            defaultJSONParser.setContext(parseContext3);
                            return null;
                        } else if (this.beanInfo.jsonType != null) {
                            for (Class<?> cls7 : this.beanInfo.jsonType.seeAlso()) {
                                if (Enum.class.isAssignableFrom(cls7)) {
                                    try {
                                        T t3 = (T) Enum.valueOf(cls7, stringVal);
                                        defaultJSONParser.setContext(parseContext3);
                                        return t3;
                                    } catch (IllegalArgumentException unused) {
                                        continue;
                                    }
                                }
                            }
                        }
                    } else if (i5 == 5) {
                        jSONLexerBase.getCalendar();
                    }
                    if (i5 == 14 && jSONLexerBase.getCurrent() == ']') {
                        jSONLexerBase.next();
                        jSONLexerBase.nextToken();
                        defaultJSONParser.setContext(parseContext3);
                        return null;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("syntax error, expect {, actual ");
                    stringBuffer.append(jSONLexerBase.tokenName());
                    stringBuffer.append(", pos ");
                    stringBuffer.append(jSONLexerBase.pos());
                    if (obj instanceof String) {
                        stringBuffer.append(", fieldName ");
                        stringBuffer.append(obj);
                    }
                    stringBuffer.append(", fastjson-version ");
                    stringBuffer.append(JSON.VERSION);
                    throw new JSONException(stringBuffer.toString());
                }
                try {
                    if (defaultJSONParser.resolveStatus == 2) {
                        defaultJSONParser.resolveStatus = 0;
                    }
                    String str3 = this.beanInfo.typeKey;
                    obj3 = obj2;
                    int[] iArr4 = iArr;
                    ParseContext parseContext4 = null;
                    ParseContext parseContext5 = null;
                    int i7 = 0;
                    while (true) {
                        try {
                            if (i7 < this.sortedFieldDeserializers.length) {
                                try {
                                    fieldDeserializer = this.sortedFieldDeserializers[i7];
                                    fieldInfo = fieldDeserializer.fieldInfo;
                                    cls = fieldInfo.fieldClass;
                                    annotation = fieldInfo.getAnnotation();
                                } catch (Throwable th) {
                                    th = th;
                                    parseContext2 = parseContext4;
                                    parseContext = parseContext3;
                                    if (parseContext2 != null) {
                                    }
                                    defaultJSONParser.setContext(parseContext);
                                    throw th;
                                }
                            } else {
                                fieldDeserializer = null;
                                cls = null;
                                fieldInfo = null;
                                annotation = null;
                            }
                            try {
                                if (fieldDeserializer != null) {
                                    i2 = i7;
                                    char[] cArr = fieldInfo.name_chars;
                                    iArr2 = iArr4;
                                    if (cls != Integer.TYPE && cls != Integer.class) {
                                        if (cls != Long.TYPE && cls != Long.class) {
                                            if (cls == cls6) {
                                                obj4 = jSONLexerBase.scanFieldString(cArr);
                                                if (jSONLexerBase.matchStat > 0) {
                                                    z = true;
                                                    z2 = true;
                                                    if (z) {
                                                        obj6 = obj4;
                                                        cls4 = cls;
                                                        cls3 = cls6;
                                                        str2 = null;
                                                    } else {
                                                        cls3 = cls6;
                                                        str2 = jSONLexerBase.scanSymbol(defaultJSONParser.symbolTable);
                                                        if (str2 == null) {
                                                            cls4 = cls;
                                                            int i8 = jSONLexerBase.token();
                                                            obj6 = obj4;
                                                            if (i8 == 13) {
                                                                jSONLexerBase.nextToken(16);
                                                                break;
                                                            } else if (i8 == 16 && jSONLexerBase.isEnabled(Feature.AllowArbitraryCommas)) {
                                                            }
                                                        } else {
                                                            obj6 = obj4;
                                                            cls4 = cls;
                                                        }
                                                        if ("$ref" == str2 && parseContext3 != null) {
                                                            jSONLexerBase.nextTokenWithColon(4);
                                                            if (jSONLexerBase.token() == 4) {
                                                                String stringVal2 = jSONLexerBase.stringVal();
                                                                if ("@".equals(stringVal2)) {
                                                                    obj3 = (T) parseContext3.object;
                                                                } else if (IStringUtil.TOP_PATH.equals(stringVal2)) {
                                                                    ParseContext parseContext6 = parseContext3.parent;
                                                                    if (parseContext6.object != null) {
                                                                        obj3 = (T) parseContext6.object;
                                                                    } else {
                                                                        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext6, stringVal2));
                                                                        defaultJSONParser.resolveStatus = 1;
                                                                    }
                                                                } else if ("$".equals(stringVal2)) {
                                                                    ParseContext parseContext7 = parseContext3;
                                                                    while (parseContext7.parent != null) {
                                                                        parseContext7 = parseContext7.parent;
                                                                    }
                                                                    if (parseContext7.object != null) {
                                                                        obj3 = (T) parseContext7.object;
                                                                    } else {
                                                                        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext7, stringVal2));
                                                                        defaultJSONParser.resolveStatus = 1;
                                                                    }
                                                                } else {
                                                                    Object resolveReference = defaultJSONParser.resolveReference(stringVal2);
                                                                    if (resolveReference != null) {
                                                                        obj3 = (T) resolveReference;
                                                                    } else {
                                                                        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext3, stringVal2));
                                                                        defaultJSONParser.resolveStatus = 1;
                                                                    }
                                                                }
                                                                jSONLexerBase.nextToken(13);
                                                                if (jSONLexerBase.token() == 13) {
                                                                    jSONLexerBase.nextToken(16);
                                                                    defaultJSONParser.setContext(parseContext3, obj3, obj);
                                                                    if (parseContext4 != null) {
                                                                        parseContext4.object = obj3;
                                                                    }
                                                                    defaultJSONParser.setContext(parseContext3);
                                                                    return (T) obj3;
                                                                }
                                                                throw new JSONException("illegal ref");
                                                            }
                                                            throw new JSONException("illegal ref, " + JSONToken.name(i4));
                                                        } else if ((str3 != null && str3.equals(str2)) || JSON.DEFAULT_TYPE_KEY == str2) {
                                                            jSONLexerBase.nextTokenWithColon(4);
                                                            if (jSONLexerBase.token() == 4) {
                                                                String stringVal3 = jSONLexerBase.stringVal();
                                                                jSONLexerBase.nextToken(16);
                                                                if (!stringVal3.equals(this.beanInfo.typeName) && !defaultJSONParser.isEnabled(Feature.IgnoreAutoType)) {
                                                                    ObjectDeserializer seeAlso2 = getSeeAlso(config, this.beanInfo, stringVal3);
                                                                    if (seeAlso2 == null) {
                                                                        cls5 = config.checkAutoType(stringVal3, TypeUtils.getClass(type), jSONLexerBase.getFeatures());
                                                                        seeAlso2 = defaultJSONParser.getConfig().getDeserializer(cls5);
                                                                    } else {
                                                                        cls5 = null;
                                                                    }
                                                                    T t4 = (T) seeAlso2.deserialze(defaultJSONParser, cls5, obj);
                                                                    if (seeAlso2 instanceof JavaBeanDeserializer) {
                                                                        JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) seeAlso2;
                                                                        if (str3 != null) {
                                                                            javaBeanDeserializer.getFieldDeserializer(str3).setValue((Object) t4, stringVal3);
                                                                        }
                                                                    }
                                                                    if (parseContext4 != null) {
                                                                        parseContext4.object = obj3;
                                                                    }
                                                                    defaultJSONParser.setContext(parseContext3);
                                                                    return t4;
                                                                }
                                                                if (jSONLexerBase.token() == 13) {
                                                                    jSONLexerBase.nextToken();
                                                                    break;
                                                                }
                                                                type2 = type;
                                                                iArr3 = iArr2;
                                                                obj5 = obj3;
                                                                str = str3;
                                                                parseContext = parseContext3;
                                                                cls2 = cls3;
                                                                iArr4 = iArr3;
                                                                cls6 = cls2;
                                                                str3 = str;
                                                                obj3 = (T) obj5;
                                                                i7 = i2 + 1;
                                                                parseContext3 = parseContext;
                                                                parseContext5 = parseContext5;
                                                            } else {
                                                                throw new JSONException("syntax error");
                                                            }
                                                        }
                                                    }
                                                    if (obj3 == null && parseContext5 == null) {
                                                        obj3 = (T) createInstance(defaultJSONParser, type);
                                                        if (obj3 == null) {
                                                            parseContext5 = new HashMap(this.fieldDeserializers.length);
                                                        }
                                                        parseContext4 = defaultJSONParser.setContext(parseContext3, obj3, obj);
                                                        if (iArr2 == null) {
                                                            iArr3 = new int[(this.fieldDeserializers.length / 32) + 1];
                                                            Object obj7 = obj3;
                                                            HashMap hashMap2 = parseContext5;
                                                            ParseContext parseContext8 = parseContext4;
                                                            if (z) {
                                                                type2 = type;
                                                                str = str3;
                                                                String str4 = str2;
                                                                hashMap = hashMap2;
                                                                b2 = 0;
                                                                obj5 = obj7;
                                                                i3 = 13;
                                                                parseContext = parseContext3;
                                                                if (!parseField(defaultJSONParser, str4, obj7, type, hashMap, iArr3)) {
                                                                    if (jSONLexerBase.token() == 13) {
                                                                        jSONLexerBase.nextToken();
                                                                        break;
                                                                    }
                                                                    cls2 = cls3;
                                                                    parseContext4 = parseContext8;
                                                                    parseContext5 = hashMap;
                                                                } else {
                                                                    if (jSONLexerBase.token() == 17) {
                                                                        throw new JSONException("syntax error, unexpect token ':'");
                                                                    }
                                                                    if (jSONLexerBase.token() != 16) {
                                                                    }
                                                                }
                                                            } else {
                                                                if (!z2) {
                                                                    type2 = type;
                                                                    try {
                                                                        fieldDeserializer.parseField(defaultJSONParser, obj7, type2, hashMap2);
                                                                    } catch (Throwable th2) {
                                                                        th = th2;
                                                                        obj3 = obj7;
                                                                        parseContext = parseContext3;
                                                                        parseContext2 = parseContext8;
                                                                        if (parseContext2 != null) {
                                                                        }
                                                                        defaultJSONParser.setContext(parseContext);
                                                                        throw th;
                                                                    }
                                                                } else {
                                                                    type2 = type;
                                                                    if (obj7 == null) {
                                                                        hashMap2.put(fieldInfo.name, obj6);
                                                                    } else {
                                                                        Object obj8 = obj6;
                                                                        if (obj8 == null) {
                                                                            Class<?> cls8 = cls4;
                                                                            if (cls8 != Integer.TYPE && cls8 != Long.TYPE && cls8 != Float.TYPE && cls8 != Double.TYPE && cls8 != Boolean.TYPE) {
                                                                                fieldDeserializer.setValue(obj7, obj8);
                                                                            }
                                                                        } else {
                                                                            fieldDeserializer.setValue(obj7, obj8);
                                                                        }
                                                                    }
                                                                    if (iArr3 != null) {
                                                                        int i9 = i2 / 32;
                                                                        iArr3[i9] = (1 >> (i2 % 32)) | iArr3[i9];
                                                                    }
                                                                    if (jSONLexerBase.matchStat == 4) {
                                                                        hashMap = hashMap2;
                                                                        obj5 = obj7;
                                                                        parseContext = parseContext3;
                                                                        b2 = 0;
                                                                        break;
                                                                    }
                                                                }
                                                                str = str3;
                                                                hashMap = hashMap2;
                                                                obj5 = obj7;
                                                                parseContext = parseContext3;
                                                                b2 = 0;
                                                                i3 = 13;
                                                                if (jSONLexerBase.token() != 16) {
                                                                    cls2 = cls3;
                                                                    parseContext4 = parseContext8;
                                                                    parseContext5 = hashMap;
                                                                } else if (jSONLexerBase.token() == i3) {
                                                                    jSONLexerBase.nextToken(16);
                                                                    break;
                                                                } else {
                                                                    cls2 = cls3;
                                                                    if (jSONLexerBase.token() == 18 || jSONLexerBase.token() == 1) {
                                                                        break;
                                                                    }
                                                                    parseContext4 = parseContext8;
                                                                    parseContext5 = hashMap;
                                                                }
                                                            }
                                                            iArr4 = iArr3;
                                                            cls6 = cls2;
                                                            str3 = str;
                                                            obj3 = (T) obj5;
                                                            i7 = i2 + 1;
                                                            parseContext3 = parseContext;
                                                            parseContext5 = parseContext5;
                                                        }
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj72 = obj3;
                                                    HashMap hashMap22 = parseContext5;
                                                    ParseContext parseContext82 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                } else {
                                                    if (jSONLexerBase.matchStat == -2) {
                                                        cls3 = cls6;
                                                    }
                                                    z = false;
                                                    z2 = false;
                                                    if (z) {
                                                    }
                                                    if (obj3 == null) {
                                                        obj3 = (T) createInstance(defaultJSONParser, type);
                                                        if (obj3 == null) {
                                                        }
                                                        parseContext4 = defaultJSONParser.setContext(parseContext3, obj3, obj);
                                                        if (iArr2 == null) {
                                                        }
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj722 = obj3;
                                                    HashMap hashMap222 = parseContext5;
                                                    ParseContext parseContext822 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                }
                                            } else if (cls == Date.class && fieldInfo.format == null) {
                                                obj4 = jSONLexerBase.scanFieldDate(cArr);
                                                if (jSONLexerBase.matchStat > 0) {
                                                    z = true;
                                                    z2 = true;
                                                    if (z) {
                                                    }
                                                    if (obj3 == null) {
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj7222 = obj3;
                                                    HashMap hashMap2222 = parseContext5;
                                                    ParseContext parseContext8222 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                } else {
                                                    if (jSONLexerBase.matchStat == -2) {
                                                        cls3 = cls6;
                                                    }
                                                    z = false;
                                                    z2 = false;
                                                    if (z) {
                                                    }
                                                    if (obj3 == null) {
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj72222 = obj3;
                                                    HashMap hashMap22222 = parseContext5;
                                                    ParseContext parseContext82222 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                }
                                            } else if (cls == BigDecimal.class) {
                                                obj4 = jSONLexerBase.scanFieldDecimal(cArr);
                                                if (jSONLexerBase.matchStat > 0) {
                                                    z = true;
                                                    z2 = true;
                                                    if (z) {
                                                    }
                                                    if (obj3 == null) {
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj722222 = obj3;
                                                    HashMap hashMap222222 = parseContext5;
                                                    ParseContext parseContext822222 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                } else {
                                                    if (jSONLexerBase.matchStat == -2) {
                                                        cls3 = cls6;
                                                    }
                                                    z = false;
                                                    z2 = false;
                                                    if (z) {
                                                    }
                                                    if (obj3 == null) {
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj7222222 = obj3;
                                                    HashMap hashMap2222222 = parseContext5;
                                                    ParseContext parseContext8222222 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                }
                                            } else if (cls == BigInteger.class) {
                                                obj4 = jSONLexerBase.scanFieldBigInteger(cArr);
                                                if (jSONLexerBase.matchStat > 0) {
                                                    z = true;
                                                    z2 = true;
                                                    if (z) {
                                                    }
                                                    if (obj3 == null) {
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj72222222 = obj3;
                                                    HashMap hashMap22222222 = parseContext5;
                                                    ParseContext parseContext82222222 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                } else {
                                                    if (jSONLexerBase.matchStat == -2) {
                                                        cls3 = cls6;
                                                    }
                                                    z = false;
                                                    z2 = false;
                                                    if (z) {
                                                    }
                                                    if (obj3 == null) {
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj722222222 = obj3;
                                                    HashMap hashMap222222222 = parseContext5;
                                                    ParseContext parseContext822222222 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                }
                                            } else {
                                                if (cls != Boolean.TYPE && cls != Boolean.class) {
                                                    if (cls != Float.TYPE && cls != Float.class) {
                                                        if (cls != Double.TYPE && cls != Double.class) {
                                                            if (cls.isEnum() && (defaultJSONParser.getConfig().getDeserializer(cls) instanceof EnumDeserializer) && (annotation == null || annotation.deserializeUsing() == Void.class)) {
                                                                if (fieldDeserializer instanceof DefaultFieldDeserializer) {
                                                                    obj4 = scanEnum(jSONLexerBase, cArr, ((DefaultFieldDeserializer) fieldDeserializer).fieldValueDeserilizer);
                                                                    if (jSONLexerBase.matchStat > 0) {
                                                                        z = true;
                                                                        z2 = true;
                                                                        if (z) {
                                                                        }
                                                                        if (obj3 == null) {
                                                                        }
                                                                        iArr3 = iArr2;
                                                                        Object obj7222222222 = obj3;
                                                                        HashMap hashMap2222222222 = parseContext5;
                                                                        ParseContext parseContext8222222222 = parseContext4;
                                                                        if (z) {
                                                                        }
                                                                        iArr4 = iArr3;
                                                                        cls6 = cls2;
                                                                        str3 = str;
                                                                        obj3 = (T) obj5;
                                                                        i7 = i2 + 1;
                                                                        parseContext3 = parseContext;
                                                                        parseContext5 = parseContext5;
                                                                    } else {
                                                                        if (jSONLexerBase.matchStat == -2) {
                                                                            cls3 = cls6;
                                                                        }
                                                                        z = false;
                                                                        z2 = false;
                                                                        if (z) {
                                                                        }
                                                                        if (obj3 == null) {
                                                                        }
                                                                        iArr3 = iArr2;
                                                                        Object obj72222222222 = obj3;
                                                                        HashMap hashMap22222222222 = parseContext5;
                                                                        ParseContext parseContext82222222222 = parseContext4;
                                                                        if (z) {
                                                                        }
                                                                        iArr4 = iArr3;
                                                                        cls6 = cls2;
                                                                        str3 = str;
                                                                        obj3 = (T) obj5;
                                                                        i7 = i2 + 1;
                                                                        parseContext3 = parseContext;
                                                                        parseContext5 = parseContext5;
                                                                    }
                                                                }
                                                            } else if (cls == int[].class) {
                                                                obj4 = jSONLexerBase.scanFieldIntArray(cArr);
                                                                if (jSONLexerBase.matchStat > 0) {
                                                                    z = true;
                                                                    z2 = true;
                                                                    if (z) {
                                                                    }
                                                                    if (obj3 == null) {
                                                                    }
                                                                    iArr3 = iArr2;
                                                                    Object obj722222222222 = obj3;
                                                                    HashMap hashMap222222222222 = parseContext5;
                                                                    ParseContext parseContext822222222222 = parseContext4;
                                                                    if (z) {
                                                                    }
                                                                    iArr4 = iArr3;
                                                                    cls6 = cls2;
                                                                    str3 = str;
                                                                    obj3 = (T) obj5;
                                                                    i7 = i2 + 1;
                                                                    parseContext3 = parseContext;
                                                                    parseContext5 = parseContext5;
                                                                } else {
                                                                    if (jSONLexerBase.matchStat == -2) {
                                                                        cls3 = cls6;
                                                                    }
                                                                    z = false;
                                                                    z2 = false;
                                                                    if (z) {
                                                                    }
                                                                    if (obj3 == null) {
                                                                    }
                                                                    iArr3 = iArr2;
                                                                    Object obj7222222222222 = obj3;
                                                                    HashMap hashMap2222222222222 = parseContext5;
                                                                    ParseContext parseContext8222222222222 = parseContext4;
                                                                    if (z) {
                                                                    }
                                                                    iArr4 = iArr3;
                                                                    cls6 = cls2;
                                                                    str3 = str;
                                                                    obj3 = (T) obj5;
                                                                    i7 = i2 + 1;
                                                                    parseContext3 = parseContext;
                                                                    parseContext5 = parseContext5;
                                                                }
                                                            } else if (cls == float[].class) {
                                                                obj4 = jSONLexerBase.scanFieldFloatArray(cArr);
                                                                if (jSONLexerBase.matchStat > 0) {
                                                                    z = true;
                                                                    z2 = true;
                                                                    if (z) {
                                                                    }
                                                                    if (obj3 == null) {
                                                                    }
                                                                    iArr3 = iArr2;
                                                                    Object obj72222222222222 = obj3;
                                                                    HashMap hashMap22222222222222 = parseContext5;
                                                                    ParseContext parseContext82222222222222 = parseContext4;
                                                                    if (z) {
                                                                    }
                                                                    iArr4 = iArr3;
                                                                    cls6 = cls2;
                                                                    str3 = str;
                                                                    obj3 = (T) obj5;
                                                                    i7 = i2 + 1;
                                                                    parseContext3 = parseContext;
                                                                    parseContext5 = parseContext5;
                                                                } else {
                                                                    if (jSONLexerBase.matchStat == -2) {
                                                                        cls3 = cls6;
                                                                    }
                                                                    z = false;
                                                                    z2 = false;
                                                                    if (z) {
                                                                    }
                                                                    if (obj3 == null) {
                                                                    }
                                                                    iArr3 = iArr2;
                                                                    Object obj722222222222222 = obj3;
                                                                    HashMap hashMap222222222222222 = parseContext5;
                                                                    ParseContext parseContext822222222222222 = parseContext4;
                                                                    if (z) {
                                                                    }
                                                                    iArr4 = iArr3;
                                                                    cls6 = cls2;
                                                                    str3 = str;
                                                                    obj3 = (T) obj5;
                                                                    i7 = i2 + 1;
                                                                    parseContext3 = parseContext;
                                                                    parseContext5 = parseContext5;
                                                                }
                                                            } else {
                                                                if (cls == float[][].class) {
                                                                    obj4 = jSONLexerBase.scanFieldFloatArray2(cArr);
                                                                    if (jSONLexerBase.matchStat > 0) {
                                                                        z = true;
                                                                        z2 = true;
                                                                        if (z) {
                                                                        }
                                                                        if (obj3 == null) {
                                                                        }
                                                                        iArr3 = iArr2;
                                                                        Object obj7222222222222222 = obj3;
                                                                        HashMap hashMap2222222222222222 = parseContext5;
                                                                        ParseContext parseContext8222222222222222 = parseContext4;
                                                                        if (z) {
                                                                        }
                                                                        iArr4 = iArr3;
                                                                        cls6 = cls2;
                                                                        str3 = str;
                                                                        obj3 = (T) obj5;
                                                                        i7 = i2 + 1;
                                                                        parseContext3 = parseContext;
                                                                        parseContext5 = parseContext5;
                                                                    } else {
                                                                        if (jSONLexerBase.matchStat == -2) {
                                                                        }
                                                                        z = false;
                                                                        z2 = false;
                                                                        if (z) {
                                                                        }
                                                                        if (obj3 == null) {
                                                                        }
                                                                        iArr3 = iArr2;
                                                                        Object obj72222222222222222 = obj3;
                                                                        HashMap hashMap22222222222222222 = parseContext5;
                                                                        ParseContext parseContext82222222222222222 = parseContext4;
                                                                        if (z) {
                                                                        }
                                                                        iArr4 = iArr3;
                                                                        cls6 = cls2;
                                                                        str3 = str;
                                                                        obj3 = (T) obj5;
                                                                        i7 = i2 + 1;
                                                                        parseContext3 = parseContext;
                                                                        parseContext5 = parseContext5;
                                                                    }
                                                                } else if (jSONLexerBase.matchField(cArr)) {
                                                                    obj4 = null;
                                                                    z = true;
                                                                    z2 = false;
                                                                    if (z) {
                                                                    }
                                                                    if (obj3 == null) {
                                                                    }
                                                                    iArr3 = iArr2;
                                                                    Object obj722222222222222222 = obj3;
                                                                    HashMap hashMap222222222222222222 = parseContext5;
                                                                    ParseContext parseContext822222222222222222 = parseContext4;
                                                                    if (z) {
                                                                    }
                                                                    iArr4 = iArr3;
                                                                    cls6 = cls2;
                                                                    str3 = str;
                                                                    obj3 = (T) obj5;
                                                                    i7 = i2 + 1;
                                                                    parseContext3 = parseContext;
                                                                    parseContext5 = parseContext5;
                                                                }
                                                                cls3 = cls6;
                                                            }
                                                        }
                                                        obj4 = Double.valueOf(jSONLexerBase.scanFieldDouble(cArr));
                                                        if (jSONLexerBase.matchStat > 0) {
                                                            z = true;
                                                            z2 = true;
                                                            if (z) {
                                                            }
                                                            if (obj3 == null) {
                                                            }
                                                            iArr3 = iArr2;
                                                            Object obj7222222222222222222 = obj3;
                                                            HashMap hashMap2222222222222222222 = parseContext5;
                                                            ParseContext parseContext8222222222222222222 = parseContext4;
                                                            if (z) {
                                                            }
                                                            iArr4 = iArr3;
                                                            cls6 = cls2;
                                                            str3 = str;
                                                            obj3 = (T) obj5;
                                                            i7 = i2 + 1;
                                                            parseContext3 = parseContext;
                                                            parseContext5 = parseContext5;
                                                        } else {
                                                            if (jSONLexerBase.matchStat == -2) {
                                                                cls3 = cls6;
                                                            }
                                                            z = false;
                                                            z2 = false;
                                                            if (z) {
                                                            }
                                                            if (obj3 == null) {
                                                            }
                                                            iArr3 = iArr2;
                                                            Object obj72222222222222222222 = obj3;
                                                            HashMap hashMap22222222222222222222 = parseContext5;
                                                            ParseContext parseContext82222222222222222222 = parseContext4;
                                                            if (z) {
                                                            }
                                                            iArr4 = iArr3;
                                                            cls6 = cls2;
                                                            str3 = str;
                                                            obj3 = (T) obj5;
                                                            i7 = i2 + 1;
                                                            parseContext3 = parseContext;
                                                            parseContext5 = parseContext5;
                                                        }
                                                    }
                                                    obj4 = Float.valueOf(jSONLexerBase.scanFieldFloat(cArr));
                                                    if (jSONLexerBase.matchStat > 0) {
                                                        z = true;
                                                        z2 = true;
                                                        if (z) {
                                                        }
                                                        if (obj3 == null) {
                                                        }
                                                        iArr3 = iArr2;
                                                        Object obj722222222222222222222 = obj3;
                                                        HashMap hashMap222222222222222222222 = parseContext5;
                                                        ParseContext parseContext822222222222222222222 = parseContext4;
                                                        if (z) {
                                                        }
                                                        iArr4 = iArr3;
                                                        cls6 = cls2;
                                                        str3 = str;
                                                        obj3 = (T) obj5;
                                                        i7 = i2 + 1;
                                                        parseContext3 = parseContext;
                                                        parseContext5 = parseContext5;
                                                    } else {
                                                        if (jSONLexerBase.matchStat == -2) {
                                                            cls3 = cls6;
                                                        }
                                                        z = false;
                                                        z2 = false;
                                                        if (z) {
                                                        }
                                                        if (obj3 == null) {
                                                        }
                                                        iArr3 = iArr2;
                                                        Object obj7222222222222222222222 = obj3;
                                                        HashMap hashMap2222222222222222222222 = parseContext5;
                                                        ParseContext parseContext8222222222222222222222 = parseContext4;
                                                        if (z) {
                                                        }
                                                        iArr4 = iArr3;
                                                        cls6 = cls2;
                                                        str3 = str;
                                                        obj3 = (T) obj5;
                                                        i7 = i2 + 1;
                                                        parseContext3 = parseContext;
                                                        parseContext5 = parseContext5;
                                                    }
                                                }
                                                obj4 = Boolean.valueOf(jSONLexerBase.scanFieldBoolean(cArr));
                                                if (jSONLexerBase.matchStat > 0) {
                                                    z = true;
                                                    z2 = true;
                                                    if (z) {
                                                    }
                                                    if (obj3 == null) {
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj72222222222222222222222 = obj3;
                                                    HashMap hashMap22222222222222222222222 = parseContext5;
                                                    ParseContext parseContext82222222222222222222222 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                } else {
                                                    if (jSONLexerBase.matchStat == -2) {
                                                        cls3 = cls6;
                                                    }
                                                    z = false;
                                                    z2 = false;
                                                    if (z) {
                                                    }
                                                    if (obj3 == null) {
                                                    }
                                                    iArr3 = iArr2;
                                                    Object obj722222222222222222222222 = obj3;
                                                    HashMap hashMap222222222222222222222222 = parseContext5;
                                                    ParseContext parseContext822222222222222222222222 = parseContext4;
                                                    if (z) {
                                                    }
                                                    iArr4 = iArr3;
                                                    cls6 = cls2;
                                                    str3 = str;
                                                    obj3 = (T) obj5;
                                                    i7 = i2 + 1;
                                                    parseContext3 = parseContext;
                                                    parseContext5 = parseContext5;
                                                }
                                            }
                                            type2 = type;
                                            iArr3 = iArr2;
                                            obj5 = obj3;
                                            str = str3;
                                            parseContext = parseContext3;
                                            cls2 = cls3;
                                            iArr4 = iArr3;
                                            cls6 = cls2;
                                            str3 = str;
                                            obj3 = (T) obj5;
                                            i7 = i2 + 1;
                                            parseContext3 = parseContext;
                                            parseContext5 = parseContext5;
                                        }
                                        obj4 = Long.valueOf(jSONLexerBase.scanFieldLong(cArr));
                                        if (jSONLexerBase.matchStat > 0) {
                                            z = true;
                                            z2 = true;
                                            if (z) {
                                            }
                                            if (obj3 == null) {
                                            }
                                            iArr3 = iArr2;
                                            Object obj7222222222222222222222222 = obj3;
                                            HashMap hashMap2222222222222222222222222 = parseContext5;
                                            ParseContext parseContext8222222222222222222222222 = parseContext4;
                                            if (z) {
                                            }
                                            iArr4 = iArr3;
                                            cls6 = cls2;
                                            str3 = str;
                                            obj3 = (T) obj5;
                                            i7 = i2 + 1;
                                            parseContext3 = parseContext;
                                            parseContext5 = parseContext5;
                                        } else {
                                            if (jSONLexerBase.matchStat == -2) {
                                                cls3 = cls6;
                                                type2 = type;
                                                iArr3 = iArr2;
                                                obj5 = obj3;
                                                str = str3;
                                                parseContext = parseContext3;
                                                cls2 = cls3;
                                                iArr4 = iArr3;
                                                cls6 = cls2;
                                                str3 = str;
                                                obj3 = (T) obj5;
                                                i7 = i2 + 1;
                                                parseContext3 = parseContext;
                                                parseContext5 = parseContext5;
                                            }
                                            z = false;
                                            z2 = false;
                                            if (z) {
                                            }
                                            if (obj3 == null) {
                                            }
                                            iArr3 = iArr2;
                                            Object obj72222222222222222222222222 = obj3;
                                            HashMap hashMap22222222222222222222222222 = parseContext5;
                                            ParseContext parseContext82222222222222222222222222 = parseContext4;
                                            if (z) {
                                            }
                                            iArr4 = iArr3;
                                            cls6 = cls2;
                                            str3 = str;
                                            obj3 = (T) obj5;
                                            i7 = i2 + 1;
                                            parseContext3 = parseContext;
                                            parseContext5 = parseContext5;
                                        }
                                    }
                                    obj4 = Integer.valueOf(jSONLexerBase.scanFieldInt(cArr));
                                    if (jSONLexerBase.matchStat <= 0) {
                                    }
                                    z = true;
                                    z2 = true;
                                    if (z) {
                                    }
                                    if (obj3 == null) {
                                    }
                                    iArr3 = iArr2;
                                    Object obj722222222222222222222222222 = obj3;
                                    HashMap hashMap222222222222222222222222222 = parseContext5;
                                    ParseContext parseContext822222222222222222222222222 = parseContext4;
                                    if (z) {
                                    }
                                    iArr4 = iArr3;
                                    cls6 = cls2;
                                    str3 = str;
                                    obj3 = (T) obj5;
                                    i7 = i2 + 1;
                                    parseContext3 = parseContext;
                                    parseContext5 = parseContext5;
                                } else {
                                    iArr2 = iArr4;
                                    i2 = i7;
                                }
                                iArr4 = iArr3;
                                cls6 = cls2;
                                str3 = str;
                                obj3 = (T) obj5;
                                i7 = i2 + 1;
                                parseContext3 = parseContext;
                                parseContext5 = parseContext5;
                            } catch (Throwable th3) {
                                th = th3;
                                parseContext2 = parseContext5;
                                obj3 = obj5;
                                if (parseContext2 != null) {
                                    parseContext2.object = obj3;
                                }
                                defaultJSONParser.setContext(parseContext);
                                throw th;
                            }
                            obj4 = null;
                            z = false;
                            z2 = false;
                            if (z) {
                            }
                            if (obj3 == null) {
                            }
                            iArr3 = iArr2;
                            Object obj7222222222222222222222222222 = obj3;
                            HashMap hashMap2222222222222222222222222222 = parseContext5;
                            ParseContext parseContext8222222222222222222222222222 = parseContext4;
                            if (z) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            parseContext = parseContext3;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    parseContext = parseContext3;
                    obj3 = obj2;
                }
            } catch (Throwable th6) {
                th = th6;
                obj3 = obj2;
            }
        } else {
            return (T) defaultJSONParser.parse();
        }
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        String[] strArr;
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(long j) {
        int i = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = TypeUtils.fnv1a_64(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
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
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i;
                }
                i++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch];
        if (s != -1) {
            return this.sortedFieldDeserializers[s];
        }
        return null;
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null && javaBeanInfo.factoryMethod == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                FieldDeserializer smartMatch = smartMatch(entry.getKey());
                if (smartMatch != null) {
                    smartMatch.setValue(createInstance, TypeUtils.cast(value, smartMatch.fieldInfo.fieldType, parserConfig));
                }
            }
            Method method = this.beanInfo.buildMethod;
            if (method != null) {
                try {
                    return method.invoke(createInstance, new Object[0]);
                } catch (Exception e2) {
                    throw new JSONException("build object error", e2);
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = this.beanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = fieldInfoArr[i];
            char c2 = map.get(fieldInfo.name);
            if (c2 == null) {
                Class<?> cls = fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    c2 = 0;
                } else if (cls == Long.TYPE) {
                    c2 = 0L;
                } else if (cls == Short.TYPE) {
                    c2 = (short) 0;
                } else if (cls == Byte.TYPE) {
                    c2 = (byte) 0;
                } else if (cls == Float.TYPE) {
                    c2 = Float.valueOf(0.0f);
                } else if (cls == Double.TYPE) {
                    c2 = Double.valueOf(0.0d);
                } else if (cls == Character.TYPE) {
                    c2 = '0';
                } else if (cls == Boolean.TYPE) {
                    c2 = Boolean.FALSE;
                }
            }
            objArr[i] = c2;
        }
        JavaBeanInfo javaBeanInfo2 = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo2.creatorConstructor;
        if (constructor != null) {
            try {
                return constructor.newInstance(objArr);
            } catch (Exception e3) {
                throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e3);
            }
        }
        Method method2 = javaBeanInfo2.factoryMethod;
        if (method2 != null) {
            try {
                return method2.invoke(null, objArr);
            } catch (Exception e4) {
                throw new JSONException("create factory method error, " + this.beanInfo.factoryMethod.toString(), e4);
            }
        }
        return null;
    }
}
