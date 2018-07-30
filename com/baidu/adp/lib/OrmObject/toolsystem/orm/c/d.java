package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte wN;

    public d(byte b) {
        this.wN = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gF = cVar.gF();
        if (gF == Byte.class || gF == Byte.TYPE) {
            return Byte.valueOf(this.wN.byteValue());
        }
        if (gF == Short.class || gF == Short.TYPE) {
            return Short.valueOf(this.wN.shortValue());
        }
        if (gF == Integer.class || gF == Integer.TYPE) {
            return Integer.valueOf(this.wN.intValue());
        }
        if (gF == Long.class || gF == Long.TYPE) {
            return Long.valueOf(this.wN.longValue());
        }
        if (gF == Float.class || gF == Float.TYPE) {
            return Float.valueOf(this.wN.floatValue());
        }
        if (gF == Double.class || gF == Double.TYPE) {
            return Double.valueOf(this.wN.doubleValue());
        }
        if (gF == Character.class || gF == Character.TYPE) {
            return Character.valueOf((char) this.wN.intValue());
        }
        if (gF == Boolean.class || gF == Boolean.TYPE) {
            return Boolean.valueOf(this.wN.byteValue() == 0);
        } else if (gF == String.class) {
            return String.valueOf(this.wN);
        } else {
            if (gF == char[].class) {
                return String.valueOf(this.wN).toCharArray();
            }
            if (gF == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.wN), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
