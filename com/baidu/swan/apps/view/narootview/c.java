package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import com.baidu.swan.apps.adaptation.b.d;
/* loaded from: classes11.dex */
public class c {
    public static FrameLayout.LayoutParams a(@NonNull d dVar, @NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        int i;
        int i2 = 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        if (aVar.isFixed()) {
            i = dVar.getWebViewScrollX();
            i2 = dVar.getWebViewScrollY();
        } else {
            i = 0;
        }
        layoutParams.leftMargin = i + aVar.getLeft();
        layoutParams.topMargin = i2 + aVar.getTop();
        return layoutParams;
    }

    public static void a(@NonNull b bVar, @NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        bVar.hS(aVar.getLeft());
        bVar.hT(aVar.getTop());
        if (aVar.isFixed()) {
            bVar.hQ(1);
        } else {
            bVar.hR(1);
        }
    }
}
