package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double ags;

    public f(double d) {
        this.ags = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lL = cVar.lL();
        if (lL == Byte.class || lL == Byte.TYPE) {
            return Byte.valueOf(this.ags.byteValue());
        }
        if (lL == Short.class || lL == Short.TYPE) {
            return Short.valueOf(this.ags.shortValue());
        }
        if (lL == Integer.class || lL == Integer.TYPE) {
            return Integer.valueOf(this.ags.intValue());
        }
        if (lL == Long.class || lL == Long.TYPE) {
            return Long.valueOf(this.ags.longValue());
        }
        if (lL == Float.class || lL == Float.TYPE) {
            return Float.valueOf(this.ags.floatValue());
        }
        if (lL == Double.class || lL == Double.TYPE) {
            return Double.valueOf(this.ags.doubleValue());
        }
        if (lL == Character.class || lL == Character.TYPE) {
            return Character.valueOf((char) this.ags.intValue());
        }
        if (lL == Boolean.class || lL == Boolean.TYPE) {
            return Boolean.valueOf(this.ags.byteValue() == 0);
        } else if (lL == String.class) {
            return String.valueOf(this.ags);
        } else {
            if (lL == char[].class) {
                return String.valueOf(this.ags).toCharArray();
            }
            if (lL == byte[].class) {
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
