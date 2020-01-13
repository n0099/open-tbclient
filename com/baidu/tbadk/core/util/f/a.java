package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.f.a.b;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.f.b.a aEL() {
        return com.baidu.tbadk.core.util.f.b.a.aEW();
    }

    public static b aEM() {
        return b.aEN();
    }

    public static void c(View view, int i, int i2) {
        if (view != null) {
            b.aEN().kr(1).kl(i).kn(i2).aQ(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.aEN().kr(1).f(drawable).g(drawable2);
    }
}
