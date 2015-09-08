package com.baidu.tbadk.browser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ BaseWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseWebViewActivity baseWebViewActivity) {
        this.this$0 = baseWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.coreExtra.share.f createShareContent;
        createShareContent = this.this$0.createShareContent();
        if (createShareContent != null) {
            this.this$0.mView.a(createShareContent);
        }
    }
}
