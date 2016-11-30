package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View sq;
    private final /* synthetic */ int sr;
    private final /* synthetic */ int ss;
    private final /* synthetic */ int su;
    private final /* synthetic */ int sv;
    private final /* synthetic */ View sw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.sq = view;
        this.sr = i;
        this.ss = i2;
        this.su = i3;
        this.sv = i4;
        this.sw = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.sq.getHitRect(rect);
        rect.right += this.sr;
        rect.left -= this.ss;
        rect.bottom += this.su;
        rect.top -= this.sv;
        this.sw.setTouchDelegate(new TouchDelegate(rect, this.sq));
    }
}
