package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class g implements h {
    private Float xD;

    public g(float f) {
        this.xD = Float.valueOf(f);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> gS = cVar.gS();
        if (gS == Byte.class || gS == Byte.TYPE) {
            return Byte.valueOf(this.xD.byteValue());
        }
        if (gS == Short.class || gS == Short.TYPE) {
            return Short.valueOf(this.xD.shortValue());
        }
        if (gS == Integer.class || gS == Integer.TYPE) {
            return Integer.valueOf(this.xD.intValue());
        }
        if (gS == Long.class || gS == Long.TYPE) {
            return Long.valueOf(this.xD.longValue());
        }
        if (gS == Float.class || gS == Float.TYPE) {
            return Float.valueOf(this.xD.floatValue());
        }
        if (gS == Double.class || gS == Double.TYPE) {
            return Double.valueOf(this.xD.doubleValue());
        }
        if (gS == Character.class || gS == Character.TYPE) {
            return Character.valueOf((char) this.xD.intValue());
        }
        if (gS == Boolean.class || gS == Boolean.TYPE) {
            return Boolean.valueOf(this.xD.byteValue() == 0);
        } else if (gS == String.class) {
            return String.valueOf(this.xD);
        } else {
            if (gS == char[].class) {
                return String.valueOf(this.xD).toCharArray();
            }
            if (gS == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.xD), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
