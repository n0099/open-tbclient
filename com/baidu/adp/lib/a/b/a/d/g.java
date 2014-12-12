package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float gG;

    public g(float f) {
        this.gG = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> cs = cVar.cs();
        if (cs == Byte.class || cs == Byte.TYPE) {
            return Byte.valueOf(this.gG.byteValue());
        }
        if (cs == Short.class || cs == Short.TYPE) {
            return Short.valueOf(this.gG.shortValue());
        }
        if (cs == Integer.class || cs == Integer.TYPE) {
            return Integer.valueOf(this.gG.intValue());
        }
        if (cs == Long.class || cs == Long.TYPE) {
            return Long.valueOf(this.gG.longValue());
        }
        if (cs == Float.class || cs == Float.TYPE) {
            return Float.valueOf(this.gG.floatValue());
        }
        if (cs == Double.class || cs == Double.TYPE) {
            return Double.valueOf(this.gG.doubleValue());
        }
        if (cs == Character.class || cs == Character.TYPE) {
            return Character.valueOf((char) this.gG.intValue());
        }
        if (cs == Boolean.class || cs == Boolean.TYPE) {
            return Boolean.valueOf(this.gG.byteValue() == 0);
        } else if (cs == String.class) {
            return String.valueOf(this.gG);
        } else {
            if (cs == char[].class) {
                return String.valueOf(this.gG).toCharArray();
            }
            if (cs == byte[].class) {
                try {
                    return com.baidu.adp.lib.webSocket.a.decode(String.valueOf(this.gG), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
