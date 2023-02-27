package com.baidu.searchbox.ai;

import java.util.HashMap;
/* loaded from: classes2.dex */
public enum DataType {
    FLOAT(1),
    DOUBLE(2),
    INT32(3),
    INT64(4),
    UINT8(5),
    STRING(6),
    BOOL(7);
    
    public static HashMap<Class<?>, DataType> classDataTypes;
    public final int value;

    static {
        HashMap<Class<?>, DataType> hashMap = new HashMap<>();
        classDataTypes = hashMap;
        hashMap.put(Integer.TYPE, INT32);
        classDataTypes.put(Integer.class, INT32);
        classDataTypes.put(Long.TYPE, INT64);
        classDataTypes.put(Long.class, INT64);
        classDataTypes.put(Float.TYPE, FLOAT);
        classDataTypes.put(Float.class, FLOAT);
        classDataTypes.put(Double.TYPE, DOUBLE);
        classDataTypes.put(Double.class, DOUBLE);
        classDataTypes.put(Byte.TYPE, STRING);
        classDataTypes.put(Byte.class, STRING);
        classDataTypes.put(Boolean.TYPE, BOOL);
        classDataTypes.put(Boolean.class, BOOL);
    }

    DataType(int i) {
        this.value = i;
    }

    public static DataType dataTypeOf(Object obj) {
        Class<?> cls = obj.getClass();
        while (cls.isArray()) {
            cls = cls.getComponentType();
        }
        DataType dataType = classDataTypes.get(cls);
        if (dataType != null) {
            return dataType;
        }
        throw new IllegalArgumentException("cannot create Tensors of type " + cls.getName());
    }

    public int value() {
        return this.value;
    }
}
