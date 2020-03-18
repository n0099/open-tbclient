package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a aHe() {
        return com.baidu.tbadk.core.util.e.b.a.aHp();
    }

    public static b aHf() {
        return b.aHg();
    }

    public static void d(View view, int i, int i2) {
        if (view != null) {
            b.aHg().kI(1).kC(i).kE(i2).aQ(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.aHg().kI(1).f(drawable).g(drawable2);
    }
}
