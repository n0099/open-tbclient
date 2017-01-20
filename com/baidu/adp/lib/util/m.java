package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View sg;
    private final /* synthetic */ int sh;
    private final /* synthetic */ int si;
    private final /* synthetic */ int sj;
    private final /* synthetic */ int sk;
    private final /* synthetic */ View sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.sg = view;
        this.sh = i;
        this.si = i2;
        this.sj = i3;
        this.sk = i4;
        this.sl = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.sg.getHitRect(rect);
        rect.right += this.sh;
        rect.left -= this.si;
        rect.bottom += this.sj;
        rect.top -= this.sk;
        this.sl.setTouchDelegate(new TouchDelegate(rect, this.sg));
    }
}
