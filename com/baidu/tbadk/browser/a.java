package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BaseWebViewActivity Sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseWebViewActivity baseWebViewActivity) {
        this.Sl = baseWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Sl.refresh();
    }
}
