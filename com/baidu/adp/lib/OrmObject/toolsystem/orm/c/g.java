package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float zR;

    public g(float f) {
        this.zR = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ia = cVar.ia();
        if (ia == Byte.class || ia == Byte.TYPE) {
            return Byte.valueOf(this.zR.byteValue());
        }
        if (ia == Short.class || ia == Short.TYPE) {
            return Short.valueOf(this.zR.shortValue());
        }
        if (ia == Integer.class || ia == Integer.TYPE) {
            return Integer.valueOf(this.zR.intValue());
        }
        if (ia == Long.class || ia == Long.TYPE) {
            return Long.valueOf(this.zR.longValue());
        }
        if (ia == Float.class || ia == Float.TYPE) {
            return Float.valueOf(this.zR.floatValue());
        }
        if (ia == Double.class || ia == Double.TYPE) {
            return Double.valueOf(this.zR.doubleValue());
        }
        if (ia == Character.class || ia == Character.TYPE) {
            return Character.valueOf((char) this.zR.intValue());
        }
        if (ia == Boolean.class || ia == Boolean.TYPE) {
            return Boolean.valueOf(this.zR.byteValue() == 0);
        } else if (ia == String.class) {
            return String.valueOf(this.zR);
        } else {
            if (ia == char[].class) {
                return String.valueOf(this.zR).toCharArray();
            }
            if (ia == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zR), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
