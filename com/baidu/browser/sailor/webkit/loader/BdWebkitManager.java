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
    private static int WP = b.Vt;
    private static int WQ = b.Vt;
    private boolean WR = true;
    private List<IWebkitLoaderListener> WN = new ArrayList();
    private com.baidu.browser.sailor.webkit.loader.a WO = new com.baidu.browser.sailor.webkit.loader.a();

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
            if (com.baidu.browser.sailor.util.a.qX()) {
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
        if (this.WN != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : this.WN) {
                iWebkitLoaderListener.onInstallZeusSDKFailed(b, a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, byte b) {
        ArrayList<IWebkitLoaderListener> arrayList;
        if (this.WN != null) {
            synchronized (this) {
                arrayList = new ArrayList(this.WN);
            }
            for (IWebkitLoaderListener iWebkitLoaderListener : arrayList) {
                iWebkitLoaderListener.onInstallZeusSDKSuccess(b);
            }
        }
    }

    public void a(IWebkitLoaderListener iWebkitLoaderListener) {
        synchronized (this) {
            this.WN.add(iWebkitLoaderListener);
        }
    }

    public void a(String str, boolean z, Class<? extends CrashCallback> cls) {
        boolean z2;
        this.WR = z;
        com.baidu.browser.sailor.webkit.loader.a aVar = this.WO;
        Context appContext = com.baidu.browser.sailor.b.a.qR().getAppContext();
        int i = WP;
        if (!z || (a.b != i && a.c != i)) {
            if (com.baidu.browser.sailor.util.a.qX()) {
                return;
            }
            com.baidu.browser.sailor.webkit.loader.a.a(appContext, z, i);
            if (com.baidu.browser.sailor.util.a.qX()) {
                com.baidu.browser.sailor.b.a.qS().a("init-webkit", "success");
                com.baidu.browser.sailor.b.a.qT().onLoadZeusSDKSuccess();
                return;
            }
            LoadErrorCode loadErrorCode = WebKitFactory.getLoadErrorCode();
            aVar.b(loadErrorCode);
            com.baidu.browser.sailor.webkit.loader.a.c(loadErrorCode);
            com.baidu.browser.sailor.b.a.qT().onLoadSysSDKSuccess();
            return;
        }
        if (cls != null) {
            WebKitFactory.setCrashCallback(appContext, cls);
        }
        WebKitFactory.init(appContext, str, com.baidu.browser.sailor.b.a.qR().getCuid());
        WebKitFactory.setApkLibLoadType(z);
        WebKitFactory.setEmulator(com.baidu.browser.sailor.util.a.qY());
        if (!WebKitFactory.isZeusSupported()) {
            aVar.b(new LoadErrorCode(99, "not support"));
            com.baidu.browser.sailor.b.a.qS().a("init-webkit", "notSupport");
            com.baidu.browser.sailor.b.a.qS().e = false;
            return;
        }
        if (a.c == i) {
            com.baidu.browser.sailor.b.a.qS().a("emulator-check", "emulator:" + com.baidu.browser.sailor.util.a.qY());
            z2 = WebKitFactory.setEngine(1);
            Log.d(com.baidu.browser.sailor.webkit.loader.a.a, "zeus version = " + WebKitFactory.getZeusVersionName());
        } else {
            z2 = false;
        }
        if (!z2) {
            LoadErrorCode loadErrorCode2 = WebKitFactory.getLoadErrorCode();
            aVar.b(loadErrorCode2);
            com.baidu.browser.sailor.webkit.loader.a.c(loadErrorCode2);
            com.baidu.browser.sailor.b.a.qS().e = false;
            return;
        }
        Log.d(com.baidu.browser.sailor.webkit.loader.a.a, "zeus version = " + WebKitFactory.getZeusVersionName());
        Log.d(com.baidu.browser.sailor.webkit.loader.a.a, "sdk version = " + WebKitFactory.getSdkVersionName());
        com.baidu.browser.sailor.b.a.qT().onLoadZeusSDKSuccess();
        com.baidu.browser.sailor.b.a.qS().a("init-webkit", "success");
        com.baidu.browser.sailor.b.a.qS().e = true;
    }

    public void b(IWebkitLoaderListener iWebkitLoaderListener) {
        synchronized (this) {
            if (this.WN.contains(iWebkitLoaderListener)) {
                this.WN.remove(iWebkitLoaderListener);
            }
        }
    }

    public void cE(String str) {
        com.baidu.browser.sailor.webkit.loader.a aVar = this.WO;
        com.baidu.browser.sailor.b.a.qR().getAppContext();
        int i = WP;
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
        if (this.WN != null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : this.WN) {
                iWebkitLoaderListener.onLoadSysSDKSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLoadZeusSDKSuccess() {
        for (IWebkitLoaderListener iWebkitLoaderListener : this.WN) {
            iWebkitLoaderListener.onLoadZeusSDKSuccess();
        }
    }

    public void rb() {
        WP = WQ;
    }

    public void rc() {
        WP = a.a;
    }

    public boolean rd() {
        return this.WR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int re() {
        return WP;
    }
}
