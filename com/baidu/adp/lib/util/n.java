package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class n implements Runnable {
    private final /* synthetic */ View nA;
    private final /* synthetic */ View nv;
    private final /* synthetic */ int nw;
    private final /* synthetic */ int nx;
    private final /* synthetic */ int ny;
    private final /* synthetic */ int nz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(View view, int i, int i2, int i3, int i4, View view2) {
        this.nv = view;
        this.nw = i;
        this.nx = i2;
        this.ny = i3;
        this.nz = i4;
        this.nA = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.nv.getHitRect(rect);
        rect.right += this.nw;
        rect.left -= this.nx;
        rect.bottom += this.ny;
        rect.top -= this.nz;
        this.nA.setTouchDelegate(new TouchDelegate(rect, this.nv));
    }
}
