package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte sg;

    public d(byte b) {
        this.sg = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        if (fL == Byte.class || fL == Byte.TYPE) {
            return Byte.valueOf(this.sg.byteValue());
        }
        if (fL == Short.class || fL == Short.TYPE) {
            return Short.valueOf(this.sg.shortValue());
        }
        if (fL == Integer.class || fL == Integer.TYPE) {
            return Integer.valueOf(this.sg.intValue());
        }
        if (fL == Long.class || fL == Long.TYPE) {
            return Long.valueOf(this.sg.longValue());
        }
        if (fL == Float.class || fL == Float.TYPE) {
            return Float.valueOf(this.sg.floatValue());
        }
        if (fL == Double.class || fL == Double.TYPE) {
            return Double.valueOf(this.sg.doubleValue());
        }
        if (fL == Character.class || fL == Character.TYPE) {
            return Character.valueOf((char) this.sg.intValue());
        }
        if (fL == Boolean.class || fL == Boolean.TYPE) {
            return Boolean.valueOf(this.sg.byteValue() == 0);
        } else if (fL == String.class) {
            return String.valueOf(this.sg);
        } else {
            if (fL == char[].class) {
                return String.valueOf(this.sg).toCharArray();
            }
            if (fL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sg), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
