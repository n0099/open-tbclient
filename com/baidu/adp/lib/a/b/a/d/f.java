package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double iq;

    public f(double d) {
        this.iq = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cj = cVar.cj();
        if (cj == Byte.class || cj == Byte.TYPE) {
            return Byte.valueOf(this.iq.byteValue());
        }
        if (cj == Short.class || cj == Short.TYPE) {
            return Short.valueOf(this.iq.shortValue());
        }
        if (cj == Integer.class || cj == Integer.TYPE) {
            return Integer.valueOf(this.iq.intValue());
        }
        if (cj == Long.class || cj == Long.TYPE) {
            return Long.valueOf(this.iq.longValue());
        }
        if (cj == Float.class || cj == Float.TYPE) {
            return Float.valueOf(this.iq.floatValue());
        }
        if (cj == Double.class || cj == Double.TYPE) {
            return Double.valueOf(this.iq.doubleValue());
        }
        if (cj == Character.class || cj == Character.TYPE) {
            return Character.valueOf((char) this.iq.intValue());
        }
        if (cj == Boolean.class || cj == Boolean.TYPE) {
            return Boolean.valueOf(this.iq.byteValue() == 0);
        } else if (cj == String.class) {
            return String.valueOf(this.iq);
        } else {
            if (cj == char[].class) {
                return String.valueOf(this.iq).toCharArray();
            }
            if (cj == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.iq), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
