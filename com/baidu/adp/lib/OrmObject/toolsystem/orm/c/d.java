package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class d implements h {
    private Byte xB;

    public d(byte b) {
        this.xB = Byte.valueOf(b);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gS = cVar.gS();
        if (gS == Byte.class || gS == Byte.TYPE) {
            return Byte.valueOf(this.xB.byteValue());
        }
        if (gS == Short.class || gS == Short.TYPE) {
            return Short.valueOf(this.xB.shortValue());
        }
        if (gS == Integer.class || gS == Integer.TYPE) {
            return Integer.valueOf(this.xB.intValue());
        }
        if (gS == Long.class || gS == Long.TYPE) {
            return Long.valueOf(this.xB.longValue());
        }
        if (gS == Float.class || gS == Float.TYPE) {
            return Float.valueOf(this.xB.floatValue());
        }
        if (gS == Double.class || gS == Double.TYPE) {
            return Double.valueOf(this.xB.doubleValue());
        }
        if (gS == Character.class || gS == Character.TYPE) {
            return Character.valueOf((char) this.xB.intValue());
        }
        if (gS == Boolean.class || gS == Boolean.TYPE) {
            return Boolean.valueOf(this.xB.byteValue() == 0);
        } else if (gS == String.class) {
            return String.valueOf(this.xB);
        } else {
            if (gS == char[].class) {
                return String.valueOf(this.xB).toCharArray();
            }
            if (gS == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.xB), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
