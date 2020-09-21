package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a bkK() {
        return com.baidu.tbadk.core.util.e.b.a.bkV();
    }

    public static b bkL() {
        return b.bkM();
    }

    public static void g(View view, int i, int i2) {
        if (view != null) {
            b.bkM().ox(1).or(i).ot(i2).bb(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.bkM().ox(1).f(drawable).g(drawable2);
    }
}
