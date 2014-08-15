package com.baidu.tbadk.browser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.refresh();
    }
}
