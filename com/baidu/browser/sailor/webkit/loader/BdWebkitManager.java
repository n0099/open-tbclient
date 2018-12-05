package com.baidu.browser.sailor.webkit.loader;

import android.content.Context;
import com.baidu.browser.sailor.b;
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BdWebkitManager {
    private static final String LOG_TAG = BdWebkitManager.class.getName();
    private static int WR = b.Vv;
    private static int WS = b.Vv;
    private boolean WT = true;
    private List<IWebkitLoaderListener> WP = new ArrayList();
    private com.baidu.browser.sailor.webkit.loader.a WQ = new com.baidu.browser.sailor.webkit.loader.a();

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {a, b, c};
    }

    private String a(LoadErrorCode loadErrorCode) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", loadErrorCode.getInt());
            jSONObject.put("error_reason", loadErrorCode.getString());
            String str = ARCameraAttr.FlashType.FLASH_OFF;
            if (com.baidu.browser.sailor.util.a.qU()) {
                str = ARCameraAttr.FlashType.FLASH_ON;
            }
            jSONObject.put("t5_integration", str);
        } catch (Exception e) {
            Log.d("soar", "exception when make error info");
        }
        Log.d("soar", "error info: " + jSONObject.toString());
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte b, LoadErrorCode loadErrorCode) {
        String a2 = a(loadErrorCode);
        Log.d(LOG_TAG, a2);
        if (this.WP != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : this.WP) {
                iWebkitLoaderListener.onInstallZeusSDKFailed(b, a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, byte b) {
        ArrayList<IWebkitLoaderListener> arrayList;
        if (this.WP != null) {
            synchronized (this) {
                arrayList = new ArrayList(this.WP);
            }
            for (IWebkitLoaderListener iWebkitLoaderListener : arrayList) {
                iWebkitLoaderListener.onInstallZeusSDKSuccess(b);
            }
        }
    }

    public void a(IWebkitLoaderListener iWebkitLoaderListener) {
        synchronized (this) {
            this.WP.add(iWebkitLoaderListener);
        }
    }

    public void a(String str, boolean z, Class<? extends CrashCallback> cls) {
        boolean z2;
        this.WT = z;
        com.baidu.browser.sailor.webkit.loader.a aVar = this.WQ;
        Context appContext = com.baidu.browser.sailor.b.a.qO().getAppContext();
        int i = WR;
        if (!z || (a.b != i && a.c != i)) {
            if (com.baidu.browser.sailor.util.a.qU()) {
                return;
            }
            com.baidu.browser.sailor.webkit.loader.a.a(appContext, z, i);
            if (com.baidu.browser.sailor.util.a.qU()) {
                com.baidu.browser.sailor.b.a.qP().a("init-webkit", "success");
                com.baidu.browser.sailor.b.a.qQ().onLoadZeusSDKSuccess();
                return;
            }
            LoadErrorCode loadErrorCode = WebKitFactory.getLoadErrorCode();
            aVar.b(loadErrorCode);
            com.baidu.browser.sailor.webkit.loader.a.c(loadErrorCode);
            com.baidu.browser.sailor.b.a.qQ().onLoadSysSDKSuccess();
            return;
        }
        if (cls != null) {
            WebKitFactory.setCrashCallback(appContext, cls);
        }
        WebKitFactory.init(appContext, str, com.baidu.browser.sailor.b.a.qO().getCuid());
        WebKitFactory.setApkLibLoadType(z);
        WebKitFactory.setEmulator(com.baidu.browser.sailor.util.a.qV());
        if (!WebKitFactory.isZeusSupported()) {
            aVar.b(new LoadErrorCode(99, "not support"));
            com.baidu.browser.sailor.b.a.qP().a("init-webkit", "notSupport");
            com.baidu.browser.sailor.b.a.qP().e = false;
            return;
        }
        if (a.c == i) {
            com.baidu.browser.sailor.b.a.qP().a("emulator-check", "emulator:" + com.baidu.browser.sailor.util.a.qV());
            z2 = WebKitFactory.setEngine(1);
            Log.d(com.baidu.browser.sailor.webkit.loader.a.a, "zeus version = " + WebKitFactory.getZeusVersionName());
        } else {
            z2 = false;
        }
        if (!z2) {
            LoadErrorCode loadErrorCode2 = WebKitFactory.getLoadErrorCode();
            aVar.b(loadErrorCode2);
            com.baidu.browser.sailor.webkit.loader.a.c(loadErrorCode2);
            com.baidu.browser.sailor.b.a.qP().e = false;
            return;
        }
        Log.d(com.baidu.browser.sailor.webkit.loader.a.a, "zeus version = " + WebKitFactory.getZeusVersionName());
        Log.d(com.baidu.browser.sailor.webkit.loader.a.a, "sdk version = " + WebKitFactory.getSdkVersionName());
        com.baidu.browser.sailor.b.a.qQ().onLoadZeusSDKSuccess();
        com.baidu.browser.sailor.b.a.qP().a("init-webkit", "success");
        com.baidu.browser.sailor.b.a.qP().e = true;
    }

    public void b(IWebkitLoaderListener iWebkitLoaderListener) {
        synchronized (this) {
            if (this.WP.contains(iWebkitLoaderListener)) {
                this.WP.remove(iWebkitLoaderListener);
            }
        }
    }

    public void cE(String str) {
        com.baidu.browser.sailor.webkit.loader.a aVar = this.WQ;
        com.baidu.browser.sailor.b.a.qO().getAppContext();
        int i = WR;
        if (str != null) {
            aVar.b = (byte) 0;
            if (a.c == i) {
                WebKitFactory.destroy();
                Log.d(com.baidu.browser.sailor.webkit.loader.a.a, "sdk version =  =" + WebKitFactory.getSdkVersionName());
            }
            if (!str.startsWith("file://")) {
                str = "file://" + str;
            }
            com.baidu.browser.sailor.util.a.cD("install plugin from download");
            WebKitFactory.installAsync(str, aVar);
            aVar.c = System.currentTimeMillis();
            Log.i(com.baidu.browser.sailor.webkit.loader.a.a, "full update started!");
        }
    }

    void onLoadSysSDKSuccess() {
        if (this.WP != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : this.WP) {
                iWebkitLoaderListener.onLoadSysSDKSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLoadZeusSDKSuccess() {
        for (IWebkitLoaderListener iWebkitLoaderListener : this.WP) {
            iWebkitLoaderListener.onLoadZeusSDKSuccess();
        }
    }

    public void qY() {
        WR = WS;
    }

    public void qZ() {
        WR = a.a;
    }

    public boolean ra() {
        return this.WT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int rb() {
        return WR;
    }
}
