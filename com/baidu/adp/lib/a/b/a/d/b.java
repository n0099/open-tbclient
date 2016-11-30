package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean kR;

    public b(boolean z) {
        this.kR = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd = cVar.dd();
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(this.kR);
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf(this.kR ? (short) 0 : (short) 1);
        } else if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(this.kR ? (short) 0 : (short) 1);
        } else if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(this.kR ? (short) 0 : (short) 1);
        } else if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(this.kR ? (short) 0 : (short) 1);
        } else if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(this.kR ? (short) 0 : (short) 1);
        } else if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf((char) (this.kR ? (short) 0 : (short) 1));
        } else if (dd == String.class) {
            return String.valueOf(this.kR);
        } else {
            if (dd == char[].class) {
                return String.valueOf(this.kR).toCharArray();
            }
            if (dd == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.kR), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
