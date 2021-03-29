package com.baidu.mobad.feeds;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.b.a;
import com.baidu.mobads.component.AdLogInfo;
import com.baidu.mobads.g.b;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.production.b.e;
import com.baidu.mobads.r;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.c;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.XAdInstanceInfo;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import dalvik.system.DexClassLoader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdNativeResponse implements NativeResponse {

    /* renamed from: a  reason: collision with root package name */
    public IXAdInstanceInfo f8033a;

    /* renamed from: b  reason: collision with root package name */
    public e f8034b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8035c;

    /* renamed from: d  reason: collision with root package name */
    public IXAdFeedsRequestParameters f8036d;

    /* renamed from: e  reason: collision with root package name */
    public IXAdContainer f8037e;

    /* renamed from: f  reason: collision with root package name */
    public NativeResponse.AdInteractionListener f8038f;

    /* renamed from: g  reason: collision with root package name */
    public NativeResponse.AdPrivacyListener f8039g;

    /* renamed from: h  reason: collision with root package name */
    public IXAdURIUitls f8040h;

    /* loaded from: classes2.dex */
    public class ResponseInvocationHandlerImp implements InvocationHandler {
        public ResponseInvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals("onShow")) {
                if (XAdNativeResponse.this.f8039g != null) {
                    XAdNativeResponse.this.f8039g.onADPermissionShow();
                }
            } else if (name.equals("onDismiss") && XAdNativeResponse.this.f8039g != null) {
                XAdNativeResponse.this.f8039g.onADPermissionClose();
            }
            return null;
        }
    }

    public XAdNativeResponse(IXAdInstanceInfo iXAdInstanceInfo, e eVar, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.f8035c = false;
        this.f8033a = iXAdInstanceInfo;
        this.f8034b = eVar;
        this.f8037e = iXAdContainer;
        if (this.f8033a.getActionType() == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload()) {
            this.f8035c = true;
        }
        this.f8036d = iXAdFeedsRequestParameters;
        this.f8040h = XAdSDKFoundationFacade.getInstance().getURIUitls();
    }

    public AdLogInfo getAdLogInfo() {
        AdLogInfo adLogInfo = new AdLogInfo();
        IXAdFeedsRequestParameters iXAdFeedsRequestParameters = this.f8036d;
        if (iXAdFeedsRequestParameters != null) {
            adLogInfo.setAdPlaceId(iXAdFeedsRequestParameters.getAdPlacementId());
        }
        IXAdInstanceInfo iXAdInstanceInfo = this.f8033a;
        if (iXAdInstanceInfo != null) {
            adLogInfo.setQk(iXAdInstanceInfo.getQueryKey());
            adLogInfo.setVideoUrl(this.f8033a.getVideoUrl());
        }
        return adLogInfo;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAdLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAdMaterialType() {
        if (this.f8033a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) {
            return NativeResponse.MaterialType.VIDEO.getValue();
        }
        if (this.f8033a.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML) {
            return NativeResponse.MaterialType.HTML.getValue();
        }
        return NativeResponse.MaterialType.NORMAL.getValue();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppPackage() {
        return this.f8033a.getAppPackageName();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppPermissionLink() {
        JSONObject originJsonObject;
        IXAdInstanceInfo iXAdInstanceInfo = this.f8033a;
        return (iXAdInstanceInfo == null || (originJsonObject = iXAdInstanceInfo.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("permission_link", "");
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppPrivacyLink() {
        JSONObject originJsonObject;
        IXAdInstanceInfo iXAdInstanceInfo = this.f8033a;
        return (iXAdInstanceInfo == null || (originJsonObject = iXAdInstanceInfo.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("privacy_link", "");
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public long getAppSize() {
        return this.f8033a.getAppSize();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppVersion() {
        JSONObject originJsonObject;
        IXAdInstanceInfo iXAdInstanceInfo = this.f8033a;
        return (iXAdInstanceInfo == null || (originJsonObject = iXAdInstanceInfo.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("app_version", "");
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getBaiduLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getBrandName() {
        return this.f8033a.getAppName();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getContainerHeight() {
        return this.f8033a.getAdContainerHeight();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getContainerSizeType() {
        return this.f8033a.getAdContainerSizeType();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getContainerWidth() {
        return this.f8033a.getAdContainerWidth();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getDesc() {
        return this.f8033a.getDescription();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getDownloadStatus() {
        IXAdContainer iXAdContainer;
        if (!this.f8035c || (iXAdContainer = this.f8037e) == null || iXAdContainer.getAdContainerContext() == null) {
            return -1;
        }
        return c.a(this.f8037e.getAdContainerContext().getApplicationContext()).a(this.f8037e.getAdContainerContext().getApplicationContext(), getAppPackage());
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getDuration() {
        return this.f8033a.getVideoDuration();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getECPMLevel() {
        JSONObject originJsonObject;
        IXAdInstanceInfo iXAdInstanceInfo = this.f8033a;
        return (iXAdInstanceInfo == null || (originJsonObject = iXAdInstanceInfo.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("bidlayer", "");
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public Map<String, String> getExtras() {
        return null;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getHtmlSnippet() {
        return this.f8033a.getHtmlSnippet();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getIconUrl() {
        String iconUrl = this.f8033a.getIconUrl();
        return (iconUrl == null || iconUrl.equals("")) ? this.f8033a.getMainPictureUrl() : iconUrl;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getImageUrl() {
        return this.f8033a.getMainPictureUrl();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getMainPicHeight() {
        return this.f8033a.getMainMaterialHeight();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getMainPicWidth() {
        return this.f8033a.getMainMaterialWidth();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        if (this.f8033a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) {
            return NativeResponse.MaterialType.VIDEO;
        }
        if (this.f8033a.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML) {
            return NativeResponse.MaterialType.HTML;
        }
        return NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public List<String> getMultiPicUrls() {
        try {
            JSONArray optJSONArray = this.f8033a.getOriginJsonObject().optJSONArray("morepics");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (Exception unused) {
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }

    public String getMute() {
        return this.f8033a.getMute();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getPublisher() {
        JSONObject originJsonObject;
        IXAdInstanceInfo iXAdInstanceInfo = this.f8033a;
        return (iXAdInstanceInfo == null || (originJsonObject = iXAdInstanceInfo.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("publisher", "");
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getStyleType() {
        return this.f8033a.getFeedAdStyleType();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getTitle() {
        return this.f8033a.getTitle();
    }

    public String getUniqueId() {
        return this.f8033a.getUniqueId();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getVideoUrl() {
        return this.f8033a.getVideoUrl();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public WebView getWebView() {
        return (WebView) this.f8037e.getAdView();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void handleClick(View view) {
        handleClick(view, -1);
    }

    public void handleClickDownloadDirect(View view) {
        if (supportDownloadDirect()) {
            try {
                XAdInstanceInfo xAdInstanceInfo = (XAdInstanceInfo) ((XAdInstanceInfo) this.f8033a).clone();
                xAdInstanceInfo.setAction("");
                a(view, -1, xAdInstanceInfo);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isAdAvailable(Context context) {
        return this.f8034b.a(context, this.f8033a, this.f8036d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isAutoPlay() {
        return this.f8033a.getOriginJsonObject().optInt("auto_play", 0) == 1;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isDownloadApp() {
        return this.f8035c;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isNonWifiAutoPlay() {
        try {
            return this.f8033a.getOriginJsonObject().optInt("auto_play_non_wifi", 1) == 1;
        } catch (Throwable unused) {
            return true;
        }
    }

    public boolean isVideoMuted() {
        return this.f8033a.isVideoMuted();
    }

    public void onADExposed() {
        NativeResponse.AdInteractionListener adInteractionListener = this.f8038f;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposed();
        }
    }

    public void onADStatusChanged() {
        NativeResponse.AdInteractionListener adInteractionListener = this.f8038f;
        if (adInteractionListener != null) {
            adInteractionListener.onADStatusChanged();
        }
    }

    public void onAdClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.f8038f;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClick();
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onClickAd(Context context) {
        this.f8034b.d(context, this.f8033a, this.f8036d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onClose(Context context, int i) {
        this.f8034b.a(context, i, this.f8033a, this.f8036d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onComplete(Context context) {
        this.f8034b.c(context, this.f8033a, this.f8036d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onError(Context context, int i, int i2) {
        this.f8034b.a(context, i, i2, this.f8033a);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onFullScreen(Context context, int i) {
        this.f8034b.b(context, i, this.f8033a, this.f8036d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onStart(Context context) {
        this.f8034b.b(context, this.f8033a, this.f8036d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void pauseAppDownload() {
        IXAdContainer iXAdContainer;
        if (!this.f8035c || (iXAdContainer = this.f8037e) == null || iXAdContainer.getAdContainerContext() == null) {
            return;
        }
        c.a(this.f8037e.getAdContainerContext().getApplicationContext()).a(getAppPackage());
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void permissionClick() {
        Class<?> cls;
        q a2 = q.a();
        try {
            Activity activity = this.f8037e.getAdContainerContext().getActivity();
            DexClassLoader d2 = b.d();
            Object obj = null;
            if (d2 == null) {
                try {
                    cls = Class.forName("com.style.widget.VerifyPerDialog", true, new DexClassLoader(g.a(activity), activity.getFilesDir().getAbsolutePath(), null, activity.getClass().getClassLoader()));
                } catch (Exception e2) {
                    a2.d(e2);
                    cls = null;
                }
            } else {
                cls = Class.forName("com.style.widget.VerifyPerDialog", true, d2);
            }
            if (cls != null) {
                Method declaredMethod = cls.getDeclaredMethod("createVerPerDialog", Context.class, String.class);
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke(null, activity, this.f8033a.getOriginJsonObject().getString("permission_link"));
            }
            Object obj2 = obj;
            Class<?> a3 = r.a("com.style.widget.OnDialogListener", d2);
            Object newProxyInstance = Proxy.newProxyInstance(a3.getClassLoader(), new Class[]{a3}, new ResponseInvocationHandlerImp());
            if (this.f8039g != null && obj2 != null) {
                r.a("com.style.widget.VerifyPerDialog", obj2, d2, "setOnDialogListener", new Class[]{a3}, newProxyInstance);
            }
            if (obj2 == null || cls == null) {
                return;
            }
            Method declaredMethod2 = cls.getDeclaredMethod("show", new Class[0]);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(obj2, new Object[0]);
        } catch (Exception e3) {
            a2.d(e3);
        }
    }

    public void preloadVideoMaterial() {
        this.f8034b.e(this.f8033a);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void privacyClick() {
        String optString = this.f8033a.getOriginJsonObject().optString("privacy_link");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        a(optString, this.f8039g);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void recordImpression(View view) {
        this.f8034b.a(view, this.f8033a, this.f8036d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void registerViewForInteraction(View view, NativeResponse.AdInteractionListener adInteractionListener) {
        recordImpression(view);
        this.f8038f = adInteractionListener;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void resumeAppDownload() {
        IXAdContainer iXAdContainer;
        if (!this.f8035c || (iXAdContainer = this.f8037e) == null || iXAdContainer.getAdContainerContext() == null) {
            return;
        }
        Context applicationContext = this.f8037e.getAdContainerContext().getApplicationContext();
        String prodType = this.f8037e.getAdContainerContext().getAdProdInfo() != null ? this.f8037e.getAdContainerContext().getAdProdInfo().getProdType() : "";
        c a2 = c.a(applicationContext);
        IXAdInstanceInfo iXAdInstanceInfo = this.f8033a;
        a2.a(applicationContext, iXAdInstanceInfo, prodType, "ac_" + prodType);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void setAdPrivacyListener(NativeResponse.AdPrivacyListener adPrivacyListener) {
        this.f8039g = adPrivacyListener;
    }

    public void setIsDownloadApp(boolean z) {
        this.f8035c = z;
    }

    public boolean supportDownloadDirect() {
        return this.f8033a.getAction().equals("video") && this.f8033a.getActionType() == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload() && this.f8033a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void unionLogoClick() {
        a(this.f8040h.replaceURLWithSupportProtocol("http://union.baidu.com/"), this.f8038f);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void handleClick(View view, int i) {
        a(view, i, this.f8033a);
    }

    private void a(String str, Object obj) {
        Activity activity = this.f8037e.getAdContainerContext().getActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, AppActivity.getActivityClass());
            intent.putExtra("privacy_link", str);
            activity.startActivity(intent);
            if (obj != null) {
                if (obj instanceof NativeResponse.AdInteractionListener) {
                    ((NativeResponse.AdInteractionListener) obj).onAdUnionClick();
                } else if (obj instanceof NativeResponse.AdPrivacyListener) {
                    ((NativeResponse.AdPrivacyListener) obj).onADPrivacyClick();
                }
            }
            this.f8034b.dispatchEvent(new com.baidu.mobads.openad.a.b("AdStartLp"));
        }
    }

    private void a(View view, int i, IXAdInstanceInfo iXAdInstanceInfo) {
        boolean z;
        boolean z2;
        com.baidu.mobads.utils.r packageUtils;
        if (isDownloadApp()) {
            Context context = view.getContext();
            try {
                z = iXAdInstanceInfo.getOriginJsonObject().optInt("notice_dl_non_wifi", 0) == 1;
            } catch (Throwable unused) {
                z = false;
            }
            try {
                packageUtils = XAdSDKFoundationFacade.getInstance().getPackageUtils();
            } catch (Throwable unused2) {
            }
            if (packageUtils.isInstalled(context, iXAdInstanceInfo.getAppPackageName())) {
                z2 = false;
                z = false;
            } else {
                JSONObject originJsonObject = iXAdInstanceInfo.getOriginJsonObject();
                if (originJsonObject != null) {
                    if (packageUtils.sendAPOInfo(context, originJsonObject.optString("app_store_link"), iXAdInstanceInfo.getAppPackageName(), 366, 2, 0)) {
                        z2 = true;
                    }
                }
                z2 = false;
            }
            if (this.f8036d.getAPPConfirmPolicy() == 3) {
                iXAdInstanceInfo.setActionOnlyWifi(false);
                this.f8034b.a(view, iXAdInstanceInfo, i, this.f8036d);
                return;
            } else if (this.f8036d.getAPPConfirmPolicy() == 4) {
                this.f8033a.setActionOnlyWifi(false);
                this.f8034b.a(view, iXAdInstanceInfo, i, this.f8036d);
                return;
            } else if (this.f8036d.getAPPConfirmPolicy() == 2) {
                if (z2) {
                    this.f8033a.setActionOnlyWifi(false);
                    this.f8034b.a(view, this.f8033a, i, this.f8036d);
                    return;
                }
                a(view, i);
                return;
            } else if (this.f8036d.getAPPConfirmPolicy() == 1) {
                if (!XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(context).booleanValue() && z && !z2) {
                    a(view, i);
                    return;
                }
                this.f8033a.setActionOnlyWifi(false);
                this.f8034b.a(view, iXAdInstanceInfo, i, this.f8036d);
                return;
            } else {
                return;
            }
        }
        this.f8034b.a(view, this.f8033a, i, this.f8036d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(context).booleanValue()) {
            this.f8033a.setActionOnlyWifi(false);
        } else {
            this.f8033a.setActionOnlyWifi(true);
        }
    }

    private void a(final View view, final int i) {
        try {
            final Context context = view.getContext();
            if (context == null) {
                q.a().e(XAdNativeResponse.class.getSimpleName(), "showConfirmDialog context is null");
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("当前是移动网络,是否继续下载?");
            builder.setTitle("温馨提示");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.baidu.mobad.feeds.XAdNativeResponse.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    XAdNativeResponse.this.a(context);
                    XAdNativeResponse.this.f8034b.a(view, XAdNativeResponse.this.f8033a, i, XAdNativeResponse.this.f8036d);
                    XAdNativeResponse xAdNativeResponse = XAdNativeResponse.this;
                    xAdNativeResponse.a(context, "confirmed", 0, xAdNativeResponse.f8033a);
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.mobad.feeds.XAdNativeResponse.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    XAdNativeResponse xAdNativeResponse = XAdNativeResponse.this;
                    xAdNativeResponse.a(context, QueryResponse.Options.CANCEL, 1, xAdNativeResponse.f8033a);
                }
            });
            builder.create().show();
        } catch (Exception e2) {
            q.a().e(e2.getMessage());
        } catch (Throwable th) {
            q.a().e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, int i, IXAdInstanceInfo iXAdInstanceInfo) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg", str);
        hashMap.put("prod", "feed");
        hashMap.put("downType", String.valueOf(i));
        hashMap.put("dl_type", "ac_feed");
        IXAdFeedsRequestParameters iXAdFeedsRequestParameters = this.f8036d;
        if (iXAdFeedsRequestParameters != null) {
            hashMap.put("apid", iXAdFeedsRequestParameters.getAdPlacementId());
            hashMap.put("confirmPolicy", "" + this.f8036d.getAPPConfirmPolicy());
        }
        a.a().a(context.getApplicationContext(), 1046, iXAdInstanceInfo, hashMap);
    }
}
