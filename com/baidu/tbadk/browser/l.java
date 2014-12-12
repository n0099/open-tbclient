package com.baidu.tbadk.browser;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class l extends WebChromeClient {
    final /* synthetic */ TbWebViewActivity Bj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbWebViewActivity tbWebViewActivity) {
        this.Bj = tbWebViewActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        quotaUpdater.updateQuota(2 * j2);
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.Bj.getPageContext().getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }
}
