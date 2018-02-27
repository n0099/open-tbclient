package com.baidu.adp.lib.guide;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.adp.lib.guide.e;
/* loaded from: classes.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(LayoutInflater layoutInflater, b bVar) {
        View a = bVar.a(layoutInflater);
        e.a aVar = new e.a(-2, -2);
        aVar.aiy = bVar.getXOffset();
        aVar.aiz = bVar.getYOffset();
        aVar.aiw = bVar.mB();
        aVar.aix = bVar.mC();
        a.setLayoutParams(aVar);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect c(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Rect rect = new Rect();
        rect.set(iArr[0], iArr[1], iArr[0] + view.getMeasuredWidth(), iArr[1] + view.getMeasuredHeight());
        rect.offset(-i, -i2);
        return rect;
    }
}
