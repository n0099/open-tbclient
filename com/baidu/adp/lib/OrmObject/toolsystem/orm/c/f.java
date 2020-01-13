package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double pq;

    public f(double d) {
        this.pq = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fp = cVar.fp();
        if (fp == Byte.class || fp == Byte.TYPE) {
            return Byte.valueOf(this.pq.byteValue());
        }
        if (fp == Short.class || fp == Short.TYPE) {
            return Short.valueOf(this.pq.shortValue());
        }
        if (fp == Integer.class || fp == Integer.TYPE) {
            return Integer.valueOf(this.pq.intValue());
        }
        if (fp == Long.class || fp == Long.TYPE) {
            return Long.valueOf(this.pq.longValue());
        }
        if (fp == Float.class || fp == Float.TYPE) {
            return Float.valueOf(this.pq.floatValue());
        }
        if (fp == Double.class || fp == Double.TYPE) {
            return Double.valueOf(this.pq.doubleValue());
        }
        if (fp == Character.class || fp == Character.TYPE) {
            return Character.valueOf((char) this.pq.intValue());
        }
        if (fp == Boolean.class || fp == Boolean.TYPE) {
            return Boolean.valueOf(this.pq.byteValue() == 0);
        } else if (fp == String.class) {
            return String.valueOf(this.pq);
        } else {
            if (fp == char[].class) {
                return String.valueOf(this.pq).toCharArray();
            }
            if (fp == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.pq), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
