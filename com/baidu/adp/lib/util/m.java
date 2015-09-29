package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View yG;
    private final /* synthetic */ int yH;
    private final /* synthetic */ int yI;
    private final /* synthetic */ int yJ;
    private final /* synthetic */ int yK;
    private final /* synthetic */ View yL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.yG = view;
        this.yH = i;
        this.yI = i2;
        this.yJ = i3;
        this.yK = i4;
        this.yL = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.yG.getHitRect(rect);
        rect.right += this.yH;
        rect.left -= this.yI;
        rect.bottom += this.yJ;
        rect.top -= this.yK;
        this.yL.setTouchDelegate(new TouchDelegate(rect, this.yG));
    }
}
