package com.baidu.browser.sailor;

import com.baidu.webkit.sdk.WebSettings;
/* loaded from: classes2.dex */
public class g {
    private WebSettings VD;

    /* loaded from: classes2.dex */
    protected class a implements j {
        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
        }

        @Override // com.baidu.browser.sailor.j
        public synchronized void ar(boolean z) {
            g.this.VD.setPlayVideoInFullScreenMode(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(WebSettings webSettings) {
        this.VD = webSettings;
    }

    public void ap(boolean z) {
        if (this.VD != null) {
            this.VD.setBackForwardAnimationEnable(z);
        }
    }

    public void aq(boolean z) {
        this.VD.setEnableJsPrompt(z);
    }

    public void cv(String str) {
        this.VD.setWebViewFrameName(str);
    }

    public synchronized String getUserAgentString() {
        return this.VD.getUserAgentString();
    }

    public boolean qx() {
        if (this.VD != null) {
            return this.VD.getBackForwardAnimationEnable();
        }
        return false;
    }

    public String qy() {
        return this.VD.getWebViewFrameName();
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (this.VD != null) {
            this.VD.setAllowUniversalAccessFromFileURLs(z);
        }
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        this.VD.setAppCacheEnabled(z);
    }

    public synchronized void setAppCachePath(String str) {
        this.VD.setAppCachePath(str);
    }

    public void setBuiltInZoomControls(boolean z) {
        if (this.VD != null) {
            this.VD.setBuiltInZoomControls(z);
        }
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        this.VD.setDatabaseEnabled(z);
    }

    public synchronized void setDatabasePath(String str) {
        this.VD.setDatabasePath(str);
    }

    public void setDisplayZoomControls(boolean z) {
        if (this.VD != null) {
            this.VD.setDisplayZoomControls(z);
        }
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        this.VD.setDomStorageEnabled(z);
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        this.VD.setGeolocationDatabasePath(str);
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        if (this.VD != null) {
            this.VD.setJavaScriptEnabled(z);
        }
    }

    public void setLightTouchEnabled(boolean z) {
        this.VD.setLightTouchEnabled(z);
    }

    public void setLoadWithOverviewMode(boolean z) {
        this.VD.setLoadWithOverviewMode(z);
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        if (this.VD != null) {
            this.VD.setLoadsImagesAutomatically(z);
        }
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (this.VD != null) {
            this.VD.setMediaPlaybackRequiresUserGesture(z);
        }
    }

    public void setMixedContentMode(int i) {
        if (this.VD != null) {
            this.VD.setMixedContentMode(i);
        }
    }

    public void setNeedInitialFocus(boolean z) {
        this.VD.setNeedInitialFocus(z);
    }

    public synchronized void setPageCacheCapacity(int i) {
        this.VD.setPageCacheCapacity(i);
    }

    public synchronized void setPluginState(WebSettings.PluginState pluginState) {
        this.VD.setPluginState(pluginState);
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        this.VD.setSupportMultipleWindows(z);
    }

    public void setSupportZoom(boolean z) {
        if (this.VD != null) {
            this.VD.setSupportZoom(z);
        }
    }

    public synchronized void setTextZoom(int i) {
        this.VD.setTextZoom(i);
    }

    public synchronized void setUseWideViewPort(boolean z) {
        this.VD.setUseWideViewPort(z);
    }

    public synchronized void setUserAgentString(String str) {
        this.VD.setUserAgentString(str);
    }
}
