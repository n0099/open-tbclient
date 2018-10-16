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
        Class<?> ia = cVar.ia();
        if (ia == Byte.class || ia == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (ia == Short.class || ia == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (ia == Integer.class || ia == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (ia == Long.class || ia == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (ia == Float.class || ia == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (ia == Double.class || ia == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (ia == Character.class || ia == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (ia == Boolean.class || ia == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (ia == String.class) {
            return String.valueOf(this.value);
        } else {
            if (ia == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (ia == byte[].class) {
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
