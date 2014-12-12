package com.baidu.adp.base;

import android.content.Context;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class m {
    public static l B(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof l) {
            return (l) context;
        }
        if (context instanceof k) {
            Object orignalPage = ((k) context).getPageContext().getOrignalPage();
            if (orignalPage instanceof l) {
                return (l) orignalPage;
            }
        }
        Field b = com.baidu.adp.lib.util.b.b(context.getClass(), l.class);
        if (b == null || (a = com.baidu.adp.lib.util.b.a(context, b)) == null || !(a instanceof l)) {
            return null;
        }
        return (l) a;
    }

    public static k<?> C(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof k) {
            return (k) context;
        }
        Field b = com.baidu.adp.lib.util.b.b(context.getClass(), l.class);
        if (b == null || (a = com.baidu.adp.lib.util.b.a(context, b)) == null || !(a instanceof l) || !(a instanceof k)) {
            return null;
        }
        return (k) a;
    }

    public static j<?> D(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof j) {
            return (j) context;
        }
        if (context instanceof k) {
            return ((k) context).getPageContext();
        }
        Field b = com.baidu.adp.lib.util.b.b(context.getClass(), l.class);
        if (b == null || (a = com.baidu.adp.lib.util.b.a(context, b)) == null || !(a instanceof l) || !(a instanceof k)) {
            return null;
        }
        return ((k) a).getPageContext();
    }
}
