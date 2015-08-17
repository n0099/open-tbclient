package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char rR;

    public e(char c) {
        this.rR = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fO = cVar.fO();
        if (fO == Byte.class || fO == Byte.TYPE) {
            return Byte.valueOf((byte) this.rR);
        }
        if (fO == Short.class || fO == Short.TYPE) {
            return Short.valueOf((short) this.rR);
        }
        if (fO == Integer.class || fO == Integer.TYPE) {
            return Integer.valueOf(this.rR);
        }
        if (fO == Long.class || fO == Long.TYPE) {
            return Long.valueOf(this.rR);
        }
        if (fO == Float.class || fO == Float.TYPE) {
            return Float.valueOf(this.rR);
        }
        if (fO == Double.class || fO == Double.TYPE) {
            return Double.valueOf(this.rR);
        }
        if (fO == Character.class || fO == Character.TYPE) {
            return Character.valueOf(this.rR);
        }
        if (fO == Boolean.class || fO == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.rR) == 0);
        } else if (fO == String.class) {
            return String.valueOf(this.rR);
        } else {
            if (fO == char[].class) {
                return String.valueOf(this.rR).toCharArray();
            }
            if (fO == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rR), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
