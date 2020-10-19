package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a bnu() {
        return com.baidu.tbadk.core.util.e.b.a.bnF();
    }

    public static b bnv() {
        return b.bnw();
    }

    public static void g(View view, int i, int i2) {
        if (view != null) {
            b.bnw().oV(1).oP(i).oR(i2).bf(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.bnw().oV(1).f(drawable).g(drawable2);
    }
}
