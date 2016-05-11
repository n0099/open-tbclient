package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BdBaseFragmentActivity dp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdBaseFragmentActivity bdBaseFragmentActivity) {
        this.dp = bdBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dp.onPreLoad(this.dp.onGetPreLoadListView());
    }
}
