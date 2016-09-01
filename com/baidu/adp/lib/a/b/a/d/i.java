package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class i implements h {
    private Integer value;

    public i(int i) {
        this.value = Integer.valueOf(i);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd = cVar.dd();
        if (dd == Byte.class || dd == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (dd == String.class) {
            return String.valueOf(this.value);
        } else {
            if (dd == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (dd == byte[].class) {
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
