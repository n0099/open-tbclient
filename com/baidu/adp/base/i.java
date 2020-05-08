package com.baidu.adp.base;

import android.content.Context;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.megapp.ma.MAFragmentActivity;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class i {
    public static h E(Context context) {
        Object forceGetProperty;
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
        Field declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), h.class);
        if (declaredField == null && (declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), MAActivity.class)) == null) {
            declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), MAFragmentActivity.class);
        }
        if (declaredField == null || (forceGetProperty = com.baidu.adp.lib.util.b.forceGetProperty(context, declaredField)) == null || !(forceGetProperty instanceof h)) {
            return null;
        }
        return (h) forceGetProperty;
    }

    public static f<?> F(Context context) {
        Object forceGetProperty;
        if (context == null) {
            return null;
        }
        if (context instanceof f) {
            return (f) context;
        }
        Field declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), h.class);
        if (declaredField == null && (declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), MAActivity.class)) == null) {
            declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), MAFragmentActivity.class);
        }
        if (declaredField == null || (forceGetProperty = com.baidu.adp.lib.util.b.forceGetProperty(context, declaredField)) == null || !(forceGetProperty instanceof h) || !(forceGetProperty instanceof f)) {
            return null;
        }
        return (f) forceGetProperty;
    }

    public static e<?> G(Context context) {
        Object forceGetProperty;
        if (context == null) {
            return null;
        }
        if (context instanceof e) {
            return (e) context;
        }
        if (context instanceof f) {
            return ((f) context).getPageContext();
        }
        Field declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), h.class);
        if (declaredField == null && (declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), MAActivity.class)) == null) {
            declaredField = com.baidu.adp.lib.util.b.getDeclaredField(context.getClass(), MAFragmentActivity.class);
        }
        if (declaredField == null || (forceGetProperty = com.baidu.adp.lib.util.b.forceGetProperty(context, declaredField)) == null || !(forceGetProperty instanceof h) || !(forceGetProperty instanceof f)) {
            return null;
        }
        return ((f) forceGetProperty).getPageContext();
    }
}
