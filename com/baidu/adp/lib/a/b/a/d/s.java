package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short sh;

    public s(short s) {
        this.sh = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fO = cVar.fO();
        if (fO == Byte.class || fO == Byte.TYPE) {
            return Byte.valueOf(this.sh.byteValue());
        }
        if (fO == Short.class || fO == Short.TYPE) {
            return Short.valueOf(this.sh.shortValue());
        }
        if (fO == Integer.class || fO == Integer.TYPE) {
            return Integer.valueOf(this.sh.intValue());
        }
        if (fO == Long.class || fO == Long.TYPE) {
            return Long.valueOf(this.sh.longValue());
        }
        if (fO == Float.class || fO == Float.TYPE) {
            return Float.valueOf(this.sh.floatValue());
        }
        if (fO == Double.class || fO == Double.TYPE) {
            return Double.valueOf(this.sh.doubleValue());
        }
        if (fO == Character.class || fO == Character.TYPE) {
            return Character.valueOf((char) this.sh.intValue());
        }
        if (fO == Boolean.class || fO == Boolean.TYPE) {
            return Boolean.valueOf(this.sh.byteValue() == 0);
        } else if (fO == String.class) {
            return String.valueOf(this.sh);
        } else {
            if (fO == char[].class) {
                return String.valueOf(this.sh).toCharArray();
            }
            if (fO == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sh), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
