package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ BaseFragment RX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseFragment baseFragment) {
        this.RX = baseFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.RX.onPreLoad(this.RX.onGetPreLoadListView());
    }
}
