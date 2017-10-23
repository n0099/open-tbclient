package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte rV;

    public d(byte b) {
        this.rV = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eg = cVar.eg();
        if (eg == Byte.class || eg == Byte.TYPE) {
            return Byte.valueOf(this.rV.byteValue());
        }
        if (eg == Short.class || eg == Short.TYPE) {
            return Short.valueOf(this.rV.shortValue());
        }
        if (eg == Integer.class || eg == Integer.TYPE) {
            return Integer.valueOf(this.rV.intValue());
        }
        if (eg == Long.class || eg == Long.TYPE) {
            return Long.valueOf(this.rV.longValue());
        }
        if (eg == Float.class || eg == Float.TYPE) {
            return Float.valueOf(this.rV.floatValue());
        }
        if (eg == Double.class || eg == Double.TYPE) {
            return Double.valueOf(this.rV.doubleValue());
        }
        if (eg == Character.class || eg == Character.TYPE) {
            return Character.valueOf((char) this.rV.intValue());
        }
        if (eg == Boolean.class || eg == Boolean.TYPE) {
            return Boolean.valueOf(this.rV.byteValue() == 0);
        } else if (eg == String.class) {
            return String.valueOf(this.rV);
        } else {
            if (eg == char[].class) {
                return String.valueOf(this.rV).toCharArray();
            }
            if (eg == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.rV), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
