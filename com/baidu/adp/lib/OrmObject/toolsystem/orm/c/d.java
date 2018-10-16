package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte zP;

    public d(byte b) {
        this.zP = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ia = cVar.ia();
        if (ia == Byte.class || ia == Byte.TYPE) {
            return Byte.valueOf(this.zP.byteValue());
        }
        if (ia == Short.class || ia == Short.TYPE) {
            return Short.valueOf(this.zP.shortValue());
        }
        if (ia == Integer.class || ia == Integer.TYPE) {
            return Integer.valueOf(this.zP.intValue());
        }
        if (ia == Long.class || ia == Long.TYPE) {
            return Long.valueOf(this.zP.longValue());
        }
        if (ia == Float.class || ia == Float.TYPE) {
            return Float.valueOf(this.zP.floatValue());
        }
        if (ia == Double.class || ia == Double.TYPE) {
            return Double.valueOf(this.zP.doubleValue());
        }
        if (ia == Character.class || ia == Character.TYPE) {
            return Character.valueOf((char) this.zP.intValue());
        }
        if (ia == Boolean.class || ia == Boolean.TYPE) {
            return Boolean.valueOf(this.zP.byteValue() == 0);
        } else if (ia == String.class) {
            return String.valueOf(this.zP);
        } else {
            if (ia == char[].class) {
                return String.valueOf(this.zP).toCharArray();
            }
            if (ia == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.zP), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
