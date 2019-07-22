package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte xH;

    public d(byte b) {
        this.xH = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> hb = cVar.hb();
        if (hb == Byte.class || hb == Byte.TYPE) {
            return Byte.valueOf(this.xH.byteValue());
        }
        if (hb == Short.class || hb == Short.TYPE) {
            return Short.valueOf(this.xH.shortValue());
        }
        if (hb == Integer.class || hb == Integer.TYPE) {
            return Integer.valueOf(this.xH.intValue());
        }
        if (hb == Long.class || hb == Long.TYPE) {
            return Long.valueOf(this.xH.longValue());
        }
        if (hb == Float.class || hb == Float.TYPE) {
            return Float.valueOf(this.xH.floatValue());
        }
        if (hb == Double.class || hb == Double.TYPE) {
            return Double.valueOf(this.xH.doubleValue());
        }
        if (hb == Character.class || hb == Character.TYPE) {
            return Character.valueOf((char) this.xH.intValue());
        }
        if (hb == Boolean.class || hb == Boolean.TYPE) {
            return Boolean.valueOf(this.xH.byteValue() == 0);
        } else if (hb == String.class) {
            return String.valueOf(this.xH);
        } else {
            if (hb == char[].class) {
                return String.valueOf(this.xH).toCharArray();
            }
            if (hb == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.xH), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
