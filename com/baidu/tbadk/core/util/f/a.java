package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.f.a.b;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.f.b.a aGX() {
        return com.baidu.tbadk.core.util.f.b.a.aHi();
    }

    public static b aGY() {
        return b.aGZ();
    }

    public static void c(View view, int i, int i2) {
        if (view != null) {
            b.aGZ().kI(1).kC(i).kE(i2).aQ(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.aGZ().kI(1).f(drawable).g(drawable2);
    }
}
