package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RsplashType;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashLpCloseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XSplashAdProd extends XAbstractAdProdTemplate {
    public static int scaleType;
    public static XSplashAdProd tempInstance;
    public boolean adClicked;
    public boolean adClosed;
    public boolean adFailed;
    public int mAdHeight;
    public SplashAdListener mAdListener;
    public String mAdPlaceId;
    public int mAdTimeout;
    public int mAdWidth;
    public SplashAd.OnFinishListener mFinishListener;
    public SplashAd.SplashFocusAdListener mFocusListener;
    public boolean mIsPopDialogIfDl;
    public boolean mLimitRegionClick;
    public AdElementInfo mPrimaryAdInfo;
    public RequestParameters mRequestParameters;
    public RelativeLayout mRl;
    public boolean mShowDownInfo;
    public int mTipStyle;
    public boolean onlyFetchAd;

    public XSplashAdProd(Context context, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3) {
        super(context);
        this.adClicked = false;
        this.adClosed = false;
        this.adFailed = false;
        this.mAdPlaceId = str;
        this.mAdWidth = i2;
        this.mAdHeight = i3;
        this.mTipStyle = i4;
        this.mAdTimeout = i5;
        this.mShowDownInfo = z;
        this.mIsPopDialogIfDl = z2;
        this.mLimitRegionClick = z3;
    }

    public static void registerEnterTransition(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        XSplashAdProd xSplashAdProd = tempInstance;
        if (xSplashAdProd != null) {
            xSplashAdProd.setFocusListener(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    hashMap.put("splash_focus_activity", activity);
                    tempInstance.handleEvent(jSONObject2, hashMap);
                } catch (JSONException e2) {
                    XAdLogger.getInstance().e(e2);
                }
                tempInstance = null;
            }
        }
    }

    public static void setDisplayMode(int i2) {
        scaleType = i2;
    }

    public void finishAndJump(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        if (!this.adClicked && intent != null && this.mAdInterlistener != null && !this.adFailed) {
            this.mFinishListener = onFinishListener;
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.putOpt("event_type", "splash_focus_start_activity");
                hashMap.put("splash_focus_user_intent", intent);
            } catch (JSONException e2) {
                XAdLogger.getInstance().d(e2);
            }
            this.mAdInterlistener.removeAllListeners();
            this.mAdInterlistener.addEventListener("AdFinishActivity", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdUserClick", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdStopped", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdLpClosed", this.mEventListener);
            handleEvent(jSONObject, hashMap);
            this.mAdListener = null;
            tempInstance = this;
            TaskScheduler.getInstance().submitWithDelay(new BaseTask() { // from class: com.baidu.mobads.sdk.internal.XSplashAdProd.1
                @Override // com.baidu.mobads.sdk.internal.BaseTask
                public Object doInBackground() {
                    XSplashAdProd unused = XSplashAdProd.tempInstance = null;
                    return null;
                }
            }, 3L, TimeUnit.SECONDS);
            return;
        }
        this.mContext.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public HashMap<String, Object> getExtData() {
        HashMap<String, Object> extData = this.mPrimaryAdInfo.getExtData();
        return extData != null ? extData : new HashMap<>();
    }

    public AdElementInfo getPrimaryAdInfo() {
        return this.mPrimaryAdInfo;
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onADLoaded(IOAdEvent iOAdEvent) {
        List<AdElementInfo> adInstanceInfoList;
        int i2 = 0;
        if (iOAdEvent != null && (adInstanceInfoList = AdResponseInfo.fromJson(iOAdEvent.getMessage()).getAdInstanceInfoList()) != null && adInstanceInfoList.size() > 0) {
            this.mPrimaryAdInfo = adInstanceInfoList.get(0);
        }
        RsplashType rsplashType = RsplashType.IMAGE;
        AdElementInfo adElementInfo = this.mPrimaryAdInfo;
        if (adElementInfo != null) {
            String creativeType = adElementInfo.getCreativeType();
            if (TextUtils.equals(creativeType, "html")) {
                rsplashType = RsplashType.HTML;
            } else if (TextUtils.equals(creativeType, "video")) {
                rsplashType = RsplashType.VIDEO;
                i2 = this.mPrimaryAdInfo.getVideoDuration();
            }
        }
        SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded(rsplashType, i2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onAdClick(String str) {
        this.adClicked = true;
        SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.mFocusListener;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onAdClose(IOAdEvent iOAdEvent) {
        if (!this.adClosed) {
            super.onAdClose(iOAdEvent);
            SplashAdListener splashAdListener = this.mAdListener;
            if (splashAdListener != null) {
                splashAdListener.onAdDismissed();
            }
            this.adClosed = true;
        }
        Map<String, Object> data = iOAdEvent.getData();
        if (this.mFocusListener == null || !data.containsKey("splash_close_reason")) {
            return;
        }
        this.mFocusListener.onAdClose();
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onAdFailed(String str, int i2) {
        this.adFailed = true;
        SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed(str);
        }
        super.onAdFailed(str, i2);
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onAdPresent() {
        SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onAdPresent();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onFinishActivity() {
        SplashAd.OnFinishListener onFinishListener = this.mFinishListener;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
        } else {
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        super.onFinishActivity();
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onLpClosed() {
        SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null && (splashAdListener instanceof SplashLpCloseListener)) {
            ((SplashLpCloseListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.mFocusListener;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.onLpClosed();
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onNoAd(int i2, String str) {
        this.adFailed = true;
        SplashAdListener splashAdListener = this.mAdListener;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.onNoAd(i2, str);
    }

    public void setFocusListener(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.mFocusListener = splashFocusAdListener;
    }

    public void setListener(SplashAdListener splashAdListener) {
        this.mAdListener = splashAdListener;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void showAd() {
        IAdInterListener iAdInterListener = this.mAdInterlistener;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void startAdRequest() {
        if (this.mAdInterlistener == null) {
            this.mExecuteRequest = false;
            return;
        }
        this.mExecuteRequest = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("prod", "rsplash");
            this.mAdInterlistener.createProdHandler(jSONObject3);
            this.mAdInterlistener.setAdContainer(this.mRl);
            registerAdListener();
            jSONObject.put("prod", "rsplash");
            jSONObject.put("apid", this.mAdPlaceId);
            jSONObject.put("fet", "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put("at", "26");
            jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put("w", "" + this.mAdWidth);
            jSONObject.put("h", "" + this.mAdHeight);
            if (!TextUtils.isEmpty(this.mAppsid)) {
                jSONObject.put("appid", this.mAppsid);
            }
            jSONObject2.put("timeout", this.mAdTimeout);
            jSONObject2.put("splashTipStyle", this.mTipStyle);
            jSONObject2.put("bitmapDisplayMode", scaleType);
            jSONObject2.put("countDownNew", "true");
            jSONObject2.put("Display_Down_Info", "" + this.mShowDownInfo);
            jSONObject2.put("popDialogIfDl", "" + this.mIsPopDialogIfDl);
            jSONObject2.put("limitRegionClick", "" + this.mLimitRegionClick);
            jSONObject2.put("needCache", true);
            jSONObject2.put("onlyLoadAd", this.onlyFetchAd);
            jSONObject2.put("cacheVideoOnlyWifi", true);
            if (this.mRequestParameters != null) {
                setCustomParameters(this.mRequestParameters.getExtras());
            }
            jSONObject2 = ConvertUtils.combineJson(jSONObject2, hashMap2Json(this.mCustomRequestParameters));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mAdInterlistener.loadAd(jSONObject, jSONObject2);
    }
}
