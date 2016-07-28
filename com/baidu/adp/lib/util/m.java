package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View qa;
    private final /* synthetic */ int qb;
    private final /* synthetic */ int qc;
    private final /* synthetic */ int qd;
    private final /* synthetic */ int qe;
    private final /* synthetic */ View qf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.qa = view;
        this.qb = i;
        this.qc = i2;
        this.qd = i3;
        this.qe = i4;
        this.qf = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.qa.getHitRect(rect);
        rect.right += this.qb;
        rect.left -= this.qc;
        rect.bottom += this.qd;
        rect.top -= this.qe;
        this.qf.setTouchDelegate(new TouchDelegate(rect, this.qa));
    }
}
