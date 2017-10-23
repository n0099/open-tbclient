package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short sb;

    public s(short s) {
        this.sb = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eg = cVar.eg();
        if (eg == Byte.class || eg == Byte.TYPE) {
            return Byte.valueOf(this.sb.byteValue());
        }
        if (eg == Short.class || eg == Short.TYPE) {
            return Short.valueOf(this.sb.shortValue());
        }
        if (eg == Integer.class || eg == Integer.TYPE) {
            return Integer.valueOf(this.sb.intValue());
        }
        if (eg == Long.class || eg == Long.TYPE) {
            return Long.valueOf(this.sb.longValue());
        }
        if (eg == Float.class || eg == Float.TYPE) {
            return Float.valueOf(this.sb.floatValue());
        }
        if (eg == Double.class || eg == Double.TYPE) {
            return Double.valueOf(this.sb.doubleValue());
        }
        if (eg == Character.class || eg == Character.TYPE) {
            return Character.valueOf((char) this.sb.intValue());
        }
        if (eg == Boolean.class || eg == Boolean.TYPE) {
            return Boolean.valueOf(this.sb.byteValue() == 0);
        } else if (eg == String.class) {
            return String.valueOf(this.sb);
        } else {
            if (eg == char[].class) {
                return String.valueOf(this.sb).toCharArray();
            }
            if (eg == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sb), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
