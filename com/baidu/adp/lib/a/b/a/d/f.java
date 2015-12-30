package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double sk;

    public f(double d) {
        this.sk = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        if (fL == Byte.class || fL == Byte.TYPE) {
            return Byte.valueOf(this.sk.byteValue());
        }
        if (fL == Short.class || fL == Short.TYPE) {
            return Short.valueOf(this.sk.shortValue());
        }
        if (fL == Integer.class || fL == Integer.TYPE) {
            return Integer.valueOf(this.sk.intValue());
        }
        if (fL == Long.class || fL == Long.TYPE) {
            return Long.valueOf(this.sk.longValue());
        }
        if (fL == Float.class || fL == Float.TYPE) {
            return Float.valueOf(this.sk.floatValue());
        }
        if (fL == Double.class || fL == Double.TYPE) {
            return Double.valueOf(this.sk.doubleValue());
        }
        if (fL == Character.class || fL == Character.TYPE) {
            return Character.valueOf((char) this.sk.intValue());
        }
        if (fL == Boolean.class || fL == Boolean.TYPE) {
            return Boolean.valueOf(this.sk.byteValue() == 0);
        } else if (fL == String.class) {
            return String.valueOf(this.sk);
        } else {
            if (fL == char[].class) {
                return String.valueOf(this.sk).toCharArray();
            }
            if (fL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sk), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
