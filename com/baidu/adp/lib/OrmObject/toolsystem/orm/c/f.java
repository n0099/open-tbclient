package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double zT;

    public f(double d) {
        this.zT = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hZ = cVar.hZ();
        if (hZ == Byte.class || hZ == Byte.TYPE) {
            return Byte.valueOf(this.zT.byteValue());
        }
        if (hZ == Short.class || hZ == Short.TYPE) {
            return Short.valueOf(this.zT.shortValue());
        }
        if (hZ == Integer.class || hZ == Integer.TYPE) {
            return Integer.valueOf(this.zT.intValue());
        }
        if (hZ == Long.class || hZ == Long.TYPE) {
            return Long.valueOf(this.zT.longValue());
        }
        if (hZ == Float.class || hZ == Float.TYPE) {
            return Float.valueOf(this.zT.floatValue());
        }
        if (hZ == Double.class || hZ == Double.TYPE) {
            return Double.valueOf(this.zT.doubleValue());
        }
        if (hZ == Character.class || hZ == Character.TYPE) {
            return Character.valueOf((char) this.zT.intValue());
        }
        if (hZ == Boolean.class || hZ == Boolean.TYPE) {
            return Boolean.valueOf(this.zT.byteValue() == 0);
        } else if (hZ == String.class) {
            return String.valueOf(this.zT);
        } else {
            if (hZ == char[].class) {
                return String.valueOf(this.zT).toCharArray();
            }
            if (hZ == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zT), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
