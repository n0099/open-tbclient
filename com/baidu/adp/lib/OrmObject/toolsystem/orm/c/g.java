package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float ags;

    public g(float f) {
        this.ags = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lK = cVar.lK();
        if (lK == Byte.class || lK == Byte.TYPE) {
            return Byte.valueOf(this.ags.byteValue());
        }
        if (lK == Short.class || lK == Short.TYPE) {
            return Short.valueOf(this.ags.shortValue());
        }
        if (lK == Integer.class || lK == Integer.TYPE) {
            return Integer.valueOf(this.ags.intValue());
        }
        if (lK == Long.class || lK == Long.TYPE) {
            return Long.valueOf(this.ags.longValue());
        }
        if (lK == Float.class || lK == Float.TYPE) {
            return Float.valueOf(this.ags.floatValue());
        }
        if (lK == Double.class || lK == Double.TYPE) {
            return Double.valueOf(this.ags.doubleValue());
        }
        if (lK == Character.class || lK == Character.TYPE) {
            return Character.valueOf((char) this.ags.intValue());
        }
        if (lK == Boolean.class || lK == Boolean.TYPE) {
            return Boolean.valueOf(this.ags.byteValue() == 0);
        } else if (lK == String.class) {
            return String.valueOf(this.ags);
        } else {
            if (lK == char[].class) {
                return String.valueOf(this.ags).toCharArray();
            }
            if (lK == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.ags), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
