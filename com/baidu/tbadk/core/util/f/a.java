package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.f.a.b;
/* loaded from: classes.dex */
public class a {
    public static final float fcm = ap.fcm;
    public static final float fcn = ap.fcn;

    public static com.baidu.tbadk.core.util.f.b.a btx() {
        return com.baidu.tbadk.core.util.f.b.a.btI();
    }

    public static b bty() {
        return b.btz();
    }

    public static void m(View view, int i, int i2) {
        if (view != null) {
            b.btz().oY(1).oQ(i).oU(i2).bv(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.btz().oY(1).l(drawable).m(drawable2);
    }
}
