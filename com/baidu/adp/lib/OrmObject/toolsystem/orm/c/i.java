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
        Class<?> es = cVar.es();
        if (es == Byte.class || es == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (es == String.class) {
            return String.valueOf(this.value);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (es == byte[].class) {
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
