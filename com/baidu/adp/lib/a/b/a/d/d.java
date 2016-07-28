package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte iU;

    public d(byte b) {
        this.iU = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> ci = cVar.ci();
        if (ci == Byte.class || ci == Byte.TYPE) {
            return Byte.valueOf(this.iU.byteValue());
        }
        if (ci == Short.class || ci == Short.TYPE) {
            return Short.valueOf(this.iU.shortValue());
        }
        if (ci == Integer.class || ci == Integer.TYPE) {
            return Integer.valueOf(this.iU.intValue());
        }
        if (ci == Long.class || ci == Long.TYPE) {
            return Long.valueOf(this.iU.longValue());
        }
        if (ci == Float.class || ci == Float.TYPE) {
            return Float.valueOf(this.iU.floatValue());
        }
        if (ci == Double.class || ci == Double.TYPE) {
            return Double.valueOf(this.iU.doubleValue());
        }
        if (ci == Character.class || ci == Character.TYPE) {
            return Character.valueOf((char) this.iU.intValue());
        }
        if (ci == Boolean.class || ci == Boolean.TYPE) {
            return Boolean.valueOf(this.iU.byteValue() == 0);
        } else if (ci == String.class) {
            return String.valueOf(this.iU);
        } else {
            if (ci == char[].class) {
                return String.valueOf(this.iU).toCharArray();
            }
            if (ci == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.iU), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
