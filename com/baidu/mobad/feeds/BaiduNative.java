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
/* loaded from: classes20.dex */
public class BaiduNative {
    private final Context a;
    private final String b;
    private c bwH;
    private BaiduNativeNetworkListener bwI;
    private BaiduNativeEventListener bwJ;

    /* loaded from: classes20.dex */
    public interface BaiduNativeEventListener {
        void onClicked();

        void onImpressionSended();
    }

    /* loaded from: classes20.dex */
    public interface BaiduNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List<NativeResponse> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class CustomIOAdEventListener implements IOAdEventListener {
        private IXAdFeedsRequestParameters bwK;

        public CustomIOAdEventListener(IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
            this.bwK = iXAdFeedsRequestParameters;
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
                BaiduNative.this.bwH.removeAllListeners();
                if (BaiduNative.this.bwI != null) {
                    final ArrayList arrayList = new ArrayList();
                    HashSet hashSet = new HashSet();
                    h adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
                    for (int i = 0; i < BaiduNative.this.bwH.q().size(); i++) {
                        IXAdInstanceInfo iXAdInstanceInfo = BaiduNative.this.bwH.q().get(i);
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
                                XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, BaiduNative.this, this.bwK, BaiduNative.this.bwH.getCurrentXAdContainer());
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
                            BaiduNative.this.bwI.onNativeLoad(arrayList);
                        }
                    });
                }
            }
            if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                BaiduNative.this.bwH.removeAllListeners();
                String str = (String) iOAdEvent.getData().get("message");
                if (BaiduNative.this.bwI != null) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNative.this.bwI.onNativeFail(NativeErrorCode.LOAD_AD_FAILED);
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
        this.bwI = baiduNativeNetworkListener;
        q.a(context).a();
        this.bwH = cVar;
    }

    public void destroy() {
    }

    @Deprecated
    public void setNativeEventListener(BaiduNativeEventListener baiduNativeEventListener) {
        this.bwJ = baiduNativeEventListener;
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        requestParameters.bwO = this.b;
        CustomIOAdEventListener customIOAdEventListener = new CustomIOAdEventListener(requestParameters);
        this.bwH.addEventListener(IXAdEvent.AD_STARTED, customIOAdEventListener);
        this.bwH.addEventListener(IXAdEvent.AD_ERROR, customIOAdEventListener);
        this.bwH.a(requestParameters);
        this.bwH.request();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.bwH.a(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAdAvailable(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        return this.bwH.a(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.bwH.a(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.bwH.b(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
        this.bwH.a(context, i, i2, iXAdInstanceInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.bwH.c(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.bwH.a(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.bwH.d(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.bwH.b(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }
}
