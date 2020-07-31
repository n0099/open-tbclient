package com.baidu.swan.apps.aq;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.view.View;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(BdSailorWebView bdSailorWebView) {
        if (Build.VERSION.SDK_INT <= 26) {
            if (BdZeusUtil.isWebkitLoaded()) {
                c(bdSailorWebView.getCurrentWebView(), a.e.common_scrollbar_vertical, a.e.common_scrollbar_horizontal);
            } else {
                c(bdSailorWebView.getCurrentWebView().getWebView(), a.e.common_scrollbar_vertical, a.e.common_scrollbar_horizontal);
            }
        }
    }

    private static void c(@Nullable View view, @DrawableRes int i, @DrawableRes int i2) {
        if (view != null) {
            try {
                Field declaredField = View.class.getDeclaredField("mScrollCache");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(view);
                Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj2, view.getContext().getResources().getDrawable(i));
                Method declaredMethod2 = obj2.getClass().getDeclaredMethod("setHorizontalThumbDrawable", Drawable.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(obj2, view.getContext().getResources().getDrawable(i2));
            } catch (Throwable th) {
                if (DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }
}
