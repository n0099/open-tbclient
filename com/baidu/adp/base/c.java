package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BdBaseActivity cj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdBaseActivity bdBaseActivity) {
        this.cj = bdBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cj.onPreLoad(this.cj.onGetPreLoadListView());
    }
}
