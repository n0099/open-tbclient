package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double mU;

    public f(double d) {
        this.mU = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eV = cVar.eV();
        if (eV == Byte.class || eV == Byte.TYPE) {
            return Byte.valueOf(this.mU.byteValue());
        }
        if (eV == Short.class || eV == Short.TYPE) {
            return Short.valueOf(this.mU.shortValue());
        }
        if (eV == Integer.class || eV == Integer.TYPE) {
            return Integer.valueOf(this.mU.intValue());
        }
        if (eV == Long.class || eV == Long.TYPE) {
            return Long.valueOf(this.mU.longValue());
        }
        if (eV == Float.class || eV == Float.TYPE) {
            return Float.valueOf(this.mU.floatValue());
        }
        if (eV == Double.class || eV == Double.TYPE) {
            return Double.valueOf(this.mU.doubleValue());
        }
        if (eV == Character.class || eV == Character.TYPE) {
            return Character.valueOf((char) this.mU.intValue());
        }
        if (eV == Boolean.class || eV == Boolean.TYPE) {
            return Boolean.valueOf(this.mU.byteValue() == 0);
        } else if (eV == String.class) {
            return String.valueOf(this.mU);
        } else {
            if (eV == char[].class) {
                return String.valueOf(this.mU).toCharArray();
            }
            if (eV == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.mU), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
