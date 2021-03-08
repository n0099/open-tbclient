package com.baidu.mobad.feeds;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pay.PayHelper;
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
/* loaded from: classes4.dex */
public class XAdNativeResponse implements NativeResponse {

    /* renamed from: a  reason: collision with root package name */
    private IXAdInstanceInfo f2324a;
    private e b;
    private boolean c;
    private IXAdFeedsRequestParameters d;
    private IXAdContainer e;
    private NativeResponse.AdInteractionListener f;
    private NativeResponse.AdPrivacyListener g;
    private IXAdURIUitls h;

    public XAdNativeResponse(IXAdInstanceInfo iXAdInstanceInfo, e eVar, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.c = false;
        this.f2324a = iXAdInstanceInfo;
        this.b = eVar;
        this.e = iXAdContainer;
        if (this.f2324a.getActionType() == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload()) {
            this.c = true;
        }
        this.d = iXAdFeedsRequestParameters;
        this.h = XAdSDKFoundationFacade.getInstance().getURIUitls();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAdLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getBaiduLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getTitle() {
        return this.f2324a.getTitle();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getDesc() {
        return this.f2324a.getDescription();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getIconUrl() {
        String iconUrl = this.f2324a.getIconUrl();
        if (iconUrl == null || iconUrl.equals("")) {
            return this.f2324a.getMainPictureUrl();
        }
        return iconUrl;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getImageUrl() {
        return this.f2324a.getMainPictureUrl();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isDownloadApp() {
        return this.c;
    }

    public void setIsDownloadApp(boolean z) {
        this.c = z;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void pauseAppDownload() {
        if (this.c && this.e != null && this.e.getAdContainerContext() != null) {
            c.a(this.e.getAdContainerContext().getApplicationContext()).a(getAppPackage());
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void resumeAppDownload() {
        if (this.c && this.e != null && this.e.getAdContainerContext() != null) {
            Context applicationContext = this.e.getAdContainerContext().getApplicationContext();
            String str = "";
            if (this.e.getAdContainerContext().getAdProdInfo() != null) {
                str = this.e.getAdContainerContext().getAdProdInfo().getProdType();
            }
            c.a(applicationContext).a(applicationContext, this.f2324a, str, "ac_" + str);
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getDownloadStatus() {
        if (!this.c || this.e == null || this.e.getAdContainerContext() == null) {
            return -1;
        }
        return c.a(this.e.getAdContainerContext().getApplicationContext()).a(this.e.getAdContainerContext().getApplicationContext(), getAppPackage());
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isAdAvailable(Context context) {
        return this.b.a(context, this.f2324a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public long getAppSize() {
        return this.f2324a.getAppSize();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isAutoPlay() {
        return this.f2324a.getOriginJsonObject().optInt("auto_play", 0) == 1;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public boolean isNonWifiAutoPlay() {
        try {
            return this.f2324a.getOriginJsonObject().optInt("auto_play_non_wifi", 1) == 1;
        } catch (Throwable th) {
            return true;
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppPackage() {
        return this.f2324a.getAppPackageName();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public List<String> getMultiPicUrls() {
        try {
            JSONArray optJSONArray = this.f2324a.getOriginJsonObject().optJSONArray("morepics");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (Exception e) {
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public Map<String, String> getExtras() {
        return null;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void permissionClick() {
        Class<?> cls;
        Object obj;
        Class<?> cls2;
        q a2 = q.a();
        try {
            Activity activity = this.e.getAdContainerContext().getActivity();
            DexClassLoader d = b.d();
            if (d == null) {
                try {
                    cls2 = Class.forName("com.style.widget.VerifyPerDialog", true, new DexClassLoader(g.a(activity), activity.getFilesDir().getAbsolutePath(), null, activity.getClass().getClassLoader()));
                } catch (Exception e) {
                    a2.d(e);
                    cls2 = null;
                }
                cls = cls2;
            } else {
                cls = Class.forName("com.style.widget.VerifyPerDialog", true, d);
            }
            if (cls != null) {
                Method declaredMethod = cls.getDeclaredMethod("createVerPerDialog", Context.class, String.class);
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke(null, activity, this.f2324a.getOriginJsonObject().getString("permission_link"));
            } else {
                obj = null;
            }
            Class<?> a3 = r.a("com.style.widget.OnDialogListener", d);
            Object newProxyInstance = Proxy.newProxyInstance(a3.getClassLoader(), new Class[]{a3}, new ResponseInvocationHandlerImp());
            if (this.g != null && obj != null) {
                r.a("com.style.widget.VerifyPerDialog", obj, d, "setOnDialogListener", new Class[]{a3}, newProxyInstance);
            }
            if (obj != null && cls != null) {
                Method declaredMethod2 = cls.getDeclaredMethod("show", new Class[0]);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(obj, new Object[0]);
            }
        } catch (Exception e2) {
            a2.d(e2);
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void privacyClick() {
        String optString = this.f2324a.getOriginJsonObject().optString("privacy_link");
        if (!TextUtils.isEmpty(optString)) {
            a(optString, this.g);
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void unionLogoClick() {
        a(this.h.replaceURLWithSupportProtocol("http://union.baidu.com/"), this.f);
    }

    private void a(String str, Object obj) {
        Activity activity = this.e.getAdContainerContext().getActivity();
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
            this.b.dispatchEvent(new com.baidu.mobads.openad.a.b("AdStartLp"));
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void recordImpression(View view) {
        this.b.a(view, this.f2324a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void handleClick(View view) {
        handleClick(view, -1);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void handleClick(View view, int i) {
        a(view, i, this.f2324a);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getPublisher() {
        JSONObject originJsonObject;
        return (this.f2324a == null || (originJsonObject = this.f2324a.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("publisher", "");
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppPrivacyLink() {
        JSONObject originJsonObject;
        return (this.f2324a == null || (originJsonObject = this.f2324a.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("privacy_link", "");
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppPermissionLink() {
        JSONObject originJsonObject;
        return (this.f2324a == null || (originJsonObject = this.f2324a.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("permission_link", "");
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAppVersion() {
        JSONObject originJsonObject;
        return (this.f2324a == null || (originJsonObject = this.f2324a.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("app_version", "");
    }

    private void a(View view, int i, IXAdInstanceInfo iXAdInstanceInfo) {
        boolean z;
        boolean z2;
        if (isDownloadApp()) {
            Context context = view.getContext();
            try {
                z = iXAdInstanceInfo.getOriginJsonObject().optInt("notice_dl_non_wifi", 0) == 1;
            } catch (Throwable th) {
                z = false;
            }
            try {
                com.baidu.mobads.utils.r packageUtils = XAdSDKFoundationFacade.getInstance().getPackageUtils();
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
            } catch (Throwable th2) {
                z2 = false;
            }
            if (this.d.getAPPConfirmPolicy() == 3) {
                iXAdInstanceInfo.setActionOnlyWifi(false);
                this.b.a(view, iXAdInstanceInfo, i, this.d);
                return;
            } else if (this.d.getAPPConfirmPolicy() == 4) {
                this.f2324a.setActionOnlyWifi(false);
                this.b.a(view, iXAdInstanceInfo, i, this.d);
                return;
            } else if (this.d.getAPPConfirmPolicy() == 2) {
                if (z2) {
                    this.f2324a.setActionOnlyWifi(false);
                    this.b.a(view, this.f2324a, i, this.d);
                    return;
                }
                a(view, i);
                return;
            } else if (this.d.getAPPConfirmPolicy() == 1) {
                if (!XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(context).booleanValue() && z && !z2) {
                    a(view, i);
                    return;
                }
                this.f2324a.setActionOnlyWifi(false);
                this.b.a(view, iXAdInstanceInfo, i, this.d);
                return;
            } else {
                return;
            }
        }
        this.b.a(view, this.f2324a, i, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(context).booleanValue()) {
            this.f2324a.setActionOnlyWifi(false);
        } else {
            this.f2324a.setActionOnlyWifi(true);
        }
    }

    private void a(final View view, final int i) {
        try {
            final Context context = view.getContext();
            if (context == null) {
                q.a().e(XAdNativeResponse.class.getSimpleName(), "showConfirmDialog context is null");
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("当前是移动网络,是否继续下载?");
                builder.setTitle("温馨提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.baidu.mobad.feeds.XAdNativeResponse.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        XAdNativeResponse.this.a(context);
                        XAdNativeResponse.this.b.a(view, XAdNativeResponse.this.f2324a, i, XAdNativeResponse.this.d);
                        XAdNativeResponse.this.a(context, "confirmed", 0, XAdNativeResponse.this.f2324a);
                    }
                });
                builder.setNegativeButton(PayHelper.STATUS_CANCEL_DESC, new DialogInterface.OnClickListener() { // from class: com.baidu.mobad.feeds.XAdNativeResponse.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                        XAdNativeResponse.this.a(context, "cancel", 1, XAdNativeResponse.this.f2324a);
                    }
                });
                builder.create().show();
            }
        } catch (Exception e) {
            q.a().e(e.getMessage());
        } catch (Throwable th) {
            q.a().e(th.getMessage());
        }
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onStart(Context context) {
        this.b.b(context, this.f2324a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onError(Context context, int i, int i2) {
        this.b.a(context, i, i2, this.f2324a);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onComplete(Context context) {
        this.b.c(context, this.f2324a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onClose(Context context, int i) {
        this.b.a(context, i, this.f2324a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onFullScreen(Context context, int i) {
        this.b.b(context, i, this.f2324a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getVideoUrl() {
        return this.f2324a.getVideoUrl();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getDuration() {
        return this.f2324a.getVideoDuration();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        if (this.f2324a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) {
            return NativeResponse.MaterialType.VIDEO;
        }
        if (this.f2324a.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML) {
            return NativeResponse.MaterialType.HTML;
        }
        return NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getHtmlSnippet() {
        return this.f2324a.getHtmlSnippet();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public WebView getWebView() {
        return (WebView) this.e.getAdView();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getAdMaterialType() {
        if (this.f2324a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO) {
            return NativeResponse.MaterialType.VIDEO.getValue();
        }
        if (this.f2324a.getCreativeType() == IXAdInstanceInfo.CreativeType.HTML) {
            return NativeResponse.MaterialType.HTML.getValue();
        }
        return NativeResponse.MaterialType.NORMAL.getValue();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getStyleType() {
        return this.f2324a.getFeedAdStyleType();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getContainerWidth() {
        return this.f2324a.getAdContainerWidth();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getContainerHeight() {
        return this.f2324a.getAdContainerHeight();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getContainerSizeType() {
        return this.f2324a.getAdContainerSizeType();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getECPMLevel() {
        JSONObject originJsonObject;
        return (this.f2324a == null || (originJsonObject = this.f2324a.getOriginJsonObject()) == null) ? "" : originJsonObject.optString("bidlayer", "");
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void registerViewForInteraction(View view, NativeResponse.AdInteractionListener adInteractionListener) {
        recordImpression(view);
        this.f = adInteractionListener;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void setAdPrivacyListener(NativeResponse.AdPrivacyListener adPrivacyListener) {
        this.g = adPrivacyListener;
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public void onClickAd(Context context) {
        this.b.d(context, this.f2324a, this.d);
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getMainPicWidth() {
        return this.f2324a.getMainMaterialWidth();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public int getMainPicHeight() {
        return this.f2324a.getMainMaterialHeight();
    }

    @Override // com.baidu.mobad.feeds.NativeResponse
    public String getBrandName() {
        return this.f2324a.getAppName();
    }

    public boolean isVideoMuted() {
        return this.f2324a.isVideoMuted();
    }

    public String getMute() {
        return this.f2324a.getMute();
    }

    public void preloadVideoMaterial() {
        this.b.e(this.f2324a);
    }

    public String getUniqueId() {
        return this.f2324a.getUniqueId();
    }

    public void onAdClick() {
        if (this.f != null) {
            this.f.onAdClick();
        }
    }

    public void onADExposed() {
        if (this.f != null) {
            this.f.onADExposed();
        }
    }

    public void onADStatusChanged() {
        if (this.f != null) {
            this.f.onADStatusChanged();
        }
    }

    protected boolean supportDownloadDirect() {
        return this.f2324a.getAction().equals("video") && this.f2324a.getActionType() == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload() && this.f2324a.getCreativeType() == IXAdInstanceInfo.CreativeType.VIDEO;
    }

    protected void handleClickDownloadDirect(View view) {
        if (supportDownloadDirect()) {
            try {
                XAdInstanceInfo xAdInstanceInfo = (XAdInstanceInfo) ((XAdInstanceInfo) this.f2324a).clone();
                xAdInstanceInfo.setAction("");
                a(view, -1, xAdInstanceInfo);
            } catch (Exception e) {
            }
        }
    }

    public AdLogInfo getAdLogInfo() {
        AdLogInfo adLogInfo = new AdLogInfo();
        if (this.d != null) {
            adLogInfo.setAdPlaceId(this.d.getAdPlacementId());
        }
        if (this.f2324a != null) {
            adLogInfo.setQk(this.f2324a.getQueryKey());
            adLogInfo.setVideoUrl(this.f2324a.getVideoUrl());
        }
        return adLogInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, int i, IXAdInstanceInfo iXAdInstanceInfo) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("msg", str);
        hashMap.put("prod", LogConfig.KEY_FEED);
        hashMap.put("downType", String.valueOf(i));
        hashMap.put("dl_type", "ac_feed");
        if (this.d != null) {
            hashMap.put("apid", this.d.getAdPlacementId());
            hashMap.put("confirmPolicy", "" + this.d.getAPPConfirmPolicy());
        }
        a.a().a(context.getApplicationContext(), 1046, iXAdInstanceInfo, hashMap);
    }

    /* loaded from: classes4.dex */
    class ResponseInvocationHandlerImp implements InvocationHandler {
        ResponseInvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (!TextUtils.isEmpty(name)) {
                if (name.equals("onShow")) {
                    if (XAdNativeResponse.this.g != null) {
                        XAdNativeResponse.this.g.onADPermissionShow();
                    }
                } else if (name.equals("onDismiss") && XAdNativeResponse.this.g != null) {
                    XAdNativeResponse.this.g.onADPermissionClose();
                }
            }
            return null;
        }
    }
}
