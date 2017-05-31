package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ BaseFragment RJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaseFragment baseFragment) {
        this.RJ = baseFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.RJ.onPreLoad(this.RJ.onGetPreLoadListView());
    }
}
