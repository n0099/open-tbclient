package com.baidu.adp.base;

import android.content.Context;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.megapp.ma.MAFragmentActivity;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class l {
    public static k A(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof k) {
            return (k) context;
        }
        if (context instanceof i) {
            Object orignalPage = ((i) context).getPageContext().getOrignalPage();
            if (orignalPage instanceof k) {
                return (k) orignalPage;
            }
        }
        Field b = com.baidu.adp.lib.util.b.b(context.getClass(), k.class);
        if (b == null && (b = com.baidu.adp.lib.util.b.b(context.getClass(), MAActivity.class)) == null) {
            b = com.baidu.adp.lib.util.b.b(context.getClass(), MAFragmentActivity.class);
        }
        if (b == null || (a = com.baidu.adp.lib.util.b.a(context, b)) == null || !(a instanceof k)) {
            return null;
        }
        return (k) a;
    }

    public static i<?> B(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof i) {
            return (i) context;
        }
        Field b = com.baidu.adp.lib.util.b.b(context.getClass(), k.class);
        if (b == null && (b = com.baidu.adp.lib.util.b.b(context.getClass(), MAActivity.class)) == null) {
            b = com.baidu.adp.lib.util.b.b(context.getClass(), MAFragmentActivity.class);
        }
        if (b == null || (a = com.baidu.adp.lib.util.b.a(context, b)) == null || !(a instanceof k) || !(a instanceof i)) {
            return null;
        }
        return (i) a;
    }

    public static h<?> C(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof h) {
            return (h) context;
        }
        if (context instanceof i) {
            return ((i) context).getPageContext();
        }
        Field b = com.baidu.adp.lib.util.b.b(context.getClass(), k.class);
        if (b == null && (b = com.baidu.adp.lib.util.b.b(context.getClass(), MAActivity.class)) == null) {
            b = com.baidu.adp.lib.util.b.b(context.getClass(), MAFragmentActivity.class);
        }
        if (b == null || (a = com.baidu.adp.lib.util.b.a(context, b)) == null || !(a instanceof k) || !(a instanceof i)) {
            return null;
        }
        return ((i) a).getPageContext();
    }
}
