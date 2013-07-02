package com.baidu.browser.webkit.sys;

import android.util.Log;
import android.webkit.WebSettings;
/* loaded from: classes.dex */
public class BdSysWebSettings8 extends BdSysWebSettings {
    private static final boolean DEBUG = true;
    private static final String LOG_TAG = "BdSysWebSettings8";

    public BdSysWebSettings8(WebSettings webSettings) {
        super(webSettings);
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebSettings
    public void setDisplayZoomControls(boolean z) {
        Log.w(LOG_TAG, "setDisplayZoomControls not support in Api 7.");
    }
}
