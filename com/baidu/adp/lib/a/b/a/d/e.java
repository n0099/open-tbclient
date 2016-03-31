package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char sk;

    public e(char c) {
        this.sk = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        if (fT == Byte.class || fT == Byte.TYPE) {
            return Byte.valueOf((byte) this.sk);
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf((short) this.sk);
        }
        if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(this.sk);
        }
        if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(this.sk);
        }
        if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(this.sk);
        }
        if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(this.sk);
        }
        if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf(this.sk);
        }
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.sk) == 0);
        } else if (fT == String.class) {
            return String.valueOf(this.sk);
        } else {
            if (fT == char[].class) {
                return String.valueOf(this.sk).toCharArray();
            }
            if (fT == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sk), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
