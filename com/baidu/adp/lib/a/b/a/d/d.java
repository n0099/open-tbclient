package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte eE;

    public d(byte b) {
        this.eE = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> bS = cVar.bS();
        if (bS == Byte.class || bS == Byte.TYPE) {
            return Byte.valueOf(this.eE.byteValue());
        }
        if (bS == Short.class || bS == Short.TYPE) {
            return Short.valueOf(this.eE.shortValue());
        }
        if (bS == Integer.class || bS == Integer.TYPE) {
            return Integer.valueOf(this.eE.intValue());
        }
        if (bS == Long.class || bS == Long.TYPE) {
            return Long.valueOf(this.eE.longValue());
        }
        if (bS == Float.class || bS == Float.TYPE) {
            return Float.valueOf(this.eE.floatValue());
        }
        if (bS == Double.class || bS == Double.TYPE) {
            return Double.valueOf(this.eE.doubleValue());
        }
        if (bS == Character.class || bS == Character.TYPE) {
            return Character.valueOf((char) this.eE.intValue());
        }
        if (bS == Boolean.class || bS == Boolean.TYPE) {
            return Boolean.valueOf(this.eE.byteValue() == 0);
        } else if (bS == String.class) {
            return String.valueOf(this.eE);
        } else {
            if (bS == char[].class) {
                return String.valueOf(this.eE).toCharArray();
            }
            if (bS == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.k(String.valueOf(this.eE), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
