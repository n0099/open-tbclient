package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float gI;

    public g(float f) {
        this.gI = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cq = cVar.cq();
        if (cq == Byte.class || cq == Byte.TYPE) {
            return Byte.valueOf(this.gI.byteValue());
        }
        if (cq == Short.class || cq == Short.TYPE) {
            return Short.valueOf(this.gI.shortValue());
        }
        if (cq == Integer.class || cq == Integer.TYPE) {
            return Integer.valueOf(this.gI.intValue());
        }
        if (cq == Long.class || cq == Long.TYPE) {
            return Long.valueOf(this.gI.longValue());
        }
        if (cq == Float.class || cq == Float.TYPE) {
            return Float.valueOf(this.gI.floatValue());
        }
        if (cq == Double.class || cq == Double.TYPE) {
            return Double.valueOf(this.gI.doubleValue());
        }
        if (cq == Character.class || cq == Character.TYPE) {
            return Character.valueOf((char) this.gI.intValue());
        }
        if (cq == Boolean.class || cq == Boolean.TYPE) {
            return Boolean.valueOf(this.gI.byteValue() == 0);
        } else if (cq == String.class) {
            return String.valueOf(this.gI);
        } else {
            if (cq == char[].class) {
                return String.valueOf(this.gI).toCharArray();
            }
            if (cq == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gI), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
