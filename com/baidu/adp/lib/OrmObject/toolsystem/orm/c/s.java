package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short up;

    public s(short s) {
        this.up = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> es = cVar.es();
        if (es == Byte.class || es == Byte.TYPE) {
            return Byte.valueOf(this.up.byteValue());
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf(this.up.shortValue());
        }
        if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.up.intValue());
        }
        if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.up.longValue());
        }
        if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.up.floatValue());
        }
        if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.up.doubleValue());
        }
        if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf((char) this.up.intValue());
        }
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(this.up.byteValue() == 0);
        } else if (es == String.class) {
            return String.valueOf(this.up);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.up).toCharArray();
            }
            if (es == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.up), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
