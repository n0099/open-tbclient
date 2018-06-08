package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float wX;

    public g(float f) {
        this.wX = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gG = cVar.gG();
        if (gG == Byte.class || gG == Byte.TYPE) {
            return Byte.valueOf(this.wX.byteValue());
        }
        if (gG == Short.class || gG == Short.TYPE) {
            return Short.valueOf(this.wX.shortValue());
        }
        if (gG == Integer.class || gG == Integer.TYPE) {
            return Integer.valueOf(this.wX.intValue());
        }
        if (gG == Long.class || gG == Long.TYPE) {
            return Long.valueOf(this.wX.longValue());
        }
        if (gG == Float.class || gG == Float.TYPE) {
            return Float.valueOf(this.wX.floatValue());
        }
        if (gG == Double.class || gG == Double.TYPE) {
            return Double.valueOf(this.wX.doubleValue());
        }
        if (gG == Character.class || gG == Character.TYPE) {
            return Character.valueOf((char) this.wX.intValue());
        }
        if (gG == Boolean.class || gG == Boolean.TYPE) {
            return Boolean.valueOf(this.wX.byteValue() == 0);
        } else if (gG == String.class) {
            return String.valueOf(this.wX);
        } else {
            if (gG == char[].class) {
                return String.valueOf(this.wX).toCharArray();
            }
            if (gG == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.wX), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
