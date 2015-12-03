package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short sq;

    public s(short s) {
        this.sq = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        if (fL == Byte.class || fL == Byte.TYPE) {
            return Byte.valueOf(this.sq.byteValue());
        }
        if (fL == Short.class || fL == Short.TYPE) {
            return Short.valueOf(this.sq.shortValue());
        }
        if (fL == Integer.class || fL == Integer.TYPE) {
            return Integer.valueOf(this.sq.intValue());
        }
        if (fL == Long.class || fL == Long.TYPE) {
            return Long.valueOf(this.sq.longValue());
        }
        if (fL == Float.class || fL == Float.TYPE) {
            return Float.valueOf(this.sq.floatValue());
        }
        if (fL == Double.class || fL == Double.TYPE) {
            return Double.valueOf(this.sq.doubleValue());
        }
        if (fL == Character.class || fL == Character.TYPE) {
            return Character.valueOf((char) this.sq.intValue());
        }
        if (fL == Boolean.class || fL == Boolean.TYPE) {
            return Boolean.valueOf(this.sq.byteValue() == 0);
        } else if (fL == String.class) {
            return String.valueOf(this.sq);
        } else {
            if (fL == char[].class) {
                return String.valueOf(this.sq).toCharArray();
            }
            if (fL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sq), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
