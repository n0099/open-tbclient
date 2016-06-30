package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte io;

    public d(byte b) {
        this.io = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cj = cVar.cj();
        if (cj == Byte.class || cj == Byte.TYPE) {
            return Byte.valueOf(this.io.byteValue());
        }
        if (cj == Short.class || cj == Short.TYPE) {
            return Short.valueOf(this.io.shortValue());
        }
        if (cj == Integer.class || cj == Integer.TYPE) {
            return Integer.valueOf(this.io.intValue());
        }
        if (cj == Long.class || cj == Long.TYPE) {
            return Long.valueOf(this.io.longValue());
        }
        if (cj == Float.class || cj == Float.TYPE) {
            return Float.valueOf(this.io.floatValue());
        }
        if (cj == Double.class || cj == Double.TYPE) {
            return Double.valueOf(this.io.doubleValue());
        }
        if (cj == Character.class || cj == Character.TYPE) {
            return Character.valueOf((char) this.io.intValue());
        }
        if (cj == Boolean.class || cj == Boolean.TYPE) {
            return Boolean.valueOf(this.io.byteValue() == 0);
        } else if (cj == String.class) {
            return String.valueOf(this.io);
        } else {
            if (cj == char[].class) {
                return String.valueOf(this.io).toCharArray();
            }
            if (cj == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.io), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
