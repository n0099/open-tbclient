package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short sJ;

    public s(short s) {
        this.sJ = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ek = cVar.ek();
        if (ek == Byte.class || ek == Byte.TYPE) {
            return Byte.valueOf(this.sJ.byteValue());
        }
        if (ek == Short.class || ek == Short.TYPE) {
            return Short.valueOf(this.sJ.shortValue());
        }
        if (ek == Integer.class || ek == Integer.TYPE) {
            return Integer.valueOf(this.sJ.intValue());
        }
        if (ek == Long.class || ek == Long.TYPE) {
            return Long.valueOf(this.sJ.longValue());
        }
        if (ek == Float.class || ek == Float.TYPE) {
            return Float.valueOf(this.sJ.floatValue());
        }
        if (ek == Double.class || ek == Double.TYPE) {
            return Double.valueOf(this.sJ.doubleValue());
        }
        if (ek == Character.class || ek == Character.TYPE) {
            return Character.valueOf((char) this.sJ.intValue());
        }
        if (ek == Boolean.class || ek == Boolean.TYPE) {
            return Boolean.valueOf(this.sJ.byteValue() == 0);
        } else if (ek == String.class) {
            return String.valueOf(this.sJ);
        } else {
            if (ek == char[].class) {
                return String.valueOf(this.sJ).toCharArray();
            }
            if (ek == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sJ), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
