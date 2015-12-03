package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean rN;

    public b(boolean z) {
        this.rN = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        if (fL == Boolean.class || fL == Boolean.TYPE) {
            return Boolean.valueOf(this.rN);
        }
        if (fL == Short.class || fL == Short.TYPE) {
            return Short.valueOf(this.rN ? (short) 0 : (short) 1);
        } else if (fL == Integer.class || fL == Integer.TYPE) {
            return Integer.valueOf(this.rN ? (short) 0 : (short) 1);
        } else if (fL == Long.class || fL == Long.TYPE) {
            return Long.valueOf(this.rN ? (short) 0 : (short) 1);
        } else if (fL == Float.class || fL == Float.TYPE) {
            return Float.valueOf(this.rN ? (short) 0 : (short) 1);
        } else if (fL == Double.class || fL == Double.TYPE) {
            return Double.valueOf(this.rN ? (short) 0 : (short) 1);
        } else if (fL == Character.class || fL == Character.TYPE) {
            return Character.valueOf((char) (this.rN ? (short) 0 : (short) 1));
        } else if (fL == String.class) {
            return String.valueOf(this.rN);
        } else {
            if (fL == char[].class) {
                return String.valueOf(this.rN).toCharArray();
            }
            if (fL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rN), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
