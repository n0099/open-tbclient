package com.baidu.browser.sailor;

import com.baidu.webkit.sdk.WebSettings;
/* loaded from: classes2.dex */
public class g {
    private WebSettings VO;

    /* loaded from: classes2.dex */
    protected class a implements j {
        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
        }

        @Override // com.baidu.browser.sailor.j
        public synchronized void aF(boolean z) {
            g.this.VO.setPlayVideoInFullScreenMode(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(WebSettings webSettings) {
        this.VO = webSettings;
    }

    public void aD(boolean z) {
        if (this.VO != null) {
            this.VO.setBackForwardAnimationEnable(z);
        }
    }

    public void aE(boolean z) {
        this.VO.setEnableJsPrompt(z);
    }

    public void cw(String str) {
        this.VO.setWebViewFrameName(str);
    }

    public synchronized String getUserAgentString() {
        return this.VO.getUserAgentString();
    }

    public boolean qy() {
        if (this.VO != null) {
            return this.VO.getBackForwardAnimationEnable();
        }
        return false;
    }

    public String qz() {
        return this.VO.getWebViewFrameName();
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (this.VO != null) {
            this.VO.setAllowUniversalAccessFromFileURLs(z);
        }
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        this.VO.setAppCacheEnabled(z);
    }

    public synchronized void setAppCachePath(String str) {
        this.VO.setAppCachePath(str);
    }

    public void setBuiltInZoomControls(boolean z) {
        if (this.VO != null) {
            this.VO.setBuiltInZoomControls(z);
        }
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        this.VO.setDatabaseEnabled(z);
    }

    public synchronized void setDatabasePath(String str) {
        this.VO.setDatabasePath(str);
    }

    public void setDisplayZoomControls(boolean z) {
        if (this.VO != null) {
            this.VO.setDisplayZoomControls(z);
        }
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        this.VO.setDomStorageEnabled(z);
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        this.VO.setGeolocationDatabasePath(str);
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        if (this.VO != null) {
            this.VO.setJavaScriptEnabled(z);
        }
    }

    public void setLightTouchEnabled(boolean z) {
        this.VO.setLightTouchEnabled(z);
    }

    public void setLoadWithOverviewMode(boolean z) {
        this.VO.setLoadWithOverviewMode(z);
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        if (this.VO != null) {
            this.VO.setLoadsImagesAutomatically(z);
        }
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (this.VO != null) {
            this.VO.setMediaPlaybackRequiresUserGesture(z);
        }
    }

    public void setMixedContentMode(int i) {
        if (this.VO != null) {
            this.VO.setMixedContentMode(i);
        }
    }

    public void setNeedInitialFocus(boolean z) {
        this.VO.setNeedInitialFocus(z);
    }

    public synchronized void setPageCacheCapacity(int i) {
        this.VO.setPageCacheCapacity(i);
    }

    public synchronized void setPluginState(WebSettings.PluginState pluginState) {
        this.VO.setPluginState(pluginState);
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        this.VO.setSupportMultipleWindows(z);
    }

    public void setSupportZoom(boolean z) {
        if (this.VO != null) {
            this.VO.setSupportZoom(z);
        }
    }

    public synchronized void setTextZoom(int i) {
        this.VO.setTextZoom(i);
    }

    public synchronized void setUseWideViewPort(boolean z) {
        this.VO.setUseWideViewPort(z);
    }

    public synchronized void setUserAgentString(String str) {
        this.VO.setUserAgentString(str);
    }
}
