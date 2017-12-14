package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double rT;

    public f(double d) {
        this.rT = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eg = cVar.eg();
        if (eg == Byte.class || eg == Byte.TYPE) {
            return Byte.valueOf(this.rT.byteValue());
        }
        if (eg == Short.class || eg == Short.TYPE) {
            return Short.valueOf(this.rT.shortValue());
        }
        if (eg == Integer.class || eg == Integer.TYPE) {
            return Integer.valueOf(this.rT.intValue());
        }
        if (eg == Long.class || eg == Long.TYPE) {
            return Long.valueOf(this.rT.longValue());
        }
        if (eg == Float.class || eg == Float.TYPE) {
            return Float.valueOf(this.rT.floatValue());
        }
        if (eg == Double.class || eg == Double.TYPE) {
            return Double.valueOf(this.rT.doubleValue());
        }
        if (eg == Character.class || eg == Character.TYPE) {
            return Character.valueOf((char) this.rT.intValue());
        }
        if (eg == Boolean.class || eg == Boolean.TYPE) {
            return Boolean.valueOf(this.rT.byteValue() == 0);
        } else if (eg == String.class) {
            return String.valueOf(this.rT);
        } else {
            if (eg == char[].class) {
                return String.valueOf(this.rT).toCharArray();
            }
            if (eg == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rT), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
