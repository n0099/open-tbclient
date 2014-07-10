package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ BdBaseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdBaseActivity bdBaseActivity) {
        this.a = bdBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onPreLoad(this.a.onGetPreLoadListView());
    }
}
