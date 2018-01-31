package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.io.IOException;
/* loaded from: classes.dex */
public class b implements h {
    private boolean value;

    public b(boolean z) {
        this.value = z;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        Class<?> lL = cVar.lL();
        if (lL == Boolean.class || lL == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (lL == Short.class || lL == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (lL == Integer.class || lL == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (lL == Long.class || lL == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (lL == Float.class || lL == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (lL == Double.class || lL == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (lL == Character.class || lL == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (lL == String.class) {
            return String.valueOf(this.value);
        } else {
            if (lL == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (lL == byte[].class) {
                try {
                    return com.baidu.adp.lib.util.c.decode(String.valueOf(this.value), 0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
