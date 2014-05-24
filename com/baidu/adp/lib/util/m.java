package com.baidu.adp.lib.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* loaded from: classes.dex */
class m implements Runnable {
    private final /* synthetic */ View a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;
    private final /* synthetic */ View f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(View view, int i, int i2, int i3, int i4, View view2) {
        this.a = view;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Rect rect = new Rect();
        this.a.getHitRect(rect);
        rect.right += this.b;
        rect.left -= this.c;
        rect.bottom += this.d;
        rect.top -= this.e;
        this.f.setTouchDelegate(new TouchDelegate(rect, this.a));
    }
}
