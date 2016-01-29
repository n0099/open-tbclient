package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double sv;

    public f(double d) {
        this.sv = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        if (fT == Byte.class || fT == Byte.TYPE) {
            return Byte.valueOf(this.sv.byteValue());
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf(this.sv.shortValue());
        }
        if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(this.sv.intValue());
        }
        if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(this.sv.longValue());
        }
        if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(this.sv.floatValue());
        }
        if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(this.sv.doubleValue());
        }
        if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf((char) this.sv.intValue());
        }
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(this.sv.byteValue() == 0);
        } else if (fT == String.class) {
            return String.valueOf(this.sv);
        } else {
            if (fT == char[].class) {
                return String.valueOf(this.sv).toCharArray();
            }
            if (fT == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sv), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
