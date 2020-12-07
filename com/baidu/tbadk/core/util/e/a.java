package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.e.a.b;
/* loaded from: classes.dex */
public class a {
    public static final float eTK = ap.eTK;
    public static final float eTL = ap.eTL;

    public static com.baidu.tbadk.core.util.e.b.a buy() {
        return com.baidu.tbadk.core.util.e.b.a.buJ();
    }

    public static b buz() {
        return b.buA();
    }

    public static void g(View view, int i, int i2) {
        if (view != null) {
            b.buA().qo(1).qg(i).qk(i2).bq(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.buA().qo(1).g(drawable).h(drawable2);
    }
}
