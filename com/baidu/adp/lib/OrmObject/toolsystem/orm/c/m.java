package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class m implements h {
    private Long value;

    public m(long j) {
        this.value = Long.valueOf(j);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ej = cVar.ej();
        if (ej == Byte.class || ej == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (ej == Short.class || ej == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (ej == Integer.class || ej == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (ej == Long.class || ej == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (ej == Float.class || ej == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (ej == Double.class || ej == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (ej == Character.class || ej == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (ej == Boolean.class || ej == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (ej == String.class) {
            return String.valueOf(this.value);
        } else {
            if (ej == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (ej == byte[].class) {
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
