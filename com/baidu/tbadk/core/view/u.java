package com.baidu.tbadk.core.view;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ t Zj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.Zj = tVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.Zj.ur();
    }
}
