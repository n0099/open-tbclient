package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float zU;

    public g(float f) {
        this.zU = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hZ = cVar.hZ();
        if (hZ == Byte.class || hZ == Byte.TYPE) {
            return Byte.valueOf(this.zU.byteValue());
        }
        if (hZ == Short.class || hZ == Short.TYPE) {
            return Short.valueOf(this.zU.shortValue());
        }
        if (hZ == Integer.class || hZ == Integer.TYPE) {
            return Integer.valueOf(this.zU.intValue());
        }
        if (hZ == Long.class || hZ == Long.TYPE) {
            return Long.valueOf(this.zU.longValue());
        }
        if (hZ == Float.class || hZ == Float.TYPE) {
            return Float.valueOf(this.zU.floatValue());
        }
        if (hZ == Double.class || hZ == Double.TYPE) {
            return Double.valueOf(this.zU.doubleValue());
        }
        if (hZ == Character.class || hZ == Character.TYPE) {
            return Character.valueOf((char) this.zU.intValue());
        }
        if (hZ == Boolean.class || hZ == Boolean.TYPE) {
            return Boolean.valueOf(this.zU.byteValue() == 0);
        } else if (hZ == String.class) {
            return String.valueOf(this.zU);
        } else {
            if (hZ == char[].class) {
                return String.valueOf(this.zU).toCharArray();
            }
            if (hZ == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zU), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
