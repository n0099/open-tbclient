package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ BdBaseActivity dR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdBaseActivity bdBaseActivity) {
        this.dR = bdBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dR.onPreLoad(this.dR.onGetPreLoadListView());
    }
}
