package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double rW;

    public f(double d) {
        this.rW = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eg = cVar.eg();
        if (eg == Byte.class || eg == Byte.TYPE) {
            return Byte.valueOf(this.rW.byteValue());
        }
        if (eg == Short.class || eg == Short.TYPE) {
            return Short.valueOf(this.rW.shortValue());
        }
        if (eg == Integer.class || eg == Integer.TYPE) {
            return Integer.valueOf(this.rW.intValue());
        }
        if (eg == Long.class || eg == Long.TYPE) {
            return Long.valueOf(this.rW.longValue());
        }
        if (eg == Float.class || eg == Float.TYPE) {
            return Float.valueOf(this.rW.floatValue());
        }
        if (eg == Double.class || eg == Double.TYPE) {
            return Double.valueOf(this.rW.doubleValue());
        }
        if (eg == Character.class || eg == Character.TYPE) {
            return Character.valueOf((char) this.rW.intValue());
        }
        if (eg == Boolean.class || eg == Boolean.TYPE) {
            return Boolean.valueOf(this.rW.byteValue() == 0);
        } else if (eg == String.class) {
            return String.valueOf(this.rW);
        } else {
            if (eg == char[].class) {
                return String.valueOf(this.rW).toCharArray();
            }
            if (eg == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rW), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
