package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short zY;

    public s(short s) {
        this.zY = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hZ = cVar.hZ();
        if (hZ == Byte.class || hZ == Byte.TYPE) {
            return Byte.valueOf(this.zY.byteValue());
        }
        if (hZ == Short.class || hZ == Short.TYPE) {
            return Short.valueOf(this.zY.shortValue());
        }
        if (hZ == Integer.class || hZ == Integer.TYPE) {
            return Integer.valueOf(this.zY.intValue());
        }
        if (hZ == Long.class || hZ == Long.TYPE) {
            return Long.valueOf(this.zY.longValue());
        }
        if (hZ == Float.class || hZ == Float.TYPE) {
            return Float.valueOf(this.zY.floatValue());
        }
        if (hZ == Double.class || hZ == Double.TYPE) {
            return Double.valueOf(this.zY.doubleValue());
        }
        if (hZ == Character.class || hZ == Character.TYPE) {
            return Character.valueOf((char) this.zY.intValue());
        }
        if (hZ == Boolean.class || hZ == Boolean.TYPE) {
            return Boolean.valueOf(this.zY.byteValue() == 0);
        } else if (hZ == String.class) {
            return String.valueOf(this.zY);
        } else {
            if (hZ == char[].class) {
                return String.valueOf(this.zY).toCharArray();
            }
            if (hZ == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zY), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
