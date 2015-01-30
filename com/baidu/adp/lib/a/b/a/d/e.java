package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char gp;

    public e(char c) {
        this.gp = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cq = cVar.cq();
        if (cq == Byte.class || cq == Byte.TYPE) {
            return Byte.valueOf((byte) this.gp);
        }
        if (cq == Short.class || cq == Short.TYPE) {
            return Short.valueOf((short) this.gp);
        }
        if (cq == Integer.class || cq == Integer.TYPE) {
            return Integer.valueOf(this.gp);
        }
        if (cq == Long.class || cq == Long.TYPE) {
            return Long.valueOf(this.gp);
        }
        if (cq == Float.class || cq == Float.TYPE) {
            return Float.valueOf(this.gp);
        }
        if (cq == Double.class || cq == Double.TYPE) {
            return Double.valueOf(this.gp);
        }
        if (cq == Character.class || cq == Character.TYPE) {
            return Character.valueOf(this.gp);
        }
        if (cq == Boolean.class || cq == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.gp) == 0);
        } else if (cq == String.class) {
            return String.valueOf(this.gp);
        } else {
            if (cq == char[].class) {
                return String.valueOf(this.gp).toCharArray();
            }
            if (cq == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gp), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
