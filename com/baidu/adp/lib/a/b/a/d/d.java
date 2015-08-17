package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte si;

    public d(byte b) {
        this.si = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fO = cVar.fO();
        if (fO == Byte.class || fO == Byte.TYPE) {
            return Byte.valueOf(this.si.byteValue());
        }
        if (fO == Short.class || fO == Short.TYPE) {
            return Short.valueOf(this.si.shortValue());
        }
        if (fO == Integer.class || fO == Integer.TYPE) {
            return Integer.valueOf(this.si.intValue());
        }
        if (fO == Long.class || fO == Long.TYPE) {
            return Long.valueOf(this.si.longValue());
        }
        if (fO == Float.class || fO == Float.TYPE) {
            return Float.valueOf(this.si.floatValue());
        }
        if (fO == Double.class || fO == Double.TYPE) {
            return Double.valueOf(this.si.doubleValue());
        }
        if (fO == Character.class || fO == Character.TYPE) {
            return Character.valueOf((char) this.si.intValue());
        }
        if (fO == Boolean.class || fO == Boolean.TYPE) {
            return Boolean.valueOf(this.si.byteValue() == 0);
        } else if (fO == String.class) {
            return String.valueOf(this.si);
        } else {
            if (fO == char[].class) {
                return String.valueOf(this.si).toCharArray();
            }
            if (fO == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.si), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
