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
/* loaded from: classes3.dex */
public class BaiduNative {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3253a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3254b;
    private c c;
    private BaiduNativeNetworkListener d;
    private BaiduNativeEventListener e;

    /* loaded from: classes3.dex */
    public interface BaiduNativeEventListener {
        void onClicked();

        void onImpressionSended();
    }

    /* loaded from: classes3.dex */
    public interface BaiduNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List<NativeResponse> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class CustomIOAdEventListener implements IOAdEventListener {

        /* renamed from: b  reason: collision with root package name */
        private IXAdFeedsRequestParameters f3256b;

        public CustomIOAdEventListener(IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
            this.f3256b = iXAdFeedsRequestParameters;
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
                BaiduNative.this.c.removeAllListeners();
                if (BaiduNative.this.d != null) {
                    final ArrayList arrayList = new ArrayList();
                    HashSet hashSet = new HashSet();
                    h adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
                    for (int i = 0; i < BaiduNative.this.c.q().size(); i++) {
                        IXAdInstanceInfo iXAdInstanceInfo = BaiduNative.this.c.q().get(i);
                        String appPackageName = iXAdInstanceInfo.getAppPackageName();
                        if (iXAdInstanceInfo.getActionType() == adConstants.getActTypeDownload()) {
                            if (appPackageName == null || appPackageName.equals("") || appPackageName.equals("null") || hashSet.contains(appPackageName)) {
                                z = false;
                                z2 = true;
                            } else {
                                hashSet.add(appPackageName);
                                if (XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(BaiduNative.this.f3253a, appPackageName)) {
                                    z = true;
                                    z2 = false;
                                }
                            }
                            if (z2) {
                                XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, BaiduNative.this, this.f3256b, BaiduNative.this.c.getCurrentXAdContainer());
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
                            BaiduNative.this.d.onNativeLoad(arrayList);
                        }
                    });
                }
            }
            if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                BaiduNative.this.c.removeAllListeners();
                String str = (String) iOAdEvent.getData().get("message");
                if (BaiduNative.this.d != null) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNative.this.d.onNativeFail(NativeErrorCode.LOAD_AD_FAILED);
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
        this.f3253a = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(context.getApplicationContext());
        this.f3254b = str;
        this.d = baiduNativeNetworkListener;
        q.a(context).a();
        this.c = cVar;
    }

    public void destroy() {
    }

    @Deprecated
    public void setNativeEventListener(BaiduNativeEventListener baiduNativeEventListener) {
        this.e = baiduNativeEventListener;
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        requestParameters.mPlacementId = this.f3254b;
        CustomIOAdEventListener customIOAdEventListener = new CustomIOAdEventListener(requestParameters);
        this.c.addEventListener(IXAdEvent.AD_STARTED, customIOAdEventListener);
        this.c.addEventListener(IXAdEvent.AD_ERROR, customIOAdEventListener);
        this.c.a(requestParameters);
        this.c.request();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recordImpression(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.a(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAdAvailable(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        return this.c.a(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.b(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.a(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOnStart(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.b(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOnError(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
        this.c.a(context, i, i2, iXAdInstanceInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOnComplete(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.c(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOnClose(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.a(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOnClickAd(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.d(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOnFullScreen(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.c.b(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }
}
