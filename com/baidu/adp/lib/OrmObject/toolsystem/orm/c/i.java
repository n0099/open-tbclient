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
        Class<?> hL = cVar.hL();
        if (hL == Byte.class || hL == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (hL == Short.class || hL == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (hL == Integer.class || hL == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (hL == Long.class || hL == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (hL == Float.class || hL == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (hL == Double.class || hL == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (hL == Character.class || hL == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (hL == Boolean.class || hL == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (hL == String.class) {
            return String.valueOf(this.value);
        } else {
            if (hL == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (hL == byte[].class) {
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
