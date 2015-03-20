package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BaseWebViewActivity Nl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseWebViewActivity baseWebViewActivity) {
        this.Nl = baseWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Nl.refresh();
    }
}
