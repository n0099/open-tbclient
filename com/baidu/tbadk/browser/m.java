package com.baidu.tbadk.browser;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class m extends WebChromeClient {
    final /* synthetic */ TbWebViewActivity NJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbWebViewActivity tbWebViewActivity) {
        this.NJ = tbWebViewActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        quotaUpdater.updateQuota(2 * j2);
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.NJ.getPageContext().getPageActivity());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }
}
