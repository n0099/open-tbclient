package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ int pA;
    private final /* synthetic */ int pB;
    private final /* synthetic */ int pC;
    private final /* synthetic */ View pD;
    private final /* synthetic */ View py;
    private final /* synthetic */ int pz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.py = view;
        this.pz = i;
        this.pA = i2;
        this.pB = i3;
        this.pC = i4;
        this.pD = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.py.getHitRect(rect);
        rect.right += this.pz;
        rect.left -= this.pA;
        rect.bottom += this.pB;
        rect.top -= this.pC;
        this.pD.setTouchDelegate(new TouchDelegate(rect, this.py));
    }
}
