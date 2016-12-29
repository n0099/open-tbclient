package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char kT;

    public e(char c) {
        this.kT = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd = cVar.dd();
        if (dd == Byte.class || dd == Byte.TYPE) {
            return Byte.valueOf((byte) this.kT);
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf((short) this.kT);
        }
        if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(this.kT);
        }
        if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(this.kT);
        }
        if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(this.kT);
        }
        if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(this.kT);
        }
        if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf(this.kT);
        }
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.kT) == 0);
        } else if (dd == String.class) {
            return String.valueOf(this.kT);
        } else {
            if (dd == char[].class) {
                return String.valueOf(this.kT).toCharArray();
            }
            if (dd == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.kT), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
