package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
/* loaded from: classes2.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a bjP() {
        return com.baidu.tbadk.core.util.e.b.a.bka();
    }

    public static b bjQ() {
        return b.bjR();
    }

    public static void g(View view, int i, int i2) {
        if (view != null) {
            b.bjR().ol(1).of(i).oh(i2).aZ(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.bjR().ol(1).f(drawable).g(drawable2);
    }
}
