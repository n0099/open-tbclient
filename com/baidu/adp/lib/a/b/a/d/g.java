package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float eG;

    public g(float f) {
        this.eG = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> bS = cVar.bS();
        if (bS == Byte.class || bS == Byte.TYPE) {
            return Byte.valueOf(this.eG.byteValue());
        }
        if (bS == Short.class || bS == Short.TYPE) {
            return Short.valueOf(this.eG.shortValue());
        }
        if (bS == Integer.class || bS == Integer.TYPE) {
            return Integer.valueOf(this.eG.intValue());
        }
        if (bS == Long.class || bS == Long.TYPE) {
            return Long.valueOf(this.eG.longValue());
        }
        if (bS == Float.class || bS == Float.TYPE) {
            return Float.valueOf(this.eG.floatValue());
        }
        if (bS == Double.class || bS == Double.TYPE) {
            return Double.valueOf(this.eG.doubleValue());
        }
        if (bS == Character.class || bS == Character.TYPE) {
            return Character.valueOf((char) this.eG.intValue());
        }
        if (bS == Boolean.class || bS == Boolean.TYPE) {
            return Boolean.valueOf(this.eG.byteValue() == 0);
        } else if (bS == String.class) {
            return String.valueOf(this.eG);
        } else {
            if (bS == char[].class) {
                return String.valueOf(this.eG).toCharArray();
            }
            if (bS == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.k(String.valueOf(this.eG), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
