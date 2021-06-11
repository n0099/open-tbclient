package com.baidu.browser.sailor.webkit.loader;

import android.content.Context;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdWebkitManager implements INoProGuard {
    public static final String LOG_TAG = "com.baidu.browser.sailor.webkit.loader.BdWebkitManager";
    public static a mBdWebkitType;
    public static a mWebkitType;
    public boolean mIsWebkitBuiltin = true;
    public List<IWebkitLoaderListener> mListenerLst = new ArrayList();
    public d.a.h.b.d.b.a mLoader = new d.a.h.b.d.b.a();

    /* loaded from: classes.dex */
    public enum a {
        SYSTEM,
        T5,
        T7
    }

    static {
        a aVar = BdSailorConfig.BUILTIN_WEBKIT;
        mWebkitType = aVar;
        mBdWebkitType = aVar;
    }

    private String makeErrorInfo(LoadErrorCode loadErrorCode) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", loadErrorCode.getInt());
            jSONObject.put(LoadErrorCode.Statistics.KEY_ERROR_REASON, loadErrorCode.getString());
            String str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            if (BdZeusUtil.isWebkitLoaded()) {
                str = DebugKt.DEBUG_PROPERTY_VALUE_ON;
            }
            jSONObject.put("t5_integration", str);
        } catch (Exception unused) {
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
        mWebkitType = a.SYSTEM;
    }

    public void enableBdWebkit() {
        mWebkitType = mBdWebkitType;
    }

    public a getWebkitType() {
        return mWebkitType;
    }

    public void initWebkit(String str, boolean z, Class<? extends CrashCallback> cls) {
        String str2;
        StringBuilder sb;
        boolean z2;
        this.mIsWebkitBuiltin = z;
        d.a.h.b.d.b.a aVar = this.mLoader;
        Context appContext = BdSailorPlatform.getInstance().getAppContext();
        a aVar2 = mWebkitType;
        if (z && (a.T5 == aVar2 || a.T7 == aVar2)) {
            if (cls != null) {
                WebKitFactory.setCrashCallback(appContext, cls);
            }
            WebKitFactory.init(appContext, str, BdSailorPlatform.getInstance().getCuid());
            WebKitFactory.setApkLibLoadType(z);
            WebKitFactory.setEmulator(BdZeusUtil.checkEmulator());
            if (WebKitFactory.isZeusSupported()) {
                if (a.T7 == aVar2) {
                    d.a.h.b.b.b.a aVar3 = BdSailorPlatform.getStatic();
                    aVar3.b("emulator-check", "emulator:" + BdZeusUtil.checkEmulator());
                    z2 = WebKitFactory.setEngine(1);
                    String str3 = d.a.h.b.d.b.a.f43675c;
                    Log.d(str3, "zeus version = " + WebKitFactory.getZeusVersionName());
                } else {
                    z2 = false;
                }
                if (z2) {
                    String str4 = d.a.h.b.d.b.a.f43675c;
                    Log.d(str4, "zeus version = " + WebKitFactory.getZeusVersionName());
                    String str5 = d.a.h.b.d.b.a.f43675c;
                    Log.d(str5, "sdk version = " + WebKitFactory.getSdkVersionName());
                    BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
                    BdSailorPlatform.getStatic().b("init-webkit", "success");
                    BdSailorPlatform.getStatic().f43659d = true;
                } else {
                    LoadErrorCode loadErrorCode = WebKitFactory.getLoadErrorCode();
                    aVar.a(loadErrorCode);
                    d.a.h.b.d.b.a.c(loadErrorCode);
                }
            } else {
                aVar.a(new LoadErrorCode(99, "not support"));
                BdSailorPlatform.getStatic().b("init-webkit", "notSupport");
            }
            BdSailorPlatform.getStatic().f43659d = false;
        } else if (BdZeusUtil.isWebkitLoaded()) {
            return;
        } else {
            WebKitFactory.init(appContext, appContext.getPackageName(), BdSailorPlatform.getInstance().getCuid());
            WebKitFactory.setApkLibLoadType(z);
            if (a.T7 == aVar2 || a.T5 == aVar2) {
                WebKitFactory.setEngine(1);
                str2 = d.a.h.b.d.b.a.f43675c;
                sb = new StringBuilder("zeus version =");
            } else {
                WebKitFactory.setEngine(0);
                str2 = d.a.h.b.d.b.a.f43675c;
                sb = new StringBuilder("zeus version =");
            }
            sb.append(WebKitFactory.getZeusVersionName());
            Log.d(str2, sb.toString());
            Log.i(EngineManager.LOG_TAG, "so in=" + WebKitFactory.getZeusVersionName());
            Log.i(EngineManager.LOG_TAG, "so out=" + WebKitFactory.getSdkVersionName());
            if (BdZeusUtil.isWebkitLoaded()) {
                BdSailorPlatform.getStatic().b("init-webkit", "success");
                BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
            } else {
                LoadErrorCode loadErrorCode2 = WebKitFactory.getLoadErrorCode();
                aVar.a(loadErrorCode2);
                d.a.h.b.d.b.a.c(loadErrorCode2);
                BdSailorPlatform.getWebkitManager().onLoadSysSDKSuccess();
            }
        }
        ZeusPerformanceTiming.setZeusWebkitInitStatistics(BdSailorPlatform.getStatic().f43657b);
    }

    public void installZeusFromDownload(final String str) {
        if (!WebViewFactory.hasProvider()) {
            Log.i(EngineManager.LOG_TAG, "installZeusFromDownload post after initwebkit");
            BdSailor.getInstance().addListener(new IWebkitLoaderListener() { // from class: com.baidu.browser.sailor.webkit.loader.BdWebkitManager.1
                @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                public void onInstallZeusSDKFailed(byte b2, String str2) {
                }

                @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                public void onInstallZeusSDKSuccess(byte b2) {
                }

                @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                public void onLoadSysSDKFailed() {
                    Log.i(EngineManager.LOG_TAG, "installZeusFromDownload after onLoadSysSDKFailed");
                }

                @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                public void onLoadSysSDKSuccess() {
                    Log.i(EngineManager.LOG_TAG, "installZeusFromDownload after onLoadSysSDKSuccess");
                    d.a.h.b.d.b.a aVar = BdWebkitManager.this.mLoader;
                    BdSailorPlatform.getInstance().getAppContext();
                    String str2 = str;
                    a unused = BdWebkitManager.mWebkitType;
                    aVar.b(str2);
                }

                @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                public void onLoadZeusSDKFailed() {
                    Log.i(EngineManager.LOG_TAG, "installZeusFromDownload after onLoadZeusSDKFailed");
                }

                @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                public void onLoadZeusSDKSuccess() {
                    Log.i(EngineManager.LOG_TAG, "installZeusFromDownload after onLoadZeusSDKSuccess");
                    d.a.h.b.d.b.a aVar = BdWebkitManager.this.mLoader;
                    BdSailorPlatform.getInstance().getAppContext();
                    String str2 = str;
                    a unused = BdWebkitManager.mWebkitType;
                    aVar.b(str2);
                }
            });
            return;
        }
        d.a.h.b.d.b.a aVar = this.mLoader;
        BdSailorPlatform.getInstance().getAppContext();
        aVar.b(str);
    }

    public boolean isWebkitBuiltin() {
        return this.mIsWebkitBuiltin;
    }

    public void loadWebkitOnly(Context context, boolean z) {
        boolean init = WebKitFactory.init(context, context.getPackageName(), BdSailorPlatform.getInstance().getCuid());
        WebKitFactory.setApkLibLoadType(z);
        WebKitFactory.destroy();
        boolean engine = (a.T5 == mWebkitType || a.T7 == mWebkitType) ? WebKitFactory.setEngine(1) : false;
        Log.d(" initResult " + init + " " + engine);
    }

    public void onInstallZeusPluginFailed(byte b2, LoadErrorCode loadErrorCode) {
        String makeErrorInfo = makeErrorInfo(loadErrorCode);
        Log.d(LOG_TAG, makeErrorInfo);
        List<IWebkitLoaderListener> list = this.mListenerLst;
        if (list != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : list) {
                iWebkitLoaderListener.onInstallZeusSDKFailed(b2, makeErrorInfo);
            }
        }
    }

    public void onInstallZeusPluginSuccess(Context context, String str, byte b2) {
        ArrayList<IWebkitLoaderListener> arrayList;
        if (this.mListenerLst != null) {
            synchronized (this) {
                arrayList = new ArrayList(this.mListenerLst);
            }
            for (IWebkitLoaderListener iWebkitLoaderListener : arrayList) {
                iWebkitLoaderListener.onInstallZeusSDKSuccess(b2);
            }
        }
    }

    public void onLoadSysSDKFailed() {
        List<IWebkitLoaderListener> list = this.mListenerLst;
        if (list != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : list) {
                iWebkitLoaderListener.onLoadSysSDKFailed();
            }
        }
    }

    public void onLoadSysSDKSuccess() {
        List<IWebkitLoaderListener> list = this.mListenerLst;
        if (list != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : list) {
                iWebkitLoaderListener.onLoadSysSDKSuccess();
            }
        }
    }

    public void onLoadZeusSDKFailed() {
        for (IWebkitLoaderListener iWebkitLoaderListener : this.mListenerLst) {
            iWebkitLoaderListener.onLoadZeusSDKFailed();
        }
    }

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
