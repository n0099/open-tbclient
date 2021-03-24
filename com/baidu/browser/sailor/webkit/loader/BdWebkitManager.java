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
/* loaded from: classes2.dex */
public class BdWebkitManager implements INoProGuard {
    public static final String LOG_TAG = "com.baidu.browser.sailor.webkit.loader.BdWebkitManager";
    public static int mBdWebkitType$25688051;
    public static int mWebkitType$25688051;
    public boolean mIsWebkitBuiltin = true;
    public List<IWebkitLoaderListener> mListenerLst = new ArrayList();
    public d.b.h.b.f.b.a mLoader = new d.b.h.b.f.b.a();

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4326a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f4327b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4328c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f4329d = {1, 2, 3};
    }

    static {
        int i = BdSailorConfig.BUILTIN_WEBKIT$25688051;
        mWebkitType$25688051 = i;
        mBdWebkitType$25688051 = i;
    }

    private String makeErrorInfo(LoadErrorCode loadErrorCode) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", loadErrorCode.getInt());
            jSONObject.put(LoadErrorCode.Statistics.KEY_ERROR_REASON, loadErrorCode.getString());
            jSONObject.put("t5_integration", BdZeusUtil.isWebkitLoaded() ? "on" : "off");
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
        mWebkitType$25688051 = a.f4326a;
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
        d.b.h.b.f.b.a aVar = this.mLoader;
        Context appContext = BdSailorPlatform.getInstance().getAppContext();
        int i = mWebkitType$25688051;
        if (z && (a.f4327b == i || a.f4328c == i)) {
            if (cls != null) {
                WebKitFactory.setCrashCallback(appContext, cls);
            }
            WebKitFactory.init(appContext, str, BdSailorPlatform.getInstance().getCuid());
            WebKitFactory.setApkLibLoadType(z);
            WebKitFactory.setEmulator(BdZeusUtil.checkEmulator());
            if (WebKitFactory.isZeusSupported()) {
                if (a.f4328c == i) {
                    d.b.h.b.d.c.a aVar2 = BdSailorPlatform.getStatic();
                    aVar2.b("emulator-check", "emulator:" + BdZeusUtil.checkEmulator());
                    z2 = WebKitFactory.setEngine(1);
                    String str2 = d.b.h.b.f.b.a.f49492c;
                    Log.d(str2, "zeus version = " + WebKitFactory.getZeusVersionName());
                } else {
                    z2 = false;
                }
                if (z2) {
                    String str3 = d.b.h.b.f.b.a.f49492c;
                    Log.d(str3, "zeus version = " + WebKitFactory.getZeusVersionName());
                    String str4 = d.b.h.b.f.b.a.f49492c;
                    Log.d(str4, "sdk version = " + WebKitFactory.getSdkVersionName());
                    BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
                    BdSailorPlatform.getStatic().b("init-webkit", "success");
                    BdSailorPlatform.getStatic().f49477d = true;
                } else {
                    LoadErrorCode loadErrorCode = WebKitFactory.getLoadErrorCode();
                    aVar.b(loadErrorCode);
                    d.b.h.b.f.b.a.c(loadErrorCode);
                }
            } else {
                aVar.b(new LoadErrorCode(99, "not support"));
                BdSailorPlatform.getStatic().b("init-webkit", "notSupport");
            }
            BdSailorPlatform.getStatic().f49477d = false;
        } else if (BdZeusUtil.isWebkitLoaded()) {
            return;
        } else {
            d.b.h.b.f.b.a.a(appContext, z, i);
            if (BdZeusUtil.isWebkitLoaded()) {
                BdSailorPlatform.getStatic().b("init-webkit", "success");
                BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
            } else {
                LoadErrorCode loadErrorCode2 = WebKitFactory.getLoadErrorCode();
                aVar.b(loadErrorCode2);
                d.b.h.b.f.b.a.c(loadErrorCode2);
                BdSailorPlatform.getWebkitManager().onLoadSysSDKSuccess();
            }
        }
        ZeusPerformanceTiming.setZeusWebkitInitStatistics(BdSailorPlatform.getStatic().f49475b);
    }

    public void installZeusFromDownload(String str) {
        d.b.h.b.f.b.a aVar = this.mLoader;
        BdSailorPlatform.getInstance().getAppContext();
        int i = mWebkitType$25688051;
        if (str != null) {
            aVar.f49493a = (byte) 0;
            if (a.f4328c == i) {
                WebKitFactory.destroy();
                Log.d(d.b.h.b.f.b.a.f49492c, "sdk version =  =" + WebKitFactory.getSdkVersionName());
            }
            if (!str.startsWith("file://")) {
                str = "file://" + str;
            }
            BdZeusUtil.printKernellog("install plugin from download");
            WebKitFactory.installAsync(str, aVar);
            aVar.f49494b = System.currentTimeMillis();
            Log.i(d.b.h.b.f.b.a.f49492c, "full update started!");
        }
    }

    public boolean isWebkitBuiltin() {
        return this.mIsWebkitBuiltin;
    }

    public void loadWebkitOnly(Context context, boolean z) {
        boolean init = WebKitFactory.init(context, context.getPackageName(), BdSailorPlatform.getInstance().getCuid());
        WebKitFactory.setApkLibLoadType(z);
        WebKitFactory.destroy();
        boolean engine = (a.f4327b == mWebkitType$25688051 || a.f4328c == mWebkitType$25688051) ? WebKitFactory.setEngine(1) : false;
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
