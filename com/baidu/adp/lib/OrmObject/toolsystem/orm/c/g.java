package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float JQ;

    public g(float f) {
        this.JQ = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fieldClass = cVar.getFieldClass();
        if (fieldClass == Byte.class || fieldClass == Byte.TYPE) {
            return Byte.valueOf(this.JQ.byteValue());
        }
        if (fieldClass == Short.class || fieldClass == Short.TYPE) {
            return Short.valueOf(this.JQ.shortValue());
        }
        if (fieldClass == Integer.class || fieldClass == Integer.TYPE) {
            return Integer.valueOf(this.JQ.intValue());
        }
        if (fieldClass == Long.class || fieldClass == Long.TYPE) {
            return Long.valueOf(this.JQ.longValue());
        }
        if (fieldClass == Float.class || fieldClass == Float.TYPE) {
            return Float.valueOf(this.JQ.floatValue());
        }
        if (fieldClass == Double.class || fieldClass == Double.TYPE) {
            return Double.valueOf(this.JQ.doubleValue());
        }
        if (fieldClass == Character.class || fieldClass == Character.TYPE) {
            return Character.valueOf((char) this.JQ.intValue());
        }
        if (fieldClass == Boolean.class || fieldClass == Boolean.TYPE) {
            return Boolean.valueOf(this.JQ.byteValue() == 0);
        } else if (fieldClass == String.class) {
            return String.valueOf(this.JQ);
        } else {
            if (fieldClass == char[].class) {
                return String.valueOf(this.JQ).toCharArray();
            }
            if (fieldClass == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.JQ), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
