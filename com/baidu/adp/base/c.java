package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BdBaseFragmentActivity gd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdBaseFragmentActivity bdBaseFragmentActivity) {
        this.gd = bdBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gd.onPreLoad(this.gd.onGetPreLoadListView());
    }
}
