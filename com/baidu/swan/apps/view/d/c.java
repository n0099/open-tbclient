package com.baidu.swan.apps.view.d;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import com.baidu.swan.apps.b.c.d;
/* loaded from: classes2.dex */
public class c {
    public static FrameLayout.LayoutParams a(@NonNull d dVar, @NonNull com.baidu.swan.apps.model.a.a.b bVar) {
        int i;
        int i2 = 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.getWidth(), bVar.getHeight());
        if (bVar.isFixed()) {
            i = dVar.getWebViewScrollX();
            i2 = dVar.getWebViewScrollY();
        } else {
            i = 0;
        }
        layoutParams.leftMargin = i + bVar.getLeft();
        layoutParams.topMargin = i2 + bVar.Mu();
        return layoutParams;
    }

    public static void a(@NonNull b bVar, @NonNull com.baidu.swan.apps.model.a.a.b bVar2) {
        bVar.fK(bVar2.getLeft());
        bVar.fL(bVar2.Mu());
        if (bVar2.isFixed()) {
            bVar.fI(1);
        } else {
            bVar.fJ(1);
        }
    }
}
