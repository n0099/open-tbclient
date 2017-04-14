package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class e implements h {
    private char sd;

    public e(char c) {
        this.sd = c;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> ej = cVar.ej();
        if (ej == Byte.class || ej == Byte.TYPE) {
            return Byte.valueOf((byte) this.sd);
        }
        if (ej == Short.class || ej == Short.TYPE) {
            return Short.valueOf((short) this.sd);
        }
        if (ej == Integer.class || ej == Integer.TYPE) {
            return Integer.valueOf(this.sd);
        }
        if (ej == Long.class || ej == Long.TYPE) {
            return Long.valueOf(this.sd);
        }
        if (ej == Float.class || ej == Float.TYPE) {
            return Float.valueOf(this.sd);
        }
        if (ej == Double.class || ej == Double.TYPE) {
            return Double.valueOf(this.sd);
        }
        if (ej == Character.class || ej == Character.TYPE) {
            return Character.valueOf(this.sd);
        }
        if (ej == Boolean.class || ej == Boolean.TYPE) {
            return Boolean.valueOf(((byte) this.sd) == 0);
        } else if (ej == String.class) {
            return String.valueOf(this.sd);
        } else {
            if (ej == char[].class) {
                return String.valueOf(this.sd).toCharArray();
            }
            if (ej == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.sd), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
