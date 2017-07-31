package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float uj;

    public g(float f) {
        this.uj = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> es = cVar.es();
        if (es == Byte.class || es == Byte.TYPE) {
            return Byte.valueOf(this.uj.byteValue());
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf(this.uj.shortValue());
        }
        if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.uj.intValue());
        }
        if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.uj.longValue());
        }
        if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.uj.floatValue());
        }
        if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.uj.doubleValue());
        }
        if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf((char) this.uj.intValue());
        }
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(this.uj.byteValue() == 0);
        } else if (es == String.class) {
            return String.valueOf(this.uj);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.uj).toCharArray();
            }
            if (es == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.uj), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
