package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double eF;

    public f(double d) {
        this.eF = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> bS = cVar.bS();
        if (bS == Byte.class || bS == Byte.TYPE) {
            return Byte.valueOf(this.eF.byteValue());
        }
        if (bS == Short.class || bS == Short.TYPE) {
            return Short.valueOf(this.eF.shortValue());
        }
        if (bS == Integer.class || bS == Integer.TYPE) {
            return Integer.valueOf(this.eF.intValue());
        }
        if (bS == Long.class || bS == Long.TYPE) {
            return Long.valueOf(this.eF.longValue());
        }
        if (bS == Float.class || bS == Float.TYPE) {
            return Float.valueOf(this.eF.floatValue());
        }
        if (bS == Double.class || bS == Double.TYPE) {
            return Double.valueOf(this.eF.doubleValue());
        }
        if (bS == Character.class || bS == Character.TYPE) {
            return Character.valueOf((char) this.eF.intValue());
        }
        if (bS == Boolean.class || bS == Boolean.TYPE) {
            return Boolean.valueOf(this.eF.byteValue() == 0);
        } else if (bS == String.class) {
            return String.valueOf(this.eF);
        } else {
            if (bS == char[].class) {
                return String.valueOf(this.eF).toCharArray();
            }
            if (bS == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.k(String.valueOf(this.eF), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
