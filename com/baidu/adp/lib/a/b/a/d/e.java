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
        Class<?> ci = cVar.ci();
        if (ci == Byte.class || ci == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (ci == Short.class || ci == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (ci == Integer.class || ci == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (ci == Long.class || ci == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (ci == Float.class || ci == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (ci == Double.class || ci == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (ci == Character.class || ci == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (ci == Boolean.class || ci == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
        } else if (ci == String.class) {
            return String.valueOf(this.value);
        } else {
            if (ci == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (ci == byte[].class) {
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
