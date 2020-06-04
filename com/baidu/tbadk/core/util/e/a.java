package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
import com.baidu.tbadk.core.util.e.a.c;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a aVv() {
        return com.baidu.tbadk.core.util.e.b.a.aVJ();
    }

    public static c aVw() {
        return c.aVA();
    }

    public static void f(View view, int i, int i2) {
        if (view != null) {
            c.aVA().lw(1).lq(i).ls(i2).aR(view);
        }
    }

    public static b aF(@ColorRes int i, @ColorRes int i2) {
        return b.aVx().lm(1).ll(i2).lk(i);
    }

    public static c c(Drawable drawable, Drawable drawable2) {
        return c.aVA().lw(1).f(drawable).g(drawable2);
    }
}
