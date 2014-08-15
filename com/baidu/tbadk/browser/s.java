package com.baidu.tbadk.browser;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends WebChromeClient {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        quotaUpdater.updateQuota(2 * j2);
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }
}
