package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean rO;

    public b(boolean z) {
        this.rO = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fO = cVar.fO();
        if (fO == Boolean.class || fO == Boolean.TYPE) {
            return Boolean.valueOf(this.rO);
        }
        if (fO == Short.class || fO == Short.TYPE) {
            return Short.valueOf(this.rO ? (short) 0 : (short) 1);
        } else if (fO == Integer.class || fO == Integer.TYPE) {
            return Integer.valueOf(this.rO ? (short) 0 : (short) 1);
        } else if (fO == Long.class || fO == Long.TYPE) {
            return Long.valueOf(this.rO ? (short) 0 : (short) 1);
        } else if (fO == Float.class || fO == Float.TYPE) {
            return Float.valueOf(this.rO ? (short) 0 : (short) 1);
        } else if (fO == Double.class || fO == Double.TYPE) {
            return Double.valueOf(this.rO ? (short) 0 : (short) 1);
        } else if (fO == Character.class || fO == Character.TYPE) {
            return Character.valueOf((char) (this.rO ? (short) 0 : (short) 1));
        } else if (fO == String.class) {
            return String.valueOf(this.rO);
        } else {
            if (fO == char[].class) {
                return String.valueOf(this.rO).toCharArray();
            }
            if (fO == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rO), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
