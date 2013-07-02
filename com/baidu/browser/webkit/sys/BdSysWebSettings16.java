package com.baidu.browser.webkit.sys;

import android.util.Log;
import android.webkit.WebSettings;
/* loaded from: classes.dex */
public class BdSysWebSettings16 extends BdSysWebSettings {
    private static final boolean DEBUG = true;
    private static final String LOG_TAG = "BdSysWebSettings16";

    public BdSysWebSettings16(WebSettings webSettings) {
        super(webSettings);
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebSettings
    public void setWorkersEnabled(boolean z) {
        Log.w(LOG_TAG, "setWorkersEnabled not support in Api 16.");
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebSettings
    public void setPageCacheCapacity(int i) {
        Log.w(LOG_TAG, "setPageCacheCapacity not support in Api 16.");
    }
}
