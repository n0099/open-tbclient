package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short agw;

    public s(short s) {
        this.agw = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lK = cVar.lK();
        if (lK == Byte.class || lK == Byte.TYPE) {
            return Byte.valueOf(this.agw.byteValue());
        }
        if (lK == Short.class || lK == Short.TYPE) {
            return Short.valueOf(this.agw.shortValue());
        }
        if (lK == Integer.class || lK == Integer.TYPE) {
            return Integer.valueOf(this.agw.intValue());
        }
        if (lK == Long.class || lK == Long.TYPE) {
            return Long.valueOf(this.agw.longValue());
        }
        if (lK == Float.class || lK == Float.TYPE) {
            return Float.valueOf(this.agw.floatValue());
        }
        if (lK == Double.class || lK == Double.TYPE) {
            return Double.valueOf(this.agw.doubleValue());
        }
        if (lK == Character.class || lK == Character.TYPE) {
            return Character.valueOf((char) this.agw.intValue());
        }
        if (lK == Boolean.class || lK == Boolean.TYPE) {
            return Boolean.valueOf(this.agw.byteValue() == 0);
        } else if (lK == String.class) {
            return String.valueOf(this.agw);
        } else {
            if (lK == char[].class) {
                return String.valueOf(this.agw).toCharArray();
            }
            if (lK == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.agw), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
