package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class i implements h {
    private Integer value;

    public i(int i) {
        this.value = Integer.valueOf(i);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> dP = cVar.dP();
        if (dP == Byte.class || dP == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (dP == Short.class || dP == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (dP == Integer.class || dP == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (dP == Long.class || dP == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (dP == Float.class || dP == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (dP == Double.class || dP == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (dP == Character.class || dP == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (dP == Boolean.class || dP == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (dP == String.class) {
            return String.valueOf(this.value);
        } else {
            if (dP == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (dP == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.value), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
