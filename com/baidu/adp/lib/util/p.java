package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class p implements Runnable {
    private final /* synthetic */ View yS;
    private final /* synthetic */ int yT;
    private final /* synthetic */ int yU;
    private final /* synthetic */ int yV;
    private final /* synthetic */ int yW;
    private final /* synthetic */ View yX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(View view, int i, int i2, int i3, int i4, View view2) {
        this.yS = view;
        this.yT = i;
        this.yU = i2;
        this.yV = i3;
        this.yW = i4;
        this.yX = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.yS.getHitRect(rect);
        rect.right += this.yT;
        rect.left -= this.yU;
        rect.bottom += this.yV;
        rect.top -= this.yW;
        this.yX.setTouchDelegate(new TouchDelegate(rect, this.yS));
    }
}
