package com.baidu.browser.webkit.zeus;

import com.baidu.browser.core.BdNoProGuard;
import com.baidu.zeus.WebSettings;
/* loaded from: classes.dex */
public class BdZeusWebSettings implements BdNoProGuard {
    protected WebSettings mWebSettings;

    public BdZeusWebSettings(WebSettings webSettings) {
        this.mWebSettings = webSettings;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdZeusWebSettings) && unwrap() == ((BdZeusWebSettings) obj).unwrap();
    }

    public int hashCode() {
        return this.mWebSettings.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mWebSettings == obj;
    }

    public Object unwrap() {
        return this.mWebSettings;
    }

    public void setNavDump(boolean z) {
        this.mWebSettings.setNavDump(z);
    }

    public boolean getNavDump() {
        return this.mWebSettings.getNavDump();
    }

    public void setSupportZoom(boolean z) {
        this.mWebSettings.setSupportZoom(z);
    }

    public boolean supportZoom() {
        return this.mWebSettings.supportZoom();
    }

    public void setBuiltInZoomControls(boolean z) {
        this.mWebSettings.setBuiltInZoomControls(z);
    }

    public boolean getBuiltInZoomControls() {
        return this.mWebSettings.getBuiltInZoomControls();
    }

    public void setAllowFileAccess(boolean z) {
        this.mWebSettings.setAllowFileAccess(z);
    }

    public boolean getAllowFileAccess() {
        return this.mWebSettings.getAllowFileAccess();
    }

    public void setLoadWithOverviewMode(boolean z) {
        this.mWebSettings.setLoadWithOverviewMode(z);
    }

    public boolean getLoadWithOverviewMode() {
        return this.mWebSettings.getLoadWithOverviewMode();
    }

    public void setSaveFormData(boolean z) {
        this.mWebSettings.setSaveFormData(z);
    }

    public boolean getSaveFormData() {
        return this.mWebSettings.getSaveFormData();
    }

    public void setSavePassword(boolean z) {
        this.mWebSettings.setSavePassword(z);
    }

    public boolean getSavePassword() {
        return this.mWebSettings.getSavePassword();
    }

    public synchronized void setTextSize(WebSettings.TextSize textSize) {
        this.mWebSettings.setTextSize(textSize);
    }

    public synchronized WebSettings.TextSize getTextSize() {
        return this.mWebSettings.getTextSize();
    }

    public void setDefaultZoom(WebSettings.ZoomDensity zoomDensity) {
        this.mWebSettings.setDefaultZoom(zoomDensity);
    }

    public WebSettings.ZoomDensity getDefaultZoom() {
        return this.mWebSettings.getDefaultZoom();
    }

    public void setLightTouchEnabled(boolean z) {
        this.mWebSettings.setLightTouchEnabled(z);
    }

    public boolean getLightTouchEnabled() {
        return this.mWebSettings.getLightTouchEnabled();
    }

    public synchronized void setUseWideViewPort(boolean z) {
        this.mWebSettings.setUseWideViewPort(z);
    }

    public synchronized boolean getUseWideViewPort() {
        return this.mWebSettings.getUseWideViewPort();
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        this.mWebSettings.setSupportMultipleWindows(z);
    }

    public synchronized boolean supportMultipleWindows() {
        return this.mWebSettings.supportMultipleWindows();
    }

    public synchronized void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        this.mWebSettings.setLayoutAlgorithm(layoutAlgorithm);
    }

    public synchronized WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.mWebSettings.getLayoutAlgorithm();
    }

    public synchronized void setStandardFontFamily(String str) {
        this.mWebSettings.setStandardFontFamily(str);
    }

    public synchronized String getStandardFontFamily() {
        return this.mWebSettings.getStandardFontFamily();
    }

    public synchronized void setFixedFontFamily(String str) {
        this.mWebSettings.setFixedFontFamily(str);
    }

    public synchronized String getFixedFontFamily() {
        return this.mWebSettings.getFixedFontFamily();
    }

    public synchronized void setSansSerifFontFamily(String str) {
        this.mWebSettings.setSansSerifFontFamily(str);
    }

    public synchronized String getSansSerifFontFamily() {
        return this.mWebSettings.getSansSerifFontFamily();
    }

    public synchronized void setSerifFontFamily(String str) {
        this.mWebSettings.setSerifFontFamily(str);
    }

    public synchronized String getSerifFontFamily() {
        return this.mWebSettings.getSerifFontFamily();
    }

    public synchronized void setCursiveFontFamily(String str) {
        this.mWebSettings.setCursiveFontFamily(str);
    }

    public synchronized String getCursiveFontFamily() {
        return this.mWebSettings.getCursiveFontFamily();
    }

    public synchronized void setFantasyFontFamily(String str) {
        this.mWebSettings.setFantasyFontFamily(str);
    }

    public synchronized String getFantasyFontFamily() {
        return this.mWebSettings.getFantasyFontFamily();
    }

    public synchronized void setMinimumFontSize(int i) {
        this.mWebSettings.setMinimumFontSize(i);
    }

    public synchronized int getMinimumFontSize() {
        return this.mWebSettings.getMinimumFontSize();
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        this.mWebSettings.setMinimumLogicalFontSize(i);
    }

    public synchronized int getMinimumLogicalFontSize() {
        return this.mWebSettings.getMinimumLogicalFontSize();
    }

    public synchronized void setDefaultFontSize(int i) {
        this.mWebSettings.setDefaultFontSize(i);
    }

    public synchronized int getDefaultFontSize() {
        return this.mWebSettings.getDefaultFontSize();
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        this.mWebSettings.setDefaultFixedFontSize(i);
    }

    public synchronized int getDefaultFixedFontSize() {
        return this.mWebSettings.getDefaultFixedFontSize();
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        this.mWebSettings.setLoadsImagesAutomatically(z);
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        return this.mWebSettings.getLoadsImagesAutomatically();
    }

    public synchronized void setBlockNetworkImage(boolean z) {
        this.mWebSettings.setBlockNetworkImage(z);
    }

    public synchronized boolean getBlockNetworkImage() {
        return this.mWebSettings.getBlockNetworkImage();
    }

    public synchronized void setBlockNetworkLoads(boolean z) {
        this.mWebSettings.setBlockNetworkLoads(z);
    }

    public synchronized boolean getBlockNetworkLoads() {
        return this.mWebSettings.getBlockNetworkLoads();
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        this.mWebSettings.setJavaScriptEnabled(z);
    }

    public synchronized void setPluginState(WebSettings.PluginState pluginState) {
        this.mWebSettings.setPluginState(pluginState);
    }

    public synchronized void setDatabasePath(String str) {
        this.mWebSettings.setDatabasePath(str);
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        this.mWebSettings.setGeolocationDatabasePath(str);
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        this.mWebSettings.setAppCacheEnabled(z);
    }

    public synchronized void setAppCachePath(String str) {
        this.mWebSettings.setAppCachePath(str);
    }

    public synchronized void setAppCacheMaxSize(long j) {
        this.mWebSettings.setAppCacheMaxSize(j);
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        this.mWebSettings.setDatabaseEnabled(z);
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        this.mWebSettings.setDomStorageEnabled(z);
    }

    public synchronized boolean getDomStorageEnabled() {
        return this.mWebSettings.getDomStorageEnabled();
    }

    public synchronized String getDatabasePath() {
        return this.mWebSettings.getDatabasePath();
    }

    public synchronized boolean getDatabaseEnabled() {
        return this.mWebSettings.getDatabaseEnabled();
    }

    public synchronized void setGeolocationEnabled(boolean z) {
        this.mWebSettings.setGeolocationEnabled(z);
    }

    public synchronized boolean getJavaScriptEnabled() {
        return this.mWebSettings.getJavaScriptEnabled();
    }

    public synchronized WebSettings.PluginState getPluginState() {
        return this.mWebSettings.getPluginState();
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.mWebSettings.setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.mWebSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        this.mWebSettings.setDefaultTextEncodingName(str);
    }

    public synchronized String getDefaultTextEncodingName() {
        return this.mWebSettings.getDefaultTextEncodingName();
    }

    public synchronized void setUserAgentString(String str) {
        this.mWebSettings.setUserAgentString(str);
    }

    public synchronized String getUserAgentString() {
        return this.mWebSettings.getUserAgentString();
    }

    public void setNeedInitialFocus(boolean z) {
        this.mWebSettings.setNeedInitialFocus(z);
    }

    public synchronized void setRenderPriority(WebSettings.RenderPriority renderPriority) {
        this.mWebSettings.setRenderPriority(renderPriority);
    }

    public void setCacheMode(int i) {
        this.mWebSettings.setCacheMode(i);
    }

    public int getCacheMode() {
        return this.mWebSettings.getCacheMode();
    }

    public void setWorkersEnabled(boolean z) {
        this.mWebSettings.setWorkersEnabled(z);
    }

    public void setPageCacheCapacity(int i) {
        this.mWebSettings.setPageCacheCapacity(i);
    }

    public void setUseImageLoadProxy(boolean z) {
        this.mWebSettings.setUseImageLoadProxy(z);
    }

    public boolean getUseImageLoadProxy() {
        return this.mWebSettings.useImageLoadProxy();
    }

    public void setUseUnderLine(boolean z) {
        this.mWebSettings.setUseUnderLine(z);
    }

    public boolean getUseUnderLine() {
        return this.mWebSettings.useUnderLine();
    }

    public void setUseGifLoadProxy(boolean z) {
        this.mWebSettings.setUseGifLoadProxy(z);
    }

    public boolean getUseGifLoadProxy() {
        return this.mWebSettings.useGifLoadProxy();
    }

    public void setEnableVideo(boolean z) {
        this.mWebSettings.setEnableVideo(z);
    }

    public boolean getEnableVideo() {
        return this.mWebSettings.getEnableVideo();
    }

    public void setUseScaleStore(boolean z) {
        this.mWebSettings.setUseScaleStore(z);
    }

    public boolean getUseScaleStore() {
        return this.mWebSettings.useScaleStore();
    }

    public void setUseGLRendering(boolean z) {
        this.mWebSettings.setUseGLRendering(z);
    }

    public boolean getUseGLRendering() {
        return this.mWebSettings.getUseGLRendering();
    }

    public void setPreloadEnabled(boolean z) {
        this.mWebSettings.setPreloadEnabled(z);
    }

    public boolean getPreloadEnabled() {
        return this.mWebSettings.preloadEnabled();
    }

    public void setNightModeEnabled(boolean z) {
        this.mWebSettings.setNightModeEnabled(z);
    }

    public boolean getNightModeEnabled() {
        return this.mWebSettings.nightModeEnabled();
    }

    public void setMarkSubjectEnabled(boolean z) {
        this.mWebSettings.setMarkSubjectEnabled(z);
    }

    public boolean getMarkSubjectEnabled() {
        return this.mWebSettings.markSubjectEnabled();
    }

    public void setCollectMainAction(boolean z) {
        this.mWebSettings.setCollectMainAction(z);
    }

    public boolean getCollectMainAction() {
        return this.mWebSettings.collectMainAction();
    }

    public void setImageMaxWidth(int i) {
        this.mWebSettings.setImageMaxWidth(i);
    }

    public void setShrinksStandaloneImagesToFit(boolean z) {
        this.mWebSettings.setShrinksStandaloneImagesToFit(z);
    }

    public void setForcePageCanBeScaled(boolean z) {
        this.mWebSettings.setForcePageCanBeScaled(z);
    }

    public boolean getForcePageCanBeScaled() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.getIsForcePageCanBeScaled();
        }
        return false;
    }

    public void setEnableFlashFullScreenMode(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setEnableFlashFullScreenMode(z);
        }
    }

    public boolean getEnableFlashFullScreenMode() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.getFlashFullScreenMode();
        }
        return false;
    }

    public void setPauseAudioEnabled(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setPauseAudioEnabled(z);
        }
    }

    public boolean getPauseAudioEnabled() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.getPauseAudioEnabled();
        }
        return false;
    }
}
