package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte sY;

    public d(byte b) {
        this.sY = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ek = cVar.ek();
        if (ek == Byte.class || ek == Byte.TYPE) {
            return Byte.valueOf(this.sY.byteValue());
        }
        if (ek == Short.class || ek == Short.TYPE) {
            return Short.valueOf(this.sY.shortValue());
        }
        if (ek == Integer.class || ek == Integer.TYPE) {
            return Integer.valueOf(this.sY.intValue());
        }
        if (ek == Long.class || ek == Long.TYPE) {
            return Long.valueOf(this.sY.longValue());
        }
        if (ek == Float.class || ek == Float.TYPE) {
            return Float.valueOf(this.sY.floatValue());
        }
        if (ek == Double.class || ek == Double.TYPE) {
            return Double.valueOf(this.sY.doubleValue());
        }
        if (ek == Character.class || ek == Character.TYPE) {
            return Character.valueOf((char) this.sY.intValue());
        }
        if (ek == Boolean.class || ek == Boolean.TYPE) {
            return Boolean.valueOf(this.sY.byteValue() == 0);
        } else if (ek == String.class) {
            return String.valueOf(this.sY);
        } else {
            if (ek == char[].class) {
                return String.valueOf(this.sY).toCharArray();
            }
            if (ek == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sY), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
