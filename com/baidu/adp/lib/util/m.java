package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View yH;
    private final /* synthetic */ int yI;
    private final /* synthetic */ int yJ;
    private final /* synthetic */ int yK;
    private final /* synthetic */ int yL;
    private final /* synthetic */ View yM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.yH = view;
        this.yI = i;
        this.yJ = i2;
        this.yK = i3;
        this.yL = i4;
        this.yM = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.yH.getHitRect(rect);
        rect.right += this.yI;
        rect.left -= this.yJ;
        rect.bottom += this.yK;
        rect.top -= this.yL;
        this.yM.setTouchDelegate(new TouchDelegate(rect, this.yH));
    }
}
