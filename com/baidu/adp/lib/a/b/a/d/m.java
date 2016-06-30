package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class m implements h {
    private Long value;

    public m(long j) {
        this.value = Long.valueOf(j);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cj = cVar.cj();
        if (cj == Byte.class || cj == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (cj == Short.class || cj == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (cj == Integer.class || cj == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (cj == Long.class || cj == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (cj == Float.class || cj == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (cj == Double.class || cj == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (cj == Character.class || cj == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (cj == Boolean.class || cj == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (cj == String.class) {
            return String.valueOf(this.value);
        } else {
            if (cj == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (cj == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.value), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
