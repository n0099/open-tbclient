package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    public SerializeBeanInfo beanInfo;
    public final FieldSerializer[] getters;
    public volatile transient long[] hashArray;
    public volatile transient short[] hashArrayMapping;
    public final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        List<LabelFilter> list = jSONSerializer.labelFilters;
        if (list != null) {
            for (LabelFilter labelFilter : list) {
                if (!labelFilter.apply(str)) {
                    return false;
                }
            }
        }
        List<LabelFilter> list2 = this.labelFilters;
        if (list2 != null) {
            for (LabelFilter labelFilter2 : list2) {
                if (!labelFilter2.apply(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int length = this.sortedGetters.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else if (compareTo <= 0) {
                return this.sortedGetters[i2];
            } else {
                length = i2 - 1;
            }
        }
        return null;
    }

    public Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            } catch (InvocationTargetException e3) {
                throw new JSONException("getFieldValue error." + str, e3);
            }
        }
        throw new JSONException("field not found. " + str);
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c2) {
        List<AfterFilter> list = jSONSerializer.afterFilters;
        if (list != null) {
            for (AfterFilter afterFilter : list) {
                c2 = afterFilter.writeAfter(jSONSerializer, obj, c2);
            }
        }
        List<AfterFilter> list2 = this.afterFilters;
        if (list2 != null) {
            for (AfterFilter afterFilter2 : list2) {
                c2 = afterFilter2.writeAfter(jSONSerializer, obj, c2);
            }
        }
        return c2;
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c2) {
        List<BeforeFilter> list = jSONSerializer.beforeFilters;
        if (list != null) {
            for (BeforeFilter beforeFilter : list) {
                c2 = beforeFilter.writeBefore(jSONSerializer, obj, c2);
            }
        }
        List<BeforeFilter> list2 = this.beforeFilters;
        if (list2 != null) {
            for (BeforeFilter beforeFilter2 : list2) {
                c2 = beforeFilter2.writeBefore(jSONSerializer, obj, c2);
            }
        }
        return c2;
    }

    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class<?> cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext != null && (serialContext.features & i2) == 0 && (i & i2) == 0 && (identityHashMap = jSONSerializer.references) != null && identityHashMap.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return true;
        }
        return false;
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ea, code lost:
        if (r10.fieldTransient != false) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0352 A[Catch: Exception -> 0x0396, all -> 0x03cf, TryCatch #6 {Exception -> 0x0396, blocks: (B:64:0x00de, B:75:0x00f8, B:77:0x00fe, B:80:0x0108, B:91:0x0127, B:271:0x037a, B:94:0x0130, B:102:0x014c, B:107:0x016f, B:109:0x017d, B:113:0x0186, B:115:0x0194, B:118:0x019b, B:120:0x01a3, B:122:0x01b1, B:125:0x01b7, B:127:0x01bf, B:129:0x01cd, B:132:0x01d3, B:134:0x01d7, B:138:0x01e4, B:140:0x01e8, B:142:0x01f1, B:144:0x01fc, B:146:0x0202, B:148:0x0206, B:151:0x0211, B:153:0x0215, B:155:0x0219, B:158:0x0224, B:160:0x0228, B:162:0x022c, B:165:0x0237, B:167:0x023b, B:169:0x023f, B:172:0x024d, B:174:0x0251, B:176:0x0255, B:179:0x0262, B:181:0x0266, B:183:0x026a, B:186:0x0278, B:188:0x027c, B:190:0x0280, B:194:0x028c, B:196:0x0290, B:198:0x0294, B:201:0x02a1, B:203:0x02ac, B:207:0x02b5, B:209:0x02bb, B:250:0x0340, B:252:0x0344, B:254:0x0348, B:257:0x0352, B:259:0x035a, B:260:0x0362, B:262:0x0368, B:214:0x02c6, B:215:0x02c9, B:217:0x02cf, B:220:0x02d5, B:224:0x02e7, B:227:0x02ef, B:230:0x02f9, B:232:0x0302, B:235:0x030c, B:236:0x0310, B:237:0x0316, B:239:0x031d, B:240:0x0321, B:241:0x0325, B:243:0x0329, B:245:0x032d, B:248:0x0339, B:249:0x033d, B:221:0x02df), top: B:323:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03c5 A[Catch: all -> 0x03cf, Exception -> 0x03d3, TRY_LEAVE, TryCatch #7 {Exception -> 0x03d3, blocks: (B:281:0x03ad, B:283:0x03b5, B:285:0x03bd, B:287:0x03c5), top: B:325:0x03ad }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0401 A[Catch: all -> 0x0439, TryCatch #5 {all -> 0x0439, blocks: (B:301:0x03e1, B:304:0x0401, B:305:0x0415, B:307:0x041b, B:308:0x0433, B:309:0x0438), top: B:321:0x03e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x041b A[Catch: all -> 0x0439, TryCatch #5 {all -> 0x0439, blocks: (B:301:0x03e1, B:304:0x0401, B:305:0x0415, B:307:0x041b, B:308:0x0433, B:309:0x0438), top: B:321:0x03e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x03e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i, boolean z) throws IOException {
        FieldSerializer[] fieldSerializerArr;
        SerialContext serialContext;
        Object obj3;
        boolean z2;
        int i2;
        FieldSerializer[] fieldSerializerArr2;
        SerialContext serialContext2;
        String str;
        int i3;
        char c2;
        char c3;
        boolean z3;
        Map map;
        boolean z4;
        Object obj4 = obj;
        Type type2 = type;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj4 == null) {
            serializeWriter.writeNull();
        } else if (writeReference(jSONSerializer, obj4, i)) {
        } else {
            if (serializeWriter.sortField) {
                fieldSerializerArr = this.sortedGetters;
            } else {
                fieldSerializerArr = this.getters;
            }
            FieldSerializer[] fieldSerializerArr3 = fieldSerializerArr;
            SerialContext serialContext3 = jSONSerializer.context;
            if (!this.beanInfo.beanType.isEnum()) {
                jSONSerializer.setContext(serialContext3, obj, obj2, this.beanInfo.features, i);
            }
            boolean isWriteAsArray = isWriteAsArray(jSONSerializer, i);
            char c4 = isWriteAsArray ? '[' : '{';
            char c5 = isWriteAsArray ? ']' : '}';
            if (!z) {
                try {
                    try {
                        serializeWriter.append(c4);
                    } catch (Exception e2) {
                        e = e2;
                        obj3 = obj4;
                        serialContext = serialContext3;
                        String str2 = "write javaBean error, fastjson version 1.2.41";
                        if (obj3 != null) {
                        }
                        if (obj2 != null) {
                        }
                        if (e.getMessage() != null) {
                        }
                        throw new JSONException(str2, e);
                    }
                } catch (Throwable th) {
                    th = th;
                    serialContext = serialContext3;
                    jSONSerializer.context = serialContext;
                    throw th;
                }
            }
            if (fieldSerializerArr3.length > 0 && serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
            }
            try {
                if ((this.beanInfo.features & SerializerFeature.WriteClassName.mask) != 0 || (i & SerializerFeature.WriteClassName.mask) != 0 || jSONSerializer.isWriteClassName(type2, obj4)) {
                    Class<?> cls = obj.getClass();
                    if (cls != ((cls == type2 || !(type2 instanceof WildcardType)) ? type2 : TypeUtils.getClass(type))) {
                        writeClassName(jSONSerializer, this.beanInfo.typeKey, obj4);
                        z2 = true;
                        char c6 = !z2 ? ',' : (char) 0;
                        boolean z5 = (serializeWriter.quoteFieldNames || serializeWriter.useSingleQuotes) ? false : true;
                        boolean z6 = writeBefore(jSONSerializer, obj4, c6) != ',';
                        boolean isEnabled = serializeWriter.isEnabled(SerializerFeature.SkipTransientField);
                        boolean isEnabled2 = serializeWriter.isEnabled(SerializerFeature.IgnoreNonFieldGetter);
                        boolean z7 = z6;
                        i2 = 0;
                        while (i2 < fieldSerializerArr3.length) {
                            try {
                                FieldSerializer fieldSerializer = fieldSerializerArr3[i2];
                                Field field = fieldSerializer.fieldInfo.field;
                                FieldInfo fieldInfo = fieldSerializer.fieldInfo;
                                serialContext2 = serialContext3;
                                try {
                                    try {
                                        String str3 = fieldInfo.name;
                                        FieldSerializer[] fieldSerializerArr4 = fieldSerializerArr3;
                                        Class<?> cls2 = fieldInfo.fieldClass;
                                        if (isEnabled && field != null) {
                                            try {
                                            } catch (Exception e3) {
                                                e = e3;
                                                obj3 = obj4;
                                                serialContext = serialContext2;
                                                String str22 = "write javaBean error, fastjson version 1.2.41";
                                                if (obj3 != null) {
                                                    try {
                                                        str22 = "write javaBean error, fastjson version 1.2.41, class " + obj.getClass().getName();
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        jSONSerializer.context = serialContext;
                                                        throw th;
                                                    }
                                                }
                                                if (obj2 != null) {
                                                    str22 = str22 + ", fieldName : " + obj2;
                                                }
                                                if (e.getMessage() != null) {
                                                    str22 = str22 + StringUtil.ARRAY_ELEMENT_SEPARATOR + e.getMessage();
                                                }
                                                throw new JSONException(str22, e);
                                            }
                                        }
                                        if ((!isEnabled2 || field != null) && applyName(jSONSerializer, obj4, str3) && applyLabel(jSONSerializer, fieldInfo.label) && (this.beanInfo.typeKey == null || !str3.equals(this.beanInfo.typeKey) || !jSONSerializer.isWriteClassName(type2, obj4))) {
                                            try {
                                                str = fieldSerializer.getPropertyValueDirect(obj4);
                                            } catch (InvocationTargetException e4) {
                                                if (!serializeWriter.isEnabled(SerializerFeature.IgnoreErrorGetter)) {
                                                    throw e4;
                                                }
                                                str = null;
                                            }
                                            if (apply(jSONSerializer, obj4, str3, str)) {
                                                if (cls2 == String.class && "trim".equals(fieldInfo.format) && str != null) {
                                                    str = ((String) str).trim();
                                                }
                                                String processKey = processKey(jSONSerializer, obj4, str3, str);
                                                i3 = i2;
                                                c2 = c5;
                                                Object processValue = processValue(jSONSerializer, fieldSerializer.fieldContext, obj, str3, str);
                                                if (processValue == null && !isWriteAsArray) {
                                                    if (cls2 != Boolean.class) {
                                                        if (cls2 == String.class) {
                                                            int i4 = SerializerFeature.WriteNullStringAsEmpty.mask | SerializerFeature.WriteMapNullValue.mask;
                                                            if ((fieldInfo.serialzeFeatures & i4) == 0 && (i4 & serializeWriter.features) == 0) {
                                                            }
                                                        } else if (Number.class.isAssignableFrom(cls2)) {
                                                            int i5 = SerializerFeature.WriteNullNumberAsZero.mask | SerializerFeature.WriteMapNullValue.mask;
                                                            if ((fieldInfo.serialzeFeatures & i5) == 0 && (i5 & serializeWriter.features) == 0) {
                                                            }
                                                        } else if (Collection.class.isAssignableFrom(cls2)) {
                                                            int i6 = SerializerFeature.WriteNullListAsEmpty.mask | SerializerFeature.WriteMapNullValue.mask;
                                                            if ((fieldInfo.serialzeFeatures & i6) == 0 && (i6 & serializeWriter.features) == 0) {
                                                            }
                                                        } else if (!fieldSerializer.writeNull && !serializeWriter.isEnabled(SerializerFeature.WriteMapNullValue.mask)) {
                                                        }
                                                    } else {
                                                        int i7 = SerializerFeature.WriteNullBooleanAsFalse.mask | SerializerFeature.WriteMapNullValue.mask;
                                                        if ((fieldInfo.serialzeFeatures & i7) == 0 && (i7 & serializeWriter.features) == 0) {
                                                        }
                                                    }
                                                    i2 = i3 + 1;
                                                    obj4 = obj;
                                                    type2 = type;
                                                    serialContext3 = serialContext2;
                                                    fieldSerializerArr3 = fieldSerializerArr4;
                                                    c5 = c2;
                                                }
                                                if (processValue != null && (serializeWriter.notWriteDefaultValue || (fieldInfo.serialzeFeatures & SerializerFeature.NotWriteDefaultValue.mask) != 0 || (this.beanInfo.features & SerializerFeature.NotWriteDefaultValue.mask) != 0)) {
                                                    Class<?> cls3 = fieldInfo.fieldClass;
                                                    if (cls3 != Byte.TYPE || !(processValue instanceof Byte) || ((Byte) processValue).byteValue() != 0) {
                                                        if (cls3 != Short.TYPE || !(processValue instanceof Short) || ((Short) processValue).shortValue() != 0) {
                                                            if (cls3 != Integer.TYPE || !(processValue instanceof Integer) || ((Integer) processValue).intValue() != 0) {
                                                                if (cls3 != Long.TYPE || !(processValue instanceof Long) || ((Long) processValue).longValue() != 0) {
                                                                    if ((cls3 != Float.TYPE || !(processValue instanceof Float) || ((Float) processValue).floatValue() != 0.0f) && (cls3 != Double.TYPE || !(processValue instanceof Double) || ((Double) processValue).doubleValue() != 0.0d)) {
                                                                        if (cls3 == Boolean.TYPE && (processValue instanceof Boolean) && !((Boolean) processValue).booleanValue()) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            i2 = i3 + 1;
                                                            obj4 = obj;
                                                            type2 = type;
                                                            serialContext3 = serialContext2;
                                                            fieldSerializerArr3 = fieldSerializerArr4;
                                                            c5 = c2;
                                                        }
                                                        i2 = i3 + 1;
                                                        obj4 = obj;
                                                        type2 = type;
                                                        serialContext3 = serialContext2;
                                                        fieldSerializerArr3 = fieldSerializerArr4;
                                                        c5 = c2;
                                                    }
                                                    i2 = i3 + 1;
                                                    obj4 = obj;
                                                    type2 = type;
                                                    serialContext3 = serialContext2;
                                                    fieldSerializerArr3 = fieldSerializerArr4;
                                                    c5 = c2;
                                                }
                                                if (z7) {
                                                    if (!fieldInfo.unwrapped || !(processValue instanceof Map) || ((Map) processValue).size() != 0) {
                                                        serializeWriter.write(44);
                                                        if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                                            jSONSerializer.println();
                                                        }
                                                    }
                                                    i2 = i3 + 1;
                                                    obj4 = obj;
                                                    type2 = type;
                                                    serialContext3 = serialContext2;
                                                    fieldSerializerArr3 = fieldSerializerArr4;
                                                    c5 = c2;
                                                }
                                                if (processKey != str3) {
                                                    if (!isWriteAsArray) {
                                                        serializeWriter.writeFieldName(processKey, true);
                                                    }
                                                    jSONSerializer.write(processValue);
                                                } else if (str != processValue) {
                                                    if (!isWriteAsArray) {
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                    jSONSerializer.write(processValue);
                                                } else {
                                                    if (isWriteAsArray || fieldInfo.unwrapped) {
                                                        c3 = 0;
                                                    } else if (z5) {
                                                        c3 = 0;
                                                        serializeWriter.write(fieldInfo.name_chars, 0, fieldInfo.name_chars.length);
                                                    } else {
                                                        c3 = 0;
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                    if (!isWriteAsArray) {
                                                        JSONField annotation = fieldInfo.getAnnotation();
                                                        if (cls2 == String.class && (annotation == null || annotation.serializeUsing() == Void.class)) {
                                                            if (processValue == null) {
                                                                if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0 && (fieldSerializer.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                    serializeWriter.writeNull();
                                                                }
                                                                serializeWriter.writeString("");
                                                            } else {
                                                                String str4 = (String) processValue;
                                                                if (serializeWriter.useSingleQuotes) {
                                                                    serializeWriter.writeStringWithSingleQuote(str4);
                                                                } else {
                                                                    serializeWriter.writeStringWithDoubleQuote(str4, c3);
                                                                }
                                                            }
                                                        } else if (fieldInfo.unwrapped && (processValue instanceof Map) && ((Map) processValue).size() == 0) {
                                                            z7 = false;
                                                            i2 = i3 + 1;
                                                            obj4 = obj;
                                                            type2 = type;
                                                            serialContext3 = serialContext2;
                                                            fieldSerializerArr3 = fieldSerializerArr4;
                                                            c5 = c2;
                                                        } else {
                                                            fieldSerializer.writeValue(jSONSerializer, processValue);
                                                        }
                                                    } else {
                                                        fieldSerializer.writeValue(jSONSerializer, processValue);
                                                    }
                                                    if (fieldInfo.unwrapped && (processValue instanceof Map)) {
                                                        map = (Map) processValue;
                                                        if (map.size() != 0) {
                                                            if (!jSONSerializer.isEnabled(SerializerFeature.WriteMapNullValue)) {
                                                                Iterator it = map.values().iterator();
                                                                while (true) {
                                                                    if (!it.hasNext()) {
                                                                        z4 = false;
                                                                        break;
                                                                    } else if (it.next() != null) {
                                                                        z4 = true;
                                                                        break;
                                                                    }
                                                                }
                                                                if (!z4) {
                                                                }
                                                            }
                                                        }
                                                        z3 = true;
                                                        if (z3) {
                                                            z7 = true;
                                                        }
                                                        i2 = i3 + 1;
                                                        obj4 = obj;
                                                        type2 = type;
                                                        serialContext3 = serialContext2;
                                                        fieldSerializerArr3 = fieldSerializerArr4;
                                                        c5 = c2;
                                                    }
                                                    z3 = false;
                                                    if (z3) {
                                                    }
                                                    i2 = i3 + 1;
                                                    obj4 = obj;
                                                    type2 = type;
                                                    serialContext3 = serialContext2;
                                                    fieldSerializerArr3 = fieldSerializerArr4;
                                                    c5 = c2;
                                                }
                                                if (fieldInfo.unwrapped) {
                                                    map = (Map) processValue;
                                                    if (map.size() != 0) {
                                                    }
                                                    z3 = true;
                                                    if (z3) {
                                                    }
                                                    i2 = i3 + 1;
                                                    obj4 = obj;
                                                    type2 = type;
                                                    serialContext3 = serialContext2;
                                                    fieldSerializerArr3 = fieldSerializerArr4;
                                                    c5 = c2;
                                                }
                                                z3 = false;
                                                if (z3) {
                                                }
                                                i2 = i3 + 1;
                                                obj4 = obj;
                                                type2 = type;
                                                serialContext3 = serialContext2;
                                                fieldSerializerArr3 = fieldSerializerArr4;
                                                c5 = c2;
                                            }
                                        }
                                        i3 = i2;
                                        c2 = c5;
                                        i2 = i3 + 1;
                                        obj4 = obj;
                                        type2 = type;
                                        serialContext3 = serialContext2;
                                        fieldSerializerArr3 = fieldSerializerArr4;
                                        c5 = c2;
                                    } catch (Exception e5) {
                                        e = e5;
                                        obj3 = obj;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    serialContext = serialContext2;
                                    jSONSerializer.context = serialContext;
                                    throw th;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                obj3 = obj;
                                serialContext = serialContext3;
                                String str222 = "write javaBean error, fastjson version 1.2.41";
                                if (obj3 != null) {
                                }
                                if (obj2 != null) {
                                }
                                if (e.getMessage() != null) {
                                }
                                throw new JSONException(str222, e);
                            }
                        }
                        char c7 = c5;
                        fieldSerializerArr2 = fieldSerializerArr3;
                        serialContext2 = serialContext3;
                        obj3 = obj;
                        writeAfter(jSONSerializer, obj3, z7 ? ',' : (char) 0);
                        if (fieldSerializerArr2.length > 0 && serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                            jSONSerializer.decrementIdent();
                            jSONSerializer.println();
                        }
                        if (!z) {
                            serializeWriter.append(c7);
                        }
                        jSONSerializer.context = serialContext2;
                        return;
                    }
                }
                writeAfter(jSONSerializer, obj3, z7 ? ',' : (char) 0);
                if (fieldSerializerArr2.length > 0) {
                    jSONSerializer.decrementIdent();
                    jSONSerializer.println();
                }
                if (!z) {
                }
                jSONSerializer.context = serialContext2;
                return;
            } catch (Exception e7) {
                e = e7;
                serialContext = serialContext2;
                String str2222 = "write javaBean error, fastjson version 1.2.41";
                if (obj3 != null) {
                }
                if (obj2 != null) {
                }
                if (e.getMessage() != null) {
                }
                throw new JSONException(str2222, e);
            }
            z2 = false;
            if (!z2) {
            }
            if (serializeWriter.quoteFieldNames) {
            }
            if (writeBefore(jSONSerializer, obj4, c6) != ',') {
            }
            boolean isEnabled3 = serializeWriter.isEnabled(SerializerFeature.SkipTransientField);
            boolean isEnabled22 = serializeWriter.isEnabled(SerializerFeature.IgnoreNonFieldGetter);
            boolean z72 = z6;
            i2 = 0;
            while (i2 < fieldSerializerArr3.length) {
            }
            char c72 = c5;
            fieldSerializerArr2 = fieldSerializerArr3;
            serialContext2 = serialContext3;
            obj3 = obj;
        }
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i2 >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i2] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i2]);
            i2++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
            return;
        }
        this.getters = new FieldSerializer[fieldInfoArr.length];
        while (true) {
            FieldSerializer[] fieldSerializerArr2 = this.getters;
            if (i >= fieldSerializerArr2.length) {
                return;
            }
            fieldSerializerArr2[i] = getFieldSerializer(serializeBeanInfo.fields[i].name);
            i++;
        }
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArr.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArr) {
                    String translate = propertyNamingStrategy.translate(str);
                    if (!str.equals(translate)) {
                        jArr[i2] = TypeUtils.fnv1a_64(translate);
                        i2++;
                    }
                }
                i++;
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch2 = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i3 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i3;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArr) {
                    String translate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(translate2) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate2))) >= 0) {
                        sArr[binarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public Object getFieldValue(Object obj, String str, long j, boolean z) {
        FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer == null) {
            if (z) {
                throw new JSONException("field not found. " + str);
            }
            return null;
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        } catch (InvocationTargetException e3) {
            throw new JSONException("getFieldValue error." + str, e3);
        }
    }
}
