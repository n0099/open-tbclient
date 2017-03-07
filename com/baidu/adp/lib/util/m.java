package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View zB;
    private final /* synthetic */ int zC;
    private final /* synthetic */ int zD;
    private final /* synthetic */ int zE;
    private final /* synthetic */ int zF;
    private final /* synthetic */ View zG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.zB = view;
        this.zC = i;
        this.zD = i2;
        this.zE = i3;
        this.zF = i4;
        this.zG = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.zB.getHitRect(rect);
        rect.right += this.zC;
        rect.left -= this.zD;
        rect.bottom += this.zE;
        rect.top -= this.zF;
        this.zG.setTouchDelegate(new TouchDelegate(rect, this.zB));
    }
}
