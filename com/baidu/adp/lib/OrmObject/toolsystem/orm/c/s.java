package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short ur;

    public s(short s) {
        this.ur = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> es = cVar.es();
        if (es == Byte.class || es == Byte.TYPE) {
            return Byte.valueOf(this.ur.byteValue());
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf(this.ur.shortValue());
        }
        if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.ur.intValue());
        }
        if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.ur.longValue());
        }
        if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.ur.floatValue());
        }
        if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.ur.doubleValue());
        }
        if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf((char) this.ur.intValue());
        }
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(this.ur.byteValue() == 0);
        } else if (es == String.class) {
            return String.valueOf(this.ur);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.ur).toCharArray();
            }
            if (es == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.ur), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
