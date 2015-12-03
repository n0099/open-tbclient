package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View yM;
    private final /* synthetic */ int yN;
    private final /* synthetic */ int yO;
    private final /* synthetic */ int yP;
    private final /* synthetic */ int yQ;
    private final /* synthetic */ View yR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.yM = view;
        this.yN = i;
        this.yO = i2;
        this.yP = i3;
        this.yQ = i4;
        this.yR = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.yM.getHitRect(rect);
        rect.right += this.yN;
        rect.left -= this.yO;
        rect.bottom += this.yP;
        rect.top -= this.yQ;
        this.yR.setTouchDelegate(new TouchDelegate(rect, this.yM));
    }
}
