package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short iz;

    public s(short s) {
        this.iz = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cj = cVar.cj();
        if (cj == Byte.class || cj == Byte.TYPE) {
            return Byte.valueOf(this.iz.byteValue());
        }
        if (cj == Short.class || cj == Short.TYPE) {
            return Short.valueOf(this.iz.shortValue());
        }
        if (cj == Integer.class || cj == Integer.TYPE) {
            return Integer.valueOf(this.iz.intValue());
        }
        if (cj == Long.class || cj == Long.TYPE) {
            return Long.valueOf(this.iz.longValue());
        }
        if (cj == Float.class || cj == Float.TYPE) {
            return Float.valueOf(this.iz.floatValue());
        }
        if (cj == Double.class || cj == Double.TYPE) {
            return Double.valueOf(this.iz.doubleValue());
        }
        if (cj == Character.class || cj == Character.TYPE) {
            return Character.valueOf((char) this.iz.intValue());
        }
        if (cj == Boolean.class || cj == Boolean.TYPE) {
            return Boolean.valueOf(this.iz.byteValue() == 0);
        } else if (cj == String.class) {
            return String.valueOf(this.iz);
        } else {
            if (cj == char[].class) {
                return String.valueOf(this.iz).toCharArray();
            }
            if (cj == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.iz), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
