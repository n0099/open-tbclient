package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BaseWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseWebViewActivity baseWebViewActivity) {
        this.this$0 = baseWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.refresh();
    }
}
