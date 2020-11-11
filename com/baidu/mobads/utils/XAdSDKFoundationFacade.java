package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class XAdSDKFoundationFacade {
    private static final XAdSDKFoundationFacade o = new XAdSDKFoundationFacade();

    /* renamed from: a  reason: collision with root package name */
    private i f2434a;
    private Context p;
    private IXAdContainerFactory q;
    private IBase64 c = new a();
    private IXAdLogger d = m.a();
    private o b = new o();
    private IXAdViewUtils e = new u();
    private IXAdBitmapUtils f = new d();
    private IXAdURIUitls g = new t();
    private IXAdSystemUtils k = new p();
    private e l = new e();
    private IXAdIOUtils h = new l();
    private n i = new n();
    private IXAdActivityUtils j = new c();
    private h m = new h();
    private IXAdErrorCode n = new com.baidu.mobads.e.b(this.d);

    public static XAdSDKFoundationFacade getInstance() {
        return o;
    }

    private XAdSDKFoundationFacade() {
    }

    public void initializeApplicationContext(Context context) {
        if (this.p == null) {
            this.p = context;
        }
        this.f2434a = new i(this.p);
    }

    public void initializeAdContainerFactory(IXAdContainerFactory iXAdContainerFactory) {
        if (iXAdContainerFactory == null) {
            this.q = iXAdContainerFactory;
        }
    }

    public i getAdCreativeCacheManager() {
        return this.f2434a;
    }

    public IXAdContainerFactory getAdContainerFactory() {
        return this.q;
    }

    public Context getApplicationContext() {
        return this.p;
    }

    public IBase64 getBase64() {
        return this.c;
    }

    public IXAdLogger getAdLogger() {
        return this.d;
    }

    public o getAdResource() {
        return this.b;
    }

    public IXAdBitmapUtils getBitmapUtils() {
        return this.f;
    }

    public IXAdURIUitls getURIUitls() {
        return this.g;
    }

    public IXAdViewUtils getViewUtils() {
        return this.e;
    }

    public IXAdIOUtils getIoUtils() {
        return this.h;
    }

    public n getPackageUtils() {
        return this.i;
    }

    public e getCommonUtils() {
        return this.l;
    }

    public IXAdSystemUtils getSystemUtils() {
        return this.k;
    }

    public IXAdActivityUtils getActivityUtils() {
        return this.j;
    }

    public h getAdConstants() {
        return this.m;
    }

    public IXAdErrorCode getErrorCode() {
        return this.n;
    }

    public IOAdDownloaderManager getDownloaderManager(Context context) {
        return com.baidu.mobads.openad.b.d.a(context);
    }

    public IOAdDownloaderManager getDownloaderManager() {
        return com.baidu.mobads.openad.b.d.a(getApplicationContext());
    }

    public void setMobileConfirmed(String str) {
        com.baidu.mobads.command.a a2;
        com.baidu.mobads.openad.b.b a3 = com.baidu.mobads.openad.b.b.a(str);
        if (a3 != null && (a2 = a3.a()) != null) {
            a2.s = true;
        }
    }

    public void makeRequest(String str) {
        com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(str, "");
        cVar.e = 1;
        new com.baidu.mobads.openad.d.a().a(cVar);
    }

    public String getProxyVer() {
        return "8.8146";
    }

    public void downloadApp(IXAdInstanceInfo iXAdInstanceInfo) {
        try {
            getInstance().getCommonUtils();
            new com.baidu.mobads.command.a.a(null, iXAdInstanceInfo, null).a();
        } catch (Exception e) {
            Log.e("", "");
        }
    }

    public void downloadAppSilence(IXAdInstanceInfo iXAdInstanceInfo) {
        downloadApp(iXAdInstanceInfo);
    }

    public void sendLog(String str, HashMap<String, String> hashMap) {
        com.baidu.mobads.c.a.a().a(getApplicationContext(), str, (IXAdInstanceInfo) null, (IXAdProdInfo) null, hashMap);
    }

    public Intent getInstallIntent(String str) {
        return getPackageUtils().a(getApplicationContext(), str);
    }
}
