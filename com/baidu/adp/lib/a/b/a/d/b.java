package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean hT;

    public b(boolean z) {
        this.hT = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cj = cVar.cj();
        if (cj == Boolean.class || cj == Boolean.TYPE) {
            return Boolean.valueOf(this.hT);
        }
        if (cj == Short.class || cj == Short.TYPE) {
            return Short.valueOf(this.hT ? (short) 0 : (short) 1);
        } else if (cj == Integer.class || cj == Integer.TYPE) {
            return Integer.valueOf(this.hT ? (short) 0 : (short) 1);
        } else if (cj == Long.class || cj == Long.TYPE) {
            return Long.valueOf(this.hT ? (short) 0 : (short) 1);
        } else if (cj == Float.class || cj == Float.TYPE) {
            return Float.valueOf(this.hT ? (short) 0 : (short) 1);
        } else if (cj == Double.class || cj == Double.TYPE) {
            return Double.valueOf(this.hT ? (short) 0 : (short) 1);
        } else if (cj == Character.class || cj == Character.TYPE) {
            return Character.valueOf((char) (this.hT ? (short) 0 : (short) 1));
        } else if (cj == String.class) {
            return String.valueOf(this.hT);
        } else {
            if (cj == char[].class) {
                return String.valueOf(this.hT).toCharArray();
            }
            if (cj == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.hT), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
