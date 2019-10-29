package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte nv;

    public d(byte b) {
        this.nv = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eV = cVar.eV();
        if (eV == Byte.class || eV == Byte.TYPE) {
            return Byte.valueOf(this.nv.byteValue());
        }
        if (eV == Short.class || eV == Short.TYPE) {
            return Short.valueOf(this.nv.shortValue());
        }
        if (eV == Integer.class || eV == Integer.TYPE) {
            return Integer.valueOf(this.nv.intValue());
        }
        if (eV == Long.class || eV == Long.TYPE) {
            return Long.valueOf(this.nv.longValue());
        }
        if (eV == Float.class || eV == Float.TYPE) {
            return Float.valueOf(this.nv.floatValue());
        }
        if (eV == Double.class || eV == Double.TYPE) {
            return Double.valueOf(this.nv.doubleValue());
        }
        if (eV == Character.class || eV == Character.TYPE) {
            return Character.valueOf((char) this.nv.intValue());
        }
        if (eV == Boolean.class || eV == Boolean.TYPE) {
            return Boolean.valueOf(this.nv.byteValue() == 0);
        } else if (eV == String.class) {
            return String.valueOf(this.nv);
        } else {
            if (eV == char[].class) {
                return String.valueOf(this.nv).toCharArray();
            }
            if (eV == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.nv), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
