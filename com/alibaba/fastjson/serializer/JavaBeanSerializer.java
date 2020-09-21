package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    protected SerializeBeanInfo beanInfo;
    protected final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        for (int i = 0; i < this.sortedGetters.length; i++) {
            this.sortedGetters[i] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
        }
        if (serializeBeanInfo.fields == serializeBeanInfo.sortedFields) {
            this.getters = this.sortedGetters;
            return;
        }
        this.getters = new FieldSerializer[serializeBeanInfo.fields.length];
        for (int i2 = 0; i2 < this.getters.length; i2++) {
            this.getters[i2] = getFieldSerializer(serializeBeanInfo.fields[i2].name);
        }
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i, boolean z) throws IOException {
        FieldSerializer[] fieldSerializerArr;
        boolean z2;
        Object obj3;
        boolean z3;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
        } else if (!writeReference(jSONSerializer, obj, i)) {
            if (serializeWriter.sortField) {
                fieldSerializerArr = this.sortedGetters;
            } else {
                fieldSerializerArr = this.getters;
            }
            SerialContext serialContext = jSONSerializer.context;
            if (!this.beanInfo.beanType.isEnum()) {
                jSONSerializer.setContext(serialContext, obj, obj2, this.beanInfo.features, i);
            }
            boolean isWriteAsArray = isWriteAsArray(jSONSerializer, i);
            char c = isWriteAsArray ? '[' : '{';
            char c2 = isWriteAsArray ? ']' : '}';
            try {
                if (!z) {
                    try {
                        serializeWriter.append(c);
                    } catch (Exception e) {
                        String str = obj != null ? "write javaBean error, fastjson version 1.2.41, class " + obj.getClass().getName() : "write javaBean error, fastjson version 1.2.41";
                        if (obj2 != null) {
                            str = str + ", fieldName : " + obj2;
                        }
                        if (e.getMessage() != null) {
                            str = str + ", " + e.getMessage();
                        }
                        throw new JSONException(str, e);
                    }
                }
                if (fieldSerializerArr.length > 0 && serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                    jSONSerializer.incrementIndent();
                    jSONSerializer.println();
                }
                boolean z4 = false;
                if ((this.beanInfo.features & SerializerFeature.WriteClassName.mask) != 0 || (SerializerFeature.WriteClassName.mask & i) != 0 || jSONSerializer.isWriteClassName(type, obj)) {
                    Class<?> cls = obj.getClass();
                    if (cls != ((cls == type || !(type instanceof WildcardType)) ? type : TypeUtils.getClass(type))) {
                        writeClassName(jSONSerializer, this.beanInfo.typeKey, obj);
                        z4 = true;
                    }
                }
                char c3 = z4 ? ',' : (char) 0;
                boolean z5 = serializeWriter.quoteFieldNames && !serializeWriter.useSingleQuotes;
                boolean z6 = writeBefore(jSONSerializer, obj, c3) == ',';
                boolean isEnabled = serializeWriter.isEnabled(SerializerFeature.SkipTransientField);
                boolean isEnabled2 = serializeWriter.isEnabled(SerializerFeature.IgnoreNonFieldGetter);
                int i2 = 0;
                while (i2 < fieldSerializerArr.length) {
                    FieldSerializer fieldSerializer = fieldSerializerArr[i2];
                    Field field = fieldSerializer.fieldInfo.field;
                    FieldInfo fieldInfo = fieldSerializer.fieldInfo;
                    String str2 = fieldInfo.name;
                    Class<?> cls2 = fieldInfo.fieldClass;
                    if (isEnabled && field != null && fieldInfo.fieldTransient) {
                        z2 = z6;
                    } else if (isEnabled2 && field == null) {
                        z2 = z6;
                    } else {
                        if (applyName(jSONSerializer, obj, str2)) {
                            if (!applyLabel(jSONSerializer, fieldInfo.label)) {
                                z2 = z6;
                            } else if (this.beanInfo.typeKey != null && str2.equals(this.beanInfo.typeKey) && jSONSerializer.isWriteClassName(type, obj)) {
                                z2 = z6;
                            } else {
                                try {
                                    obj3 = fieldSerializer.getPropertyValueDirect(obj);
                                } catch (InvocationTargetException e2) {
                                    if (serializeWriter.isEnabled(SerializerFeature.IgnoreErrorGetter)) {
                                        obj3 = null;
                                    } else {
                                        throw e2;
                                    }
                                }
                                if (apply(jSONSerializer, obj, str2, obj3)) {
                                    String trim = (cls2 == String.class && "trim".equals(fieldInfo.format) && obj3 != null) ? ((String) obj3).trim() : obj3;
                                    String processKey = processKey(jSONSerializer, obj, str2, trim);
                                    Object processValue = processValue(jSONSerializer, fieldSerializer.fieldContext, obj, str2, trim);
                                    if (processValue == null && !isWriteAsArray) {
                                        if (cls2 == Boolean.class) {
                                            int i3 = SerializerFeature.WriteNullBooleanAsFalse.mask | SerializerFeature.WriteMapNullValue.mask;
                                            if ((fieldInfo.serialzeFeatures & i3) == 0 && (i3 & serializeWriter.features) == 0) {
                                                z2 = z6;
                                            }
                                        } else if (cls2 == String.class) {
                                            int i4 = SerializerFeature.WriteNullStringAsEmpty.mask | SerializerFeature.WriteMapNullValue.mask;
                                            if ((fieldInfo.serialzeFeatures & i4) == 0 && (i4 & serializeWriter.features) == 0) {
                                                z2 = z6;
                                            }
                                        } else if (Number.class.isAssignableFrom(cls2)) {
                                            int i5 = SerializerFeature.WriteNullNumberAsZero.mask | SerializerFeature.WriteMapNullValue.mask;
                                            if ((fieldInfo.serialzeFeatures & i5) == 0 && (i5 & serializeWriter.features) == 0) {
                                                z2 = z6;
                                            }
                                        } else if (Collection.class.isAssignableFrom(cls2)) {
                                            int i6 = SerializerFeature.WriteNullListAsEmpty.mask | SerializerFeature.WriteMapNullValue.mask;
                                            if ((fieldInfo.serialzeFeatures & i6) == 0 && (i6 & serializeWriter.features) == 0) {
                                                z2 = z6;
                                            }
                                        } else if (!fieldSerializer.writeNull && !serializeWriter.isEnabled(SerializerFeature.WriteMapNullValue.mask)) {
                                            z2 = z6;
                                        }
                                    }
                                    if (processValue != null && (serializeWriter.notWriteDefaultValue || (fieldInfo.serialzeFeatures & SerializerFeature.NotWriteDefaultValue.mask) != 0 || (this.beanInfo.features & SerializerFeature.NotWriteDefaultValue.mask) != 0)) {
                                        Class<?> cls3 = fieldInfo.fieldClass;
                                        if (cls3 == Byte.TYPE && (processValue instanceof Byte) && ((Byte) processValue).byteValue() == 0) {
                                            z2 = z6;
                                        } else if (cls3 == Short.TYPE && (processValue instanceof Short) && ((Short) processValue).shortValue() == 0) {
                                            z2 = z6;
                                        } else if (cls3 == Integer.TYPE && (processValue instanceof Integer) && ((Integer) processValue).intValue() == 0) {
                                            z2 = z6;
                                        } else if (cls3 == Long.TYPE && (processValue instanceof Long) && ((Long) processValue).longValue() == 0) {
                                            z2 = z6;
                                        } else if (cls3 == Float.TYPE && (processValue instanceof Float) && ((Float) processValue).floatValue() == 0.0f) {
                                            z2 = z6;
                                        } else if (cls3 == Double.TYPE && (processValue instanceof Double) && ((Double) processValue).doubleValue() == 0.0d) {
                                            z2 = z6;
                                        } else if (cls3 == Boolean.TYPE && (processValue instanceof Boolean) && !((Boolean) processValue).booleanValue()) {
                                            z2 = z6;
                                        }
                                    }
                                    if (z6) {
                                        if (fieldInfo.unwrapped && (processValue instanceof Map) && ((Map) processValue).size() == 0) {
                                            z2 = z6;
                                        } else {
                                            serializeWriter.write(44);
                                            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                                jSONSerializer.println();
                                            }
                                        }
                                    }
                                    if (processKey != str2) {
                                        if (!isWriteAsArray) {
                                            serializeWriter.writeFieldName(processKey, true);
                                        }
                                        jSONSerializer.write(processValue);
                                    } else if (trim != processValue) {
                                        if (!isWriteAsArray) {
                                            fieldSerializer.writePrefix(jSONSerializer);
                                        }
                                        jSONSerializer.write(processValue);
                                    } else {
                                        if (!isWriteAsArray && !fieldInfo.unwrapped) {
                                            if (z5) {
                                                serializeWriter.write(fieldInfo.name_chars, 0, fieldInfo.name_chars.length);
                                            } else {
                                                fieldSerializer.writePrefix(jSONSerializer);
                                            }
                                        }
                                        if (!isWriteAsArray) {
                                            JSONField annotation = fieldInfo.getAnnotation();
                                            if (cls2 == String.class && (annotation == null || annotation.serializeUsing() == Void.class)) {
                                                if (processValue == null) {
                                                    if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0 || (fieldSerializer.features & SerializerFeature.WriteNullStringAsEmpty.mask) != 0) {
                                                        serializeWriter.writeString("");
                                                    } else {
                                                        serializeWriter.writeNull();
                                                    }
                                                } else {
                                                    String str3 = (String) processValue;
                                                    if (serializeWriter.useSingleQuotes) {
                                                        serializeWriter.writeStringWithSingleQuote(str3);
                                                    } else {
                                                        serializeWriter.writeStringWithDoubleQuote(str3, (char) 0);
                                                    }
                                                }
                                            } else if (fieldInfo.unwrapped && (processValue instanceof Map) && ((Map) processValue).size() == 0) {
                                                z2 = false;
                                            } else {
                                                fieldSerializer.writeValue(jSONSerializer, processValue);
                                            }
                                        } else {
                                            fieldSerializer.writeValue(jSONSerializer, processValue);
                                        }
                                    }
                                    boolean z7 = false;
                                    if (fieldInfo.unwrapped && (processValue instanceof Map)) {
                                        Map map = (Map) processValue;
                                        if (map.size() == 0) {
                                            z7 = true;
                                        } else if (!jSONSerializer.isEnabled(SerializerFeature.WriteMapNullValue)) {
                                            Iterator it = map.values().iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    z3 = false;
                                                    break;
                                                } else if (it.next() != null) {
                                                    z3 = true;
                                                    break;
                                                }
                                            }
                                            if (!z3) {
                                                z7 = true;
                                            }
                                        }
                                    }
                                    if (!z7) {
                                        z2 = true;
                                    }
                                } else {
                                    z2 = z6;
                                }
                            }
                        }
                        z2 = z6;
                    }
                    i2++;
                    z6 = z2;
                }
                writeAfter(jSONSerializer, obj, z6 ? ',' : (char) 0);
                if (fieldSerializerArr.length > 0 && serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                    jSONSerializer.decrementIdent();
                    jSONSerializer.println();
                }
                if (!z) {
                    serializeWriter.append(c2);
                }
            } finally {
                jSONSerializer.context = serialContext;
            }
        }
    }

    protected void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
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

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i) {
        SerialContext serialContext = jSONSerializer.context;
        int i2 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext != null && (serialContext.features & i2) == 0 && (i & i2) == 0 && jSONSerializer.references != null && jSONSerializer.references.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return true;
        }
        return false;
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    protected boolean isWriteAsArray(JSONSerializer jSONSerializer, int i) {
        int i2 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i2 & i) == 0) ? false : true;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer == null) {
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
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
        } catch (IllegalAccessException e) {
            throw new JSONException("getFieldValue error." + str, e);
        } catch (InvocationTargetException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        }
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
            } else if (compareTo > 0) {
                length = i2 - 1;
            } else {
                return this.sortedGetters[i2];
            }
        }
        return null;
    }

    public FieldSerializer getFieldSerializer(long j) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        int i;
        if (this.hashArray == null) {
            PropertyNamingStrategy[] values = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * values.length];
            int i2 = 0;
            for (int i3 = 0; i3 < this.sortedGetters.length; i3++) {
                String str = this.sortedGetters[i3].fieldInfo.name;
                jArr[i2] = TypeUtils.fnv1a_64(str);
                i2++;
                int i4 = 0;
                while (i4 < values.length) {
                    String translate = values[i4].translate(str);
                    if (str.equals(translate)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        jArr[i2] = TypeUtils.fnv1a_64(translate);
                    }
                    i4++;
                    i2 = i;
                }
            }
            Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            System.arraycopy(jArr, 0, this.hashArray, 0, i2);
            propertyNamingStrategyArr = values;
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
            for (int i5 = 0; i5 < this.sortedGetters.length; i5++) {
                String str2 = this.sortedGetters[i5].fieldInfo.name;
                int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i5;
                }
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArr) {
                    String translate2 = propertyNamingStrategy.translate(str2);
                    if (!str2.equals(translate2) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate2))) >= 0) {
                        sArr[binarySearch] = (short) i5;
                    }
                }
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
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

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    protected BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    protected Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    protected char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.beforeFilters != null) {
            for (BeforeFilter beforeFilter : jSONSerializer.beforeFilters) {
                c = beforeFilter.writeBefore(jSONSerializer, obj, c);
            }
        }
        if (this.beforeFilters != null) {
            for (BeforeFilter beforeFilter2 : this.beforeFilters) {
                c = beforeFilter2.writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        if (jSONSerializer.afterFilters != null) {
            for (AfterFilter afterFilter : jSONSerializer.afterFilters) {
                c = afterFilter.writeAfter(jSONSerializer, obj, c);
            }
        }
        if (this.afterFilters != null) {
            for (AfterFilter afterFilter2 : this.afterFilters) {
                c = afterFilter2.writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        if (jSONSerializer.labelFilters != null) {
            for (LabelFilter labelFilter : jSONSerializer.labelFilters) {
                if (!labelFilter.apply(str)) {
                    return false;
                }
            }
        }
        if (this.labelFilters != null) {
            for (LabelFilter labelFilter2 : this.labelFilters) {
                if (!labelFilter2.apply(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
