package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a aHa() {
        return com.baidu.tbadk.core.util.e.b.a.aHl();
    }

    public static b aHb() {
        return b.aHc();
    }

    public static void d(View view, int i, int i2) {
        if (view != null) {
            b.aHc().kI(1).kC(i).kE(i2).aQ(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.aHc().kI(1).f(drawable).g(drawable2);
    }
}
