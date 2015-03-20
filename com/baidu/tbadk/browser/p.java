package com.baidu.tbadk.browser;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class p implements DownloadListener {
    final /* synthetic */ TbWebViewActivity Nq;

    private p(TbWebViewActivity tbWebViewActivity) {
        this.Nq = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(TbWebViewActivity tbWebViewActivity, p pVar) {
        this(tbWebViewActivity);
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (!StringUtils.isNull(str)) {
            this.Nq.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }
}
