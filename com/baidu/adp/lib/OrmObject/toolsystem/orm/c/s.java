package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short py;

    public s(short s) {
        this.py = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fp = cVar.fp();
        if (fp == Byte.class || fp == Byte.TYPE) {
            return Byte.valueOf(this.py.byteValue());
        }
        if (fp == Short.class || fp == Short.TYPE) {
            return Short.valueOf(this.py.shortValue());
        }
        if (fp == Integer.class || fp == Integer.TYPE) {
            return Integer.valueOf(this.py.intValue());
        }
        if (fp == Long.class || fp == Long.TYPE) {
            return Long.valueOf(this.py.longValue());
        }
        if (fp == Float.class || fp == Float.TYPE) {
            return Float.valueOf(this.py.floatValue());
        }
        if (fp == Double.class || fp == Double.TYPE) {
            return Double.valueOf(this.py.doubleValue());
        }
        if (fp == Character.class || fp == Character.TYPE) {
            return Character.valueOf((char) this.py.intValue());
        }
        if (fp == Boolean.class || fp == Boolean.TYPE) {
            return Boolean.valueOf(this.py.byteValue() == 0);
        } else if (fp == String.class) {
            return String.valueOf(this.py);
        } else {
            if (fp == char[].class) {
                return String.valueOf(this.py).toCharArray();
            }
            if (fp == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.py), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
