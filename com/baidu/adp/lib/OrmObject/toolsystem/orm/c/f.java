package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double JX;

    public f(double d) {
        this.JX = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == Byte.class || fieldClass == Byte.TYPE) {
            return Byte.valueOf(this.JX.byteValue());
        }
        if (fieldClass == Short.class || fieldClass == Short.TYPE) {
            return Short.valueOf(this.JX.shortValue());
        }
        if (fieldClass == Integer.class || fieldClass == Integer.TYPE) {
            return Integer.valueOf(this.JX.intValue());
        }
        if (fieldClass == Long.class || fieldClass == Long.TYPE) {
            return Long.valueOf(this.JX.longValue());
        }
        if (fieldClass == Float.class || fieldClass == Float.TYPE) {
            return Float.valueOf(this.JX.floatValue());
        }
        if (fieldClass == Double.class || fieldClass == Double.TYPE) {
            return Double.valueOf(this.JX.doubleValue());
        }
        if (fieldClass == Character.class || fieldClass == Character.TYPE) {
            return Character.valueOf((char) this.JX.intValue());
        }
        if (fieldClass == Boolean.class || fieldClass == Boolean.TYPE) {
            return Boolean.valueOf(this.JX.byteValue() == 0);
        } else if (fieldClass == String.class) {
            return String.valueOf(this.JX);
        } else {
            if (fieldClass == char[].class) {
                return String.valueOf(this.JX).toCharArray();
            }
            if (fieldClass == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.JX), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
