package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ BdBaseFragmentActivity ck;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BdBaseFragmentActivity bdBaseFragmentActivity) {
        this.ck = bdBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ck.onPreLoad(this.ck.onGetPreLoadListView());
    }
}
