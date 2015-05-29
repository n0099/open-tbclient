package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte sl;

    public d(byte b) {
        this.sl = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        if (fT == Byte.class || fT == Byte.TYPE) {
            return Byte.valueOf(this.sl.byteValue());
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf(this.sl.shortValue());
        }
        if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(this.sl.intValue());
        }
        if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(this.sl.longValue());
        }
        if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(this.sl.floatValue());
        }
        if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(this.sl.doubleValue());
        }
        if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf((char) this.sl.intValue());
        }
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(this.sl.byteValue() == 0);
        } else if (fT == String.class) {
            return String.valueOf(this.sl);
        } else {
            if (fT == char[].class) {
                return String.valueOf(this.sl).toCharArray();
            }
            if (fT == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sl), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
