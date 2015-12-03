package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char rQ;

    public e(char c) {
        this.rQ = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        if (fL == Byte.class || fL == Byte.TYPE) {
            return Byte.valueOf((byte) this.rQ);
        }
        if (fL == Short.class || fL == Short.TYPE) {
            return Short.valueOf((short) this.rQ);
        }
        if (fL == Integer.class || fL == Integer.TYPE) {
            return Integer.valueOf(this.rQ);
        }
        if (fL == Long.class || fL == Long.TYPE) {
            return Long.valueOf(this.rQ);
        }
        if (fL == Float.class || fL == Float.TYPE) {
            return Float.valueOf(this.rQ);
        }
        if (fL == Double.class || fL == Double.TYPE) {
            return Double.valueOf(this.rQ);
        }
        if (fL == Character.class || fL == Character.TYPE) {
            return Character.valueOf(this.rQ);
        }
        if (fL == Boolean.class || fL == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.rQ) == 0);
        } else if (fL == String.class) {
            return String.valueOf(this.rQ);
        } else {
            if (fL == char[].class) {
                return String.valueOf(this.rQ).toCharArray();
            }
            if (fL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rQ), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
