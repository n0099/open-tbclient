package com.baidu.adp.base;

import android.content.Context;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.megapp.ma.MAFragmentActivity;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class i {
    public static h Z(Context context) {
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
        Field e = com.baidu.adp.lib.util.b.e(context.getClass(), h.class);
        if (e == null && (e = com.baidu.adp.lib.util.b.e(context.getClass(), MAActivity.class)) == null) {
            e = com.baidu.adp.lib.util.b.e(context.getClass(), MAFragmentActivity.class);
        }
        if (e == null || (a = com.baidu.adp.lib.util.b.a(context, e)) == null || !(a instanceof h)) {
            return null;
        }
        return (h) a;
    }

    public static f<?> aa(Context context) {
        Object a;
        if (context == null) {
            return null;
        }
        if (context instanceof f) {
            return (f) context;
        }
        Field e = com.baidu.adp.lib.util.b.e(context.getClass(), h.class);
        if (e == null && (e = com.baidu.adp.lib.util.b.e(context.getClass(), MAActivity.class)) == null) {
            e = com.baidu.adp.lib.util.b.e(context.getClass(), MAFragmentActivity.class);
        }
        if (e == null || (a = com.baidu.adp.lib.util.b.a(context, e)) == null || !(a instanceof h) || !(a instanceof f)) {
            return null;
        }
        return (f) a;
    }

    public static e<?> ab(Context context) {
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
        Field e = com.baidu.adp.lib.util.b.e(context.getClass(), h.class);
        if (e == null && (e = com.baidu.adp.lib.util.b.e(context.getClass(), MAActivity.class)) == null) {
            e = com.baidu.adp.lib.util.b.e(context.getClass(), MAFragmentActivity.class);
        }
        if (e == null || (a = com.baidu.adp.lib.util.b.a(context, e)) == null || !(a instanceof h) || !(a instanceof f)) {
            return null;
        }
        return ((f) a).getPageContext();
    }
}
