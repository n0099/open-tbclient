package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View zg;
    private final /* synthetic */ int zh;
    private final /* synthetic */ int zi;
    private final /* synthetic */ int zj;
    private final /* synthetic */ int zk;
    private final /* synthetic */ View zl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.zg = view;
        this.zh = i;
        this.zi = i2;
        this.zj = i3;
        this.zk = i4;
        this.zl = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.zg.getHitRect(rect);
        rect.right += this.zh;
        rect.left -= this.zi;
        rect.bottom += this.zj;
        rect.top -= this.zk;
        this.zl.setTouchDelegate(new TouchDelegate(rect, this.zg));
    }
}
