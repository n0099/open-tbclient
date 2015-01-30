package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double gH;

    public f(double d) {
        this.gH = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cq = cVar.cq();
        if (cq == Byte.class || cq == Byte.TYPE) {
            return Byte.valueOf(this.gH.byteValue());
        }
        if (cq == Short.class || cq == Short.TYPE) {
            return Short.valueOf(this.gH.shortValue());
        }
        if (cq == Integer.class || cq == Integer.TYPE) {
            return Integer.valueOf(this.gH.intValue());
        }
        if (cq == Long.class || cq == Long.TYPE) {
            return Long.valueOf(this.gH.longValue());
        }
        if (cq == Float.class || cq == Float.TYPE) {
            return Float.valueOf(this.gH.floatValue());
        }
        if (cq == Double.class || cq == Double.TYPE) {
            return Double.valueOf(this.gH.doubleValue());
        }
        if (cq == Character.class || cq == Character.TYPE) {
            return Character.valueOf((char) this.gH.intValue());
        }
        if (cq == Boolean.class || cq == Boolean.TYPE) {
            return Boolean.valueOf(this.gH.byteValue() == 0);
        } else if (cq == String.class) {
            return String.valueOf(this.gH);
        } else {
            if (cq == char[].class) {
                return String.valueOf(this.gH).toCharArray();
            }
            if (cq == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gH), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
