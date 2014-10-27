package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class o implements Runnable {
    private final /* synthetic */ View nt;
    private final /* synthetic */ int nu;
    private final /* synthetic */ int nv;
    private final /* synthetic */ int nw;
    private final /* synthetic */ int nx;
    private final /* synthetic */ View ny;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(View view, int i, int i2, int i3, int i4, View view2) {
        this.nt = view;
        this.nu = i;
        this.nv = i2;
        this.nw = i3;
        this.nx = i4;
        this.ny = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.nt.getHitRect(rect);
        rect.right += this.nu;
        rect.left -= this.nv;
        rect.bottom += this.nw;
        rect.top -= this.nx;
        this.ny.setTouchDelegate(new TouchDelegate(rect, this.nt));
    }
}
