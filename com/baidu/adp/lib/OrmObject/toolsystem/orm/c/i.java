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
        Class<?> db = cVar.db();
        if (db == Byte.class || db == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (db == Short.class || db == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (db == Integer.class || db == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (db == Long.class || db == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (db == Float.class || db == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (db == Double.class || db == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (db == Character.class || db == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (db == Boolean.class || db == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (db == String.class) {
            return String.valueOf(this.value);
        } else {
            if (db == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (db == byte[].class) {
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
