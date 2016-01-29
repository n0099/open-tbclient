package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte su;

    public d(byte b) {
        this.su = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        if (fT == Byte.class || fT == Byte.TYPE) {
            return Byte.valueOf(this.su.byteValue());
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf(this.su.shortValue());
        }
        if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(this.su.intValue());
        }
        if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(this.su.longValue());
        }
        if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(this.su.floatValue());
        }
        if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(this.su.doubleValue());
        }
        if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf((char) this.su.intValue());
        }
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(this.su.byteValue() == 0);
        } else if (fT == String.class) {
            return String.valueOf(this.su);
        } else {
            if (fT == char[].class) {
                return String.valueOf(this.su).toCharArray();
            }
            if (fT == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.su), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
