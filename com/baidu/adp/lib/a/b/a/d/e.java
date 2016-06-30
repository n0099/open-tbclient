package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char value;

    public e(char c) {
        this.value = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cj = cVar.cj();
        if (cj == Byte.class || cj == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (cj == Short.class || cj == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (cj == Integer.class || cj == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (cj == Long.class || cj == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (cj == Float.class || cj == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (cj == Double.class || cj == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (cj == Character.class || cj == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (cj == Boolean.class || cj == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
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
