package com.baidu.tbadk.core.view;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ q aeu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.aeu = qVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.aeu.vA();
    }
}
