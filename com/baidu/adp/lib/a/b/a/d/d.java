package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte lj;

    public d(byte b) {
        this.lj = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd = cVar.dd();
        if (dd == Byte.class || dd == Byte.TYPE) {
            return Byte.valueOf(this.lj.byteValue());
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf(this.lj.shortValue());
        }
        if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(this.lj.intValue());
        }
        if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(this.lj.longValue());
        }
        if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(this.lj.floatValue());
        }
        if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(this.lj.doubleValue());
        }
        if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf((char) this.lj.intValue());
        }
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(this.lj.byteValue() == 0);
        } else if (dd == String.class) {
            return String.valueOf(this.lj);
        } else {
            if (dd == char[].class) {
                return String.valueOf(this.lj).toCharArray();
            }
            if (dd == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.lj), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
