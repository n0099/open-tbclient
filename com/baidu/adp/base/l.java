package com.baidu.adp.base;

import android.content.Context;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.megapp.ma.MAFragmentActivity;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class l {
    public static k q(Context context) {
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
        Field f = com.baidu.adp.lib.util.b.f(context.getClass(), k.class);
        if (f == null && (f = com.baidu.adp.lib.util.b.f(context.getClass(), MAActivity.class)) == null) {
            f = com.baidu.adp.lib.util.b.f(context.getClass(), MAFragmentActivity.class);
        }
        if (f == null || (a = com.baidu.adp.lib.util.b.a(context, f)) == null || !(a instanceof k)) {
            return null;
        }
        return (k) a;
    }

    public static i<?> r(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof i) {
            return (i) context;
        }
        Field f = com.baidu.adp.lib.util.b.f(context.getClass(), k.class);
        if (f == null && (f = com.baidu.adp.lib.util.b.f(context.getClass(), MAActivity.class)) == null) {
            f = com.baidu.adp.lib.util.b.f(context.getClass(), MAFragmentActivity.class);
        }
        if (f == null || (a = com.baidu.adp.lib.util.b.a(context, f)) == null || !(a instanceof k) || !(a instanceof i)) {
            return null;
        }
        return (i) a;
    }

    public static h<?> s(Context context) {
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
        Field f = com.baidu.adp.lib.util.b.f(context.getClass(), k.class);
        if (f == null && (f = com.baidu.adp.lib.util.b.f(context.getClass(), MAActivity.class)) == null) {
            f = com.baidu.adp.lib.util.b.f(context.getClass(), MAFragmentActivity.class);
        }
        if (f == null || (a = com.baidu.adp.lib.util.b.a(context, f)) == null || !(a instanceof k) || !(a instanceof i)) {
            return null;
        }
        return ((i) a).getPageContext();
    }
}
