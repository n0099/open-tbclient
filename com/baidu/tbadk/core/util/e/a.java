package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.e.a.b;
/* loaded from: classes.dex */
public class a {
    public static final float eMy = ap.eMy;
    public static final float eMz = ap.eMz;

    public static com.baidu.tbadk.core.util.e.b.a brb() {
        return com.baidu.tbadk.core.util.e.b.a.brm();
    }

    public static b brc() {
        return b.brd();
    }

    public static void h(View view, int i, int i2) {
        if (view != null) {
            b.brd().pO(1).pG(i).pK(i2).bn(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.brd().pO(1).g(drawable).h(drawable2);
    }
}
