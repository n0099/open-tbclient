package com.baidu.browser.sailor;

import com.baidu.webkit.sdk.WebSettings;
/* loaded from: classes2.dex */
public class g {
    private WebSettings VF;

    /* loaded from: classes2.dex */
    protected class a implements j {
        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
        }

        @Override // com.baidu.browser.sailor.j
        public synchronized void aF(boolean z) {
            g.this.VF.setPlayVideoInFullScreenMode(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(WebSettings webSettings) {
        this.VF = webSettings;
    }

    public void aD(boolean z) {
        if (this.VF != null) {
            this.VF.setBackForwardAnimationEnable(z);
        }
    }

    public void aE(boolean z) {
        this.VF.setEnableJsPrompt(z);
    }

    public void cv(String str) {
        this.VF.setWebViewFrameName(str);
    }

    public synchronized String getUserAgentString() {
        return this.VF.getUserAgentString();
    }

    public boolean qv() {
        if (this.VF != null) {
            return this.VF.getBackForwardAnimationEnable();
        }
        return false;
    }

    public String qw() {
        return this.VF.getWebViewFrameName();
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (this.VF != null) {
            this.VF.setAllowUniversalAccessFromFileURLs(z);
        }
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        this.VF.setAppCacheEnabled(z);
    }

    public synchronized void setAppCachePath(String str) {
        this.VF.setAppCachePath(str);
    }

    public void setBuiltInZoomControls(boolean z) {
        if (this.VF != null) {
            this.VF.setBuiltInZoomControls(z);
        }
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        this.VF.setDatabaseEnabled(z);
    }

    public synchronized void setDatabasePath(String str) {
        this.VF.setDatabasePath(str);
    }

    public void setDisplayZoomControls(boolean z) {
        if (this.VF != null) {
            this.VF.setDisplayZoomControls(z);
        }
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        this.VF.setDomStorageEnabled(z);
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        this.VF.setGeolocationDatabasePath(str);
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        if (this.VF != null) {
            this.VF.setJavaScriptEnabled(z);
        }
    }

    public void setLightTouchEnabled(boolean z) {
        this.VF.setLightTouchEnabled(z);
    }

    public void setLoadWithOverviewMode(boolean z) {
        this.VF.setLoadWithOverviewMode(z);
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        if (this.VF != null) {
            this.VF.setLoadsImagesAutomatically(z);
        }
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (this.VF != null) {
            this.VF.setMediaPlaybackRequiresUserGesture(z);
        }
    }

    public void setMixedContentMode(int i) {
        if (this.VF != null) {
            this.VF.setMixedContentMode(i);
        }
    }

    public void setNeedInitialFocus(boolean z) {
        this.VF.setNeedInitialFocus(z);
    }

    public synchronized void setPageCacheCapacity(int i) {
        this.VF.setPageCacheCapacity(i);
    }

    public synchronized void setPluginState(WebSettings.PluginState pluginState) {
        this.VF.setPluginState(pluginState);
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        this.VF.setSupportMultipleWindows(z);
    }

    public void setSupportZoom(boolean z) {
        if (this.VF != null) {
            this.VF.setSupportZoom(z);
        }
    }

    public synchronized void setTextZoom(int i) {
        this.VF.setTextZoom(i);
    }

    public synchronized void setUseWideViewPort(boolean z) {
        this.VF.setUseWideViewPort(z);
    }

    public synchronized void setUserAgentString(String str) {
        this.VF.setUserAgentString(str);
    }
}
