package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte sj;

    public d(byte b) {
        this.sj = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fL = cVar.fL();
        if (fL == Byte.class || fL == Byte.TYPE) {
            return Byte.valueOf(this.sj.byteValue());
        }
        if (fL == Short.class || fL == Short.TYPE) {
            return Short.valueOf(this.sj.shortValue());
        }
        if (fL == Integer.class || fL == Integer.TYPE) {
            return Integer.valueOf(this.sj.intValue());
        }
        if (fL == Long.class || fL == Long.TYPE) {
            return Long.valueOf(this.sj.longValue());
        }
        if (fL == Float.class || fL == Float.TYPE) {
            return Float.valueOf(this.sj.floatValue());
        }
        if (fL == Double.class || fL == Double.TYPE) {
            return Double.valueOf(this.sj.doubleValue());
        }
        if (fL == Character.class || fL == Character.TYPE) {
            return Character.valueOf((char) this.sj.intValue());
        }
        if (fL == Boolean.class || fL == Boolean.TYPE) {
            return Boolean.valueOf(this.sj.byteValue() == 0);
        } else if (fL == String.class) {
            return String.valueOf(this.sj);
        } else {
            if (fL == char[].class) {
                return String.valueOf(this.sj).toCharArray();
            }
            if (fL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sj), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
