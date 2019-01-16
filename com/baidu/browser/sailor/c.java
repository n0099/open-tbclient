package com.baidu.browser.sailor;

import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
/* loaded from: classes2.dex */
public final class c {
    private boolean VF = false;
    private boolean VG = true;
    private boolean VH = false;
    private boolean VI = true;
    private boolean VJ = true;
    private boolean VK = true;
    private boolean VL = true;

    private void k(String str, boolean z) {
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

    public final void aB(boolean z) {
        k(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA, z);
    }

    public final void aC(boolean z) {
        int networkType = com.baidu.browser.sailor.b.a.qS().getNetworkType();
        if (networkType == 1 || -1 == networkType) {
            this.VI = false;
            k(WebViewFactoryProvider.SETTING_SAVE_FLOW, false);
            return;
        }
        this.VI = z;
        k(WebViewFactoryProvider.SETTING_SAVE_FLOW, z);
    }
}
