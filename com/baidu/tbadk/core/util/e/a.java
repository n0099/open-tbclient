package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
import com.baidu.tbadk.core.util.e.a.c;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a bbq() {
        return com.baidu.tbadk.core.util.e.b.a.bbE();
    }

    public static c bbr() {
        return c.bbv();
    }

    public static void h(View view, int i, int i2) {
        if (view != null) {
            c.bbv().mh(1).mb(i).md(i2).aX(view);
        }
    }

    public static b aI(@ColorRes int i, @ColorRes int i2) {
        return b.bbs().lX(1).lW(i2).lV(i);
    }

    public static c c(Drawable drawable, Drawable drawable2) {
        return c.bbv().mh(1).f(drawable).g(drawable2);
    }
}
