package com.baidu.mobads.production;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class k extends com.baidu.mobads.openad.a.c implements IXAdContainerContext {

    /* renamed from: b  reason: collision with root package name */
    public IXAdContainerEventListener f8476b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8477c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f8478d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f8479e;

    /* renamed from: f  reason: collision with root package name */
    public IXAdResponseInfo f8480f;

    /* renamed from: g  reason: collision with root package name */
    public IXAdInstanceInfo f8481g;

    /* renamed from: h  reason: collision with root package name */
    public View f8482h;
    public IXAdProdInfo i;
    public long j = 0;
    public HashMap<String, Integer> k = new HashMap<>();

    /* loaded from: classes2.dex */
    public class a extends com.baidu.mobads.openad.a.b {

        /* renamed from: b  reason: collision with root package name */
        public String f8484b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, Object> f8485c;

        public a(String str, String str2, HashMap<String, Object> hashMap) {
            super(str);
            this.f8484b = str2;
            this.f8485c = hashMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.mobads.openad.a.b, com.baidu.mobads.openad.interfaces.event.IOAdEvent
        /* renamed from: a */
        public HashMap<String, Object> getData() {
            return this.f8485c;
        }
    }

    public k(Context context, Activity activity, IXAdProdInfo iXAdProdInfo, RelativeLayout relativeLayout, IXAdContainerEventListener iXAdContainerEventListener, IXAdResponseInfo iXAdResponseInfo, View view) {
        this.f8477c = context;
        this.f8478d = activity;
        this.i = iXAdProdInfo;
        this.f8479e = relativeLayout;
        this.f8476b = iXAdContainerEventListener;
        this.f8480f = iXAdResponseInfo;
        this.f8481g = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        this.f8482h = view;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IOAdTimer createOAdTimer(int i) {
        return null;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IOAdTimer createOAdTimer(int i, int i2) {
        return null;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public void fireAdMetrics(String str, HashMap<String, String> hashMap) {
        String addParameters = XAdSDKFoundationFacade.getInstance().getURIUitls().addParameters(str, hashMap);
        com.baidu.mobads.openad.b.a aVar = new com.baidu.mobads.openad.b.a();
        com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(addParameters, "");
        bVar.f8414e = 1;
        aVar.a(bVar, Boolean.TRUE);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public Activity getActivity() {
        RelativeLayout relativeLayout;
        if (this.f8478d == null && (relativeLayout = this.f8479e) != null) {
            this.f8478d = (Activity) relativeLayout.getContext();
        }
        return this.f8478d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdConstants getAdConstants() {
        return XAdSDKFoundationFacade.getInstance().getAdConstants();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdContainerEventListener getAdContainerListener() {
        return this.f8476b;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.f8481g;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public View getAdLeadingView() {
        return this.f8482h;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdLogger getAdLogger() {
        return XAdSDKFoundationFacade.getInstance().getAdLogger();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public RelativeLayout getAdProdBase() {
        return this.f8479e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdProdInfo getAdProdInfo() {
        return this.i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdResource getAdResource() {
        return XAdSDKFoundationFacade.getInstance().getAdResource();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdResponseInfo getAdResponseInfo() {
        return this.f8480f;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdURIUitls getAdUitls4URI() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdActivityUtils getAdUtils4Activity() {
        return XAdSDKFoundationFacade.getInstance().getActivityUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdBitmapUtils getAdUtils4Bitmap() {
        return XAdSDKFoundationFacade.getInstance().getBitmapUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdCommonUtils getAdUtils4Common() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdIOUtils getAdUtils4IO() {
        return XAdSDKFoundationFacade.getInstance().getIoUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdPackageUtils getAdUtils4Package() {
        return XAdSDKFoundationFacade.getInstance().getPackageUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdSystemUtils getAdUtils4System() {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdViewUtils getAdUtils4View() {
        return XAdSDKFoundationFacade.getInstance().getViewUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public Context getApplicationContext() {
        return this.f8477c;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IBase64 getBase64() {
        return XAdSDKFoundationFacade.getInstance().getBase64();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IOAdDownloaderManager getDownloaderManager(Context context) {
        return XAdSDKFoundationFacade.getInstance().getDownloaderManager(context);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdErrorCode getErrorCode() {
        return XAdSDKFoundationFacade.getInstance().getErrorCode();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public String getProxyVersion() {
        return XAdSDKProxyVersion.RELEASE_TAG;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public void processCommand(String str, HashMap<String, Object> hashMap) {
        if (System.currentTimeMillis() - this.j > 1000) {
            this.j = System.currentTimeMillis();
            dispatchEvent(new a("process_command", str, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public void registerAdService(String str, HashMap<String, Object> hashMap) {
        if (this.k.containsKey(str)) {
            return;
        }
        this.k.put(str, 1);
        dispatchEvent(new a("regsiter_adservice", str, hashMap));
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public void unregisterAdService(String str) {
        if (this.k.containsKey(str)) {
            this.k.remove(str);
            dispatchEvent(new a("unregsiter_adservice", str, new HashMap()));
        }
    }
}
