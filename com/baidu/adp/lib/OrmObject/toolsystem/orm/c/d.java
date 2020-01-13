package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte pp;

    public d(byte b) {
        this.pp = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fp = cVar.fp();
        if (fp == Byte.class || fp == Byte.TYPE) {
            return Byte.valueOf(this.pp.byteValue());
        }
        if (fp == Short.class || fp == Short.TYPE) {
            return Short.valueOf(this.pp.shortValue());
        }
        if (fp == Integer.class || fp == Integer.TYPE) {
            return Integer.valueOf(this.pp.intValue());
        }
        if (fp == Long.class || fp == Long.TYPE) {
            return Long.valueOf(this.pp.longValue());
        }
        if (fp == Float.class || fp == Float.TYPE) {
            return Float.valueOf(this.pp.floatValue());
        }
        if (fp == Double.class || fp == Double.TYPE) {
            return Double.valueOf(this.pp.doubleValue());
        }
        if (fp == Character.class || fp == Character.TYPE) {
            return Character.valueOf((char) this.pp.intValue());
        }
        if (fp == Boolean.class || fp == Boolean.TYPE) {
            return Boolean.valueOf(this.pp.byteValue() == 0);
        } else if (fp == String.class) {
            return String.valueOf(this.pp);
        } else {
            if (fp == char[].class) {
                return String.valueOf(this.pp).toCharArray();
            }
            if (fp == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.pp), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
