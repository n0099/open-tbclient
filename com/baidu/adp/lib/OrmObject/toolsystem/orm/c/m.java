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
        Class<?> lK = cVar.lK();
        if (lK == Byte.class || lK == Byte.TYPE) {
            return Byte.valueOf(this.value.byteValue());
        }
        if (lK == Short.class || lK == Short.TYPE) {
            return Short.valueOf(this.value.shortValue());
        }
        if (lK == Integer.class || lK == Integer.TYPE) {
            return Integer.valueOf(this.value.intValue());
        }
        if (lK == Long.class || lK == Long.TYPE) {
            return Long.valueOf(this.value.longValue());
        }
        if (lK == Float.class || lK == Float.TYPE) {
            return Float.valueOf(this.value.floatValue());
        }
        if (lK == Double.class || lK == Double.TYPE) {
            return Double.valueOf(this.value.doubleValue());
        }
        if (lK == Character.class || lK == Character.TYPE) {
            return Character.valueOf((char) this.value.intValue());
        }
        if (lK == Boolean.class || lK == Boolean.TYPE) {
            return Boolean.valueOf(this.value.byteValue() == 0);
        } else if (lK == String.class) {
            return String.valueOf(this.value);
        } else {
            if (lK == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (lK == byte[].class) {
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
