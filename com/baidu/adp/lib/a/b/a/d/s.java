package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short eK;

    public s(short s) {
        this.eK = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> bS = cVar.bS();
        if (bS == Byte.class || bS == Byte.TYPE) {
            return Byte.valueOf(this.eK.byteValue());
        }
        if (bS == Short.class || bS == Short.TYPE) {
            return Short.valueOf(this.eK.shortValue());
        }
        if (bS == Integer.class || bS == Integer.TYPE) {
            return Integer.valueOf(this.eK.intValue());
        }
        if (bS == Long.class || bS == Long.TYPE) {
            return Long.valueOf(this.eK.longValue());
        }
        if (bS == Float.class || bS == Float.TYPE) {
            return Float.valueOf(this.eK.floatValue());
        }
        if (bS == Double.class || bS == Double.TYPE) {
            return Double.valueOf(this.eK.doubleValue());
        }
        if (bS == Character.class || bS == Character.TYPE) {
            return Character.valueOf((char) this.eK.intValue());
        }
        if (bS == Boolean.class || bS == Boolean.TYPE) {
            return Boolean.valueOf(this.eK.byteValue() == 0);
        } else if (bS == String.class) {
            return String.valueOf(this.eK);
        } else {
            if (bS == char[].class) {
                return String.valueOf(this.eK).toCharArray();
            }
            if (bS == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.k(String.valueOf(this.eK), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
