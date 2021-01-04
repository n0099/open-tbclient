package com.baidu.adp.base;

import android.content.Context;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class j {
    public static i I(Context context) {
        Object forceGetProperty;
        if (context == null) {
            return null;
        }
        if (context instanceof i) {
            return (i) context;
        }
        if (context instanceof g) {
            Object orignalPage = ((g) context).getPageContext().getOrignalPage();
            if (orignalPage instanceof i) {
                return (i) orignalPage;
            }
        }
        Field declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), i.class);
        if (declaredField == null || (forceGetProperty = com.baidu.adp.lib.util.b.forceGetProperty(context, declaredField)) == null || !(forceGetProperty instanceof i)) {
            return null;
        }
        return (i) forceGetProperty;
    }

    public static g<?> J(Context context) {
        Object forceGetProperty;
        if (context == null) {
            return null;
        }
        if (context instanceof g) {
            return (g) context;
        }
        Field declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), i.class);
        if (declaredField == null || (forceGetProperty = com.baidu.adp.lib.util.b.forceGetProperty(context, declaredField)) == null || !(forceGetProperty instanceof i) || !(forceGetProperty instanceof g)) {
            return null;
        }
        return (g) forceGetProperty;
    }

    public static f<?> K(Context context) {
        Object forceGetProperty;
        if (context == null) {
            return null;
        }
        if (context instanceof f) {
            return (f) context;
        }
        if (context instanceof g) {
            return ((g) context).getPageContext();
        }
        Field declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), i.class);
        if (declaredField == null || (forceGetProperty = com.baidu.adp.lib.util.b.forceGetProperty(context, declaredField)) == null || !(forceGetProperty instanceof i) || !(forceGetProperty instanceof g)) {
            return null;
        }
        return ((g) forceGetProperty).getPageContext();
    }
}
