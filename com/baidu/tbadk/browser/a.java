package com.baidu.tbadk.browser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
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
