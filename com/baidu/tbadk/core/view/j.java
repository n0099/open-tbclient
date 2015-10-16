package com.baidu.tbadk.core.view;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ i adH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.adH = iVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.adH.vs();
    }
}
