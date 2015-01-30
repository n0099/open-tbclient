package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte gG;

    public d(byte b) {
        this.gG = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cq = cVar.cq();
        if (cq == Byte.class || cq == Byte.TYPE) {
            return Byte.valueOf(this.gG.byteValue());
        }
        if (cq == Short.class || cq == Short.TYPE) {
            return Short.valueOf(this.gG.shortValue());
        }
        if (cq == Integer.class || cq == Integer.TYPE) {
            return Integer.valueOf(this.gG.intValue());
        }
        if (cq == Long.class || cq == Long.TYPE) {
            return Long.valueOf(this.gG.longValue());
        }
        if (cq == Float.class || cq == Float.TYPE) {
            return Float.valueOf(this.gG.floatValue());
        }
        if (cq == Double.class || cq == Double.TYPE) {
            return Double.valueOf(this.gG.doubleValue());
        }
        if (cq == Character.class || cq == Character.TYPE) {
            return Character.valueOf((char) this.gG.intValue());
        }
        if (cq == Boolean.class || cq == Boolean.TYPE) {
            return Boolean.valueOf(this.gG.byteValue() == 0);
        } else if (cq == String.class) {
            return String.valueOf(this.gG);
        } else {
            if (cq == char[].class) {
                return String.valueOf(this.gG).toCharArray();
            }
            if (cq == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gG), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
