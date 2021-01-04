package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.f.a.b;
/* loaded from: classes.dex */
public class a {
    public static final float fdh = ao.fdh;
    public static final float fdi = ao.fdi;

    public static com.baidu.tbadk.core.util.f.b.a bwT() {
        return com.baidu.tbadk.core.util.f.b.a.bxe();
    }

    public static b bwU() {
        return b.bwV();
    }

    public static void m(View view, int i, int i2) {
        if (view != null) {
            b.bwV().qz(1).qr(i).qv(i2).bz(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.bwV().qz(1).l(drawable).m(drawable2);
    }
}
