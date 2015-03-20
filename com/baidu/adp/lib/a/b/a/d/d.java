package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte sa;

    public d(byte b) {
        this.sa = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fO = cVar.fO();
        if (fO == Byte.class || fO == Byte.TYPE) {
            return Byte.valueOf(this.sa.byteValue());
        }
        if (fO == Short.class || fO == Short.TYPE) {
            return Short.valueOf(this.sa.shortValue());
        }
        if (fO == Integer.class || fO == Integer.TYPE) {
            return Integer.valueOf(this.sa.intValue());
        }
        if (fO == Long.class || fO == Long.TYPE) {
            return Long.valueOf(this.sa.longValue());
        }
        if (fO == Float.class || fO == Float.TYPE) {
            return Float.valueOf(this.sa.floatValue());
        }
        if (fO == Double.class || fO == Double.TYPE) {
            return Double.valueOf(this.sa.doubleValue());
        }
        if (fO == Character.class || fO == Character.TYPE) {
            return Character.valueOf((char) this.sa.intValue());
        }
        if (fO == Boolean.class || fO == Boolean.TYPE) {
            return Boolean.valueOf(this.sa.byteValue() == 0);
        } else if (fO == String.class) {
            return String.valueOf(this.sa);
        } else {
            if (fO == char[].class) {
                return String.valueOf(this.sa).toCharArray();
            }
            if (fO == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sa), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
