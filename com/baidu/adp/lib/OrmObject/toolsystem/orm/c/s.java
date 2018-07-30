package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short wT;

    public s(short s) {
        this.wT = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gF = cVar.gF();
        if (gF == Byte.class || gF == Byte.TYPE) {
            return Byte.valueOf(this.wT.byteValue());
        }
        if (gF == Short.class || gF == Short.TYPE) {
            return Short.valueOf(this.wT.shortValue());
        }
        if (gF == Integer.class || gF == Integer.TYPE) {
            return Integer.valueOf(this.wT.intValue());
        }
        if (gF == Long.class || gF == Long.TYPE) {
            return Long.valueOf(this.wT.longValue());
        }
        if (gF == Float.class || gF == Float.TYPE) {
            return Float.valueOf(this.wT.floatValue());
        }
        if (gF == Double.class || gF == Double.TYPE) {
            return Double.valueOf(this.wT.doubleValue());
        }
        if (gF == Character.class || gF == Character.TYPE) {
            return Character.valueOf((char) this.wT.intValue());
        }
        if (gF == Boolean.class || gF == Boolean.TYPE) {
            return Boolean.valueOf(this.wT.byteValue() == 0);
        } else if (gF == String.class) {
            return String.valueOf(this.wT);
        } else {
            if (gF == char[].class) {
                return String.valueOf(this.wT).toCharArray();
            }
            if (gF == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.wT), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
