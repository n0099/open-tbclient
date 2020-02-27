package com.baidu.searchbox.ugc.lightbrowser;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes13.dex */
public class UgcLightBrowserUiUtils {
    public static void setVerticalThumbDrawable(View view, @DrawableRes int i) {
        setThumbDrawable(view, i);
    }

    public static void setThumbDrawable(View view, @DrawableRes int i) {
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
                declaredMethod.invoke(obj2, view.getResources().getDrawable(i));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
