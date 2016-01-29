package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float sw;

    public g(float f) {
        this.sw = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        if (fT == Byte.class || fT == Byte.TYPE) {
            return Byte.valueOf(this.sw.byteValue());
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf(this.sw.shortValue());
        }
        if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(this.sw.intValue());
        }
        if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(this.sw.longValue());
        }
        if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(this.sw.floatValue());
        }
        if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(this.sw.doubleValue());
        }
        if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf((char) this.sw.intValue());
        }
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(this.sw.byteValue() == 0);
        } else if (fT == String.class) {
            return String.valueOf(this.sw);
        } else {
            if (fT == char[].class) {
                return String.valueOf(this.sw).toCharArray();
            }
            if (fT == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sw), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
