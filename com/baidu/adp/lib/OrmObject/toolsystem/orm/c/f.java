package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double sZ;

    public f(double d) {
        this.sZ = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ek = cVar.ek();
        if (ek == Byte.class || ek == Byte.TYPE) {
            return Byte.valueOf(this.sZ.byteValue());
        }
        if (ek == Short.class || ek == Short.TYPE) {
            return Short.valueOf(this.sZ.shortValue());
        }
        if (ek == Integer.class || ek == Integer.TYPE) {
            return Integer.valueOf(this.sZ.intValue());
        }
        if (ek == Long.class || ek == Long.TYPE) {
            return Long.valueOf(this.sZ.longValue());
        }
        if (ek == Float.class || ek == Float.TYPE) {
            return Float.valueOf(this.sZ.floatValue());
        }
        if (ek == Double.class || ek == Double.TYPE) {
            return Double.valueOf(this.sZ.doubleValue());
        }
        if (ek == Character.class || ek == Character.TYPE) {
            return Character.valueOf((char) this.sZ.intValue());
        }
        if (ek == Boolean.class || ek == Boolean.TYPE) {
            return Boolean.valueOf(this.sZ.byteValue() == 0);
        } else if (ek == String.class) {
            return String.valueOf(this.sZ);
        } else {
            if (ek == char[].class) {
                return String.valueOf(this.sZ).toCharArray();
            }
            if (ek == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sZ), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
