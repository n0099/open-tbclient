package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class s implements h {
    private Short xI;

    public s(short s) {
        this.xI = Short.valueOf(s);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gS = cVar.gS();
        if (gS == Byte.class || gS == Byte.TYPE) {
            return Byte.valueOf(this.xI.byteValue());
        }
        if (gS == Short.class || gS == Short.TYPE) {
            return Short.valueOf(this.xI.shortValue());
        }
        if (gS == Integer.class || gS == Integer.TYPE) {
            return Integer.valueOf(this.xI.intValue());
        }
        if (gS == Long.class || gS == Long.TYPE) {
            return Long.valueOf(this.xI.longValue());
        }
        if (gS == Float.class || gS == Float.TYPE) {
            return Float.valueOf(this.xI.floatValue());
        }
        if (gS == Double.class || gS == Double.TYPE) {
            return Double.valueOf(this.xI.doubleValue());
        }
        if (gS == Character.class || gS == Character.TYPE) {
            return Character.valueOf((char) this.xI.intValue());
        }
        if (gS == Boolean.class || gS == Boolean.TYPE) {
            return Boolean.valueOf(this.xI.byteValue() == 0);
        } else if (gS == String.class) {
            return String.valueOf(this.xI);
        } else {
            if (gS == char[].class) {
                return String.valueOf(this.xI).toCharArray();
            }
            if (gS == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.xI), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
