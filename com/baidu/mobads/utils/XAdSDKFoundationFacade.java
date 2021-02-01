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
/* loaded from: classes5.dex */
public class XAdSDKFoundationFacade {
    private static final XAdSDKFoundationFacade o = new XAdSDKFoundationFacade();

    /* renamed from: a  reason: collision with root package name */
    private m f3484a;
    private Context p;
    private IXAdContainerFactory q;
    private IBase64 c = new a();
    private IXAdLogger d = q.a();

    /* renamed from: b  reason: collision with root package name */
    private s f3485b = new s();
    private IXAdViewUtils e = new ab();
    private IXAdBitmapUtils f = new g();
    private IXAdURIUitls g = new aa();
    private IXAdSystemUtils k = t.a();
    private h l = new h();
    private IXAdIOUtils h = new p();
    private r i = new r();
    private IXAdActivityUtils j = new f();
    private l m = new l();
    private IXAdErrorCode n = new com.baidu.mobads.d.b(this.d);

    public static XAdSDKFoundationFacade getInstance() {
        return o;
    }

    private XAdSDKFoundationFacade() {
    }

    public void initializeApplicationContext(Context context) {
        if (this.p == null) {
            this.p = context;
        }
        this.f3484a = new m(this.p);
    }

    public void initializeAdContainerFactory(IXAdContainerFactory iXAdContainerFactory) {
        if (iXAdContainerFactory == null) {
            this.q = iXAdContainerFactory;
        }
    }

    public m getAdCreativeCacheManager() {
        return this.f3484a;
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

    public s getAdResource() {
        return this.f3485b;
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

    public r getPackageUtils() {
        return this.i;
    }

    public h getCommonUtils() {
        return this.l;
    }

    public IXAdSystemUtils getSystemUtils() {
        return this.k;
    }

    public IXAdActivityUtils getActivityUtils() {
        return this.j;
    }

    public l getAdConstants() {
        return this.m;
    }

    public IXAdErrorCode getErrorCode() {
        return this.n;
    }

    public IOAdDownloaderManager getDownloaderManager(Context context) {
        return com.baidu.mobads.openad.download.a.a(context);
    }

    public IOAdDownloaderManager getDownloaderManager() {
        return com.baidu.mobads.openad.download.a.a(getApplicationContext());
    }

    public void setMobileConfirmed(String str) {
        this.d.i("setMobileConfirmed in proxy: " + str);
    }

    public void makeRequest(String str) {
        com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(str, "");
        bVar.e = 1;
        new com.baidu.mobads.openad.b.a().a(bVar);
    }

    public String getProxyVer() {
        return XAdSDKProxyVersion.RELEASE_TAG;
    }

    public void downloadApp(IXAdInstanceInfo iXAdInstanceInfo) {
        try {
            this.d.i("download apk in proxy: " + iXAdInstanceInfo.getAppName());
        } catch (Exception e) {
            Log.e("", "");
        }
    }

    public void downloadAppSilence(IXAdInstanceInfo iXAdInstanceInfo) {
        downloadApp(iXAdInstanceInfo);
    }

    public void sendLog(String str, HashMap<String, String> hashMap) {
        com.baidu.mobads.b.a.a().a(getApplicationContext(), str, (IXAdInstanceInfo) null, (IXAdProdInfo) null, hashMap);
    }

    public Intent getInstallIntent(String str) {
        return getPackageUtils().a(getApplicationContext(), str);
    }
}
