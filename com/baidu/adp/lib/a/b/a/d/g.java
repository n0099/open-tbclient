package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float ir;

    public g(float f) {
        this.ir = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cj = cVar.cj();
        if (cj == Byte.class || cj == Byte.TYPE) {
            return Byte.valueOf(this.ir.byteValue());
        }
        if (cj == Short.class || cj == Short.TYPE) {
            return Short.valueOf(this.ir.shortValue());
        }
        if (cj == Integer.class || cj == Integer.TYPE) {
            return Integer.valueOf(this.ir.intValue());
        }
        if (cj == Long.class || cj == Long.TYPE) {
            return Long.valueOf(this.ir.longValue());
        }
        if (cj == Float.class || cj == Float.TYPE) {
            return Float.valueOf(this.ir.floatValue());
        }
        if (cj == Double.class || cj == Double.TYPE) {
            return Double.valueOf(this.ir.doubleValue());
        }
        if (cj == Character.class || cj == Character.TYPE) {
            return Character.valueOf((char) this.ir.intValue());
        }
        if (cj == Boolean.class || cj == Boolean.TYPE) {
            return Boolean.valueOf(this.ir.byteValue() == 0);
        } else if (cj == String.class) {
            return String.valueOf(this.ir);
        } else {
            if (cj == char[].class) {
                return String.valueOf(this.ir).toCharArray();
            }
            if (cj == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.ir), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
