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
    protected static a Vq;
    private BdSailorClient Vr;
    private c Vs;
    private boolean Vt = false;
    private BdSailorWebView Vu;

    protected a() {
        Log.d(LOG_TAG, "BdSailor::BdSailor");
        this.Vr = new BdSailorClient();
    }

    private void cu(String str) {
        com.baidu.browser.sailor.feature.a cC;
        if (TextUtils.isEmpty(str) || (cC = com.baidu.browser.sailor.b.a.qP().cC(str)) == null) {
            return;
        }
        cC.enable();
    }

    public static synchronized a qo() {
        a aVar;
        synchronized (a.class) {
            if (Vq == null) {
                Vq = new a();
            }
            aVar = Vq;
        }
        return aVar;
    }

    private void qs() {
    }

    public void a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            com.baidu.browser.sailor.b.a.qP().bE(networkInfo.getType());
        }
        NetWorkUtils.onNetWorkChanged(getAppContext(), networkInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdSailorWebView bdSailorWebView) {
        this.Vu = bdSailorWebView;
    }

    public void a(IWebkitLoaderListener iWebkitLoaderListener) {
        com.baidu.browser.sailor.b.a.qR().a(iWebkitLoaderListener);
    }

    public void aA(boolean z) {
        if (z) {
            com.baidu.browser.sailor.b.a.qR().qZ();
        } else {
            com.baidu.browser.sailor.b.a.qR().ra();
        }
    }

    public void b(IWebkitLoaderListener iWebkitLoaderListener) {
        com.baidu.browser.sailor.b.a.qR().b(iWebkitLoaderListener);
    }

    public void disableFeature(String str) {
        com.baidu.browser.sailor.feature.a cC;
        WebViewFactory.getProvider().disableFeature(str);
        if (TextUtils.isEmpty(str) || (cC = com.baidu.browser.sailor.b.a.qP().cC(str)) == null) {
            return;
        }
        cC.disable();
    }

    public void enableFeature(String str) {
        com.baidu.browser.sailor.feature.a cC;
        WebViewFactory.getProvider().enableFeature(str);
        if (TextUtils.isEmpty(str) || (cC = com.baidu.browser.sailor.b.a.qP().cC(str)) == null) {
            return;
        }
        cC.enable();
    }

    public Context getAppContext() {
        return com.baidu.browser.sailor.b.a.qP().getAppContext();
    }

    public boolean init(Context context, String str) {
        if (!this.Vt) {
            Log.d(LOG_TAG, "BdSailor::init");
            if (context == null) {
                throw new RuntimeException("BdSailor::init aContext must not be null.");
            }
            boolean init = com.baidu.browser.sailor.b.a.qP().init(context.getApplicationContext(), str);
            cu("SSL");
            cu("UPLOAD");
            cu("LIGHT_APP");
            qs();
            this.Vt = init;
        }
        return this.Vt;
    }

    public boolean init(Context context, String str, String str2) {
        boolean init = init(context, str);
        String cuid = CommonParam.getCUID(com.baidu.browser.sailor.b.a.qP().getAppContext());
        com.baidu.browser.sailor.b.a qP = com.baidu.browser.sailor.b.a.qP();
        if (TextUtils.isEmpty(str2)) {
            str2 = cuid;
        }
        qP.setCuid(str2);
        return init;
    }

    public void j(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        ZeusPerformanceTiming.initWebkitStart();
        com.baidu.browser.sailor.b.a.qP().a(str, z, (Class<? extends CrashCallback>) null);
        ZeusPerformanceTiming.initWebkitEnd();
        Log.d(GlobalConstants.LOG_PER_TAG, "initWebkit =  : " + (System.currentTimeMillis() - currentTimeMillis));
        Log.d(GlobalConstants.LOG_PER_TAG, ZeusPerformanceTiming.getZeusInitTiming());
    }

    public boolean qp() {
        return this.Vt;
    }

    public boolean qq() {
        return this.Vt && com.baidu.browser.sailor.b.a.qP().qq();
    }

    public synchronized c qr() {
        if (this.Vs == null) {
            this.Vs = new c();
        }
        return this.Vs;
    }

    public BdSailorClient qt() {
        if (this.Vr == null) {
            Log.e(LOG_TAG, "SailorClient can not be NULL!");
            return new BdSailorClient();
        }
        return this.Vr;
    }

    public BdSailorWebView qu() {
        return this.Vu;
    }
}
