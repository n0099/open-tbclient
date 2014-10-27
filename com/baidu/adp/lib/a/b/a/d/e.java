package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char em;

    public e(char c) {
        this.em = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> bS = cVar.bS();
        if (bS == Byte.class || bS == Byte.TYPE) {
            return Byte.valueOf((byte) this.em);
        }
        if (bS == Short.class || bS == Short.TYPE) {
            return Short.valueOf((short) this.em);
        }
        if (bS == Integer.class || bS == Integer.TYPE) {
            return Integer.valueOf(this.em);
        }
        if (bS == Long.class || bS == Long.TYPE) {
            return Long.valueOf(this.em);
        }
        if (bS == Float.class || bS == Float.TYPE) {
            return Float.valueOf(this.em);
        }
        if (bS == Double.class || bS == Double.TYPE) {
            return Double.valueOf(this.em);
        }
        if (bS == Character.class || bS == Character.TYPE) {
            return Character.valueOf(this.em);
        }
        if (bS == Boolean.class || bS == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.em) == 0);
        } else if (bS == String.class) {
            return String.valueOf(this.em);
        } else {
            if (bS == char[].class) {
                return String.valueOf(this.em).toCharArray();
            }
            if (bS == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.k(String.valueOf(this.em), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
