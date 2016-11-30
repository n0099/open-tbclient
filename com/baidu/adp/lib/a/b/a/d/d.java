package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte lk;

    public d(byte b) {
        this.lk = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd = cVar.dd();
        if (dd == Byte.class || dd == Byte.TYPE) {
            return Byte.valueOf(this.lk.byteValue());
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf(this.lk.shortValue());
        }
        if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(this.lk.intValue());
        }
        if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(this.lk.longValue());
        }
        if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(this.lk.floatValue());
        }
        if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(this.lk.doubleValue());
        }
        if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf((char) this.lk.intValue());
        }
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(this.lk.byteValue() == 0);
        } else if (dd == String.class) {
            return String.valueOf(this.lk);
        } else {
            if (dd == char[].class) {
                return String.valueOf(this.lk).toCharArray();
            }
            if (dd == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.lk), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
