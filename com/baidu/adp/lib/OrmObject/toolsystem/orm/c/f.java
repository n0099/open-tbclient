package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double sC;

    public f(double d) {
        this.sC = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ej = cVar.ej();
        if (ej == Byte.class || ej == Byte.TYPE) {
            return Byte.valueOf(this.sC.byteValue());
        }
        if (ej == Short.class || ej == Short.TYPE) {
            return Short.valueOf(this.sC.shortValue());
        }
        if (ej == Integer.class || ej == Integer.TYPE) {
            return Integer.valueOf(this.sC.intValue());
        }
        if (ej == Long.class || ej == Long.TYPE) {
            return Long.valueOf(this.sC.longValue());
        }
        if (ej == Float.class || ej == Float.TYPE) {
            return Float.valueOf(this.sC.floatValue());
        }
        if (ej == Double.class || ej == Double.TYPE) {
            return Double.valueOf(this.sC.doubleValue());
        }
        if (ej == Character.class || ej == Character.TYPE) {
            return Character.valueOf((char) this.sC.intValue());
        }
        if (ej == Boolean.class || ej == Boolean.TYPE) {
            return Boolean.valueOf(this.sC.byteValue() == 0);
        } else if (ej == String.class) {
            return String.valueOf(this.sC);
        } else {
            if (ej == char[].class) {
                return String.valueOf(this.sC).toCharArray();
            }
            if (ej == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sC), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
