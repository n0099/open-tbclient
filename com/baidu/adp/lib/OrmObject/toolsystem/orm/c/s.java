package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short agz;

    public s(short s) {
        this.agz = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lL = cVar.lL();
        if (lL == Byte.class || lL == Byte.TYPE) {
            return Byte.valueOf(this.agz.byteValue());
        }
        if (lL == Short.class || lL == Short.TYPE) {
            return Short.valueOf(this.agz.shortValue());
        }
        if (lL == Integer.class || lL == Integer.TYPE) {
            return Integer.valueOf(this.agz.intValue());
        }
        if (lL == Long.class || lL == Long.TYPE) {
            return Long.valueOf(this.agz.longValue());
        }
        if (lL == Float.class || lL == Float.TYPE) {
            return Float.valueOf(this.agz.floatValue());
        }
        if (lL == Double.class || lL == Double.TYPE) {
            return Double.valueOf(this.agz.doubleValue());
        }
        if (lL == Character.class || lL == Character.TYPE) {
            return Character.valueOf((char) this.agz.intValue());
        }
        if (lL == Boolean.class || lL == Boolean.TYPE) {
            return Boolean.valueOf(this.agz.byteValue() == 0);
        } else if (lL == String.class) {
            return String.valueOf(this.agz);
        } else {
            if (lL == char[].class) {
                return String.valueOf(this.agz).toCharArray();
            }
            if (lL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.agz), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
