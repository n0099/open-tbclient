package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class i implements h {
    private Integer value;

    public i(int i) {
        this.value = Integer.valueOf(i);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cq = cVar.cq();
        if (cq == Byte.class || cq == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (cq == Short.class || cq == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (cq == Integer.class || cq == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (cq == Long.class || cq == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (cq == Float.class || cq == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (cq == Double.class || cq == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (cq == Character.class || cq == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (cq == Boolean.class || cq == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (cq == String.class) {
            return String.valueOf(this.value);
        } else {
            if (cq == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (cq == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.value), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
