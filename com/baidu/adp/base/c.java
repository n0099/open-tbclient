package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BdBaseFragmentActivity gf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdBaseFragmentActivity bdBaseFragmentActivity) {
        this.gf = bdBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gf.onPreLoad(this.gf.onGetPreLoadListView());
    }
}
