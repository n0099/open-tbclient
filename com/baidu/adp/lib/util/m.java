package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View yF;
    private final /* synthetic */ int yG;
    private final /* synthetic */ int yH;
    private final /* synthetic */ int yI;
    private final /* synthetic */ int yJ;
    private final /* synthetic */ View yK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.yF = view;
        this.yG = i;
        this.yH = i2;
        this.yI = i3;
        this.yJ = i4;
        this.yK = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.yF.getHitRect(rect);
        rect.right += this.yG;
        rect.left -= this.yH;
        rect.bottom += this.yI;
        rect.top -= this.yJ;
        this.yK.setTouchDelegate(new TouchDelegate(rect, this.yF));
    }
}
