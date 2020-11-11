package com.baidu.browser.sailor.webkit.loader;

import android.content.Context;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class BdWebkitManager implements INoProGuard {
    private boolean mIsWebkitBuiltin = true;
    private List<IWebkitLoaderListener> mListenerLst = new ArrayList();
    private com.baidu.browser.sailor.webkit.loader.a mLoader = new com.baidu.browser.sailor.webkit.loader.a();
    private static final String LOG_TAG = BdWebkitManager.class.getName();
    private static int mWebkitType$25688051 = BdSailorConfig.BUILTIN_WEBKIT$25688051;
    private static int mBdWebkitType$25688051 = BdSailorConfig.BUILTIN_WEBKIT$25688051;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f1286a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {f1286a, b, c};
    }

    private String makeErrorInfo(LoadErrorCode loadErrorCode) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", loadErrorCode.getInt());
            jSONObject.put("error_reason", loadErrorCode.getString());
            jSONObject.put("t5_integration", BdZeusUtil.isWebkitLoaded() ? "on" : "off");
        } catch (Exception e) {
            Log.d("soar", "exception when make error info");
        }
        Log.d("soar", "error info: " + jSONObject.toString());
        return jSONObject.toString();
    }

    public void addListener(IWebkitLoaderListener iWebkitLoaderListener) {
        synchronized (this) {
            this.mListenerLst.add(iWebkitLoaderListener);
        }
    }

    public void destroy() {
    }

    public void disableBdWebkit() {
        mWebkitType$25688051 = a.f1286a;
    }

    public void enableBdWebkit() {
        mWebkitType$25688051 = mBdWebkitType$25688051;
    }

    public int getWebkitType$630ca8f2() {
        return mWebkitType$25688051;
    }

    public void initWebkit(String str, boolean z, Class<? extends CrashCallback> cls) {
        boolean z2;
        this.mIsWebkitBuiltin = z;
        com.baidu.browser.sailor.webkit.loader.a aVar = this.mLoader;
        Context appContext = BdSailorPlatform.getInstance().getAppContext();
        int i = mWebkitType$25688051;
        if (z && (a.b == i || a.c == i)) {
            if (cls != null) {
                WebKitFactory.setCrashCallback(appContext, cls);
            }
            WebKitFactory.init(appContext, str, BdSailorPlatform.getInstance().getCuid());
            WebKitFactory.setApkLibLoadType(z);
            WebKitFactory.setEmulator(BdZeusUtil.checkEmulator());
            if (WebKitFactory.isZeusSupported()) {
                if (a.c == i) {
                    BdSailorPlatform.getStatic().a("emulator-check", "emulator:" + BdZeusUtil.checkEmulator());
                    z2 = WebKitFactory.setEngine(1);
                    Log.d(com.baidu.browser.sailor.webkit.loader.a.f1287a, "zeus version = " + WebKitFactory.getZeusVersionName());
                } else {
                    z2 = false;
                }
                if (z2) {
                    Log.d(com.baidu.browser.sailor.webkit.loader.a.f1287a, "zeus version = " + WebKitFactory.getZeusVersionName());
                    Log.d(com.baidu.browser.sailor.webkit.loader.a.f1287a, "sdk version = " + WebKitFactory.getSdkVersionName());
                    BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
                    BdSailorPlatform.getStatic().a("init-webkit", "success");
                    BdSailorPlatform.getStatic().e = true;
                } else {
                    LoadErrorCode loadErrorCode = WebKitFactory.getLoadErrorCode();
                    aVar.a(loadErrorCode);
                    com.baidu.browser.sailor.webkit.loader.a.b(loadErrorCode);
                    BdSailorPlatform.getStatic().e = false;
                }
            } else {
                aVar.a(new LoadErrorCode(99, "not support"));
                BdSailorPlatform.getStatic().a("init-webkit", "notSupport");
                BdSailorPlatform.getStatic().e = false;
            }
        } else if (BdZeusUtil.isWebkitLoaded()) {
            return;
        } else {
            com.baidu.browser.sailor.webkit.loader.a.a(appContext, z, i);
            if (BdZeusUtil.isWebkitLoaded()) {
                BdSailorPlatform.getStatic().a("init-webkit", "success");
                BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
            } else {
                LoadErrorCode loadErrorCode2 = WebKitFactory.getLoadErrorCode();
                aVar.a(loadErrorCode2);
                com.baidu.browser.sailor.webkit.loader.a.b(loadErrorCode2);
                BdSailorPlatform.getWebkitManager().onLoadSysSDKSuccess();
            }
        }
        ZeusPerformanceTiming.setZeusWebkitInitStatistics(BdSailorPlatform.getStatic().d);
    }

    public void installZeusFromDownload(String str) {
        com.baidu.browser.sailor.webkit.loader.a aVar = this.mLoader;
        BdSailorPlatform.getInstance().getAppContext();
        int i = mWebkitType$25688051;
        if (str != null) {
            aVar.b = (byte) 0;
            if (a.c == i) {
                WebKitFactory.destroy();
                Log.d(com.baidu.browser.sailor.webkit.loader.a.f1287a, "sdk version =  =" + WebKitFactory.getSdkVersionName());
            }
            if (!str.startsWith("file://")) {
                str = "file://" + str;
            }
            BdZeusUtil.printKernellog("install plugin from download");
            WebKitFactory.installAsync(str, aVar);
            aVar.c = System.currentTimeMillis();
            Log.i(com.baidu.browser.sailor.webkit.loader.a.f1287a, "full update started!");
        }
    }

    public boolean isWebkitBuiltin() {
        return this.mIsWebkitBuiltin;
    }

    public void loadWebkitOnly(Context context, boolean z) {
        boolean init = WebKitFactory.init(context, context.getPackageName(), BdSailorPlatform.getInstance().getCuid());
        WebKitFactory.setApkLibLoadType(z);
        WebKitFactory.destroy();
        boolean z2 = false;
        if (a.b == mWebkitType$25688051) {
            z2 = WebKitFactory.setEngine(1);
        } else if (a.c == mWebkitType$25688051) {
            z2 = WebKitFactory.setEngine(1);
        }
        Log.d(" initResult " + init + " " + z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInstallZeusPluginFailed(byte b, LoadErrorCode loadErrorCode) {
        String makeErrorInfo = makeErrorInfo(loadErrorCode);
        Log.d(LOG_TAG, makeErrorInfo);
        if (this.mListenerLst != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : this.mListenerLst) {
                iWebkitLoaderListener.onInstallZeusSDKFailed(b, makeErrorInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInstallZeusPluginSuccess(Context context, String str, byte b) {
        ArrayList<IWebkitLoaderListener> arrayList;
        if (this.mListenerLst != null) {
            synchronized (this) {
                arrayList = new ArrayList(this.mListenerLst);
            }
            for (IWebkitLoaderListener iWebkitLoaderListener : arrayList) {
                iWebkitLoaderListener.onInstallZeusSDKSuccess(b);
            }
        }
    }

    void onLoadSysSDKFailed() {
        if (this.mListenerLst != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : this.mListenerLst) {
                iWebkitLoaderListener.onLoadSysSDKFailed();
            }
        }
    }

    void onLoadSysSDKSuccess() {
        if (this.mListenerLst != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : this.mListenerLst) {
                iWebkitLoaderListener.onLoadSysSDKSuccess();
            }
        }
    }

    void onLoadZeusSDKFailed() {
        for (IWebkitLoaderListener iWebkitLoaderListener : this.mListenerLst) {
            iWebkitLoaderListener.onLoadZeusSDKFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLoadZeusSDKSuccess() {
        for (IWebkitLoaderListener iWebkitLoaderListener : this.mListenerLst) {
            iWebkitLoaderListener.onLoadZeusSDKSuccess();
        }
    }

    public void removeListener(IWebkitLoaderListener iWebkitLoaderListener) {
        synchronized (this) {
            if (this.mListenerLst.contains(iWebkitLoaderListener)) {
                this.mListenerLst.remove(iWebkitLoaderListener);
            }
        }
    }
}
