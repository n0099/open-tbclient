package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short sI;

    public s(short s) {
        this.sI = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ej = cVar.ej();
        if (ej == Byte.class || ej == Byte.TYPE) {
            return Byte.valueOf(this.sI.byteValue());
        }
        if (ej == Short.class || ej == Short.TYPE) {
            return Short.valueOf(this.sI.shortValue());
        }
        if (ej == Integer.class || ej == Integer.TYPE) {
            return Integer.valueOf(this.sI.intValue());
        }
        if (ej == Long.class || ej == Long.TYPE) {
            return Long.valueOf(this.sI.longValue());
        }
        if (ej == Float.class || ej == Float.TYPE) {
            return Float.valueOf(this.sI.floatValue());
        }
        if (ej == Double.class || ej == Double.TYPE) {
            return Double.valueOf(this.sI.doubleValue());
        }
        if (ej == Character.class || ej == Character.TYPE) {
            return Character.valueOf((char) this.sI.intValue());
        }
        if (ej == Boolean.class || ej == Boolean.TYPE) {
            return Boolean.valueOf(this.sI.byteValue() == 0);
        } else if (ej == String.class) {
            return String.valueOf(this.sI);
        } else {
            if (ej == char[].class) {
                return String.valueOf(this.sI).toCharArray();
            }
            if (ej == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sI), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
