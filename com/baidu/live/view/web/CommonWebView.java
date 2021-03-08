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
    private boolean bXv;
    private boolean bXw;
    private boolean bXx;

    public CommonWebView(Context context) {
        super(context);
        init();
    }

    public void setRequestDisallowInterceptTouchEvent(boolean z) {
        this.bXv = z;
    }

    public void setVerticalScrollEnabled(boolean z) {
        this.bXw = z;
    }

    public void setHorizontalScrollEnabled(boolean z) {
        this.bXx = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(this.bXv);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.bXx && super.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.bXw && super.canScrollVertically(i);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (!this.bXw && !this.bXx) {
            scrollTo(0, 0);
        } else if (!this.bXw) {
            scrollTo(i, 0);
        } else if (!this.bXx) {
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
        this.bXv = true;
        this.bXw = true;
        this.bXx = true;
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
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
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
