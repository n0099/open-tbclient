package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte uh;

    public d(byte b) {
        this.uh = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> es = cVar.es();
        if (es == Byte.class || es == Byte.TYPE) {
            return Byte.valueOf(this.uh.byteValue());
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf(this.uh.shortValue());
        }
        if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.uh.intValue());
        }
        if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.uh.longValue());
        }
        if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.uh.floatValue());
        }
        if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.uh.doubleValue());
        }
        if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf((char) this.uh.intValue());
        }
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(this.uh.byteValue() == 0);
        } else if (es == String.class) {
            return String.valueOf(this.uh);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.uh).toCharArray();
            }
            if (es == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.uh), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
