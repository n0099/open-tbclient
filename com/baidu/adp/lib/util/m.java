package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View so;
    private final /* synthetic */ int sq;
    private final /* synthetic */ int sr;
    private final /* synthetic */ int ss;
    private final /* synthetic */ int su;
    private final /* synthetic */ View sv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.so = view;
        this.sq = i;
        this.sr = i2;
        this.ss = i3;
        this.su = i4;
        this.sv = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.so.getHitRect(rect);
        rect.right += this.sq;
        rect.left -= this.sr;
        rect.bottom += this.ss;
        rect.top -= this.su;
        this.sv.setTouchDelegate(new TouchDelegate(rect, this.so));
    }
}
