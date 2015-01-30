package com.baidu.adp.lib.guide;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(LayoutInflater layoutInflater, b bVar) {
        View a = bVar.a(layoutInflater);
        j jVar = new j(-2, -2);
        jVar.jO = bVar.getXOffset();
        jVar.jP = bVar.getYOffset();
        jVar.jM = bVar.dv();
        jVar.jN = bVar.dw();
        a.setLayoutParams(jVar);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect a(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Rect rect = new Rect();
        rect.set(iArr[0], iArr[1], iArr[0] + view.getMeasuredWidth(), iArr[1] + view.getMeasuredHeight());
        rect.offset(-i, -i2);
        return rect;
    }
}
