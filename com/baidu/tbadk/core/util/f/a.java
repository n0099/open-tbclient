package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.f.a.b;
/* loaded from: classes.dex */
public class a {
    public static final float faN = ap.faN;
    public static final float faO = ap.faO;

    public static com.baidu.tbadk.core.util.f.b.a btu() {
        return com.baidu.tbadk.core.util.f.b.a.btF();
    }

    public static b btv() {
        return b.btw();
    }

    public static void m(View view, int i, int i2) {
        if (view != null) {
            b.btw().oX(1).oP(i).oT(i2).bv(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.btw().oX(1).l(drawable).m(drawable2);
    }
}
