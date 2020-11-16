package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes5.dex */
public final class BdSailorSettings implements INoProGuard {
    private boolean mDebugEnable;
    private String mEmulatedUA;
    private boolean mIsGifFirstFrameOnly;
    private boolean mNightMode;
    private boolean mOpenEyeShieldMode;
    private boolean mOpenOverSeasProxy;
    private boolean mOpenSpdy;
    private String mSafeCheck;
    private boolean mUaEmulate;
    private boolean mIsAllowTransCode = false;
    private boolean mIsAllowTransLang = true;
    private boolean mAdBlockEnable = false;
    private boolean mSaveFlow = true;
    private boolean mImageViewer = true;
    private boolean mUrlSecureCheck = true;
    private boolean mSailorMonitorEnable = true;

    private boolean getStaticWebSeting(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(str)).booleanValue();
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "getStaticWebSeting error:" + th);
        }
        return false;
    }

    private void setStaticWebSeting(String str, boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(str, new Boolean(z));
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:" + th);
        }
    }

    public final String getEmulatedUA() {
        try {
            if (WebViewFactory.hasProvider()) {
                return (String) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_UA_EMULATE);
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "getStaticWebSeting error:" + th);
        }
        return "";
    }

    public final boolean getOpenEyeShieldMode() {
        return this.mOpenEyeShieldMode;
    }

    public final String getSafeCheck() {
        return this.mSafeCheck;
    }

    public final boolean getSailorMonitorEnable() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_MONITOR);
    }

    public final boolean isAdBlockEnable() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_AD_BLOCK);
    }

    public final boolean isAllowTransCode() {
        return this.mIsAllowTransCode;
    }

    public final boolean isAllowTransLang() {
        return this.mIsAllowTransLang;
    }

    public final boolean isDebugEnable() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_DEBUG);
    }

    public final boolean isGifFirstFrameOnly() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME);
    }

    public final boolean isJavaScriptEnabledOnFileScheme() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA);
    }

    public final boolean isNightTheme() {
        return this.mNightMode;
    }

    public final boolean isOpenOverSeasProxy() {
        return this.mOpenOverSeasProxy;
    }

    public final boolean isOpenSpdy() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY);
    }

    public final boolean isPageFreezeDisable() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_PAGE_FREEZE);
    }

    public final boolean isSaveFlow() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_SAVE_FLOW);
    }

    public final boolean isUaEmulateOn() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_UA_EMULATE);
    }

    public final boolean isUrlSecureCheck() {
        return getStaticWebSeting(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK);
    }

    public final void setAdBlockEnable(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_AD_BLOCK, z);
    }

    public final void setAllowTransCode(boolean z) {
        this.mIsAllowTransCode = z;
    }

    public final void setAllowTransLang(boolean z) {
        this.mIsAllowTransLang = z;
    }

    public final void setDebugEnable(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_DEBUG, z);
    }

    public final void setEmulatedUA(String str) {
        this.mEmulatedUA = str;
    }

    @Deprecated
    public final void setFixWebViewSecurityHoles(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_FIX_WEBVIEW_HOLES, z);
    }

    public final void setGifFirstFrameOnly(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_GIF_FIRST_FRAME, z);
    }

    public final void setJavaScriptEnabledOnFileScheme(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA, z);
    }

    public final void setNightTheme(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_NIGHT_THEME, z);
        this.mNightMode = z;
        BdSailorPlatform.getInstance().setNightMode(z);
    }

    public final void setNoPicMode(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_NO_IMAGE_MODE, z);
    }

    public final void setOpenEyeShieldMode(boolean z) {
        this.mOpenEyeShieldMode = z;
        setStaticWebSeting(WebViewFactoryProvider.SETTING_EYE_SHIELD_MODE, z);
    }

    public final void setOpenOverSeasProxy(boolean z) {
        this.mOpenOverSeasProxy = z;
    }

    public final void setOpenSpdy(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_SPDY, z);
    }

    public final void setProxyType() {
        WebSettings.ProxyType proxyType = WebSettings.ProxyType.NO_PROXY;
        WebSettings.ProxyType proxyType2 = this.mOpenSpdy ? this.mOpenOverSeasProxy ? WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY : WebSettings.ProxyType.SPDY_PROXY : this.mOpenOverSeasProxy ? WebSettings.ProxyType.OVERSEAS_PROXY : WebSettings.ProxyType.NO_PROXY;
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_PROXY_TYPE, new Integer(proxyType2.ordinal()));
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e(Log.LOG_TAG, "setDefaultEnableJsPromptSailor error:" + th);
        }
    }

    public final void setSafeCheck(String str) {
        this.mSafeCheck = str;
    }

    public final void setSailorMonitorEnable(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_MONITOR, z);
    }

    public final void setSaveFlow(boolean z) {
        int networkType = BdSailorPlatform.getInstance().getNetworkType();
        if (networkType == 1 || -1 == networkType) {
            this.mSaveFlow = false;
            setStaticWebSeting(WebViewFactoryProvider.SETTING_SAVE_FLOW, false);
            return;
        }
        this.mSaveFlow = z;
        setStaticWebSeting(WebViewFactoryProvider.SETTING_SAVE_FLOW, z);
    }

    public final void setUaEmulateOn(boolean z) {
        this.mUaEmulate = z;
    }

    public final void setUrlSecureCheck(boolean z) {
        setStaticWebSeting(WebViewFactoryProvider.SETTING_URL_SAFE_CHECK, z);
    }
}
