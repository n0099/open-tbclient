package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class i implements h {
    private Integer value;

    public i(int i) {
        this.value = Integer.valueOf(i);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> eV = cVar.eV();
        if (eV == Byte.class || eV == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (eV == Short.class || eV == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (eV == Integer.class || eV == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (eV == Long.class || eV == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (eV == Float.class || eV == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (eV == Double.class || eV == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (eV == Character.class || eV == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (eV == Boolean.class || eV == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (eV == String.class) {
            return String.valueOf(this.value);
        } else {
            if (eV == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (eV == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.value), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
