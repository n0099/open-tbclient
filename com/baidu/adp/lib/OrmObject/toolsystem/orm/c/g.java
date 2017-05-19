package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float sE;

    public g(float f) {
        this.sE = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ek = cVar.ek();
        if (ek == Byte.class || ek == Byte.TYPE) {
            return Byte.valueOf(this.sE.byteValue());
        }
        if (ek == Short.class || ek == Short.TYPE) {
            return Short.valueOf(this.sE.shortValue());
        }
        if (ek == Integer.class || ek == Integer.TYPE) {
            return Integer.valueOf(this.sE.intValue());
        }
        if (ek == Long.class || ek == Long.TYPE) {
            return Long.valueOf(this.sE.longValue());
        }
        if (ek == Float.class || ek == Float.TYPE) {
            return Float.valueOf(this.sE.floatValue());
        }
        if (ek == Double.class || ek == Double.TYPE) {
            return Double.valueOf(this.sE.doubleValue());
        }
        if (ek == Character.class || ek == Character.TYPE) {
            return Character.valueOf((char) this.sE.intValue());
        }
        if (ek == Boolean.class || ek == Boolean.TYPE) {
            return Boolean.valueOf(this.sE.byteValue() == 0);
        } else if (ek == String.class) {
            return String.valueOf(this.sE);
        } else {
            if (ek == char[].class) {
                return String.valueOf(this.sE).toCharArray();
            }
            if (ek == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sE), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
