package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short sD;

    public s(short s) {
        this.sD = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ej = cVar.ej();
        if (ej == Byte.class || ej == Byte.TYPE) {
            return Byte.valueOf(this.sD.byteValue());
        }
        if (ej == Short.class || ej == Short.TYPE) {
            return Short.valueOf(this.sD.shortValue());
        }
        if (ej == Integer.class || ej == Integer.TYPE) {
            return Integer.valueOf(this.sD.intValue());
        }
        if (ej == Long.class || ej == Long.TYPE) {
            return Long.valueOf(this.sD.longValue());
        }
        if (ej == Float.class || ej == Float.TYPE) {
            return Float.valueOf(this.sD.floatValue());
        }
        if (ej == Double.class || ej == Double.TYPE) {
            return Double.valueOf(this.sD.doubleValue());
        }
        if (ej == Character.class || ej == Character.TYPE) {
            return Character.valueOf((char) this.sD.intValue());
        }
        if (ej == Boolean.class || ej == Boolean.TYPE) {
            return Boolean.valueOf(this.sD.byteValue() == 0);
        } else if (ej == String.class) {
            return String.valueOf(this.sD);
        } else {
            if (ej == char[].class) {
                return String.valueOf(this.sD).toCharArray();
            }
            if (ej == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sD), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
