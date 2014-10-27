package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BdBaseFragmentActivity ax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdBaseFragmentActivity bdBaseFragmentActivity) {
        this.ax = bdBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ax.onPreLoad(this.ax.onGetPreLoadListView());
    }
}
