package com.baidu.browser.sailor;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.utils.NetWorkUtils;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
/* loaded from: classes2.dex */
public class a {
    public static final String LOG_TAG = a.class.getSimpleName();
    protected static a Vz;
    private BdSailorClient VA;
    private c VB;
    private boolean VC = false;
    private BdSailorWebView VD;

    protected a() {
        Log.d(LOG_TAG, "BdSailor::BdSailor");
        this.VA = new BdSailorClient();
    }

    private void cv(String str) {
        com.baidu.browser.sailor.feature.a cD;
        if (TextUtils.isEmpty(str) || (cD = com.baidu.browser.sailor.b.a.qS().cD(str)) == null) {
            return;
        }
        cD.enable();
    }

    public static synchronized a qr() {
        a aVar;
        synchronized (a.class) {
            if (Vz == null) {
                Vz = new a();
            }
            aVar = Vz;
        }
        return aVar;
    }

    private void qv() {
    }

    public void a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            com.baidu.browser.sailor.b.a.qS().bE(networkInfo.getType());
        }
        NetWorkUtils.onNetWorkChanged(getAppContext(), networkInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdSailorWebView bdSailorWebView) {
        this.VD = bdSailorWebView;
    }

    public void a(IWebkitLoaderListener iWebkitLoaderListener) {
        com.baidu.browser.sailor.b.a.qU().a(iWebkitLoaderListener);
    }

    public void aA(boolean z) {
        if (z) {
            com.baidu.browser.sailor.b.a.qU().rc();
        } else {
            com.baidu.browser.sailor.b.a.qU().rd();
        }
    }

    public void b(IWebkitLoaderListener iWebkitLoaderListener) {
        com.baidu.browser.sailor.b.a.qU().b(iWebkitLoaderListener);
    }

    public void disableFeature(String str) {
        com.baidu.browser.sailor.feature.a cD;
        WebViewFactory.getProvider().disableFeature(str);
        if (TextUtils.isEmpty(str) || (cD = com.baidu.browser.sailor.b.a.qS().cD(str)) == null) {
            return;
        }
        cD.disable();
    }

    public void enableFeature(String str) {
        com.baidu.browser.sailor.feature.a cD;
        WebViewFactory.getProvider().enableFeature(str);
        if (TextUtils.isEmpty(str) || (cD = com.baidu.browser.sailor.b.a.qS().cD(str)) == null) {
            return;
        }
        cD.enable();
    }

    public Context getAppContext() {
        return com.baidu.browser.sailor.b.a.qS().getAppContext();
    }

    public boolean init(Context context, String str) {
        if (!this.VC) {
            Log.d(LOG_TAG, "BdSailor::init");
            if (context == null) {
                throw new RuntimeException("BdSailor::init aContext must not be null.");
            }
            boolean init = com.baidu.browser.sailor.b.a.qS().init(context.getApplicationContext(), str);
            cv("SSL");
            cv("UPLOAD");
            cv("LIGHT_APP");
            qv();
            this.VC = init;
        }
        return this.VC;
    }

    public boolean init(Context context, String str, String str2) {
        boolean init = init(context, str);
        String cuid = CommonParam.getCUID(com.baidu.browser.sailor.b.a.qS().getAppContext());
        com.baidu.browser.sailor.b.a qS = com.baidu.browser.sailor.b.a.qS();
        if (TextUtils.isEmpty(str2)) {
            str2 = cuid;
        }
        qS.setCuid(str2);
        return init;
    }

    public void j(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        ZeusPerformanceTiming.initWebkitStart();
        com.baidu.browser.sailor.b.a.qS().a(str, z, (Class<? extends CrashCallback>) null);
        ZeusPerformanceTiming.initWebkitEnd();
        Log.d(GlobalConstants.LOG_PER_TAG, "initWebkit =  : " + (System.currentTimeMillis() - currentTimeMillis));
        Log.d(GlobalConstants.LOG_PER_TAG, ZeusPerformanceTiming.getZeusInitTiming());
    }

    public boolean qs() {
        return this.VC;
    }

    public boolean qt() {
        return this.VC && com.baidu.browser.sailor.b.a.qS().qt();
    }

    public synchronized c qu() {
        if (this.VB == null) {
            this.VB = new c();
        }
        return this.VB;
    }

    public BdSailorClient qw() {
        if (this.VA == null) {
            Log.e(LOG_TAG, "SailorClient can not be NULL!");
            return new BdSailorClient();
        }
        return this.VA;
    }

    public BdSailorWebView qx() {
        return this.VD;
    }
}
