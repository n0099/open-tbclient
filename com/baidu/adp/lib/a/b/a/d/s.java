package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short lq;

    public s(short s) {
        this.lq = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd = cVar.dd();
        if (dd == Byte.class || dd == Byte.TYPE) {
            return Byte.valueOf(this.lq.byteValue());
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf(this.lq.shortValue());
        }
        if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(this.lq.intValue());
        }
        if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(this.lq.longValue());
        }
        if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(this.lq.floatValue());
        }
        if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(this.lq.doubleValue());
        }
        if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf((char) this.lq.intValue());
        }
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(this.lq.byteValue() == 0);
        } else if (dd == String.class) {
            return String.valueOf(this.lq);
        } else {
            if (dd == char[].class) {
                return String.valueOf(this.lq).toCharArray();
            }
            if (dd == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.lq), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
