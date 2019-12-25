package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char value;

    public e(char c) {
        this.value = c;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fp = cVar.fp();
        if (fp == Byte.class || fp == Byte.TYPE) {
            return Byte.valueOf((byte) this.value);
        }
        if (fp == Short.class || fp == Short.TYPE) {
            return Short.valueOf((short) this.value);
        }
        if (fp == Integer.class || fp == Integer.TYPE) {
            return Integer.valueOf(this.value);
        }
        if (fp == Long.class || fp == Long.TYPE) {
            return Long.valueOf(this.value);
        }
        if (fp == Float.class || fp == Float.TYPE) {
            return Float.valueOf(this.value);
        }
        if (fp == Double.class || fp == Double.TYPE) {
            return Double.valueOf(this.value);
        }
        if (fp == Character.class || fp == Character.TYPE) {
            return Character.valueOf(this.value);
        }
        if (fp == Boolean.class || fp == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.value) == 0);
        } else if (fp == String.class) {
            return String.valueOf(this.value);
        } else {
            if (fp == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (fp == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.value), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
