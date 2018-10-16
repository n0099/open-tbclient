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
    protected static a Vo;
    private BdSailorClient Vp;
    private c Vq;
    private boolean Vr = false;
    private BdSailorWebView Vs;

    protected a() {
        Log.d(LOG_TAG, "BdSailor::BdSailor");
        this.Vp = new BdSailorClient();
    }

    private void cu(String str) {
        com.baidu.browser.sailor.feature.a cC;
        if (TextUtils.isEmpty(str) || (cC = com.baidu.browser.sailor.b.a.qR().cC(str)) == null) {
            return;
        }
        cC.enable();
    }

    public static synchronized a qq() {
        a aVar;
        synchronized (a.class) {
            if (Vo == null) {
                Vo = new a();
            }
            aVar = Vo;
        }
        return aVar;
    }

    private void qu() {
    }

    public void a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            com.baidu.browser.sailor.b.a.qR().bp(networkInfo.getType());
        }
        NetWorkUtils.onNetWorkChanged(getAppContext(), networkInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdSailorWebView bdSailorWebView) {
        this.Vs = bdSailorWebView;
    }

    public void a(IWebkitLoaderListener iWebkitLoaderListener) {
        com.baidu.browser.sailor.b.a.qT().a(iWebkitLoaderListener);
    }

    public void am(boolean z) {
        if (z) {
            com.baidu.browser.sailor.b.a.qT().rb();
        } else {
            com.baidu.browser.sailor.b.a.qT().rc();
        }
    }

    public void b(IWebkitLoaderListener iWebkitLoaderListener) {
        com.baidu.browser.sailor.b.a.qT().b(iWebkitLoaderListener);
    }

    public void disableFeature(String str) {
        com.baidu.browser.sailor.feature.a cC;
        WebViewFactory.getProvider().disableFeature(str);
        if (TextUtils.isEmpty(str) || (cC = com.baidu.browser.sailor.b.a.qR().cC(str)) == null) {
            return;
        }
        cC.disable();
    }

    public void enableFeature(String str) {
        com.baidu.browser.sailor.feature.a cC;
        WebViewFactory.getProvider().enableFeature(str);
        if (TextUtils.isEmpty(str) || (cC = com.baidu.browser.sailor.b.a.qR().cC(str)) == null) {
            return;
        }
        cC.enable();
    }

    public Context getAppContext() {
        return com.baidu.browser.sailor.b.a.qR().getAppContext();
    }

    public boolean init(Context context, String str) {
        if (!this.Vr) {
            Log.d(LOG_TAG, "BdSailor::init");
            if (context == null) {
                throw new RuntimeException("BdSailor::init aContext must not be null.");
            }
            boolean init = com.baidu.browser.sailor.b.a.qR().init(context.getApplicationContext(), str);
            cu("SSL");
            cu("UPLOAD");
            cu("LIGHT_APP");
            qu();
            this.Vr = init;
        }
        return this.Vr;
    }

    public boolean init(Context context, String str, String str2) {
        boolean init = init(context, str);
        String cuid = CommonParam.getCUID(com.baidu.browser.sailor.b.a.qR().getAppContext());
        com.baidu.browser.sailor.b.a qR = com.baidu.browser.sailor.b.a.qR();
        if (TextUtils.isEmpty(str2)) {
            str2 = cuid;
        }
        qR.setCuid(str2);
        return init;
    }

    public void j(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        ZeusPerformanceTiming.initWebkitStart();
        com.baidu.browser.sailor.b.a.qR().a(str, z, (Class<? extends CrashCallback>) null);
        ZeusPerformanceTiming.initWebkitEnd();
        Log.d(GlobalConstants.LOG_PER_TAG, "initWebkit =  : " + (System.currentTimeMillis() - currentTimeMillis));
        Log.d(GlobalConstants.LOG_PER_TAG, ZeusPerformanceTiming.getZeusInitTiming());
    }

    public boolean qr() {
        return this.Vr;
    }

    public boolean qs() {
        return this.Vr && com.baidu.browser.sailor.b.a.qR().qs();
    }

    public synchronized c qt() {
        if (this.Vq == null) {
            this.Vq = new c();
        }
        return this.Vq;
    }

    public BdSailorClient qv() {
        if (this.Vp == null) {
            Log.e(LOG_TAG, "SailorClient can not be NULL!");
            return new BdSailorClient();
        }
        return this.Vp;
    }

    public BdSailorWebView qw() {
        return this.Vs;
    }
}
