package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View yO;
    private final /* synthetic */ int yP;
    private final /* synthetic */ int yQ;
    private final /* synthetic */ int yR;
    private final /* synthetic */ int yS;
    private final /* synthetic */ View yT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.yO = view;
        this.yP = i;
        this.yQ = i2;
        this.yR = i3;
        this.yS = i4;
        this.yT = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.yO.getHitRect(rect);
        rect.right += this.yP;
        rect.left -= this.yQ;
        rect.bottom += this.yR;
        rect.top -= this.yS;
        this.yT.setTouchDelegate(new TouchDelegate(rect, this.yO));
    }
}
