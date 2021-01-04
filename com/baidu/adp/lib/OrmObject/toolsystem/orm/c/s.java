package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short KM;

    public s(short s) {
        this.KM = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == Byte.class || fieldClass == Byte.TYPE) {
            return Byte.valueOf(this.KM.byteValue());
        }
        if (fieldClass == Short.class || fieldClass == Short.TYPE) {
            return Short.valueOf(this.KM.shortValue());
        }
        if (fieldClass == Integer.class || fieldClass == Integer.TYPE) {
            return Integer.valueOf(this.KM.intValue());
        }
        if (fieldClass == Long.class || fieldClass == Long.TYPE) {
            return Long.valueOf(this.KM.longValue());
        }
        if (fieldClass == Float.class || fieldClass == Float.TYPE) {
            return Float.valueOf(this.KM.floatValue());
        }
        if (fieldClass == Double.class || fieldClass == Double.TYPE) {
            return Double.valueOf(this.KM.doubleValue());
        }
        if (fieldClass == Character.class || fieldClass == Character.TYPE) {
            return Character.valueOf((char) this.KM.intValue());
        }
        if (fieldClass == Boolean.class || fieldClass == Boolean.TYPE) {
            return Boolean.valueOf(this.KM.byteValue() == 0);
        } else if (fieldClass == String.class) {
            return String.valueOf(this.KM);
        } else {
            if (fieldClass == char[].class) {
                return String.valueOf(this.KM).toCharArray();
            }
            if (fieldClass == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.KM), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
