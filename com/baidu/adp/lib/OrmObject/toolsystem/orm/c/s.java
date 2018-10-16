package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short zV;

    public s(short s) {
        this.zV = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ia = cVar.ia();
        if (ia == Byte.class || ia == Byte.TYPE) {
            return Byte.valueOf(this.zV.byteValue());
        }
        if (ia == Short.class || ia == Short.TYPE) {
            return Short.valueOf(this.zV.shortValue());
        }
        if (ia == Integer.class || ia == Integer.TYPE) {
            return Integer.valueOf(this.zV.intValue());
        }
        if (ia == Long.class || ia == Long.TYPE) {
            return Long.valueOf(this.zV.longValue());
        }
        if (ia == Float.class || ia == Float.TYPE) {
            return Float.valueOf(this.zV.floatValue());
        }
        if (ia == Double.class || ia == Double.TYPE) {
            return Double.valueOf(this.zV.doubleValue());
        }
        if (ia == Character.class || ia == Character.TYPE) {
            return Character.valueOf((char) this.zV.intValue());
        }
        if (ia == Boolean.class || ia == Boolean.TYPE) {
            return Boolean.valueOf(this.zV.byteValue() == 0);
        } else if (ia == String.class) {
            return String.valueOf(this.zV);
        } else {
            if (ia == char[].class) {
                return String.valueOf(this.zV).toCharArray();
            }
            if (ia == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zV), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
