package com.baidu.browser.sailor.webkit.loader;

import android.content.Context;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.browser.sailor.webkit.update.BdZeusDownloadHelper;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes10.dex */
public class a implements WebKitFactory.WebkitInstallListener {
    static final String a = a.class.getSimpleName();
    byte b;
    long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, boolean z, int i) {
        WebKitFactory.init(context, context.getPackageName(), BdSailorPlatform.getInstance().getCuid());
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
    public static void b(LoadErrorCode loadErrorCode) {
        BdSailorPlatform.getStatic().a("init-webkit", "Err = " + loadErrorCode.getInt() + loadErrorCode.getString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(LoadErrorCode loadErrorCode) {
        WebKitFactory.setEngine(0);
        BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.b, loadErrorCode);
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallFinish(int i, String str) {
        System.currentTimeMillis();
        Log.i("soar", "the return value of installing kernal is: " + i);
        BdZeusUtil.printKernellog("oninstalled: " + i + " targetpath: " + str);
        if (i == 0) {
            if (this.b == 0) {
                a(BdSailorPlatform.getInstance().getAppContext(), BdSailorPlatform.getWebkitManager().isWebkitBuiltin(), BdSailorPlatform.getWebkitManager().getWebkitType$630ca8f2());
                if (BdZeusUtil.isWebkitLoaded()) {
                    BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
                }
            }
            Log.d(a, "install success!");
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginSuccess(BdSailorPlatform.getInstance().getAppContext(), str, this.b);
        } else {
            Log.d(a, "install failed!");
            BdSailorPlatform.getWebkitManager().onInstallZeusPluginFailed(this.b, WebKitFactory.getLoadErrorCode());
        }
        BdZeusDownloadHelper.a();
        BdSailorPlatform.getWebkitManager().enableBdWebkit();
        Log.i(a, "total timecost: " + String.valueOf(System.currentTimeMillis() - this.c));
    }

    @Override // com.baidu.webkit.sdk.WebKitFactory.WebkitInstallListener
    public void onInstallStart() {
    }
}
