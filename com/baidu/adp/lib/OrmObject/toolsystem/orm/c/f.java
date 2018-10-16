package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double zQ;

    public f(double d) {
        this.zQ = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ia = cVar.ia();
        if (ia == Byte.class || ia == Byte.TYPE) {
            return Byte.valueOf(this.zQ.byteValue());
        }
        if (ia == Short.class || ia == Short.TYPE) {
            return Short.valueOf(this.zQ.shortValue());
        }
        if (ia == Integer.class || ia == Integer.TYPE) {
            return Integer.valueOf(this.zQ.intValue());
        }
        if (ia == Long.class || ia == Long.TYPE) {
            return Long.valueOf(this.zQ.longValue());
        }
        if (ia == Float.class || ia == Float.TYPE) {
            return Float.valueOf(this.zQ.floatValue());
        }
        if (ia == Double.class || ia == Double.TYPE) {
            return Double.valueOf(this.zQ.doubleValue());
        }
        if (ia == Character.class || ia == Character.TYPE) {
            return Character.valueOf((char) this.zQ.intValue());
        }
        if (ia == Boolean.class || ia == Boolean.TYPE) {
            return Boolean.valueOf(this.zQ.byteValue() == 0);
        } else if (ia == String.class) {
            return String.valueOf(this.zQ);
        } else {
            if (ia == char[].class) {
                return String.valueOf(this.zQ).toCharArray();
            }
            if (ia == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zQ), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
