package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class f implements h {
    private Double ui;

    public f(double d) {
        this.ui = Double.valueOf(d);
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> es = cVar.es();
        if (es == Byte.class || es == Byte.TYPE) {
            return Byte.valueOf(this.ui.byteValue());
        }
        if (es == Short.class || es == Short.TYPE) {
            return Short.valueOf(this.ui.shortValue());
        }
        if (es == Integer.class || es == Integer.TYPE) {
            return Integer.valueOf(this.ui.intValue());
        }
        if (es == Long.class || es == Long.TYPE) {
            return Long.valueOf(this.ui.longValue());
        }
        if (es == Float.class || es == Float.TYPE) {
            return Float.valueOf(this.ui.floatValue());
        }
        if (es == Double.class || es == Double.TYPE) {
            return Double.valueOf(this.ui.doubleValue());
        }
        if (es == Character.class || es == Character.TYPE) {
            return Character.valueOf((char) this.ui.intValue());
        }
        if (es == Boolean.class || es == Boolean.TYPE) {
            return Boolean.valueOf(this.ui.byteValue() == 0);
        } else if (es == String.class) {
            return String.valueOf(this.ui);
        } else {
            if (es == char[].class) {
                return String.valueOf(this.ui).toCharArray();
            }
            if (es == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.ui), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
