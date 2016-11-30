package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BdBaseFragmentActivity gg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdBaseFragmentActivity bdBaseFragmentActivity) {
        this.gg = bdBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gg.onPreLoad(this.gg.onGetPreLoadListView());
    }
}
