package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double KH;

    public f(double d) {
        this.KH = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == Byte.class || fieldClass == Byte.TYPE) {
            return Byte.valueOf(this.KH.byteValue());
        }
        if (fieldClass == Short.class || fieldClass == Short.TYPE) {
            return Short.valueOf(this.KH.shortValue());
        }
        if (fieldClass == Integer.class || fieldClass == Integer.TYPE) {
            return Integer.valueOf(this.KH.intValue());
        }
        if (fieldClass == Long.class || fieldClass == Long.TYPE) {
            return Long.valueOf(this.KH.longValue());
        }
        if (fieldClass == Float.class || fieldClass == Float.TYPE) {
            return Float.valueOf(this.KH.floatValue());
        }
        if (fieldClass == Double.class || fieldClass == Double.TYPE) {
            return Double.valueOf(this.KH.doubleValue());
        }
        if (fieldClass == Character.class || fieldClass == Character.TYPE) {
            return Character.valueOf((char) this.KH.intValue());
        }
        if (fieldClass == Boolean.class || fieldClass == Boolean.TYPE) {
            return Boolean.valueOf(this.KH.byteValue() == 0);
        } else if (fieldClass == String.class) {
            return String.valueOf(this.KH);
        } else {
            if (fieldClass == char[].class) {
                return String.valueOf(this.KH).toCharArray();
            }
            if (fieldClass == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.KH), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
