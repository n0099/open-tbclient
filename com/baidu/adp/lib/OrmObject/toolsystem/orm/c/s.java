package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short agx;

    public s(short s) {
        this.agx = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lL = cVar.lL();
        if (lL == Byte.class || lL == Byte.TYPE) {
            return Byte.valueOf(this.agx.byteValue());
        }
        if (lL == Short.class || lL == Short.TYPE) {
            return Short.valueOf(this.agx.shortValue());
        }
        if (lL == Integer.class || lL == Integer.TYPE) {
            return Integer.valueOf(this.agx.intValue());
        }
        if (lL == Long.class || lL == Long.TYPE) {
            return Long.valueOf(this.agx.longValue());
        }
        if (lL == Float.class || lL == Float.TYPE) {
            return Float.valueOf(this.agx.floatValue());
        }
        if (lL == Double.class || lL == Double.TYPE) {
            return Double.valueOf(this.agx.doubleValue());
        }
        if (lL == Character.class || lL == Character.TYPE) {
            return Character.valueOf((char) this.agx.intValue());
        }
        if (lL == Boolean.class || lL == Boolean.TYPE) {
            return Boolean.valueOf(this.agx.byteValue() == 0);
        } else if (lL == String.class) {
            return String.valueOf(this.agx);
        } else {
            if (lL == char[].class) {
                return String.valueOf(this.agx).toCharArray();
            }
            if (lL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.agx), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
