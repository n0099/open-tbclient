package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
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
/* loaded from: classes2.dex */
public class XAdSDKFoundationFacade {
    public static final XAdSDKFoundationFacade o = new XAdSDKFoundationFacade();

    /* renamed from: a  reason: collision with root package name */
    public m f8516a;
    public Context p;
    public IXAdContainerFactory q;

    /* renamed from: c  reason: collision with root package name */
    public IBase64 f8518c = new a();

    /* renamed from: d  reason: collision with root package name */
    public IXAdLogger f8519d = q.a();

    /* renamed from: b  reason: collision with root package name */
    public s f8517b = new s();

    /* renamed from: e  reason: collision with root package name */
    public IXAdViewUtils f8520e = new ab();

    /* renamed from: f  reason: collision with root package name */
    public IXAdBitmapUtils f8521f = new g();

    /* renamed from: g  reason: collision with root package name */
    public IXAdURIUitls f8522g = new aa();
    public IXAdSystemUtils k = t.a();
    public h l = new h();

    /* renamed from: h  reason: collision with root package name */
    public IXAdIOUtils f8523h = new p();
    public r i = new r();
    public IXAdActivityUtils j = new f();
    public l m = new l();
    public IXAdErrorCode n = new com.baidu.mobads.d.b(this.f8519d);

    public static XAdSDKFoundationFacade getInstance() {
        return o;
    }

    public void downloadApp(IXAdInstanceInfo iXAdInstanceInfo) {
        try {
            IXAdLogger iXAdLogger = this.f8519d;
            iXAdLogger.i("download apk in proxy: " + iXAdInstanceInfo.getAppName());
        } catch (Exception unused) {
            Log.e("", "");
        }
    }

    public void downloadAppSilence(IXAdInstanceInfo iXAdInstanceInfo) {
        downloadApp(iXAdInstanceInfo);
    }

    public IXAdActivityUtils getActivityUtils() {
        return this.j;
    }

    public l getAdConstants() {
        return this.m;
    }

    public IXAdContainerFactory getAdContainerFactory() {
        return this.q;
    }

    public m getAdCreativeCacheManager() {
        return this.f8516a;
    }

    public IXAdLogger getAdLogger() {
        return this.f8519d;
    }

    public s getAdResource() {
        return this.f8517b;
    }

    public Context getApplicationContext() {
        return this.p;
    }

    public IBase64 getBase64() {
        return this.f8518c;
    }

    public IXAdBitmapUtils getBitmapUtils() {
        return this.f8521f;
    }

    public h getCommonUtils() {
        return this.l;
    }

    public IOAdDownloaderManager getDownloaderManager(Context context) {
        return com.baidu.mobads.openad.download.a.a(context);
    }

    public IXAdErrorCode getErrorCode() {
        return this.n;
    }

    public Intent getInstallIntent(String str) {
        return getPackageUtils().a(getApplicationContext(), str);
    }

    public IXAdIOUtils getIoUtils() {
        return this.f8523h;
    }

    public r getPackageUtils() {
        return this.i;
    }

    public String getProxyVer() {
        return XAdSDKProxyVersion.RELEASE_TAG;
    }

    public IXAdSystemUtils getSystemUtils() {
        return this.k;
    }

    public IXAdURIUitls getURIUitls() {
        return this.f8522g;
    }

    public IXAdViewUtils getViewUtils() {
        return this.f8520e;
    }

    public void initializeAdContainerFactory(IXAdContainerFactory iXAdContainerFactory) {
        if (iXAdContainerFactory == null) {
            this.q = iXAdContainerFactory;
        }
    }

    public void initializeApplicationContext(Context context) {
        if (this.p == null) {
            this.p = context;
        }
        this.f8516a = new m(this.p);
    }

    public void makeRequest(String str) {
        com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(str, "");
        bVar.f8413e = 1;
        new com.baidu.mobads.openad.b.a().a(bVar);
    }

    public void sendLog(String str, HashMap<String, String> hashMap) {
        com.baidu.mobads.b.a.a().a(getApplicationContext(), str, (IXAdInstanceInfo) null, (IXAdProdInfo) null, hashMap);
    }

    public void setMobileConfirmed(String str) {
        IXAdLogger iXAdLogger = this.f8519d;
        iXAdLogger.i("setMobileConfirmed in proxy: " + str);
    }

    public IOAdDownloaderManager getDownloaderManager() {
        return com.baidu.mobads.openad.download.a.a(getApplicationContext());
    }
}
