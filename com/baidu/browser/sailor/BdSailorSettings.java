package com.baidu.browser.sailor;

import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes.dex */
public final class BdSailorSettings implements INoProGuard {
    public boolean mDebugEnable;
    public String mEmulatedUA;
    public boolean mIsGifFirstFrameOnly;
    public boolean mNightMode;
    public boolean mOpenEyeShieldMode;
    public boolean mOpenOverSeasProxy;
    public boolean mOpenSpdy;
    public String mSafeCheck;
    public boolean mUaEmulate;
    public boolean mIsAllowTransCode = false;
    public boolean mIsAllowTransLang = true;
    public boolean mAdBlockEnable = false;
    public boolean mSaveFlow = true;
    public boolean mImageViewer = true;
    public boolean mUrlSecureCheck = true;
    public boolean mSailorMonitorEnable = true;

    private boolean getStaticWebSeting(String str) {
        try {
            if (WebViewFactory.hasProvider()) {
                return ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(str)).booleanValue();
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Throwable th) {
            String str2 = Log.LOG_TAG;
            Log.e(str2, "getStaticWebSeting error:" + th);
            return false;
        }
    }

    private void setStaticWebSeting(String str, boolean z) {
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(str, new Boolean(z));
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            String str2 = Log.LOG_TAG;
            Log.e(str2, "setDefaultEnableJsPromptSailor error:" + th);
        }
    }

    public final String getEmulatedUA() {
        try {
            return WebViewFactory.hasProvider() ? (String) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_UA_EMULATE) : "";
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return "";
        } catch (Throwable th) {
            String str = Log.LOG_TAG;
            Log.e(str, "getStaticWebSeting error:" + th);
            return "";
        }
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
        if (this.mOpenSpdy) {
            proxyType = this.mOpenOverSeasProxy ? WebSettings.ProxyType.SPDYANDOVERSEAS_PROXY : WebSettings.ProxyType.SPDY_PROXY;
        } else if (this.mOpenOverSeasProxy) {
            proxyType = WebSettings.ProxyType.OVERSEAS_PROXY;
        }
        try {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().setStaticWebSeting(WebViewFactoryProvider.SETTING_PROXY_TYPE, new Integer(proxyType.ordinal()));
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            String str = Log.LOG_TAG;
            Log.e(str, "setDefaultEnableJsPromptSailor error:" + th);
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
        z = (networkType == 1 || -1 == networkType) ? false : false;
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
