package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double gF;

    public f(double d) {
        this.gF = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cs = cVar.cs();
        if (cs == Byte.class || cs == Byte.TYPE) {
            return Byte.valueOf(this.gF.byteValue());
        }
        if (cs == Short.class || cs == Short.TYPE) {
            return Short.valueOf(this.gF.shortValue());
        }
        if (cs == Integer.class || cs == Integer.TYPE) {
            return Integer.valueOf(this.gF.intValue());
        }
        if (cs == Long.class || cs == Long.TYPE) {
            return Long.valueOf(this.gF.longValue());
        }
        if (cs == Float.class || cs == Float.TYPE) {
            return Float.valueOf(this.gF.floatValue());
        }
        if (cs == Double.class || cs == Double.TYPE) {
            return Double.valueOf(this.gF.doubleValue());
        }
        if (cs == Character.class || cs == Character.TYPE) {
            return Character.valueOf((char) this.gF.intValue());
        }
        if (cs == Boolean.class || cs == Boolean.TYPE) {
            return Boolean.valueOf(this.gF.byteValue() == 0);
        } else if (cs == String.class) {
            return String.valueOf(this.gF);
        } else {
            if (cs == char[].class) {
                return String.valueOf(this.gF).toCharArray();
            }
            if (cs == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gF), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
