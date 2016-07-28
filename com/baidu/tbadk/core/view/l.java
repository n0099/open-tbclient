package com.baidu.tbadk.core.view;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ k acl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.acl = kVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.acl.uU();
    }
}
