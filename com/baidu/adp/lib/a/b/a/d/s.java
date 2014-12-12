package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short gL;

    public s(short s) {
        this.gL = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cs = cVar.cs();
        if (cs == Byte.class || cs == Byte.TYPE) {
            return Byte.valueOf(this.gL.byteValue());
        }
        if (cs == Short.class || cs == Short.TYPE) {
            return Short.valueOf(this.gL.shortValue());
        }
        if (cs == Integer.class || cs == Integer.TYPE) {
            return Integer.valueOf(this.gL.intValue());
        }
        if (cs == Long.class || cs == Long.TYPE) {
            return Long.valueOf(this.gL.longValue());
        }
        if (cs == Float.class || cs == Float.TYPE) {
            return Float.valueOf(this.gL.floatValue());
        }
        if (cs == Double.class || cs == Double.TYPE) {
            return Double.valueOf(this.gL.doubleValue());
        }
        if (cs == Character.class || cs == Character.TYPE) {
            return Character.valueOf((char) this.gL.intValue());
        }
        if (cs == Boolean.class || cs == Boolean.TYPE) {
            return Boolean.valueOf(this.gL.byteValue() == 0);
        } else if (cs == String.class) {
            return String.valueOf(this.gL);
        } else {
            if (cs == char[].class) {
                return String.valueOf(this.gL).toCharArray();
            }
            if (cs == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gL), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
