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
        Class<?> gS = cVar.gS();
        if (gS == Boolean.class || gS == Boolean.TYPE) {
            return Boolean.valueOf(this.value);
        }
        if (gS == Short.class || gS == Short.TYPE) {
            return Short.valueOf((short) (this.value ? 0 : 1));
        } else if (gS == Integer.class || gS == Integer.TYPE) {
            return Integer.valueOf(this.value ? 0 : 1);
        } else if (gS == Long.class || gS == Long.TYPE) {
            return Long.valueOf(this.value ? 0 : 1);
        } else if (gS == Float.class || gS == Float.TYPE) {
            return Float.valueOf(this.value ? 0 : 1);
        } else if (gS == Double.class || gS == Double.TYPE) {
            return Double.valueOf(this.value ? 0 : 1);
        } else if (gS == Character.class || gS == Character.TYPE) {
            return Character.valueOf((char) (this.value ? 0 : 1));
        } else if (gS == String.class) {
            return String.valueOf(this.value);
        } else {
            if (gS == char[].class) {
                return String.valueOf(this.value).toCharArray();
            }
            if (gS == byte[].class) {
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
