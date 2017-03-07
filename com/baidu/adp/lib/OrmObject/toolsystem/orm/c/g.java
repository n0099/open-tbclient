package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float tb;

    public g(float f) {
        this.tb = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ek = cVar.ek();
        if (ek == Byte.class || ek == Byte.TYPE) {
            return Byte.valueOf(this.tb.byteValue());
        }
        if (ek == Short.class || ek == Short.TYPE) {
            return Short.valueOf(this.tb.shortValue());
        }
        if (ek == Integer.class || ek == Integer.TYPE) {
            return Integer.valueOf(this.tb.intValue());
        }
        if (ek == Long.class || ek == Long.TYPE) {
            return Long.valueOf(this.tb.longValue());
        }
        if (ek == Float.class || ek == Float.TYPE) {
            return Float.valueOf(this.tb.floatValue());
        }
        if (ek == Double.class || ek == Double.TYPE) {
            return Double.valueOf(this.tb.doubleValue());
        }
        if (ek == Character.class || ek == Character.TYPE) {
            return Character.valueOf((char) this.tb.intValue());
        }
        if (ek == Boolean.class || ek == Boolean.TYPE) {
            return Boolean.valueOf(this.tb.byteValue() == 0);
        } else if (ek == String.class) {
            return String.valueOf(this.tb);
        } else {
            if (ek == char[].class) {
                return String.valueOf(this.tb).toCharArray();
            }
            if (ek == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.tb), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
