package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View zn;
    private final /* synthetic */ int zo;
    private final /* synthetic */ int zp;
    private final /* synthetic */ int zq;
    private final /* synthetic */ int zr;
    private final /* synthetic */ View zs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.zn = view;
        this.zo = i;
        this.zp = i2;
        this.zq = i3;
        this.zr = i4;
        this.zs = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.zn.getHitRect(rect);
        rect.right += this.zo;
        rect.left -= this.zp;
        rect.bottom += this.zq;
        rect.top -= this.zr;
        this.zs.setTouchDelegate(new TouchDelegate(rect, this.zn));
    }
}
