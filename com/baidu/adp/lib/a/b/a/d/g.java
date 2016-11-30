package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float lm;

    public g(float f) {
        this.lm = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd = cVar.dd();
        if (dd == Byte.class || dd == Byte.TYPE) {
            return Byte.valueOf(this.lm.byteValue());
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf(this.lm.shortValue());
        }
        if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(this.lm.intValue());
        }
        if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(this.lm.longValue());
        }
        if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(this.lm.floatValue());
        }
        if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(this.lm.doubleValue());
        }
        if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf((char) this.lm.intValue());
        }
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(this.lm.byteValue() == 0);
        } else if (dd == String.class) {
            return String.valueOf(this.lm);
        } else {
            if (dd == char[].class) {
                return String.valueOf(this.lm).toCharArray();
            }
            if (dd == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.lm), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
