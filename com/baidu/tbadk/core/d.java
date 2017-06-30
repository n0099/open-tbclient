package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ BaseFragment RD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseFragment baseFragment) {
        this.RD = baseFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.RD.onPreLoad(this.RD.onGetPreLoadListView());
    }
}
