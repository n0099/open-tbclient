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
        Class<?> hZ = cVar.hZ();
        if (hZ == Byte.class || hZ == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (hZ == Short.class || hZ == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (hZ == Integer.class || hZ == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (hZ == Long.class || hZ == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (hZ == Float.class || hZ == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (hZ == Double.class || hZ == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (hZ == Character.class || hZ == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (hZ == Boolean.class || hZ == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (hZ == String.class) {
            return String.valueOf(this.value);
        } else {
            if (hZ == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (hZ == byte[].class) {
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
