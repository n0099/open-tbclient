package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short iB;

    public s(short s) {
        this.iB = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> ci = cVar.ci();
        if (ci == Byte.class || ci == Byte.TYPE) {
            return Byte.valueOf(this.iB.byteValue());
        }
        if (ci == Short.class || ci == Short.TYPE) {
            return Short.valueOf(this.iB.shortValue());
        }
        if (ci == Integer.class || ci == Integer.TYPE) {
            return Integer.valueOf(this.iB.intValue());
        }
        if (ci == Long.class || ci == Long.TYPE) {
            return Long.valueOf(this.iB.longValue());
        }
        if (ci == Float.class || ci == Float.TYPE) {
            return Float.valueOf(this.iB.floatValue());
        }
        if (ci == Double.class || ci == Double.TYPE) {
            return Double.valueOf(this.iB.doubleValue());
        }
        if (ci == Character.class || ci == Character.TYPE) {
            return Character.valueOf((char) this.iB.intValue());
        }
        if (ci == Boolean.class || ci == Boolean.TYPE) {
            return Boolean.valueOf(this.iB.byteValue() == 0);
        } else if (ci == String.class) {
            return String.valueOf(this.iB);
        } else {
            if (ci == char[].class) {
                return String.valueOf(this.iB).toCharArray();
            }
            if (ci == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.iB), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
