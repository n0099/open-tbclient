package com.baidu.tbadk.browser;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
/* loaded from: classes.dex */
class o implements DownloadListener {
    final /* synthetic */ TbWebViewActivity Bj;

    private o(TbWebViewActivity tbWebViewActivity) {
        this.Bj = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(TbWebViewActivity tbWebViewActivity, o oVar) {
        this(tbWebViewActivity);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.Bj.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
