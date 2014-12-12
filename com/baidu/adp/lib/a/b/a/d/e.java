package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char gn;

    public e(char c) {
        this.gn = c;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cs = cVar.cs();
        if (cs == Byte.class || cs == Byte.TYPE) {
            return Byte.valueOf((byte) this.gn);
        }
        if (cs == Short.class || cs == Short.TYPE) {
            return Short.valueOf((short) this.gn);
        }
        if (cs == Integer.class || cs == Integer.TYPE) {
            return Integer.valueOf(this.gn);
        }
        if (cs == Long.class || cs == Long.TYPE) {
            return Long.valueOf(this.gn);
        }
        if (cs == Float.class || cs == Float.TYPE) {
            return Float.valueOf(this.gn);
        }
        if (cs == Double.class || cs == Double.TYPE) {
            return Double.valueOf(this.gn);
        }
        if (cs == Character.class || cs == Character.TYPE) {
            return Character.valueOf(this.gn);
        }
        if (cs == Boolean.class || cs == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.gn) == 0);
        } else if (cs == String.class) {
            return String.valueOf(this.gn);
        } else {
            if (cs == char[].class) {
                return String.valueOf(this.gn).toCharArray();
            }
            if (cs == byte[].class) {
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
