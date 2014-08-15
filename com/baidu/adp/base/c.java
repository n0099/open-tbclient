package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BdBaseFragmentActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdBaseFragmentActivity bdBaseFragmentActivity) {
        this.a = bdBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onPreLoad(this.a.p_());
    }
}
