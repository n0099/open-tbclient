package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean gn;

    public b(boolean z) {
        this.gn = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cq = cVar.cq();
        if (cq == Boolean.class || cq == Boolean.TYPE) {
            return Boolean.valueOf(this.gn);
        }
        if (cq == Short.class || cq == Short.TYPE) {
            return Short.valueOf(this.gn ? (short) 0 : (short) 1);
        } else if (cq == Integer.class || cq == Integer.TYPE) {
            return Integer.valueOf(this.gn ? (short) 0 : (short) 1);
        } else if (cq == Long.class || cq == Long.TYPE) {
            return Long.valueOf(this.gn ? (short) 0 : (short) 1);
        } else if (cq == Float.class || cq == Float.TYPE) {
            return Float.valueOf(this.gn ? (short) 0 : (short) 1);
        } else if (cq == Double.class || cq == Double.TYPE) {
            return Double.valueOf(this.gn ? (short) 0 : (short) 1);
        } else if (cq == Character.class || cq == Character.TYPE) {
            return Character.valueOf((char) (this.gn ? (short) 0 : (short) 1));
        } else if (cq == String.class) {
            return String.valueOf(this.gn);
        } else {
            if (cq == char[].class) {
                return String.valueOf(this.gn).toCharArray();
            }
            if (cq == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gn), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
