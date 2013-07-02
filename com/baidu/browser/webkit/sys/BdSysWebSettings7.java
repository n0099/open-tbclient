package com.baidu.browser.webkit.sys;

import android.util.Log;
import android.webkit.WebSettings;
/* loaded from: classes.dex */
public class BdSysWebSettings7 extends BdSysWebSettings {
    private static final boolean DEBUG = true;
    private static final String LOG_TAG = "BdSysWebSettings7";

    public BdSysWebSettings7(WebSettings webSettings) {
        super(webSettings);
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebSettings
    public synchronized void setPluginState(WebSettings.PluginState pluginState) {
        Log.w(LOG_TAG, "setPluginState not support in Api 7.");
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebSettings
    public void setDisplayZoomControls(boolean z) {
        Log.w(LOG_TAG, "setDisplayZoomControls not support in Api 7.");
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebSettings
    public void setPageCacheCapacity(int i) {
        Log.w(LOG_TAG, "setPageCacheCapacity not support in Api 7.");
    }
}
