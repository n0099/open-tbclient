package com.baidu.mobads.production;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
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
/* loaded from: classes3.dex */
public class p extends com.baidu.mobads.openad.c.c implements IXAdContainerContext {

    /* renamed from: a  reason: collision with root package name */
    public IXAdContainerEventListener f3503a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3504b;
    private Activity d;
    private RelativeLayout e;
    private IXAdResponseInfo f;
    private IXAdInstanceInfo g;
    private View h;
    private IXAdProdInfo i;
    private long j = 0;
    private HashMap<String, Integer> k = new HashMap<>();

    /* loaded from: classes3.dex */
    public class a extends com.baidu.mobads.openad.c.b {

        /* renamed from: b  reason: collision with root package name */
        private String f3506b;
        private HashMap<String, Object> c;

        public a(String str, String str2, HashMap<String, Object> hashMap) {
            super(str);
            this.f3506b = str2;
            this.c = hashMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.mobads.openad.c.b, com.baidu.mobads.openad.interfaces.event.IOAdEvent
        public HashMap<String, Object> getData() {
            return this.c;
        }
    }

    public p(Context context, Activity activity, IXAdProdInfo iXAdProdInfo, RelativeLayout relativeLayout, IXAdContainerEventListener iXAdContainerEventListener, IXAdResponseInfo iXAdResponseInfo, View view) {
        this.f3504b = context;
        this.d = activity;
        this.i = iXAdProdInfo;
        this.e = relativeLayout;
        this.f3503a = iXAdContainerEventListener;
        this.f = iXAdResponseInfo;
        this.g = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        this.h = view;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public Context getApplicationContext() {
        return this.f3504b;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public Activity getActivity() {
        if (this.d == null && this.e != null) {
            this.d = (Activity) this.e.getContext();
        }
        return this.d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdContainerEventListener getAdContainerListener() {
        return this.f3503a;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public RelativeLayout getAdProdBase() {
        return this.e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.g;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdResponseInfo getAdResponseInfo() {
        return this.f;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public View getAdLeadingView() {
        return this.h;
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
        if (!this.k.containsKey(str)) {
            this.k.put(str, 1);
            dispatchEvent(new a("regsiter_adservice", str, hashMap));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public void unregisterAdService(String str) {
        if (this.k.containsKey(str)) {
            this.k.remove(str);
            dispatchEvent(new a("unregsiter_adservice", str, new HashMap()));
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public void fireAdMetrics(String str, HashMap<String, String> hashMap) {
        String addParameters = XAdSDKFoundationFacade.getInstance().getURIUitls().addParameters(str, hashMap);
        com.baidu.mobads.openad.d.a aVar = new com.baidu.mobads.openad.d.a();
        com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(addParameters, "");
        cVar.e = 1;
        aVar.a(cVar, (Boolean) true);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdConstants getAdConstants() {
        return XAdSDKFoundationFacade.getInstance().getAdConstants();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdURIUitls getAdUitls4URI() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdBitmapUtils getAdUtils4Bitmap() {
        return XAdSDKFoundationFacade.getInstance().getBitmapUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdViewUtils getAdUtils4View() {
        return XAdSDKFoundationFacade.getInstance().getViewUtils();
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
    public IXAdActivityUtils getAdUtils4Activity() {
        return XAdSDKFoundationFacade.getInstance().getActivityUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdCommonUtils getAdUtils4Common() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdSystemUtils getAdUtils4System() {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IOAdDownloaderManager getDownloaderManager(Context context) {
        return XAdSDKFoundationFacade.getInstance().getDownloaderManager(context);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IBase64 getBase64() {
        return XAdSDKFoundationFacade.getInstance().getBase64();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdLogger getAdLogger() {
        return XAdSDKFoundationFacade.getInstance().getAdLogger();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdResource getAdResource() {
        return XAdSDKFoundationFacade.getInstance().getAdResource();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdErrorCode getErrorCode() {
        return XAdSDKFoundationFacade.getInstance().getErrorCode();
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IXAdProdInfo getAdProdInfo() {
        return this.i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public String getProxyVersion() {
        return "8.8146";
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IOAdTimer createOAdTimer(int i) {
        return new com.baidu.mobads.openad.e.a(i);
    }

    @Override // com.baidu.mobads.interfaces.IXAdContainerContext
    public IOAdTimer createOAdTimer(int i, int i2) {
        return new com.baidu.mobads.openad.e.a(i, i2);
    }
}
