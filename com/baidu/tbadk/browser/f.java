package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
