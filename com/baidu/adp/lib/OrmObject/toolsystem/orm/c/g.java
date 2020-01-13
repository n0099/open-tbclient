package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float pr;

    public g(float f) {
        this.pr = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fp = cVar.fp();
        if (fp == Byte.class || fp == Byte.TYPE) {
            return Byte.valueOf(this.pr.byteValue());
        }
        if (fp == Short.class || fp == Short.TYPE) {
            return Short.valueOf(this.pr.shortValue());
        }
        if (fp == Integer.class || fp == Integer.TYPE) {
            return Integer.valueOf(this.pr.intValue());
        }
        if (fp == Long.class || fp == Long.TYPE) {
            return Long.valueOf(this.pr.longValue());
        }
        if (fp == Float.class || fp == Float.TYPE) {
            return Float.valueOf(this.pr.floatValue());
        }
        if (fp == Double.class || fp == Double.TYPE) {
            return Double.valueOf(this.pr.doubleValue());
        }
        if (fp == Character.class || fp == Character.TYPE) {
            return Character.valueOf((char) this.pr.intValue());
        }
        if (fp == Boolean.class || fp == Boolean.TYPE) {
            return Boolean.valueOf(this.pr.byteValue() == 0);
        } else if (fp == String.class) {
            return String.valueOf(this.pr);
        } else {
            if (fp == char[].class) {
                return String.valueOf(this.pr).toCharArray();
            }
            if (fp == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.pr), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
