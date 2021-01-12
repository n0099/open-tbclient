package com.baidu.swan.apps.ao;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(@NonNull BdSailorWebView bdSailorWebView) {
        AbsoluteLayout webView;
        Drawable drawable = com.baidu.swan.support.v4.a.a.getDrawable(bdSailorWebView.getContext(), a.e.common_scrollbar_vertical);
        Drawable drawable2 = com.baidu.swan.support.v4.a.a.getDrawable(bdSailorWebView.getContext(), a.e.common_scrollbar_horizontal);
        if (BdZeusUtil.isWebkitLoaded()) {
            webView = bdSailorWebView.getCurrentWebView();
        } else {
            webView = bdSailorWebView.getCurrentWebView().getWebView();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            webView.setVerticalScrollbarThumbDrawable(drawable);
            webView.setHorizontalScrollbarThumbDrawable(drawable2);
            return;
        }
        a(webView, drawable, drawable2);
    }

    private static void a(@Nullable View view, Drawable drawable, Drawable drawable2) {
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
                declaredMethod.invoke(obj2, drawable);
                Method declaredMethod2 = obj2.getClass().getDeclaredMethod("setHorizontalThumbDrawable", Drawable.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(obj2, drawable2);
            } catch (Throwable th) {
                if (DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }
}
