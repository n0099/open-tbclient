package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte gE;

    public d(byte b) {
        this.gE = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cs = cVar.cs();
        if (cs == Byte.class || cs == Byte.TYPE) {
            return Byte.valueOf(this.gE.byteValue());
        }
        if (cs == Short.class || cs == Short.TYPE) {
            return Short.valueOf(this.gE.shortValue());
        }
        if (cs == Integer.class || cs == Integer.TYPE) {
            return Integer.valueOf(this.gE.intValue());
        }
        if (cs == Long.class || cs == Long.TYPE) {
            return Long.valueOf(this.gE.longValue());
        }
        if (cs == Float.class || cs == Float.TYPE) {
            return Float.valueOf(this.gE.floatValue());
        }
        if (cs == Double.class || cs == Double.TYPE) {
            return Double.valueOf(this.gE.doubleValue());
        }
        if (cs == Character.class || cs == Character.TYPE) {
            return Character.valueOf((char) this.gE.intValue());
        }
        if (cs == Boolean.class || cs == Boolean.TYPE) {
            return Boolean.valueOf(this.gE.byteValue() == 0);
        } else if (cs == String.class) {
            return String.valueOf(this.gE);
        } else {
            if (cs == char[].class) {
                return String.valueOf(this.gE).toCharArray();
            }
            if (cs == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gE), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
