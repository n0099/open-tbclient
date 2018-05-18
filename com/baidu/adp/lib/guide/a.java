package com.baidu.adp.lib.guide;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.adp.lib.guide.MaskView;
/* loaded from: classes.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(LayoutInflater layoutInflater, b bVar) {
        View a = bVar.a(layoutInflater);
        MaskView.a aVar = new MaskView.a(-2, -2);
        aVar.sT = bVar.getXOffset();
        aVar.sU = bVar.getYOffset();
        aVar.sR = bVar.eF();
        aVar.sS = bVar.eG();
        a.setLayoutParams(aVar);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect a(View view2, int i, int i2) {
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        Rect rect = new Rect();
        rect.set(iArr[0], iArr[1], iArr[0] + view2.getMeasuredWidth(), iArr[1] + view2.getMeasuredHeight());
        rect.offset(-i, -i2);
        return rect;
    }
}
