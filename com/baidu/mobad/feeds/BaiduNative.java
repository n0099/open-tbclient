package com.baidu.mobad.feeds;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.g.q;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.c.c;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes10.dex */
public class BaiduNative {
    private final Context a;
    private c aNS;
    private BaiduNativeNetworkListener aNT;
    private BaiduNativeEventListener aNU;
    private final String b;

    /* loaded from: classes10.dex */
    public interface BaiduNativeEventListener {
        void onClicked();

        void onImpressionSended();
    }

    /* loaded from: classes10.dex */
    public interface BaiduNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List<NativeResponse> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class CustomIOAdEventListener implements IOAdEventListener {
        private IXAdFeedsRequestParameters aNV;

        public CustomIOAdEventListener(IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
            this.aNV = iXAdFeedsRequestParameters;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x009a A[SYNTHETIC] */
        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run(IOAdEvent iOAdEvent) {
            boolean z;
            boolean z2;
            if (IXAdEvent.AD_STARTED.equals(iOAdEvent.getType())) {
                BaiduNative.this.aNS.removeAllListeners();
                if (BaiduNative.this.aNT != null) {
                    final ArrayList arrayList = new ArrayList();
                    HashSet hashSet = new HashSet();
                    h adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
                    for (int i = 0; i < BaiduNative.this.aNS.q().size(); i++) {
                        IXAdInstanceInfo iXAdInstanceInfo = BaiduNative.this.aNS.q().get(i);
                        String appPackageName = iXAdInstanceInfo.getAppPackageName();
                        if (iXAdInstanceInfo.getActionType() == adConstants.getActTypeDownload()) {
                            if (appPackageName == null || appPackageName.equals("") || appPackageName.equals("null") || hashSet.contains(appPackageName)) {
                                z = false;
                                z2 = true;
                            } else {
                                hashSet.add(appPackageName);
                                if (XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(BaiduNative.this.a, appPackageName)) {
                                    z = true;
                                    z2 = false;
                                }
                            }
                            if (z2) {
                                XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, BaiduNative.this, this.aNV, BaiduNative.this.aNS.getCurrentXAdContainer());
                                if (z) {
                                    xAdNativeResponse.setIsDownloadApp(false);
                                }
                                arrayList.add(xAdNativeResponse);
                            }
                        }
                        z = false;
                        z2 = false;
                        if (z2) {
                        }
                    }
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNative.this.aNT.onNativeLoad(arrayList);
                        }
                    });
                }
            }
            if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                BaiduNative.this.aNS.removeAllListeners();
                String str = (String) iOAdEvent.getData().get("message");
                if (BaiduNative.this.aNT != null) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNative.this.aNT.onNativeFail(NativeErrorCode.LOAD_AD_FAILED);
                        }
                    });
                }
            }
        }
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener) {
        this(context, str, baiduNativeNetworkListener, new c(context, str));
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, c cVar) {
        this.a = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(context.getApplicationContext());
        this.b = str;
        this.aNT = baiduNativeNetworkListener;
        q.a(context).a();
        this.aNS = cVar;
    }

    public void destroy() {
    }

    @Deprecated
    public void setNativeEventListener(BaiduNativeEventListener baiduNativeEventListener) {
        this.aNU = baiduNativeEventListener;
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        requestParameters.aNZ = this.b;
        CustomIOAdEventListener customIOAdEventListener = new CustomIOAdEventListener(requestParameters);
        this.aNS.addEventListener(IXAdEvent.AD_STARTED, customIOAdEventListener);
        this.aNS.addEventListener(IXAdEvent.AD_ERROR, customIOAdEventListener);
        this.aNS.a(requestParameters);
        this.aNS.request();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNS.a(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAdAvailable(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        return this.aNS.a(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNS.a(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNS.b(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
        this.aNS.a(context, i, i2, iXAdInstanceInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNS.c(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNS.a(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNS.d(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNS.b(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }
}
