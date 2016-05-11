package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char hX;

    public e(char c) {
        this.hX = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> ci = cVar.ci();
        if (ci == Byte.class || ci == Byte.TYPE) {
            return Byte.valueOf((byte) this.hX);
        }
        if (ci == Short.class || ci == Short.TYPE) {
            return Short.valueOf((short) this.hX);
        }
        if (ci == Integer.class || ci == Integer.TYPE) {
            return Integer.valueOf(this.hX);
        }
        if (ci == Long.class || ci == Long.TYPE) {
            return Long.valueOf(this.hX);
        }
        if (ci == Float.class || ci == Float.TYPE) {
            return Float.valueOf(this.hX);
        }
        if (ci == Double.class || ci == Double.TYPE) {
            return Double.valueOf(this.hX);
        }
        if (ci == Character.class || ci == Character.TYPE) {
            return Character.valueOf(this.hX);
        }
        if (ci == Boolean.class || ci == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.hX) == 0);
        } else if (ci == String.class) {
            return String.valueOf(this.hX);
        } else {
            if (ci == char[].class) {
                return String.valueOf(this.hX).toCharArray();
            }
            if (ci == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.hX), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
