package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BdBaseFragmentActivity nu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdBaseFragmentActivity bdBaseFragmentActivity) {
        this.nu = bdBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.nu.onPreLoad(this.nu.onGetPreLoadListView());
    }
}
