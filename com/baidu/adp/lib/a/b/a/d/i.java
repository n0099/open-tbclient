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
        Class<?> cs = cVar.cs();
        if (cs == Byte.class || cs == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (cs == Short.class || cs == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (cs == Integer.class || cs == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (cs == Long.class || cs == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (cs == Float.class || cs == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (cs == Double.class || cs == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (cs == Character.class || cs == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (cs == Boolean.class || cs == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (cs == String.class) {
            return String.valueOf(this.value);
        } else {
            if (cs == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (cs == byte[].class) {
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
