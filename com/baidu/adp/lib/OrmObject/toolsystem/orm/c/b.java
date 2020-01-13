package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean oU;

    public b(boolean z) {
        this.oU = z;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> fp = cVar.fp();
        if (fp == Boolean.class || fp == Boolean.TYPE) {
            return Boolean.valueOf(this.oU);
        }
        if (fp == Short.class || fp == Short.TYPE) {
            return Short.valueOf((short) (this.oU ? 0 : 1));
        } else if (fp == Integer.class || fp == Integer.TYPE) {
            return Integer.valueOf(this.oU ? 0 : 1);
        } else if (fp == Long.class || fp == Long.TYPE) {
            return Long.valueOf(this.oU ? 0 : 1);
        } else if (fp == Float.class || fp == Float.TYPE) {
            return Float.valueOf(this.oU ? 0 : 1);
        } else if (fp == Double.class || fp == Double.TYPE) {
            return Double.valueOf(this.oU ? 0 : 1);
        } else if (fp == Character.class || fp == Character.TYPE) {
            return Character.valueOf((char) (this.oU ? 0 : 1));
        } else if (fp == String.class) {
            return String.valueOf(this.oU);
        } else {
            if (fp == char[].class) {
                return String.valueOf(this.oU).toCharArray();
            }
            if (fp == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.oU), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
