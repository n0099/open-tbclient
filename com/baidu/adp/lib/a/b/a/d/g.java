package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float sc;

    public g(float f) {
        this.sc = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fO = cVar.fO();
        if (fO == Byte.class || fO == Byte.TYPE) {
            return Byte.valueOf(this.sc.byteValue());
        }
        if (fO == Short.class || fO == Short.TYPE) {
            return Short.valueOf(this.sc.shortValue());
        }
        if (fO == Integer.class || fO == Integer.TYPE) {
            return Integer.valueOf(this.sc.intValue());
        }
        if (fO == Long.class || fO == Long.TYPE) {
            return Long.valueOf(this.sc.longValue());
        }
        if (fO == Float.class || fO == Float.TYPE) {
            return Float.valueOf(this.sc.floatValue());
        }
        if (fO == Double.class || fO == Double.TYPE) {
            return Double.valueOf(this.sc.doubleValue());
        }
        if (fO == Character.class || fO == Character.TYPE) {
            return Character.valueOf((char) this.sc.intValue());
        }
        if (fO == Boolean.class || fO == Boolean.TYPE) {
            return Boolean.valueOf(this.sc.byteValue() == 0);
        } else if (fO == String.class) {
            return String.valueOf(this.sc);
        } else {
            if (fO == char[].class) {
                return String.valueOf(this.sc).toCharArray();
            }
            if (fO == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sc), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
