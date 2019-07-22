package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short xN;

    public s(short s) {
        this.xN = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hb = cVar.hb();
        if (hb == Byte.class || hb == Byte.TYPE) {
            return Byte.valueOf(this.xN.byteValue());
        }
        if (hb == Short.class || hb == Short.TYPE) {
            return Short.valueOf(this.xN.shortValue());
        }
        if (hb == Integer.class || hb == Integer.TYPE) {
            return Integer.valueOf(this.xN.intValue());
        }
        if (hb == Long.class || hb == Long.TYPE) {
            return Long.valueOf(this.xN.longValue());
        }
        if (hb == Float.class || hb == Float.TYPE) {
            return Float.valueOf(this.xN.floatValue());
        }
        if (hb == Double.class || hb == Double.TYPE) {
            return Double.valueOf(this.xN.doubleValue());
        }
        if (hb == Character.class || hb == Character.TYPE) {
            return Character.valueOf((char) this.xN.intValue());
        }
        if (hb == Boolean.class || hb == Boolean.TYPE) {
            return Boolean.valueOf(this.xN.byteValue() == 0);
        } else if (hb == String.class) {
            return String.valueOf(this.xN);
        } else {
            if (hb == char[].class) {
                return String.valueOf(this.xN).toCharArray();
            }
            if (hb == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.xN), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
