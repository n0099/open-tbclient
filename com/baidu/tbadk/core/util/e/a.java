package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a brN() {
        return com.baidu.tbadk.core.util.e.b.a.brY();
    }

    public static b brO() {
        return b.brP();
    }

    public static void g(View view, int i, int i2) {
        if (view != null) {
            b.brP().pr(1).pk(i).pm(i2).bk(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.brP().pr(1).f(drawable).g(drawable2);
    }
}
