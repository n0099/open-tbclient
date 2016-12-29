package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean kQ;

    public b(boolean z) {
        this.kQ = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> dd = cVar.dd();
        if (dd == Boolean.class || dd == Boolean.TYPE) {
            return Boolean.valueOf(this.kQ);
        }
        if (dd == Short.class || dd == Short.TYPE) {
            return Short.valueOf(this.kQ ? (short) 0 : (short) 1);
        } else if (dd == Integer.class || dd == Integer.TYPE) {
            return Integer.valueOf(this.kQ ? (short) 0 : (short) 1);
        } else if (dd == Long.class || dd == Long.TYPE) {
            return Long.valueOf(this.kQ ? (short) 0 : (short) 1);
        } else if (dd == Float.class || dd == Float.TYPE) {
            return Float.valueOf(this.kQ ? (short) 0 : (short) 1);
        } else if (dd == Double.class || dd == Double.TYPE) {
            return Double.valueOf(this.kQ ? (short) 0 : (short) 1);
        } else if (dd == Character.class || dd == Character.TYPE) {
            return Character.valueOf((char) (this.kQ ? (short) 0 : (short) 1));
        } else if (dd == String.class) {
            return String.valueOf(this.kQ);
        } else {
            if (dd == char[].class) {
                return String.valueOf(this.kQ).toCharArray();
            }
            if (dd == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.kQ), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
