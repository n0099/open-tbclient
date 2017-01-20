package com.baidu.adp.base;

import android.content.Context;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.megapp.ma.MAFragmentActivity;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class k {
    public static j A(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof j) {
            return (j) context;
        }
        if (context instanceof h) {
            Object orignalPage = ((h) context).getPageContext().getOrignalPage();
            if (orignalPage instanceof j) {
                return (j) orignalPage;
            }
        }
        Field f = com.baidu.adp.lib.util.b.f(context.getClass(), j.class);
        if (f == null && (f = com.baidu.adp.lib.util.b.f(context.getClass(), MAActivity.class)) == null) {
            f = com.baidu.adp.lib.util.b.f(context.getClass(), MAFragmentActivity.class);
        }
        if (f == null || (a = com.baidu.adp.lib.util.b.a(context, f)) == null || !(a instanceof j)) {
            return null;
        }
        return (j) a;
    }

    public static h<?> B(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof h) {
            return (h) context;
        }
        Field f = com.baidu.adp.lib.util.b.f(context.getClass(), j.class);
        if (f == null && (f = com.baidu.adp.lib.util.b.f(context.getClass(), MAActivity.class)) == null) {
            f = com.baidu.adp.lib.util.b.f(context.getClass(), MAFragmentActivity.class);
        }
        if (f == null || (a = com.baidu.adp.lib.util.b.a(context, f)) == null || !(a instanceof j) || !(a instanceof h)) {
            return null;
        }
        return (h) a;
    }

    public static g<?> C(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof g) {
            return (g) context;
        }
        if (context instanceof h) {
            return ((h) context).getPageContext();
        }
        Field f = com.baidu.adp.lib.util.b.f(context.getClass(), j.class);
        if (f == null && (f = com.baidu.adp.lib.util.b.f(context.getClass(), MAActivity.class)) == null) {
            f = com.baidu.adp.lib.util.b.f(context.getClass(), MAFragmentActivity.class);
        }
        if (f == null || (a = com.baidu.adp.lib.util.b.a(context, f)) == null || !(a instanceof j) || !(a instanceof h)) {
            return null;
        }
        return ((h) a).getPageContext();
    }
}
