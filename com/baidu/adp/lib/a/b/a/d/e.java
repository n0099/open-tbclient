package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char sa;

    public e(char c) {
        this.sa = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        if (fT == Byte.class || fT == Byte.TYPE) {
            return Byte.valueOf((byte) this.sa);
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf((short) this.sa);
        }
        if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(this.sa);
        }
        if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(this.sa);
        }
        if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(this.sa);
        }
        if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(this.sa);
        }
        if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf(this.sa);
        }
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.sa) == 0);
        } else if (fT == String.class) {
            return String.valueOf(this.sa);
        } else {
            if (fT == char[].class) {
                return String.valueOf(this.sa).toCharArray();
            }
            if (fT == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sa), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
