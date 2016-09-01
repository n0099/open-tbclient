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
        Class<?> dd = cVar.dd();
        if (dd == Byte.class || dd == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
        } else if (dd == String.class) {
            return String.valueOf(this.value);
        } else {
            if (dd == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (dd == byte[].class) {
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
