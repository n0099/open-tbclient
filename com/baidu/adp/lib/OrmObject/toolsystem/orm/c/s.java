package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short wU;

    public s(short s) {
        this.wU = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gF = cVar.gF();
        if (gF == Byte.class || gF == Byte.TYPE) {
            return Byte.valueOf(this.wU.byteValue());
        }
        if (gF == Short.class || gF == Short.TYPE) {
            return Short.valueOf(this.wU.shortValue());
        }
        if (gF == Integer.class || gF == Integer.TYPE) {
            return Integer.valueOf(this.wU.intValue());
        }
        if (gF == Long.class || gF == Long.TYPE) {
            return Long.valueOf(this.wU.longValue());
        }
        if (gF == Float.class || gF == Float.TYPE) {
            return Float.valueOf(this.wU.floatValue());
        }
        if (gF == Double.class || gF == Double.TYPE) {
            return Double.valueOf(this.wU.doubleValue());
        }
        if (gF == Character.class || gF == Character.TYPE) {
            return Character.valueOf((char) this.wU.intValue());
        }
        if (gF == Boolean.class || gF == Boolean.TYPE) {
            return Boolean.valueOf(this.wU.byteValue() == 0);
        } else if (gF == String.class) {
            return String.valueOf(this.wU);
        } else {
            if (gF == char[].class) {
                return String.valueOf(this.wU).toCharArray();
            }
            if (gF == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.wU), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
