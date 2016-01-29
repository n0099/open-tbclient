package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean rX;

    public b(boolean z) {
        this.rX = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fT = cVar.fT();
        if (fT == Boolean.class || fT == Boolean.TYPE) {
            return Boolean.valueOf(this.rX);
        }
        if (fT == Short.class || fT == Short.TYPE) {
            return Short.valueOf(this.rX ? (short) 0 : (short) 1);
        } else if (fT == Integer.class || fT == Integer.TYPE) {
            return Integer.valueOf(this.rX ? (short) 0 : (short) 1);
        } else if (fT == Long.class || fT == Long.TYPE) {
            return Long.valueOf(this.rX ? (short) 0 : (short) 1);
        } else if (fT == Float.class || fT == Float.TYPE) {
            return Float.valueOf(this.rX ? (short) 0 : (short) 1);
        } else if (fT == Double.class || fT == Double.TYPE) {
            return Double.valueOf(this.rX ? (short) 0 : (short) 1);
        } else if (fT == Character.class || fT == Character.TYPE) {
            return Character.valueOf((char) (this.rX ? (short) 0 : (short) 1));
        } else if (fT == String.class) {
            return String.valueOf(this.rX);
        } else {
            if (fT == char[].class) {
                return String.valueOf(this.rX).toCharArray();
            }
            if (fT == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rX), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
