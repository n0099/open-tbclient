package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.internal.AdElementInfo;
import com.baidu.mobads.sdk.internal.ScreenUtils;
import com.baidu.mobads.sdk.internal.XAdErrorCode;
import com.baidu.mobads.sdk.internal.XAdLogger;
import com.baidu.mobads.sdk.internal.XErrorCode;
import com.baidu.mobads.sdk.internal.XSplashAdProd;
import d.a.b0.a.b.a;
import d.a.d0.a.g.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SplashAd implements d {
    public static final String KEY_BOTTOM_LOGO_HEIGHT = "bottomLogoHeight";
    public static final String KEY_BOTTOM_LOGO_ID = "bottomLogoResId";
    public static final String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final String KEY_DISPLAY_FULL_SCREEN = "displayFullScreen";
    public static final String KEY_FETCHAD = "fetchAd";
    public static final String KEY_LABEL_TYPE = "labelType";
    public static final String KEY_LIMIT_REGION_CLICK = "region_click";
    public static final String KEY_POPDIALOG_DOWNLOAD = "user_dialog_frame";
    public static final String KEY_SKIP_TYPE = "skipType";
    public static final String KEY_TIMEOUT = "timeout";
    public static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    public String mAdPlaceId;
    public XSplashAdProd mAdProd;
    public String mAppSid;
    public Context mContext;
    public boolean mDisplayDownInfo;
    public Boolean mLimitRegionClick;
    public SplashAdListener mListener;
    public RequestParameters mParameter;
    public Boolean mPopDialogIfDL;
    public int mTimeout;
    public int mTipStyle;

    /* loaded from: classes2.dex */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* loaded from: classes2.dex */
    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onLpClosed();
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }

    private void callAdFailed(String str) {
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed(str);
        }
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        XSplashAdProd.registerEnterTransition(activity, null, splashFocusAdListener);
    }

    public void destroy() {
        XSplashAdProd xSplashAdProd = this.mAdProd;
        if (xSplashAdProd != null) {
            xSplashAdProd.destroy();
        }
        this.mListener = null;
    }

    public void finishAndJump(Intent intent) {
        finishAndJump(intent, null);
    }

    public JSONObject getAdInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("place_id", this.mAdPlaceId);
            jSONObject.put("source", TextUtils.equals(this.mAdPlaceId, a.f39288a.get().A()) ? "bes_cpc" : "gd");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String getECPMLevel() {
        AdElementInfo primaryAdInfo;
        XSplashAdProd xSplashAdProd = this.mAdProd;
        return (xSplashAdProd == null || (primaryAdInfo = xSplashAdProd.getPrimaryAdInfo()) == null) ? "" : primaryAdInfo.getECPMLevel();
    }

    public HashMap<String, Object> getExtData() {
        HashMap<String, Object> extData = this.mAdProd.getExtData();
        return extData != null ? extData : new HashMap<>();
    }

    public final void load() {
        XSplashAdProd xSplashAdProd = this.mAdProd;
        if (xSplashAdProd != null) {
            xSplashAdProd.removeAdAllListeners();
            this.mAdProd = null;
        }
        float screenDensity = ScreenUtils.getScreenDensity(this.mContext);
        Rect screenRect = ScreenUtils.getScreenRect(this.mContext);
        int width = screenRect.width();
        int height = screenRect.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * screenDensity);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * screenDensity);
            }
        }
        int i2 = height;
        int i3 = width;
        if (i3 >= 200.0f * screenDensity && i2 >= screenDensity * 150.0f) {
            XSplashAdProd xSplashAdProd2 = new XSplashAdProd(this.mContext, this.mAdPlaceId, i3, i2, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = xSplashAdProd2;
            xSplashAdProd2.setAppsid(this.mAppSid);
            XSplashAdProd xSplashAdProd3 = this.mAdProd;
            xSplashAdProd3.onlyFetchAd = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                xSplashAdProd3.setRequestParameters(requestParameters2);
            }
            this.mAdProd.setListener(this.mListener);
            this.mAdProd.startAdRequest();
            return;
        }
        XAdLogger.getInstance().e(XErrorCode.getInstance().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        this.mListener.onAdDismissed();
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public final void show(ViewGroup viewGroup) {
        XSplashAdProd xSplashAdProd;
        if (viewGroup != null && (xSplashAdProd = this.mAdProd) != null) {
            View adView = xSplashAdProd.getAdView();
            if (adView != null && adView.getParent() == null) {
                this.mAdProd.showAd();
                viewGroup.addView(adView);
                return;
            }
            this.mAdProd.removeAdAllListeners();
            callAdFailed("展现失败，请重新load");
            return;
        }
        XSplashAdProd xSplashAdProd2 = this.mAdProd;
        if (xSplashAdProd2 != null) {
            xSplashAdProd2.removeAdAllListeners();
        }
        callAdFailed("展现失败，请检查splashAd参数是否正确");
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        this.mTipStyle = 4;
        this.mDisplayDownInfo = true;
        Boolean bool = Boolean.FALSE;
        this.mPopDialogIfDL = bool;
        this.mLimitRegionClick = bool;
        this.mTimeout = RT_SPLASH_LOAD_AD_TIMEOUT;
        this.mListener = new SplashLpCloseListener() { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded(RsplashType rsplashType, int i2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdClick() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
            public void onLpClosed() {
            }
        };
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (TextUtils.isEmpty(str)) {
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        String str2 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
        if (!TextUtils.isEmpty(str2)) {
            this.mDisplayDownInfo = Boolean.parseBoolean(str2);
        }
        String str3 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
        if (!TextUtils.isEmpty(str3)) {
            this.mPopDialogIfDL = Boolean.valueOf(str3);
        }
        String str4 = this.mParameter.getExtras().get(KEY_LIMIT_REGION_CLICK);
        if (!TextUtils.isEmpty(str4)) {
            this.mLimitRegionClick = Boolean.valueOf(str4);
        }
        String str5 = this.mParameter.getExtras().get("timeout");
        if (TextUtils.isEmpty(str5)) {
            return;
        }
        this.mTimeout = Integer.parseInt(str5);
    }

    public static void registerEnterTransition(Activity activity, int i2, int i3, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i2);
            jSONObject.put("bottom_margin", i3);
        } catch (JSONException e2) {
            XAdLogger.getInstance().d(e2);
        }
        XSplashAdProd.registerEnterTransition(activity, jSONObject, splashFocusAdListener);
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        XSplashAdProd xSplashAdProd = this.mAdProd;
        if (xSplashAdProd != null) {
            xSplashAdProd.finishAndJump(intent, onFinishListener);
        }
    }
}
