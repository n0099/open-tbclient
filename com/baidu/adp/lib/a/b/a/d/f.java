package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double iu;

    public f(double d) {
        this.iu = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> ci = cVar.ci();
        if (ci == Byte.class || ci == Byte.TYPE) {
            return Byte.valueOf(this.iu.byteValue());
        }
        if (ci == Short.class || ci == Short.TYPE) {
            return Short.valueOf(this.iu.shortValue());
        }
        if (ci == Integer.class || ci == Integer.TYPE) {
            return Integer.valueOf(this.iu.intValue());
        }
        if (ci == Long.class || ci == Long.TYPE) {
            return Long.valueOf(this.iu.longValue());
        }
        if (ci == Float.class || ci == Float.TYPE) {
            return Float.valueOf(this.iu.floatValue());
        }
        if (ci == Double.class || ci == Double.TYPE) {
            return Double.valueOf(this.iu.doubleValue());
        }
        if (ci == Character.class || ci == Character.TYPE) {
            return Character.valueOf((char) this.iu.intValue());
        }
        if (ci == Boolean.class || ci == Boolean.TYPE) {
            return Boolean.valueOf(this.iu.byteValue() == 0);
        } else if (ci == String.class) {
            return String.valueOf(this.iu);
        } else {
            if (ci == char[].class) {
                return String.valueOf(this.iu).toCharArray();
            }
            if (ci == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.iu), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
