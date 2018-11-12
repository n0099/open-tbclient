package com.baidu.browser.sailor.webkit.loader;

import android.content.Context;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.browser.sailor.webkit.update.BdZeusDownloadHelper;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes2.dex */
public class a implements WebKitFactory.WebkitInstallListener {
    static final String a = a.class.getSimpleName();
    byte b;
    long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, boolean z, int i) {
        WebKitFactory.init(context, context.getPackageName(), com.baidu.browser.sailor.b.a.qP().getCuid());
        WebKitFactory.setApkLibLoadType(z);
        if (BdWebkitManager.a.c == i || BdWebkitManager.a.b == i) {
            WebKitFactory.setEngine(1);
            Log.d(a, "zeus version =" + WebKitFactory.getZeusVersionName());
        } else {
            WebKitFactory.setEngine(0);
            Log.d(a, "zeus version =" + WebKitFactory.getZeusVersionName());
        }
        Log.i(EngineManager.LOG_TAG, "so in=" + WebKitFactory.getZeusVersionName());
        Log.i(EngineManager.LOG_TAG, "so out=" + WebKitFactory.getSdkVersionName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(LoadErrorCode loadErrorCode) {
        com.baidu.browser.sailor.b.a.qQ().a("init-webkit", "Err = " + loadErrorCode.getInt() + loadErrorCode.getString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(LoadErrorCode loadErrorCode) {
        WebKitFactory.setEngine(0);
        com.baidu.browser.sailor.b.a.qR().a(this.b, loadErrorCode);
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallFinish(int i, String str) {
        System.currentTimeMillis();
        Log.i("soar", "the return value of installing kernal is: " + i);
        com.baidu.browser.sailor.util.a.cD("oninstalled: " + i + " targetpath: " + str);
        if (i == 0) {
            if (this.b == 0) {
                a(com.baidu.browser.sailor.b.a.qP().getAppContext(), com.baidu.browser.sailor.b.a.qR().rb(), com.baidu.browser.sailor.b.a.qR().rc());
                if (com.baidu.browser.sailor.util.a.qV()) {
                    com.baidu.browser.sailor.b.a.qR().onLoadZeusSDKSuccess();
                }
            }
            Log.d(a, "install success!");
            com.baidu.browser.sailor.b.a.qR().a(com.baidu.browser.sailor.b.a.qP().getAppContext(), str, this.b);
        } else {
            Log.d(a, "install failed!");
            com.baidu.browser.sailor.b.a.qR().a(this.b, WebKitFactory.getLoadErrorCode());
        }
        BdZeusDownloadHelper.rd();
        com.baidu.browser.sailor.b.a.qR().qZ();
        Log.i(a, "total timecost: " + String.valueOf(System.currentTimeMillis() - this.c));
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallStart() {
    }
}
