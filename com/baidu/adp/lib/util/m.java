package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View yW;
    private final /* synthetic */ int yX;
    private final /* synthetic */ int yY;
    private final /* synthetic */ int yZ;
    private final /* synthetic */ int za;
    private final /* synthetic */ View zb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.yW = view;
        this.yX = i;
        this.yY = i2;
        this.yZ = i3;
        this.za = i4;
        this.zb = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.yW.getHitRect(rect);
        rect.right += this.yX;
        rect.left -= this.yY;
        rect.bottom += this.yZ;
        rect.top -= this.za;
        this.zb.setTouchDelegate(new TouchDelegate(rect, this.yW));
    }
}
