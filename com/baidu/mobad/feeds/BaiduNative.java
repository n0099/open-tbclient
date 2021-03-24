package com.baidu.mobad.feeds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes2.dex */
public class BaiduNative {

    /* renamed from: a  reason: collision with root package name */
    public List<NativeResponse> f7991a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f7992b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7993c;

    /* renamed from: d  reason: collision with root package name */
    public e f7994d;

    /* renamed from: e  reason: collision with root package name */
    public BaiduNativeNetworkListener f7995e;

    /* renamed from: f  reason: collision with root package name */
    public NativeDownloadListener f7996f;

    /* renamed from: g  reason: collision with root package name */
    public BaiduNativeEventListener f7997g;

    /* renamed from: h  reason: collision with root package name */
    public CustomIOAdEventListener f7998h;

    /* loaded from: classes2.dex */
    public interface BaiduNativeEventListener {
        void onClicked();

        void onImpressionSended();
    }

    /* loaded from: classes2.dex */
    public interface BaiduNativeLoadAdListener extends NativeADEventListener {
        void onLoadFail(String str, String str2);
    }

    /* loaded from: classes2.dex */
    public interface BaiduNativeNetworkListener {
        @Deprecated
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List<NativeResponse> list);
    }

    /* loaded from: classes2.dex */
    public class CustomIOAdEventListener implements IOAdEventListener {

        /* renamed from: b  reason: collision with root package name */
        public IXAdFeedsRequestParameters f8000b;

        public CustomIOAdEventListener(IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
            this.f8000b = iXAdFeedsRequestParameters;
        }

        /* JADX WARN: Removed duplicated region for block: B:113:0x00da A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
        @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Map<String, Object> data2;
            boolean z;
            boolean isInstalled;
            boolean z2;
            int i = 0;
            if (IXAdEvent.AD_STARTED.equals(iOAdEvent.getType())) {
                if (BaiduNative.this.f7995e != null) {
                    final ArrayList arrayList = new ArrayList();
                    HashSet hashSet = new HashSet();
                    l adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
                    for (int i2 = 0; i2 < BaiduNative.this.f7994d.a().size(); i2++) {
                        IXAdInstanceInfo iXAdInstanceInfo = BaiduNative.this.f7994d.a().get(i2);
                        String appPackageName = iXAdInstanceInfo.getAppPackageName();
                        if (iXAdInstanceInfo.getActionType() == adConstants.getActTypeDownload()) {
                            if (appPackageName == null || appPackageName.equals("") || appPackageName.equals(StringUtil.NULL_STRING) || hashSet.contains(appPackageName)) {
                                z = false;
                                z2 = true;
                                if (!z2) {
                                    XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(iXAdInstanceInfo, BaiduNative.this.f7994d, this.f8000b, BaiduNative.this.f7994d.getCurrentXAdContainer());
                                    xAdNativeResponse.setIsDownloadApp(z);
                                    arrayList.add(xAdNativeResponse);
                                }
                            } else {
                                hashSet.add(appPackageName);
                                isInstalled = XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(BaiduNative.this.f7992b, appPackageName);
                            }
                        } else if (iXAdInstanceInfo.getActionType() == adConstants.getActTypeOpenExternalApp() && BaiduNative.this.a(iXAdInstanceInfo) == adConstants.getActTypeDownload() && !TextUtils.isEmpty(appPackageName)) {
                            isInstalled = XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(BaiduNative.this.f7992b, appPackageName);
                        } else {
                            z = false;
                            z2 = false;
                            if (!z2) {
                            }
                        }
                        z = !isInstalled;
                        z2 = false;
                        if (!z2) {
                        }
                    }
                    BaiduNative.this.f7991a = arrayList;
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNative.this.f7995e.onNativeLoad(arrayList);
                        }
                    });
                }
            } else if (IXAdEvent.AD_ERROR.equals(iOAdEvent.getType())) {
                BaiduNative.this.f7994d.removeAllListeners();
                final String str = (String) iOAdEvent.getData().get("error_message");
                final String str2 = (String) iOAdEvent.getData().get("error_code");
                if (BaiduNative.this.f7995e != null) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BaiduNative.this.f7995e.onNativeFail(NativeErrorCode.LOAD_AD_FAILED);
                        }
                    });
                }
                if (BaiduNative.this.f7995e instanceof BaiduNativeLoadAdListener) {
                    XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new Runnable() { // from class: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ((BaiduNativeLoadAdListener) BaiduNative.this.f7995e).onLoadFail(str, str2);
                        }
                    });
                }
            } else if ("AdUserClick".equals(iOAdEvent.getType())) {
                if ((BaiduNative.this.f7995e instanceof FeedLpCloseListener) && (data2 = iOAdEvent.getData()) != null) {
                    String str3 = (String) data2.get("instanceInfo");
                    while (i < BaiduNative.this.f7991a.size()) {
                        XAdNativeResponse xAdNativeResponse2 = (XAdNativeResponse) BaiduNative.this.f7991a.get(i);
                        if (xAdNativeResponse2.getUniqueId().equals(str3)) {
                            ((FeedLpCloseListener) BaiduNative.this.f7995e).onAdClick(xAdNativeResponse2);
                        }
                        i++;
                    }
                }
                if ((BaiduNative.this.f7995e instanceof FeedLpCloseListener) && BaiduNative.this.f7994d.f8436d.getActionType() == 1) {
                    a.a(BaiduNative.this.f7992b).b();
                    a.a(BaiduNative.this.f7992b).addEventListener("AdLpClosed", BaiduNative.this.f7998h);
                }
            } else if ("AdStartLp".equals(iOAdEvent.getType()) && (BaiduNative.this.f7995e instanceof FeedLpCloseListener)) {
                a.a(BaiduNative.this.f7992b).b();
                a.a(BaiduNative.this.f7992b).addEventListener("AdLpClosed", BaiduNative.this.f7998h);
            } else if ("AdLpClosed".equals(iOAdEvent.getType()) && (BaiduNative.this.f7995e instanceof FeedLpCloseListener)) {
                a.a(BaiduNative.this.f7992b).removeEventListeners("AdLpClosed");
                a.a(BaiduNative.this.f7992b).c();
                ((FeedLpCloseListener) BaiduNative.this.f7995e).onLpClosed();
            } else if ("vdieoCacheSucc".equals(iOAdEvent.getType())) {
                if (BaiduNative.this.f7995e instanceof VideoCacheListener) {
                    ((VideoCacheListener) BaiduNative.this.f7995e).onVideoDownloadSuccess();
                }
            } else if ("vdieoCacheFailed".equals(iOAdEvent.getType())) {
                if (BaiduNative.this.f7995e instanceof VideoCacheListener) {
                    ((VideoCacheListener) BaiduNative.this.f7995e).onVideoDownloadFailed();
                }
            } else if (IXAdEvent.AD_IMPRESSION.equals(iOAdEvent.getType())) {
                if (!(BaiduNative.this.f7995e instanceof NativeADEventListener) || (data = iOAdEvent.getData()) == null) {
                    return;
                }
                String str4 = (String) data.get("instanceInfo");
                while (i < BaiduNative.this.f7991a.size()) {
                    XAdNativeResponse xAdNativeResponse3 = (XAdNativeResponse) BaiduNative.this.f7991a.get(i);
                    if (xAdNativeResponse3.getUniqueId().equals(str4)) {
                        ((NativeADEventListener) BaiduNative.this.f7995e).onADExposed(xAdNativeResponse3);
                    }
                    i++;
                }
            } else if ("AdStatusChange".equals(iOAdEvent.getType()) && BaiduNative.this.f7996f != null) {
                Map<String, Object> data3 = iOAdEvent.getData();
                String message = iOAdEvent.getMessage();
                if (data3 == null || TextUtils.isEmpty(message)) {
                    return;
                }
                while (i < BaiduNative.this.f7991a.size()) {
                    XAdNativeResponse xAdNativeResponse4 = (XAdNativeResponse) BaiduNative.this.f7991a.get(i);
                    if (xAdNativeResponse4.isDownloadApp() && message.equals(xAdNativeResponse4.getAppPackage())) {
                        BaiduNative.this.f7996f.onADStatusChanged(xAdNativeResponse4);
                    }
                    i++;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface FeedLpCloseListener extends BaiduNativeNetworkListener {
        void onAdClick(NativeResponse nativeResponse);

        void onLpClosed();
    }

    /* loaded from: classes2.dex */
    public interface NativeADEventListener extends VideoCacheListener {
        void onADExposed(NativeResponse nativeResponse);
    }

    /* loaded from: classes2.dex */
    public interface NativeDownloadListener {
        void onADStatusChanged(NativeResponse nativeResponse);
    }

    /* loaded from: classes2.dex */
    public interface VideoCacheListener extends FeedLpCloseListener {
        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener) {
        this(context, str, baiduNativeNetworkListener, new e(context, str));
    }

    public static void setAppSid(Context context, String str) {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    public void destroy() {
    }

    public void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f7994d.b(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void handleOnClickAd(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f7994d.d(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void handleOnClose(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f7994d.a(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void handleOnComplete(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f7994d.c(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void handleOnError(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
        this.f7994d.a(context, i, i2, iXAdInstanceInfo);
    }

    public void handleOnFullScreen(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f7994d.b(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void handleOnStart(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f7994d.b(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public boolean isAdAvailable(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        return this.f7994d.a(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void preloadVideoMaterial() {
        List<NativeResponse> list = this.f7991a;
        if (list != null) {
            Iterator<NativeResponse> it = list.iterator();
            while (it.hasNext()) {
                ((XAdNativeResponse) it.next()).preloadVideoMaterial();
            }
        }
    }

    public void recordImpression(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f7994d.a(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        e eVar = this.f7994d;
        if (eVar != null) {
            eVar.b(z);
        }
    }

    public void setDownloadListener(NativeDownloadListener nativeDownloadListener) {
        this.f7996f = nativeDownloadListener;
    }

    @Deprecated
    public void setNativeEventListener(BaiduNativeEventListener baiduNativeEventListener) {
        this.f7997g = baiduNativeEventListener;
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, boolean z) {
        this(context, str, baiduNativeNetworkListener, new e(context, str, z));
    }

    public void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f7994d.a(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters);
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        requestParameters.mPlacementId = this.f7993c;
        CustomIOAdEventListener customIOAdEventListener = new CustomIOAdEventListener(requestParameters);
        this.f7998h = customIOAdEventListener;
        this.f7994d.addEventListener(IXAdEvent.AD_STARTED, customIOAdEventListener);
        this.f7994d.addEventListener("AdStartLp", this.f7998h);
        this.f7994d.addEventListener("AdUserClick", this.f7998h);
        this.f7994d.addEventListener(IXAdEvent.AD_ERROR, this.f7998h);
        this.f7994d.addEventListener("vdieoCacheSucc", this.f7998h);
        this.f7994d.addEventListener("vdieoCacheFailed", this.f7998h);
        this.f7994d.addEventListener(IXAdEvent.AD_IMPRESSION, this.f7998h);
        this.f7994d.addEventListener("AdStatusChange", this.f7998h);
        this.f7994d.a(requestParameters);
        this.f7994d.request();
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, int i) {
        this(context, str, baiduNativeNetworkListener, new e(context, str, i));
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, boolean z, int i) {
        this(context, str, baiduNativeNetworkListener, new e(context, str, z, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo != null) {
            try {
                if (iXAdInstanceInfo.getActionType() == 512) {
                    return new JSONObject(iXAdInstanceInfo.getAppOpenStrs()).optInt("fb_act");
                }
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
        return 0;
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, boolean z, int i, String str2) {
        this.f7992b = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(context.getApplicationContext());
        this.f7993c = str;
        this.f7995e = baiduNativeNetworkListener;
        q.a(context).a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.equals("insite")) {
            this.f7994d = new e(context, str, IXAdConstants4PDK.SlotType.SLOT_TYPE_INSITE, z, i);
        } else if (str2.equals("sug")) {
            this.f7994d = new e(context, str, IXAdConstants4PDK.SlotType.SLOT_TYPE_SUG, z, i);
        } else {
            this.f7994d = new e(context, str, z, i);
        }
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, e eVar) {
        this.f7992b = context;
        XAdSDKFoundationFacade.getInstance().initializeApplicationContext(context.getApplicationContext());
        this.f7993c = str;
        this.f7995e = baiduNativeNetworkListener;
        q.a(context).a();
        this.f7994d = eVar;
    }
}
