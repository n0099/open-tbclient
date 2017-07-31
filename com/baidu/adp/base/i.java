package com.baidu.adp.base;

import android.content.Context;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.megapp.ma.MAFragmentActivity;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class i {
    public static h Y(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof h) {
            return (h) context;
        }
        if (context instanceof f) {
            Object orignalPage = ((f) context).getPageContext().getOrignalPage();
            if (orignalPage instanceof h) {
                return (h) orignalPage;
            }
        }
        Field f = com.baidu.adp.lib.util.b.f(context.getClass(), h.class);
        if (f == null && (f = com.baidu.adp.lib.util.b.f(context.getClass(), MAActivity.class)) == null) {
            f = com.baidu.adp.lib.util.b.f(context.getClass(), MAFragmentActivity.class);
        }
        if (f == null || (a = com.baidu.adp.lib.util.b.a(context, f)) == null || !(a instanceof h)) {
            return null;
        }
        return (h) a;
    }

    public static f<?> Z(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof f) {
            return (f) context;
        }
        Field f = com.baidu.adp.lib.util.b.f(context.getClass(), h.class);
        if (f == null && (f = com.baidu.adp.lib.util.b.f(context.getClass(), MAActivity.class)) == null) {
            f = com.baidu.adp.lib.util.b.f(context.getClass(), MAFragmentActivity.class);
        }
        if (f == null || (a = com.baidu.adp.lib.util.b.a(context, f)) == null || !(a instanceof h) || !(a instanceof f)) {
            return null;
        }
        return (f) a;
    }

    public static e<?> aa(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof e) {
            return (e) context;
        }
        if (context instanceof f) {
            return ((f) context).getPageContext();
        }
        Field f = com.baidu.adp.lib.util.b.f(context.getClass(), h.class);
        if (f == null && (f = com.baidu.adp.lib.util.b.f(context.getClass(), MAActivity.class)) == null) {
            f = com.baidu.adp.lib.util.b.f(context.getClass(), MAFragmentActivity.class);
        }
        if (f == null || (a = com.baidu.adp.lib.util.b.a(context, f)) == null || !(a instanceof h) || !(a instanceof f)) {
            return null;
        }
        return ((f) a).getPageContext();
    }
}
