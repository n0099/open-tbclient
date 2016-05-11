package com.baidu.adp.base;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: do  reason: not valid java name */
    final /* synthetic */ BdBaseActivity f0do;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdBaseActivity bdBaseActivity) {
        this.f0do = bdBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f0do.onPreLoad(this.f0do.onGetPreLoadListView());
    }
}
