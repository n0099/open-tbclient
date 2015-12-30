package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short ss;

    public s(short s) {
        this.ss = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        if (fL == Byte.class || fL == Byte.TYPE) {
            return Byte.valueOf(this.ss.byteValue());
        }
        if (fL == Short.class || fL == Short.TYPE) {
            return Short.valueOf(this.ss.shortValue());
        }
        if (fL == Integer.class || fL == Integer.TYPE) {
            return Integer.valueOf(this.ss.intValue());
        }
        if (fL == Long.class || fL == Long.TYPE) {
            return Long.valueOf(this.ss.longValue());
        }
        if (fL == Float.class || fL == Float.TYPE) {
            return Float.valueOf(this.ss.floatValue());
        }
        if (fL == Double.class || fL == Double.TYPE) {
            return Double.valueOf(this.ss.doubleValue());
        }
        if (fL == Character.class || fL == Character.TYPE) {
            return Character.valueOf((char) this.ss.intValue());
        }
        if (fL == Boolean.class || fL == Boolean.TYPE) {
            return Boolean.valueOf(this.ss.byteValue() == 0);
        } else if (fL == String.class) {
            return String.valueOf(this.ss);
        } else {
            if (fL == char[].class) {
                return String.valueOf(this.ss).toCharArray();
            }
            if (fL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.ss), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
