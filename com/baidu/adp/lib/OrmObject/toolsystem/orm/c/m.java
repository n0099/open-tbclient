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
        Class<?> hY = cVar.hY();
        if (hY == Byte.class || hY == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (hY == Short.class || hY == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (hY == Integer.class || hY == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (hY == Long.class || hY == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (hY == Float.class || hY == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (hY == Double.class || hY == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (hY == Character.class || hY == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (hY == Boolean.class || hY == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (hY == String.class) {
            return String.valueOf(this.value);
        } else {
            if (hY == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (hY == byte[].class) {
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
