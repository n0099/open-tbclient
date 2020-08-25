package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte JO;

    public d(byte b) {
        this.JO = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == Byte.class || fieldClass == Byte.TYPE) {
            return Byte.valueOf(this.JO.byteValue());
        }
        if (fieldClass == Short.class || fieldClass == Short.TYPE) {
            return Short.valueOf(this.JO.shortValue());
        }
        if (fieldClass == Integer.class || fieldClass == Integer.TYPE) {
            return Integer.valueOf(this.JO.intValue());
        }
        if (fieldClass == Long.class || fieldClass == Long.TYPE) {
            return Long.valueOf(this.JO.longValue());
        }
        if (fieldClass == Float.class || fieldClass == Float.TYPE) {
            return Float.valueOf(this.JO.floatValue());
        }
        if (fieldClass == Double.class || fieldClass == Double.TYPE) {
            return Double.valueOf(this.JO.doubleValue());
        }
        if (fieldClass == Character.class || fieldClass == Character.TYPE) {
            return Character.valueOf((char) this.JO.intValue());
        }
        if (fieldClass == Boolean.class || fieldClass == Boolean.TYPE) {
            return Boolean.valueOf(this.JO.byteValue() == 0);
        } else if (fieldClass == String.class) {
            return String.valueOf(this.JO);
        } else {
            if (fieldClass == char[].class) {
                return String.valueOf(this.JO).toCharArray();
            }
            if (fieldClass == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.JO), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
