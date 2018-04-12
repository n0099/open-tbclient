package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float qJ;

    public g(float f) {
        this.qJ = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> dP = cVar.dP();
        if (dP == Byte.class || dP == Byte.TYPE) {
            return Byte.valueOf(this.qJ.byteValue());
        }
        if (dP == Short.class || dP == Short.TYPE) {
            return Short.valueOf(this.qJ.shortValue());
        }
        if (dP == Integer.class || dP == Integer.TYPE) {
            return Integer.valueOf(this.qJ.intValue());
        }
        if (dP == Long.class || dP == Long.TYPE) {
            return Long.valueOf(this.qJ.longValue());
        }
        if (dP == Float.class || dP == Float.TYPE) {
            return Float.valueOf(this.qJ.floatValue());
        }
        if (dP == Double.class || dP == Double.TYPE) {
            return Double.valueOf(this.qJ.doubleValue());
        }
        if (dP == Character.class || dP == Character.TYPE) {
            return Character.valueOf((char) this.qJ.intValue());
        }
        if (dP == Boolean.class || dP == Boolean.TYPE) {
            return Boolean.valueOf(this.qJ.byteValue() == 0);
        } else if (dP == String.class) {
            return String.valueOf(this.qJ);
        } else {
            if (dP == char[].class) {
                return String.valueOf(this.qJ).toCharArray();
            }
            if (dP == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.qJ), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
