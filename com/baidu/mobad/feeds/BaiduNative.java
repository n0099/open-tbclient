package com.baidu.mobad.feeds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.command.b.a;
import com.baidu.mobads.g.q;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.b.e;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BaiduNative {

    /* renamed from: a  reason: collision with root package name */
    private List<NativeResponse> f3216a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f3217b;
    private final String c;
    private e d;
    private BaiduNativeNetworkListener e;
    private NativeDownloadListener f;
    private BaiduNativeEventListener g;
    private CustomIOAdEventListener h;

    /* loaded from: classes5.dex */
    public interface BaiduNativeEventListener {
        void onClicked();

        void onImpressionSended();
    }

    /* loaded from: classes5.dex */
    public interface BaiduNativeLoadAdListener extends NativeADEventListener {
        void onLoadFail(String str, String str2);
    }

    /* loaded from: classes5.dex */
    public interface BaiduNativeNetworkListener {
        @Deprecated
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List<NativeResponse> list);
    }

    /* loaded from: classes5.dex */
    public interface FeedLpCloseListener extends BaiduNativeNetworkListener {
        void onAdClick(NativeResponse nativeResponse);

        void onLpClosed();
    }

    /* loaded from: classes5.dex */
    public interface NativeADEventListener extends VideoCacheListener {
        void onADExposed(NativeResponse nativeResponse);
    }

    /* loaded from: classes5.dex */
    public interface NativeDownloadListener {
        void onADStatusChanged(NativeResponse nativeResponse);
    }

    /* loaded from: classes5.dex */
    public interface VideoCacheListener extends FeedLpCloseListener {
        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class CustomIOAdEventListener implements IOAdEventListener {

        /* renamed from: b  reason: collision with root package name */
        private IXAdFeedsRequestParameters f3219b;

        public CustomIOAdEventListener(IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
            this.f3219b = iXAdFeedsRequestParameters;
        }

        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Map<String, Object> data2;
            boolean z;
            boolean z2;
            int i = 0;
            if (IXAdEvent.AD_STARTED.equals(iOAdEvent.getType())) {
                if (BaiduNative.this.e != null) {
                    final ArrayList arrayList = new ArrayList();
                    HashSet hashSet = new HashSet();
                    l adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
                    for (int i2 = 0; i2 < BaiduNative.this.d.a().size(); i2++) {
                        IXAdInstanceInfo iXAdInstanceInfo = BaiduNative.this.d.a().get(i2);
                        String appPackageName = iXAdInstanceInfo.getAppPackageName();
                        if (iXAdInstanceInfo.getActionType() == adConstants.getActTypeDownload()) {
                            if (appPackageName == null || appPackageName.equals("") || appPackageName.equals("null") || hashSet.contains(appPackageName)) {
                                z = false;
                                z2 = true;
                            } else {
                                hashSet.add(appPackageName);
                                z = !XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(BaiduNative.this.f3217b, appPackageName);
                                z2 = false;
                            }
                        } else if (iXAdInstanceInfo.getActionType() == adConstants.getActTypeOpenExternalApp() && BaiduNative.this.a(iXAdInstanceInfo) == adConstants.getActTypeDownload() && !TextUtils.isEmpty(appPackageName)) {
                            z = !XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(BaiduNative.this.f3217b, appPackageName);
                            z2 = false;
                        } else {
                            z = false;
                            z2 = false;
                        }
                        if (!z2) {
                            XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, BaiduNative.this.d, this.f3219b, BaiduNative.this.d.getCurrentXAdContainer());
                            xAdNativeResponse.setIsDownloadApp(z);
                            arrayList.add(xAdNativeResponse);
                        }
                    }
                    BaiduNative.this.f3216a = arrayList;
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNative.this.e.onNativeLoad(arrayList);
                        }
                    });
                }
            } else if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                BaiduNative.this.d.removeAllListeners();
                final String str = (String) iOAdEvent.getData().get("error_message");
                final String str2 = (String) iOAdEvent.getData().get("error_code");
                if (BaiduNative.this.e != null) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNative.this.e.onNativeFail(NativeErrorCode.LOAD_AD_FAILED);
                        }
                    });
                }
                if (BaiduNative.this.e instanceof BaiduNativeLoadAdListener) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ((BaiduNativeLoadAdListener) BaiduNative.this.e).onLoadFail(str, str2);
                        }
                    });
                }
            } else if ("AdUserClick".equals(iOAdEvent.getType())) {
                if ((BaiduNative.this.e instanceof FeedLpCloseListener) && (data2 = iOAdEvent.getData()) != null) {
                    String str3 = (String) data2.get("instanceInfo");
                    while (true) {
                        int i3 = i;
                        if (i3 >= BaiduNative.this.f3216a.size()) {
                            break;
                        }
                        XAdNativeResponse xAdNativeResponse2 = (XAdNativeResponse) BaiduNative.this.f3216a.get(i3);
                        if (xAdNativeResponse2.getUniqueId().equals(str3)) {
                            ((FeedLpCloseListener) BaiduNative.this.e).onAdClick(xAdNativeResponse2);
                        }
                        i = i3 + 1;
                    }
                }
                if ((BaiduNative.this.e instanceof FeedLpCloseListener) && BaiduNative.this.d.d.getActionType() == 1) {
                    a.a(BaiduNative.this.f3217b).b();
                    a.a(BaiduNative.this.f3217b).addEventListener("AdLpClosed", BaiduNative.this.h);
                }
            } else if ("AdStartLp".equals(iOAdEvent.getType()) && (BaiduNative.this.e instanceof FeedLpCloseListener)) {
                a.a(BaiduNative.this.f3217b).b();
                a.a(BaiduNative.this.f3217b).addEventListener("AdLpClosed", BaiduNative.this.h);
            } else if ("AdLpClosed".equals(iOAdEvent.getType()) && (BaiduNative.this.e instanceof FeedLpCloseListener)) {
                a.a(BaiduNative.this.f3217b).removeEventListeners("AdLpClosed");
                a.a(BaiduNative.this.f3217b).c();
                ((FeedLpCloseListener) BaiduNative.this.e).onLpClosed();
            } else if ("vdieoCacheSucc".equals(iOAdEvent.getType())) {
                if (BaiduNative.this.e instanceof VideoCacheListener) {
                    ((VideoCacheListener) BaiduNative.this.e).onVideoDownloadSuccess();
                }
            } else if ("vdieoCacheFailed".equals(iOAdEvent.getType())) {
                if (BaiduNative.this.e instanceof VideoCacheListener) {
                    ((VideoCacheListener) BaiduNative.this.e).onVideoDownloadFailed();
                }
            } else if (IXAdEvent.AD_IMPRESSION.equals(iOAdEvent.getType())) {
                if ((BaiduNative.this.e instanceof NativeADEventListener) && (data = iOAdEvent.getData()) != null) {
                    String str4 = (String) data.get("instanceInfo");
                    while (true) {
                        int i4 = i;
                        if (i4 < BaiduNative.this.f3216a.size()) {
                            XAdNativeResponse xAdNativeResponse3 = (XAdNativeResponse) BaiduNative.this.f3216a.get(i4);
                            if (xAdNativeResponse3.getUniqueId().equals(str4)) {
                                ((NativeADEventListener) BaiduNative.this.e).onADExposed(xAdNativeResponse3);
                            }
                            i = i4 + 1;
                        } else {
                            return;
                        }
                    }
                }
            } else if ("AdStatusChange".equals(iOAdEvent.getType()) && BaiduNative.this.f != null) {
                Map<String, Object> data3 = iOAdEvent.getData();
                String message = iOAdEvent.getMessage();
                if (data3 != null && !TextUtils.isEmpty(message)) {
                    while (i < BaiduNative.this.f3216a.size()) {
                        XAdNativeResponse xAdNativeResponse4 = (XAdNativeResponse) BaiduNative.this.f3216a.get(i);
                        if (xAdNativeResponse4.isDownloadApp() && message.equals(xAdNativeResponse4.getAppPackage())) {
                            BaiduNative.this.f.onADStatusChanged(xAdNativeResponse4);
                        }
                        i++;
                    }
                }
            }
        }
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener) {
        this(context, str, baiduNativeNetworkListener, new e(context, str));
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, boolean z) {
        this(context, str, baiduNativeNetworkListener, new e(context, str, z));
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, int i) {
        this(context, str, baiduNativeNetworkListener, new e(context, str, i));
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, boolean z, int i) {
        this(context, str, baiduNativeNetworkListener, new e(context, str, z, i));
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, boolean z, int i, String str2) {
        this.f3217b = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(context.getApplicationContext());
        this.c = str;
        this.e = baiduNativeNetworkListener;
        q.a(context).a();
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("insite")) {
                this.d = new e(context, str, IXAdConstants4PDK.SlotType.SLOT_TYPE_INSITE, z, i);
            } else if (str2.equals("sug")) {
                this.d = new e(context, str, IXAdConstants4PDK.SlotType.SLOT_TYPE_SUG, z, i);
            } else {
                this.d = new e(context, str, z, i);
            }
        }
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, e eVar) {
        this.f3217b = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(context.getApplicationContext());
        this.c = str;
        this.e = baiduNativeNetworkListener;
        q.a(context).a();
        this.d = eVar;
    }

    public void destroy() {
    }

    @Deprecated
    public void setNativeEventListener(BaiduNativeEventListener baiduNativeEventListener) {
        this.g = baiduNativeEventListener;
    }

    public void setDownloadListener(NativeDownloadListener nativeDownloadListener) {
        this.f = nativeDownloadListener;
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        if (this.d != null) {
            this.d.b(z);
        }
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        requestParameters.mPlacementId = this.c;
        this.h = new CustomIOAdEventListener(requestParameters);
        this.d.addEventListener(IXAdEvent.AD_STARTED, this.h);
        this.d.addEventListener("AdStartLp", this.h);
        this.d.addEventListener("AdUserClick", this.h);
        this.d.addEventListener(IXAdEvent.AD_ERROR, this.h);
        this.d.addEventListener("vdieoCacheSucc", this.h);
        this.d.addEventListener("vdieoCacheFailed", this.h);
        this.d.addEventListener(IXAdEvent.AD_IMPRESSION, this.h);
        this.d.addEventListener("AdStatusChange", this.h);
        this.d.a(requestParameters);
        this.d.request();
    }

    public void preloadVideoMaterial() {
        if (this.f3216a != null) {
            Iterator<NativeResponse> it = this.f3216a.iterator();
            while (it.hasNext()) {
                ((XAdNativeResponse) it.next()).preloadVideoMaterial();
            }
        }
    }

    protected void recordImpression(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.d.a(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected boolean isAdAvailable(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        return this.d.a(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.d.b(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.d.a(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters);
    }

    protected void handleOnStart(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.d.b(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnError(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
        this.d.a(context, i, i2, iXAdInstanceInfo);
    }

    protected void handleOnComplete(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.d.c(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnClose(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.d.a(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnClickAd(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.d.d(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnFullScreen(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.d.b(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo != null) {
            try {
                if (iXAdInstanceInfo.getActionType() == 512) {
                    try {
                        return new JSONObject(iXAdInstanceInfo.getAppOpenStrs()).optInt("fb_act");
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th2) {
            }
        }
        return 0;
    }
}
