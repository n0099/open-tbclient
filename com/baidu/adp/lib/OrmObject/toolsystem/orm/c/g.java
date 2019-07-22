package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float xJ;

    public g(float f) {
        this.xJ = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hb = cVar.hb();
        if (hb == Byte.class || hb == Byte.TYPE) {
            return Byte.valueOf(this.xJ.byteValue());
        }
        if (hb == Short.class || hb == Short.TYPE) {
            return Short.valueOf(this.xJ.shortValue());
        }
        if (hb == Integer.class || hb == Integer.TYPE) {
            return Integer.valueOf(this.xJ.intValue());
        }
        if (hb == Long.class || hb == Long.TYPE) {
            return Long.valueOf(this.xJ.longValue());
        }
        if (hb == Float.class || hb == Float.TYPE) {
            return Float.valueOf(this.xJ.floatValue());
        }
        if (hb == Double.class || hb == Double.TYPE) {
            return Double.valueOf(this.xJ.doubleValue());
        }
        if (hb == Character.class || hb == Character.TYPE) {
            return Character.valueOf((char) this.xJ.intValue());
        }
        if (hb == Boolean.class || hb == Boolean.TYPE) {
            return Boolean.valueOf(this.xJ.byteValue() == 0);
        } else if (hb == String.class) {
            return String.valueOf(this.xJ);
        } else {
            if (hb == char[].class) {
                return String.valueOf(this.xJ).toCharArray();
            }
            if (hb == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.xJ), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
