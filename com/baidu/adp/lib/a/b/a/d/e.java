package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char rU;

    public e(char c) {
        this.rU = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        if (fT == Byte.class || fT == Byte.TYPE) {
            return Byte.valueOf((byte) this.rU);
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf((short) this.rU);
        }
        if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(this.rU);
        }
        if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(this.rU);
        }
        if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(this.rU);
        }
        if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(this.rU);
        }
        if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf(this.rU);
        }
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.rU) == 0);
        } else if (fT == String.class) {
            return String.valueOf(this.rU);
        } else {
            if (fT == char[].class) {
                return String.valueOf(this.rU).toCharArray();
            }
            if (fT == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rU), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
