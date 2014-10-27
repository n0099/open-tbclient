package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean ej;

    public b(boolean z) {
        this.ej = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> bS = cVar.bS();
        if (bS == Boolean.class || bS == Boolean.TYPE) {
            return Boolean.valueOf(this.ej);
        }
        if (bS == Short.class || bS == Short.TYPE) {
            return Short.valueOf(this.ej ? (short) 0 : (short) 1);
        } else if (bS == Integer.class || bS == Integer.TYPE) {
            return Integer.valueOf(this.ej ? (short) 0 : (short) 1);
        } else if (bS == Long.class || bS == Long.TYPE) {
            return Long.valueOf(this.ej ? (short) 0 : (short) 1);
        } else if (bS == Float.class || bS == Float.TYPE) {
            return Float.valueOf(this.ej ? (short) 0 : (short) 1);
        } else if (bS == Double.class || bS == Double.TYPE) {
            return Double.valueOf(this.ej ? (short) 0 : (short) 1);
        } else if (bS == Character.class || bS == Character.TYPE) {
            return Character.valueOf((char) (this.ej ? (short) 0 : (short) 1));
        } else if (bS == String.class) {
            return String.valueOf(this.ej);
        } else {
            if (bS == char[].class) {
                return String.valueOf(this.ej).toCharArray();
            }
            if (bS == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.k(String.valueOf(this.ej), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
