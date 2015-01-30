package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short gN;

    public s(short s) {
        this.gN = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cq = cVar.cq();
        if (cq == Byte.class || cq == Byte.TYPE) {
            return Byte.valueOf(this.gN.byteValue());
        }
        if (cq == Short.class || cq == Short.TYPE) {
            return Short.valueOf(this.gN.shortValue());
        }
        if (cq == Integer.class || cq == Integer.TYPE) {
            return Integer.valueOf(this.gN.intValue());
        }
        if (cq == Long.class || cq == Long.TYPE) {
            return Long.valueOf(this.gN.longValue());
        }
        if (cq == Float.class || cq == Float.TYPE) {
            return Float.valueOf(this.gN.floatValue());
        }
        if (cq == Double.class || cq == Double.TYPE) {
            return Double.valueOf(this.gN.doubleValue());
        }
        if (cq == Character.class || cq == Character.TYPE) {
            return Character.valueOf((char) this.gN.intValue());
        }
        if (cq == Boolean.class || cq == Boolean.TYPE) {
            return Boolean.valueOf(this.gN.byteValue() == 0);
        } else if (cq == String.class) {
            return String.valueOf(this.gN);
        } else {
            if (cq == char[].class) {
                return String.valueOf(this.gN).toCharArray();
            }
            if (cq == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gN), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
