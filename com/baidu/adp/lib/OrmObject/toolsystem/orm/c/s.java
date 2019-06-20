package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short xH;

    public s(short s) {
        this.xH = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gS = cVar.gS();
        if (gS == Byte.class || gS == Byte.TYPE) {
            return Byte.valueOf(this.xH.byteValue());
        }
        if (gS == Short.class || gS == Short.TYPE) {
            return Short.valueOf(this.xH.shortValue());
        }
        if (gS == Integer.class || gS == Integer.TYPE) {
            return Integer.valueOf(this.xH.intValue());
        }
        if (gS == Long.class || gS == Long.TYPE) {
            return Long.valueOf(this.xH.longValue());
        }
        if (gS == Float.class || gS == Float.TYPE) {
            return Float.valueOf(this.xH.floatValue());
        }
        if (gS == Double.class || gS == Double.TYPE) {
            return Double.valueOf(this.xH.doubleValue());
        }
        if (gS == Character.class || gS == Character.TYPE) {
            return Character.valueOf((char) this.xH.intValue());
        }
        if (gS == Boolean.class || gS == Boolean.TYPE) {
            return Boolean.valueOf(this.xH.byteValue() == 0);
        } else if (gS == String.class) {
            return String.valueOf(this.xH);
        } else {
            if (gS == char[].class) {
                return String.valueOf(this.xH).toCharArray();
            }
            if (gS == byte[].class) {
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
