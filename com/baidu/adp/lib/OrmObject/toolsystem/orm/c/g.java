package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float pw;

    public g(float f) {
        this.pw = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fp = cVar.fp();
        if (fp == Byte.class || fp == Byte.TYPE) {
            return Byte.valueOf(this.pw.byteValue());
        }
        if (fp == Short.class || fp == Short.TYPE) {
            return Short.valueOf(this.pw.shortValue());
        }
        if (fp == Integer.class || fp == Integer.TYPE) {
            return Integer.valueOf(this.pw.intValue());
        }
        if (fp == Long.class || fp == Long.TYPE) {
            return Long.valueOf(this.pw.longValue());
        }
        if (fp == Float.class || fp == Float.TYPE) {
            return Float.valueOf(this.pw.floatValue());
        }
        if (fp == Double.class || fp == Double.TYPE) {
            return Double.valueOf(this.pw.doubleValue());
        }
        if (fp == Character.class || fp == Character.TYPE) {
            return Character.valueOf((char) this.pw.intValue());
        }
        if (fp == Boolean.class || fp == Boolean.TYPE) {
            return Boolean.valueOf(this.pw.byteValue() == 0);
        } else if (fp == String.class) {
            return String.valueOf(this.pw);
        } else {
            if (fp == char[].class) {
                return String.valueOf(this.pw).toCharArray();
            }
            if (fp == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.pw), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
