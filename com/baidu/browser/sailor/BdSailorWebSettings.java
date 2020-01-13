package com.baidu.browser.sailor;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import com.baidu.webkit.sdk.dumper.ZeusLogRecorder;
import com.baidu.webkit.sdk.jschecker.BdJsCheckPolicy;
/* loaded from: classes10.dex */
public class BdSailorWebSettings implements INoProGuard {
    private static boolean lastNightModeEnabled = false;
    private static BdJsCheckPolicy sDefaultJsCheckPolicy;
    private WebSettings mWebSettings;

    /* loaded from: classes10.dex */
    protected class BdSailorWebSettingsExt implements ISailorWebSettingsExt {
        private static final String ENABLE_LOG_RECORD = "enable_log_record";

        /* JADX INFO: Access modifiers changed from: protected */
        public BdSailorWebSettingsExt() {
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getAdBlockEnabledExt() {
            return BdSailorWebSettings.this.mWebSettings.getADblockEnabled();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getCustomFocusEnabledExt() {
            return BdSailorWebSettings.this.mWebSettings.getCustomFocusEnabled();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getEnableFileSchemaOnPrivate() {
            return BdSailorWebSettings.this.mWebSettings.getEnableFileSchemaOnPrivate();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getEnableVSyncOpt() {
            return BdSailorWebSettings.this.mWebSettings.getEnableVSyncOpt();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized float getFastFlingDampFactorExt() {
            return BdSailorWebSettings.this.mWebSettings.getFastFlingDampFactor();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized WebSettings.FlingAlgorithm getFlingAlgorithmExt() {
            return BdSailorWebSettings.this.mWebSettings.getFlingAlgorithm();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getHookH5NavigationEnabled() {
            return BdSailorWebSettings.this.mWebSettings.getHookH5NavigationEnabled();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getHtml5VideoEnabledExt() {
            return BdSailorWebSettings.this.mWebSettings.getHtml5VideoEnabled();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getMagicFilterEnabledExt() {
            return BdSailorWebSettings.this.mWebSettings.getMagicFilterEnabledExt();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getNightModeEnabledExt() {
            return BdSailorWebSettings.this.mWebSettings.getNightModeEnabled();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized boolean getPauseAudioEnabledExt() {
            return BdSailorWebSettings.this.mWebSettings.getPauseAudioEnabled();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized boolean getPlayVideoInFullScreenModeExt() {
            return BdSailorWebSettings.this.mWebSettings.getPlayVideoInFullScreenMode();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getPrerenderEnabledExt() {
            return BdSailorWebSettings.this.mWebSettings.getPrerenderEnabled();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getShowUnderLineExt() {
            return false;
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized boolean getUrlSecurityCheckEnabledExt() {
            return BdSailorWebSettings.this.mWebSettings.getUrlSecurityCheckEnabled();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized boolean getUseGLRenderingExt() {
            return BdSailorWebSettings.this.mWebSettings.getUseGLRendering();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getUseScaleStoreExt() {
            return BdSailorWebSettings.this.mWebSettings.getUseScaleStore();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean getUserSelectEnabled() {
            return BdSailorWebSettings.this.mWebSettings.getUserSelectEnabled();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean isFullScreenMode() {
            return BdSailorWebSettings.this.mWebSettings.isFullScreenMode();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean isLPLoadingAnimationEnable() {
            return BdSailorWebSettings.this.mWebSettings.isLPLoadingAnimationEnable();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean isLoadingAnimationEnable() {
            return BdSailorWebSettings.this.mWebSettings.isLoadingAnimationEnable();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public boolean isSkeletonEnable() {
            return BdSailorWebSettings.this.mWebSettings.getSkeletonViewEnable();
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setAdBlockEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setADblockEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setAntiHackInfoEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setAntiHackInfoEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setCustomFocusEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setCustomFocusEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableFileSchemaOnPrivate(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setEnableFileSchemaOnPrivate(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableLPLoadingAnimation(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setEnableLPLoadingAnimation(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableLoadingAnimation(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setEnableLoadingAnimation(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableSkeletonView(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setSkeletonViewEnable(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setEnableVSyncOpt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setEnableVSyncOpt(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setFastFlingDampFactorExt(float f) {
            BdSailorWebSettings.this.mWebSettings.setFastFlingDampFactor(f);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setFeatureDatabasePathExt(String str) {
            BdSailorWebSettings.this.mWebSettings.setFeatureDatabasePath(str);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setFeedNewsFirstScreenOptEnabledEX(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setFeedNewsFirstScreenOptEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setFlingAlgorithmExt(WebSettings.FlingAlgorithm flingAlgorithm) {
            BdSailorWebSettings.this.mWebSettings.setFlingAlgorithm(flingAlgorithm);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setFullScreenMode(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setFullScreenMode(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setHookH5NavigationEnabled(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setHookH5NavigationEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setHtml5VideoEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setHtml5VideoEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setImageMaxWidthExt(int i) {
            BdSailorWebSettings.this.mWebSettings.setImageMaxWidth(i);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setImagesEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setImagesEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setMagicFilterEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setMagicFilterEnabledExt(z);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
            if (com.baidu.browser.sailor.BdSailorWebSettings.lastNightModeEnabled == r4) goto L32;
         */
        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void setNightModeEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setNightModeEnabled(z);
            if (WebSettingsGlobalBlink.GetCloudSettingsValue(ENABLE_LOG_RECORD) == null || !WebSettingsGlobalBlink.GetCloudSettingsValue(ENABLE_LOG_RECORD).equals("true")) {
                return;
            }
            Log.i("zwsettings.setNightMode", z + HanziToPinyin.Token.SEPARATOR + BdSailorWebSettings.lastNightModeEnabled);
            if (!z || BdSailorWebSettings.lastNightModeEnabled == z) {
                synchronized (BdSailorWebSettings.class) {
                    if (z) {
                    }
                    boolean unused = BdSailorWebSettings.lastNightModeEnabled = z;
                }
                return;
            }
            synchronized (BdSailorWebSettings.class) {
                if (z) {
                    if (BdSailorWebSettings.lastNightModeEnabled != z) {
                        boolean unused2 = BdSailorWebSettings.lastNightModeEnabled = z;
                    }
                }
            }
            try {
                ZeusLogRecorder.getInstance().initAndUpload();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setPauseAudioEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setPauseAudioEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setPlayVideoInFullScreenModeExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setPlayVideoInFullScreenMode(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setPrerenderEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setPrerenderEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setSafePageEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setSafePageEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setShouldDispatchBeforeunloadEX(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setShouldDispatchBeforeunload(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setShowUnderLineExt(boolean z) {
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setShrinksStandaloneImagesToFitExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setShrinksStandaloneImagesToFit(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setUrlSecurityCheckEnabledExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setUrlSecurityCheckEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public synchronized void setUseGLRenderingExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setUseGLRendering(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setUseScaleStoreExt(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setUseScaleStore(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setUserSelectEnabled(boolean z) {
            BdSailorWebSettings.this.mWebSettings.setUserSelectEnabled(z);
        }

        @Override // com.baidu.browser.sailor.ISailorWebSettingsExt
        public void setWiseSearchFirstScreenOptTypeEX(int i) {
            BdSailorWebSettings.this.mWebSettings.setWiseSearchFirstScreenOptType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BdSailorWebSettings(WebSettings webSettings) {
        this.mWebSettings = webSettings;
    }

    public static void clearNetworkFlowExt() {
    }

    public static synchronized void clearSavingBytesExt() {
        synchronized (BdSailorWebSettings.class) {
        }
    }

    public static BdJsCheckPolicy getDefaultJsCheckPolicy() {
        try {
            if (WebViewFactory.hasProvider()) {
                Object staticWebSeting = WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_CHECK_POLICY);
                if (staticWebSeting instanceof BdJsCheckPolicy) {
                    return (BdJsCheckPolicy) staticWebSeting;
                }
                return null;
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:" + th);
        }
        return null;
    }

    public static boolean getEnableOverSeasExt() {
        return false;
    }

    public static boolean getEnableProxyExt() {
        return false;
    }

    public static boolean getEnableSpdyExt() {
        try {
            if (WebViewFactory.hasProvider()) {
                return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY)).booleanValue();
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "getEnableSpdyExt error:" + th);
        }
        return false;
    }

    public static boolean getGifOneFrameEnabledExt() {
        try {
            if (WebViewFactory.hasProvider()) {
                return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME)).booleanValue();
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "getGifOneFrameEnabledExt error:" + th);
        }
        return false;
    }

    public static int getNetworkFlowExt() {
        return 0;
    }

    public static boolean getSaveNetworkTrafficExt() {
        return false;
    }

    public static int getSavingBytesExt() {
        return 0;
    }

    public static boolean getSpdyNPNEnabled() {
        return false;
    }

    public static boolean isNA2WebEnable() {
        try {
            if (WebViewFactory.hasProvider()) {
                return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_NA2_WEB_ENABLE)).booleanValue();
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "getEnableSpdyExt error:" + th);
        }
        return false;
    }

    public static void setDefaultEnableJsPromptSailor(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_ENABLE_JS_PROMPT, new Boolean(z));
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:" + th);
        }
    }

    public static void setDefaultJsCheckPolicySailor(BdJsCheckPolicy bdJsCheckPolicy) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_JS_CHECK_POLICY, bdJsCheckPolicy);
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:" + th);
        }
    }

    public static void setEnableNA2Web(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_NA2_WEB_ENABLE, Boolean.valueOf(z));
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:" + th);
        }
    }

    public static void setEnableOverSeasProxyExt(boolean z) {
    }

    public static void setEnableProxyExt(boolean z) {
    }

    public static void setEnableSpdyExt(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY, new Boolean(z));
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "setEnableSpdyExt error:" + th);
        }
    }

    public static void setGifOneFrameEnabledExt(boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME, new Boolean(z));
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "setGifOneFrameEnabledExt error:" + th);
        }
    }

    public static void setHijackEnv(boolean z) {
    }

    public static void setNavigationInterceptionEnable(boolean z) {
    }

    public static void setSaveNetworkTrafficExt(boolean z) {
    }

    public static void setSpdyNPNEnabled(boolean z) {
    }

    public boolean enableSmoothTransition() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.enableSmoothTransition();
        }
        return false;
    }

    public boolean getAllowContentAccess() {
        return this.mWebSettings.getAllowFileAccess();
    }

    public boolean getAllowFileAccess() {
        return this.mWebSettings.getAllowFileAccess();
    }

    public boolean getAllowFileAccessFromFileURLs() {
        return this.mWebSettings.getAllowFileAccessFromFileURLs();
    }

    public boolean getAllowUniversalAccessFromFileURLs() {
        return this.mWebSettings.getAllowUniversalAccessFromFileURLs();
    }

    public synchronized boolean getBlockNetworkImage() {
        return this.mWebSettings != null ? this.mWebSettings.getBlockNetworkImage() : false;
    }

    public synchronized boolean getBlockNetworkLoads() {
        return this.mWebSettings != null ? this.mWebSettings.getBlockNetworkLoads() : false;
    }

    public boolean getBuiltInZoomControls() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.getBuiltInZoomControls();
        }
        return false;
    }

    public int getCacheMode() {
        return this.mWebSettings.getCacheMode();
    }

    public synchronized String getCursiveFontFamily() {
        return this.mWebSettings.getCursiveFontFamily();
    }

    public synchronized boolean getDatabaseEnabled() {
        return this.mWebSettings.getDatabaseEnabled();
    }

    public synchronized String getDatabasePath() {
        return this.mWebSettings.getDatabasePath();
    }

    public synchronized int getDefaultFixedFontSize() {
        return this.mWebSettings != null ? this.mWebSettings.getDefaultFixedFontSize() : 1;
    }

    public synchronized int getDefaultFontSize() {
        return this.mWebSettings != null ? this.mWebSettings.getDefaultFontSize() : 1;
    }

    public synchronized String getDefaultTextEncodingName() {
        return this.mWebSettings.getDefaultTextEncodingName();
    }

    public WebSettings.ZoomDensity getDefaultZoom() {
        return WebSettings.ZoomDensity.MEDIUM;
    }

    public boolean getDisplayZoomControls() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.getDisplayZoomControls();
        }
        return false;
    }

    public synchronized boolean getDomStorageEnabled() {
        return this.mWebSettings.getDomStorageEnabled();
    }

    public boolean getEnableJsPromptSailor() {
        return this.mWebSettings.getEnableJsPrompt();
    }

    public synchronized String getFantasyFontFamily() {
        return this.mWebSettings.getFantasyFontFamily();
    }

    public synchronized String getFixedFontFamily() {
        return this.mWebSettings.getFixedFontFamily();
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.mWebSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized boolean getJavaScriptEnabled() {
        return this.mWebSettings.getJavaScriptEnabled();
    }

    public synchronized WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.mWebSettings.getLayoutAlgorithm();
    }

    public boolean getLightTouchEnabled() {
        return this.mWebSettings.getLightTouchEnabled();
    }

    public boolean getLoadWithOverviewMode() {
        return this.mWebSettings.getLoadsImagesAutomatically();
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        return this.mWebSettings != null ? this.mWebSettings.getLoadsImagesAutomatically() : false;
    }

    public boolean getMediaPlaybackRequiresUserGesture() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.getMediaPlaybackRequiresUserGesture();
        }
        return true;
    }

    public synchronized int getMinimumFontSize() {
        return this.mWebSettings.getMinimumFontSize();
    }

    public synchronized int getMinimumLogicalFontSize() {
        return this.mWebSettings.getMinimumLogicalFontSize();
    }

    public int getMixedContentMode() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.getMixedContentMode();
        }
        return 0;
    }

    public synchronized String getSansSerifFontFamily() {
        return this.mWebSettings.getSansSerifFontFamily();
    }

    public boolean getSaveFormData() {
        return this.mWebSettings.getSaveFormData();
    }

    public boolean getSavePassword() {
        return this.mWebSettings.getSavePassword();
    }

    public synchronized String getSerifFontFamily() {
        return this.mWebSettings.getSerifFontFamily();
    }

    public synchronized String getStandardFontFamily() {
        return this.mWebSettings.getStandardFontFamily();
    }

    public synchronized int getTextZoom() {
        return this.mWebSettings.getTextZoom();
    }

    public synchronized boolean getUseWideViewPort() {
        return this.mWebSettings.getUseWideViewPort();
    }

    public synchronized String getUserAgentString() {
        return this.mWebSettings.getUserAgentString();
    }

    public String getWebViewFrameNameSailor() {
        return this.mWebSettings.getWebViewFrameName();
    }

    public boolean isGestrueBackForwardEnabled() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.getBackForwardAnimationEnable();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isGestrueBackForwardEnabledInternal() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.getBackForwardAnimationEnableInternal();
        }
        return false;
    }

    public void setAllowContentAccess(boolean z) {
        this.mWebSettings.setAllowFileAccess(z);
    }

    public void setAllowFileAccess(boolean z) {
        this.mWebSettings.setAllowFileAccess(z);
    }

    public void setAllowFileAccessFromFileURLs(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setAllowFileAccess(z);
        }
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setAllowUniversalAccessFromFileURLs(z);
        }
    }

    public synchronized void setAppCacheEnabled(boolean z) {
        this.mWebSettings.setAppCacheEnabled(z);
    }

    public synchronized void setAppCacheMaxSize(long j) {
        this.mWebSettings.setAppCacheMaxSize(j);
    }

    public synchronized void setAppCachePath(String str) {
        this.mWebSettings.setAppCachePath(str);
    }

    public void setBackForwardGesture(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setBackForwardAnimationEnable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackForwardGestureInternal(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setBackForwardAnimationEnableInternal(z);
        }
    }

    public synchronized void setBlockNetworkImage(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setBlockNetworkImage(z);
        }
    }

    public synchronized void setBlockNetworkLoads(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setBlockNetworkLoads(z);
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setBuiltInZoomControls(z);
        }
    }

    public void setCacheMode(int i) {
        this.mWebSettings.setCacheMode(i);
    }

    public synchronized void setCodeCacheSetting(WebSettings.CodeCacheSetting codeCacheSetting) {
        this.mWebSettings.setCodeCacheSetting(codeCacheSetting);
    }

    public synchronized void setCursiveFontFamily(String str) {
        this.mWebSettings.setCursiveFontFamily(str);
    }

    public synchronized void setDatabaseEnabled(boolean z) {
        this.mWebSettings.setDatabaseEnabled(z);
    }

    public synchronized void setDatabasePath(String str) {
        this.mWebSettings.setDatabasePath(str);
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setDefaultFontSize(i);
        }
    }

    public synchronized void setDefaultFontSize(int i) {
        this.mWebSettings.setDefaultFontSize(i);
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        this.mWebSettings.setDefaultTextEncodingName(str);
    }

    public void setDefaultZoom(WebSettings.ZoomDensity zoomDensity) {
        this.mWebSettings.setDefaultZoom(zoomDensity);
    }

    public void setDisplayZoomControls(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setDisplayZoomControls(z);
        }
    }

    public synchronized void setDomStorageEnabled(boolean z) {
        this.mWebSettings.setDomStorageEnabled(z);
    }

    public void setEnableJsPromptSailor(boolean z) {
        this.mWebSettings.setEnableJsPrompt(z);
    }

    public void setEnableSmoothTransition(boolean z) {
        this.mWebSettings.setEnableSmoothTransition(z);
    }

    public synchronized void setFantasyFontFamily(String str) {
        this.mWebSettings.setFantasyFontFamily(str);
    }

    public synchronized void setFixedFontFamily(String str) {
        this.mWebSettings.setFixedFontFamily(str);
    }

    public synchronized void setGeolocationDatabasePath(String str) {
        this.mWebSettings.setGeolocationDatabasePath(str);
    }

    public void setGeolocationEnabled(boolean z) {
        this.mWebSettings.setGeolocationEnabled(z);
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.mWebSettings.setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public synchronized void setJavaScriptEnabled(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setJavaScriptEnabled(z);
        }
    }

    public synchronized void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        this.mWebSettings.setLayoutAlgorithm(layoutAlgorithm);
    }

    public void setLightTouchEnabled(boolean z) {
        this.mWebSettings.setLightTouchEnabled(z);
    }

    public void setLoadWithOverviewMode(boolean z) {
        this.mWebSettings.setLoadWithOverviewMode(z);
    }

    public synchronized void setLoadsImagesAutomatically(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setLoadsImagesAutomatically(z);
        }
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setMediaPlaybackRequiresUserGesture(z);
        }
    }

    public synchronized void setMinimumFontSize(int i) {
        this.mWebSettings.setMinimumFontSize(i);
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        this.mWebSettings.setMinimumLogicalFontSize(i);
    }

    public void setMixedContentMode(int i) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setMixedContentMode(i);
        }
    }

    public void setNeedInitialFocus(boolean z) {
        this.mWebSettings.setNeedInitialFocus(z);
    }

    public synchronized void setPageCacheCapacity(int i) {
        this.mWebSettings.setPageCacheCapacity(i);
    }

    public synchronized void setPluginState(WebSettings.PluginState pluginState) {
        this.mWebSettings.setPluginState(pluginState);
    }

    public synchronized void setPrivateBrowsingEnabled(boolean z) {
        this.mWebSettings.setPrivateBrowsingEnabled(z);
    }

    public synchronized void setRenderPriority(WebSettings.RenderPriority renderPriority) {
        this.mWebSettings.setRenderPriority(renderPriority);
    }

    public synchronized void setSansSerifFontFamily(String str) {
        this.mWebSettings.setSansSerifFontFamily(str);
    }

    public void setSaveFormData(boolean z) {
        this.mWebSettings.setSaveFormData(z);
    }

    public void setSavePassword(boolean z) {
        this.mWebSettings.setSavePassword(z);
    }

    public synchronized void setSerifFontFamily(String str) {
        this.mWebSettings.setSerifFontFamily(str);
    }

    public synchronized void setStandardFontFamily(String str) {
        this.mWebSettings.setStandardFontFamily(str);
    }

    public synchronized void setSupportMultipleWindows(boolean z) {
        this.mWebSettings.setSupportMultipleWindows(z);
    }

    public void setSupportZoom(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setSupportZoom(z);
        }
    }

    public synchronized void setTextZoom(int i) {
        this.mWebSettings.setTextZoom(i);
    }

    public synchronized void setUseWideViewPort(boolean z) {
        this.mWebSettings.setUseWideViewPort(z);
    }

    public synchronized void setUserAgentString(String str) {
        this.mWebSettings.setUserAgentString(str);
    }

    protected void setWebSettings(WebSettings webSettings) {
        if (webSettings != null) {
            this.mWebSettings = webSettings;
        }
    }

    public void setWebViewFrameNameSailor(String str) {
        this.mWebSettings.setWebViewFrameName(str);
    }

    public void setZeusMutedEnable(boolean z) {
        if (this.mWebSettings != null) {
            this.mWebSettings.setZeusMutedEnable(z);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        return this.mWebSettings.supportMultipleWindows();
    }

    public boolean supportZoom() {
        if (this.mWebSettings != null) {
            return this.mWebSettings.supportZoom();
        }
        return false;
    }
}
