package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short sa;

    public s(short s) {
        this.sa = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eh = cVar.eh();
        if (eh == Byte.class || eh == Byte.TYPE) {
            return Byte.valueOf(this.sa.byteValue());
        }
        if (eh == Short.class || eh == Short.TYPE) {
            return Short.valueOf(this.sa.shortValue());
        }
        if (eh == Integer.class || eh == Integer.TYPE) {
            return Integer.valueOf(this.sa.intValue());
        }
        if (eh == Long.class || eh == Long.TYPE) {
            return Long.valueOf(this.sa.longValue());
        }
        if (eh == Float.class || eh == Float.TYPE) {
            return Float.valueOf(this.sa.floatValue());
        }
        if (eh == Double.class || eh == Double.TYPE) {
            return Double.valueOf(this.sa.doubleValue());
        }
        if (eh == Character.class || eh == Character.TYPE) {
            return Character.valueOf((char) this.sa.intValue());
        }
        if (eh == Boolean.class || eh == Boolean.TYPE) {
            return Boolean.valueOf(this.sa.byteValue() == 0);
        } else if (eh == String.class) {
            return String.valueOf(this.sa);
        } else {
            if (eh == char[].class) {
                return String.valueOf(this.sa).toCharArray();
            }
            if (eh == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sa), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
