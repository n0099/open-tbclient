package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double xC;

    public f(double d) {
        this.xC = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gS = cVar.gS();
        if (gS == Byte.class || gS == Byte.TYPE) {
            return Byte.valueOf(this.xC.byteValue());
        }
        if (gS == Short.class || gS == Short.TYPE) {
            return Short.valueOf(this.xC.shortValue());
        }
        if (gS == Integer.class || gS == Integer.TYPE) {
            return Integer.valueOf(this.xC.intValue());
        }
        if (gS == Long.class || gS == Long.TYPE) {
            return Long.valueOf(this.xC.longValue());
        }
        if (gS == Float.class || gS == Float.TYPE) {
            return Float.valueOf(this.xC.floatValue());
        }
        if (gS == Double.class || gS == Double.TYPE) {
            return Double.valueOf(this.xC.doubleValue());
        }
        if (gS == Character.class || gS == Character.TYPE) {
            return Character.valueOf((char) this.xC.intValue());
        }
        if (gS == Boolean.class || gS == Boolean.TYPE) {
            return Boolean.valueOf(this.xC.byteValue() == 0);
        } else if (gS == String.class) {
            return String.valueOf(this.xC);
        } else {
            if (gS == char[].class) {
                return String.valueOf(this.xC).toCharArray();
            }
            if (gS == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.xC), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
