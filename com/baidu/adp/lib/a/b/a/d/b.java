package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean hU;

    public b(boolean z) {
        this.hU = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> ci = cVar.ci();
        if (ci == Boolean.class || ci == Boolean.TYPE) {
            return Boolean.valueOf(this.hU);
        }
        if (ci == Short.class || ci == Short.TYPE) {
            return Short.valueOf(this.hU ? (short) 0 : (short) 1);
        } else if (ci == Integer.class || ci == Integer.TYPE) {
            return Integer.valueOf(this.hU ? (short) 0 : (short) 1);
        } else if (ci == Long.class || ci == Long.TYPE) {
            return Long.valueOf(this.hU ? (short) 0 : (short) 1);
        } else if (ci == Float.class || ci == Float.TYPE) {
            return Float.valueOf(this.hU ? (short) 0 : (short) 1);
        } else if (ci == Double.class || ci == Double.TYPE) {
            return Double.valueOf(this.hU ? (short) 0 : (short) 1);
        } else if (ci == Character.class || ci == Character.TYPE) {
            return Character.valueOf((char) (this.hU ? (short) 0 : (short) 1));
        } else if (ci == String.class) {
            return String.valueOf(this.hU);
        } else {
            if (ci == char[].class) {
                return String.valueOf(this.hU).toCharArray();
            }
            if (ci == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.hU), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
