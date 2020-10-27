package com.baidu.tbadk.core.util.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tbadk.core.util.e.a.b;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.util.e.b.a bpn() {
        return com.baidu.tbadk.core.util.e.b.a.bpy();
    }

    public static b bpo() {
        return b.bpp();
    }

    public static void g(View view, int i, int i2) {
        if (view != null) {
            b.bpp().pg(1).pa(i).pc(i2).bg(view);
        }
    }

    public static b c(Drawable drawable, Drawable drawable2) {
        return b.bpp().pg(1).f(drawable).g(drawable2);
    }
}
