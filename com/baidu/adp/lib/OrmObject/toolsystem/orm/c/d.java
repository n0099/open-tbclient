package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte wV;

    public d(byte b) {
        this.wV = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gG = cVar.gG();
        if (gG == Byte.class || gG == Byte.TYPE) {
            return Byte.valueOf(this.wV.byteValue());
        }
        if (gG == Short.class || gG == Short.TYPE) {
            return Short.valueOf(this.wV.shortValue());
        }
        if (gG == Integer.class || gG == Integer.TYPE) {
            return Integer.valueOf(this.wV.intValue());
        }
        if (gG == Long.class || gG == Long.TYPE) {
            return Long.valueOf(this.wV.longValue());
        }
        if (gG == Float.class || gG == Float.TYPE) {
            return Float.valueOf(this.wV.floatValue());
        }
        if (gG == Double.class || gG == Double.TYPE) {
            return Double.valueOf(this.wV.doubleValue());
        }
        if (gG == Character.class || gG == Character.TYPE) {
            return Character.valueOf((char) this.wV.intValue());
        }
        if (gG == Boolean.class || gG == Boolean.TYPE) {
            return Boolean.valueOf(this.wV.byteValue() == 0);
        } else if (gG == String.class) {
            return String.valueOf(this.wV);
        } else {
            if (gG == char[].class) {
                return String.valueOf(this.wV).toCharArray();
            }
            if (gG == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.wV), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
