package com.baidu.tbadk.browser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ TbWebViewActivity xA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbWebViewActivity tbWebViewActivity) {
        this.xA = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.xA.refresh();
    }
}
