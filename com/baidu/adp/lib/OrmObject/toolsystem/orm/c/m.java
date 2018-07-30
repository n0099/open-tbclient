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
        Class<?> gF = cVar.gF();
        if (gF == Byte.class || gF == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (gF == Short.class || gF == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (gF == Integer.class || gF == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (gF == Long.class || gF == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (gF == Float.class || gF == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (gF == Double.class || gF == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (gF == Character.class || gF == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (gF == Boolean.class || gF == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (gF == String.class) {
            return String.valueOf(this.value);
        } else {
            if (gF == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (gF == byte[].class) {
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
