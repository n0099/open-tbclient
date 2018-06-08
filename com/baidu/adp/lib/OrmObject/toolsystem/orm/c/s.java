package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short xb;

    public s(short s) {
        this.xb = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gG = cVar.gG();
        if (gG == Byte.class || gG == Byte.TYPE) {
            return Byte.valueOf(this.xb.byteValue());
        }
        if (gG == Short.class || gG == Short.TYPE) {
            return Short.valueOf(this.xb.shortValue());
        }
        if (gG == Integer.class || gG == Integer.TYPE) {
            return Integer.valueOf(this.xb.intValue());
        }
        if (gG == Long.class || gG == Long.TYPE) {
            return Long.valueOf(this.xb.longValue());
        }
        if (gG == Float.class || gG == Float.TYPE) {
            return Float.valueOf(this.xb.floatValue());
        }
        if (gG == Double.class || gG == Double.TYPE) {
            return Double.valueOf(this.xb.doubleValue());
        }
        if (gG == Character.class || gG == Character.TYPE) {
            return Character.valueOf((char) this.xb.intValue());
        }
        if (gG == Boolean.class || gG == Boolean.TYPE) {
            return Boolean.valueOf(this.xb.byteValue() == 0);
        } else if (gG == String.class) {
            return String.valueOf(this.xb);
        } else {
            if (gG == char[].class) {
                return String.valueOf(this.xb).toCharArray();
            }
            if (gG == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.xb), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
