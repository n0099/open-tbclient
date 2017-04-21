package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View zf;
    private final /* synthetic */ int zg;
    private final /* synthetic */ int zh;
    private final /* synthetic */ int zi;
    private final /* synthetic */ int zj;
    private final /* synthetic */ View zk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.zf = view;
        this.zg = i;
        this.zh = i2;
        this.zi = i3;
        this.zj = i4;
        this.zk = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.zf.getHitRect(rect);
        rect.right += this.zg;
        rect.left -= this.zh;
        rect.bottom += this.zi;
        rect.top -= this.zj;
        this.zk.setTouchDelegate(new TouchDelegate(rect, this.zf));
    }
}
