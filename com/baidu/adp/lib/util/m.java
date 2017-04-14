package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View zc;
    private final /* synthetic */ int zd;
    private final /* synthetic */ int ze;
    private final /* synthetic */ int zf;
    private final /* synthetic */ int zg;
    private final /* synthetic */ View zh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.zc = view;
        this.zd = i;
        this.ze = i2;
        this.zf = i3;
        this.zg = i4;
        this.zh = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.zc.getHitRect(rect);
        rect.right += this.zd;
        rect.left -= this.ze;
        rect.bottom += this.zf;
        rect.top -= this.zg;
        this.zh.setTouchDelegate(new TouchDelegate(rect, this.zc));
    }
}
