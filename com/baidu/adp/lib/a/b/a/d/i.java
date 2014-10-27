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
        Class<?> bS = cVar.bS();
        if (bS == Byte.class || bS == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (bS == Short.class || bS == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (bS == Integer.class || bS == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (bS == Long.class || bS == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (bS == Float.class || bS == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (bS == Double.class || bS == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (bS == Character.class || bS == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (bS == Boolean.class || bS == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (bS == String.class) {
            return String.valueOf(this.value);
        } else {
            if (bS == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (bS == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.k(String.valueOf(this.value), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
