package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ BdBaseActivity gf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdBaseActivity bdBaseActivity) {
        this.gf = bdBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gf.onPreLoad(this.gf.onGetPreLoadListView());
    }
}
