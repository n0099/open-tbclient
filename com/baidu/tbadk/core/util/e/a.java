package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
import com.baidu.tbadk.core.util.e.a.c;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a aXp() {
        return com.baidu.tbadk.core.util.e.b.a.aXD();
    }

    public static c aXq() {
        return c.aXu();
    }

    public static void f(View view, int i, int i2) {
        if (view != null) {
            c.aXu().lN(1).lH(i).lJ(i2).aR(view);
        }
    }

    public static b aH(@ColorRes int i, @ColorRes int i2) {
        return b.aXr().lD(1).lC(i2).lB(i);
    }

    public static c c(Drawable drawable, Drawable drawable2) {
        return c.aXu().lN(1).f(drawable).g(drawable2);
    }
}
