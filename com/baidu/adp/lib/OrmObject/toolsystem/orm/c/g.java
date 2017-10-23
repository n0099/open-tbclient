package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float rX;

    public g(float f) {
        this.rX = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eg = cVar.eg();
        if (eg == Byte.class || eg == Byte.TYPE) {
            return Byte.valueOf(this.rX.byteValue());
        }
        if (eg == Short.class || eg == Short.TYPE) {
            return Short.valueOf(this.rX.shortValue());
        }
        if (eg == Integer.class || eg == Integer.TYPE) {
            return Integer.valueOf(this.rX.intValue());
        }
        if (eg == Long.class || eg == Long.TYPE) {
            return Long.valueOf(this.rX.longValue());
        }
        if (eg == Float.class || eg == Float.TYPE) {
            return Float.valueOf(this.rX.floatValue());
        }
        if (eg == Double.class || eg == Double.TYPE) {
            return Double.valueOf(this.rX.doubleValue());
        }
        if (eg == Character.class || eg == Character.TYPE) {
            return Character.valueOf((char) this.rX.intValue());
        }
        if (eg == Boolean.class || eg == Boolean.TYPE) {
            return Boolean.valueOf(this.rX.byteValue() == 0);
        } else if (eg == String.class) {
            return String.valueOf(this.rX);
        } else {
            if (eg == char[].class) {
                return String.valueOf(this.rX).toCharArray();
            }
            if (eg == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rX), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
