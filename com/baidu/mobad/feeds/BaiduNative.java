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
    private c aNT;
    private BaiduNativeNetworkListener aNU;
    private BaiduNativeEventListener aNV;
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
        private IXAdFeedsRequestParameters aNW;

        public CustomIOAdEventListener(IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
            this.aNW = iXAdFeedsRequestParameters;
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
                BaiduNative.this.aNT.removeAllListeners();
                if (BaiduNative.this.aNU != null) {
                    final ArrayList arrayList = new ArrayList();
                    HashSet hashSet = new HashSet();
                    h adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
                    for (int i = 0; i < BaiduNative.this.aNT.q().size(); i++) {
                        IXAdInstanceInfo iXAdInstanceInfo = BaiduNative.this.aNT.q().get(i);
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
                                XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, BaiduNative.this, this.aNW, BaiduNative.this.aNT.getCurrentXAdContainer());
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
                            BaiduNative.this.aNU.onNativeLoad(arrayList);
                        }
                    });
                }
            }
            if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                BaiduNative.this.aNT.removeAllListeners();
                String str = (String) iOAdEvent.getData().get("message");
                if (BaiduNative.this.aNU != null) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNative.this.aNU.onNativeFail(NativeErrorCode.LOAD_AD_FAILED);
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
        this.aNU = baiduNativeNetworkListener;
        q.a(context).a();
        this.aNT = cVar;
    }

    public void destroy() {
    }

    @Deprecated
    public void setNativeEventListener(BaiduNativeEventListener baiduNativeEventListener) {
        this.aNV = baiduNativeEventListener;
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        requestParameters.aOa = this.b;
        CustomIOAdEventListener customIOAdEventListener = new CustomIOAdEventListener(requestParameters);
        this.aNT.addEventListener(IXAdEvent.AD_STARTED, customIOAdEventListener);
        this.aNT.addEventListener(IXAdEvent.AD_ERROR, customIOAdEventListener);
        this.aNT.a(requestParameters);
        this.aNT.request();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNT.a(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAdAvailable(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        return this.aNT.a(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNT.a(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNT.b(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
        this.aNT.a(context, i, i2, iXAdInstanceInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNT.c(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNT.a(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNT.d(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.aNT.b(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }
}
