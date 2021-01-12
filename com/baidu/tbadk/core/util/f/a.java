package com.baidu.tbadk.core.util.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.f.a.b;
/* loaded from: classes.dex */
public class a {
    public static final float eYy = ao.eYy;
    public static final float eYz = ao.eYz;

    public static com.baidu.tbadk.core.util.f.b.a bta() {
        return com.baidu.tbadk.core.util.f.b.a.btl();
    }

    public static b btb() {
        return b.btc();
    }

    public static void m(View view, int i, int i2) {
        if (view != null) {
            b.btc().oS(1).oK(i).oO(i2).bz(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.btc().oS(1).l(drawable).m(drawable2);
    }
}
