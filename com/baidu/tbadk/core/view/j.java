package com.baidu.tbadk.core.view;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ i adG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.adG = iVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.adG.vs();
    }
}
