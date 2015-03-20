package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char rJ;

    public e(char c) {
        this.rJ = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fO = cVar.fO();
        if (fO == Byte.class || fO == Byte.TYPE) {
            return Byte.valueOf((byte) this.rJ);
        }
        if (fO == Short.class || fO == Short.TYPE) {
            return Short.valueOf((short) this.rJ);
        }
        if (fO == Integer.class || fO == Integer.TYPE) {
            return Integer.valueOf(this.rJ);
        }
        if (fO == Long.class || fO == Long.TYPE) {
            return Long.valueOf(this.rJ);
        }
        if (fO == Float.class || fO == Float.TYPE) {
            return Float.valueOf(this.rJ);
        }
        if (fO == Double.class || fO == Double.TYPE) {
            return Double.valueOf(this.rJ);
        }
        if (fO == Character.class || fO == Character.TYPE) {
            return Character.valueOf(this.rJ);
        }
        if (fO == Boolean.class || fO == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.rJ) == 0);
        } else if (fO == String.class) {
            return String.valueOf(this.rJ);
        } else {
            if (fO == char[].class) {
                return String.valueOf(this.rJ).toCharArray();
            }
            if (fO == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rJ), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
