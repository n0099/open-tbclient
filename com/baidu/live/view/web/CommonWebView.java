package com.baidu.live.view.web;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes6.dex */
public class CommonWebView extends WebView {
    private boolean atA;
    private boolean atz;

    public CommonWebView(Context context) {
        super(context);
        init();
    }

    public void setVerticalScrollEnabled(boolean z) {
        this.atz = z;
    }

    public void setHorizontalScrollEnabled(boolean z) {
        this.atA = z;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (!this.atz && !this.atA) {
            scrollTo(0, 0);
        } else if (!this.atz) {
            scrollTo(i, 0);
        } else if (!this.atA) {
            scrollTo(0, i2);
        }
    }

    private void init() {
        this.atz = true;
        this.atA = true;
        setBackgroundColor(0);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setBlockNetworkImage(false);
        settings.setCacheMode(-1);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setTextZoom(100);
        String userAgent = ExtraParamsManager.getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            settings.setUserAgentString(userAgent);
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            resumeTimers();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            h.aA(getContext());
            h.webLogin(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getCurrentBduss());
        }
    }
}
