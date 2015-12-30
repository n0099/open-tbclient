package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char rS;

    public e(char c) {
        this.rS = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        if (fL == Byte.class || fL == Byte.TYPE) {
            return Byte.valueOf((byte) this.rS);
        }
        if (fL == Short.class || fL == Short.TYPE) {
            return Short.valueOf((short) this.rS);
        }
        if (fL == Integer.class || fL == Integer.TYPE) {
            return Integer.valueOf(this.rS);
        }
        if (fL == Long.class || fL == Long.TYPE) {
            return Long.valueOf(this.rS);
        }
        if (fL == Float.class || fL == Float.TYPE) {
            return Float.valueOf(this.rS);
        }
        if (fL == Double.class || fL == Double.TYPE) {
            return Double.valueOf(this.rS);
        }
        if (fL == Character.class || fL == Character.TYPE) {
            return Character.valueOf(this.rS);
        }
        if (fL == Boolean.class || fL == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.rS) == 0);
        } else if (fL == String.class) {
            return String.valueOf(this.rS);
        } else {
            if (fL == char[].class) {
                return String.valueOf(this.rS).toCharArray();
            }
            if (fL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rS), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
