package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short zX;

    public s(short s) {
        this.zX = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hY = cVar.hY();
        if (hY == Byte.class || hY == Byte.TYPE) {
            return Byte.valueOf(this.zX.byteValue());
        }
        if (hY == Short.class || hY == Short.TYPE) {
            return Short.valueOf(this.zX.shortValue());
        }
        if (hY == Integer.class || hY == Integer.TYPE) {
            return Integer.valueOf(this.zX.intValue());
        }
        if (hY == Long.class || hY == Long.TYPE) {
            return Long.valueOf(this.zX.longValue());
        }
        if (hY == Float.class || hY == Float.TYPE) {
            return Float.valueOf(this.zX.floatValue());
        }
        if (hY == Double.class || hY == Double.TYPE) {
            return Double.valueOf(this.zX.doubleValue());
        }
        if (hY == Character.class || hY == Character.TYPE) {
            return Character.valueOf((char) this.zX.intValue());
        }
        if (hY == Boolean.class || hY == Boolean.TYPE) {
            return Boolean.valueOf(this.zX.byteValue() == 0);
        } else if (hY == String.class) {
            return String.valueOf(this.zX);
        } else {
            if (hY == char[].class) {
                return String.valueOf(this.zX).toCharArray();
            }
            if (hY == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zX), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
