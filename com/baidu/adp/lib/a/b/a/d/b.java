package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean rH;

    public b(boolean z) {
        this.rH = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fO = cVar.fO();
        if (fO == Boolean.class || fO == Boolean.TYPE) {
            return Boolean.valueOf(this.rH);
        }
        if (fO == Short.class || fO == Short.TYPE) {
            return Short.valueOf(this.rH ? (short) 0 : (short) 1);
        } else if (fO == Integer.class || fO == Integer.TYPE) {
            return Integer.valueOf(this.rH ? (short) 0 : (short) 1);
        } else if (fO == Long.class || fO == Long.TYPE) {
            return Long.valueOf(this.rH ? (short) 0 : (short) 1);
        } else if (fO == Float.class || fO == Float.TYPE) {
            return Float.valueOf(this.rH ? (short) 0 : (short) 1);
        } else if (fO == Double.class || fO == Double.TYPE) {
            return Double.valueOf(this.rH ? (short) 0 : (short) 1);
        } else if (fO == Character.class || fO == Character.TYPE) {
            return Character.valueOf((char) (this.rH ? (short) 0 : (short) 1));
        } else if (fO == String.class) {
            return String.valueOf(this.rH);
        } else {
            if (fO == char[].class) {
                return String.valueOf(this.rH).toCharArray();
            }
            if (fO == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rH), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
