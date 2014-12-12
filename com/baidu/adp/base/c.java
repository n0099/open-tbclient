package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BdBaseActivity ci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdBaseActivity bdBaseActivity) {
        this.ci = bdBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ci.onPreLoad(this.ci.onGetPreLoadListView());
    }
}
