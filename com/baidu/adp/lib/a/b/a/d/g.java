package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float so;

    public g(float f) {
        this.so = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        if (fT == Byte.class || fT == Byte.TYPE) {
            return Byte.valueOf(this.so.byteValue());
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf(this.so.shortValue());
        }
        if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(this.so.intValue());
        }
        if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(this.so.longValue());
        }
        if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(this.so.floatValue());
        }
        if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(this.so.doubleValue());
        }
        if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf((char) this.so.intValue());
        }
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(this.so.byteValue() == 0);
        } else if (fT == String.class) {
            return String.valueOf(this.so);
        } else {
            if (fT == char[].class) {
                return String.valueOf(this.so).toCharArray();
            }
            if (fT == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.so), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
