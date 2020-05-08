package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
import com.baidu.tbadk.core.util.e.a.c;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a aPq() {
        return com.baidu.tbadk.core.util.e.b.a.aPE();
    }

    public static c aPr() {
        return c.aPv();
    }

    public static void d(View view, int i, int i2) {
        if (view != null) {
            c.aPv().kS(1).kM(i).kO(i2).aR(view);
        }
    }

    public static b aC(@ColorRes int i, @ColorRes int i2) {
        return b.aPs().kI(1).kH(i2).kG(i);
    }

    public static c c(Drawable drawable, Drawable drawable2) {
        return c.aPv().kS(1).f(drawable).g(drawable2);
    }
}
