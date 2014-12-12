package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean gl;

    public b(boolean z) {
        this.gl = z;
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cs = cVar.cs();
        if (cs == Boolean.class || cs == Boolean.TYPE) {
            return Boolean.valueOf(this.gl);
        }
        if (cs == Short.class || cs == Short.TYPE) {
            return Short.valueOf(this.gl ? (short) 0 : (short) 1);
        } else if (cs == Integer.class || cs == Integer.TYPE) {
            return Integer.valueOf(this.gl ? (short) 0 : (short) 1);
        } else if (cs == Long.class || cs == Long.TYPE) {
            return Long.valueOf(this.gl ? (short) 0 : (short) 1);
        } else if (cs == Float.class || cs == Float.TYPE) {
            return Float.valueOf(this.gl ? (short) 0 : (short) 1);
        } else if (cs == Double.class || cs == Double.TYPE) {
            return Double.valueOf(this.gl ? (short) 0 : (short) 1);
        } else if (cs == Character.class || cs == Character.TYPE) {
            return Character.valueOf((char) (this.gl ? (short) 0 : (short) 1));
        } else if (cs == String.class) {
            return String.valueOf(this.gl);
        } else {
            if (cs == char[].class) {
                return String.valueOf(this.gl).toCharArray();
            }
            if (cs == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gl), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
