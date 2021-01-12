package com.baidu.live.view.web;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes10.dex */
public class CommonWebView extends WebView {
    private boolean bSb;
    private boolean bSc;
    private boolean bSd;

    public CommonWebView(Context context) {
        super(context);
        init();
    }

    public void setRequestDisallowInterceptTouchEvent(boolean z) {
        this.bSb = z;
    }

    public void setVerticalScrollEnabled(boolean z) {
        this.bSc = z;
    }

    public void setHorizontalScrollEnabled(boolean z) {
        this.bSd = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(this.bSb);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.bSd && super.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.bSc && super.canScrollVertically(i);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (!this.bSc && !this.bSd) {
            scrollTo(0, 0);
        } else if (!this.bSc) {
            scrollTo(i, 0);
        } else if (!this.bSd) {
            scrollTo(0, i2);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        i.R(getContext(), str);
        i.S(getContext(), str);
        super.loadUrl(str);
    }

    private void init() {
        this.bSb = true;
        this.bSc = true;
        this.bSd = true;
        setBackgroundColor(0);
        if (getBackground() != null) {
            getBackground().setAlpha(0);
        }
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
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
            ExtraParamsManager.syncWebCookie();
        }
    }
}
