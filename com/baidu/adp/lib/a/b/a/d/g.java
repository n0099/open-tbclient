package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float iw;

    public g(float f) {
        this.iw = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> ci = cVar.ci();
        if (ci == Byte.class || ci == Byte.TYPE) {
            return Byte.valueOf(this.iw.byteValue());
        }
        if (ci == Short.class || ci == Short.TYPE) {
            return Short.valueOf(this.iw.shortValue());
        }
        if (ci == Integer.class || ci == Integer.TYPE) {
            return Integer.valueOf(this.iw.intValue());
        }
        if (ci == Long.class || ci == Long.TYPE) {
            return Long.valueOf(this.iw.longValue());
        }
        if (ci == Float.class || ci == Float.TYPE) {
            return Float.valueOf(this.iw.floatValue());
        }
        if (ci == Double.class || ci == Double.TYPE) {
            return Double.valueOf(this.iw.doubleValue());
        }
        if (ci == Character.class || ci == Character.TYPE) {
            return Character.valueOf((char) this.iw.intValue());
        }
        if (ci == Boolean.class || ci == Boolean.TYPE) {
            return Boolean.valueOf(this.iw.byteValue() == 0);
        } else if (ci == String.class) {
            return String.valueOf(this.iw);
        } else {
            if (ci == char[].class) {
                return String.valueOf(this.iw).toCharArray();
            }
            if (ci == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.iw), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
