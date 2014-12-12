package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class n implements Runnable {
    private final /* synthetic */ View ns;
    private final /* synthetic */ int nt;
    private final /* synthetic */ int nu;
    private final /* synthetic */ int nv;
    private final /* synthetic */ int nw;
    private final /* synthetic */ View nx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(View view, int i, int i2, int i3, int i4, View view2) {
        this.ns = view;
        this.nt = i;
        this.nu = i2;
        this.nv = i3;
        this.nw = i4;
        this.nx = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.ns.getHitRect(rect);
        rect.right += this.nt;
        rect.left -= this.nu;
        rect.bottom += this.nv;
        rect.top -= this.nw;
        this.nx.setTouchDelegate(new TouchDelegate(rect, this.ns));
    }
}
