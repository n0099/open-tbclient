package com.baidu.adp.lib.a.b.a.d;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double sb;

    public f(double d) {
        this.sb = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.a.b.a.d.h
    public Object g(com.baidu.adp.lib.a.b.a.e.c cVar) {
        Class<?> fO = cVar.fO();
        if (fO == Byte.class || fO == Byte.TYPE) {
            return Byte.valueOf(this.sb.byteValue());
        }
        if (fO == Short.class || fO == Short.TYPE) {
            return Short.valueOf(this.sb.shortValue());
        }
        if (fO == Integer.class || fO == Integer.TYPE) {
            return Integer.valueOf(this.sb.intValue());
        }
        if (fO == Long.class || fO == Long.TYPE) {
            return Long.valueOf(this.sb.longValue());
        }
        if (fO == Float.class || fO == Float.TYPE) {
            return Float.valueOf(this.sb.floatValue());
        }
        if (fO == Double.class || fO == Double.TYPE) {
            return Double.valueOf(this.sb.doubleValue());
        }
        if (fO == Character.class || fO == Character.TYPE) {
            return Character.valueOf((char) this.sb.intValue());
        }
        if (fO == Boolean.class || fO == Boolean.TYPE) {
            return Boolean.valueOf(this.sb.byteValue() == 0);
        } else if (fO == String.class) {
            return String.valueOf(this.sb);
        } else {
            if (fO == char[].class) {
                return String.valueOf(this.sb).toCharArray();
            }
            if (fO == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sb), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
