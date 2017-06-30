package com.baidu.tbadk.core.view;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ k ajN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.ajN = kVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.ajN.wo();
    }
}
