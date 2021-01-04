package com.baidu.swan.apps.view.narootview;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.b.d;
/* loaded from: classes9.dex */
public class c {
    public static FrameLayout.LayoutParams a(@NonNull d dVar, @NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        int i;
        int i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.getWidth(), aVar.getHeight());
        if (aVar.isFixed()) {
            int webViewScrollX = dVar.getWebViewScrollX();
            i = dVar.getWebViewScrollY();
            i2 = webViewScrollX;
        } else {
            i = 0;
            i2 = 0;
        }
        layoutParams.leftMargin = aVar.getLeft() + i2;
        layoutParams.topMargin = i + aVar.aFZ();
        return layoutParams;
    }

    public static void a(@NonNull b bVar, @NonNull com.baidu.swan.apps.model.a.a.a aVar) {
        bVar.mc(aVar.getLeft());
        bVar.md(aVar.aFZ());
        if (aVar.isFixed()) {
            bVar.ma(1);
        } else {
            bVar.mb(1);
        }
    }
}
