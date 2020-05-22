package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
import com.baidu.tbadk.core.util.e.a.c;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a aVu() {
        return com.baidu.tbadk.core.util.e.b.a.aVI();
    }

    public static c aVv() {
        return c.aVz();
    }

    public static void f(View view, int i, int i2) {
        if (view != null) {
            c.aVz().lu(1).lo(i).lq(i2).aR(view);
        }
    }

    public static b aF(@ColorRes int i, @ColorRes int i2) {
        return b.aVw().lk(1).lj(i2).li(i);
    }

    public static c c(Drawable drawable, Drawable drawable2) {
        return c.aVz().lu(1).f(drawable).g(drawable2);
    }
}
