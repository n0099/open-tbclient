package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RsplashType;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashLpCloseListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XSplashAdProd extends XAbstractAdProdTemplate {
    public static /* synthetic */ Interceptable $ic;
    public static int scaleType;
    public static XSplashAdProd tempInstance;
    public transient /* synthetic */ FieldHolder $fh;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1382417938, "Lcom/baidu/mobads/sdk/internal/XSplashAdProd;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1382417938, "Lcom/baidu/mobads/sdk/internal/XSplashAdProd;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XSplashAdProd(Context context, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    public static void registerEnterTransition(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        XSplashAdProd xSplashAdProd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, activity, jSONObject, splashFocusAdListener) == null) || (xSplashAdProd = tempInstance) == null) {
            return;
        }
        xSplashAdProd.setFocusListener(splashFocusAdListener);
        HashMap hashMap = new HashMap();
        JSONObject jSONObject2 = new JSONObject();
        try {
            try {
                jSONObject2.putOpt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "splash_focus_register_transition");
                jSONObject2.putOpt("splash_focus_params", jSONObject);
                hashMap.put("splash_focus_activity", activity);
                tempInstance.handleEvent(jSONObject2, hashMap);
            } finally {
                tempInstance = null;
            }
        } catch (JSONException e2) {
            XAdLogger.getInstance().e(e2);
        } catch (Throwable th) {
            XAdLogger.getInstance().e(th);
        }
    }

    public static void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65540, null, i2) == null) {
            scaleType = i2;
        }
    }

    public void finishAndJump(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, intent, onFinishListener) == null) {
            if (!this.adClicked && intent != null && this.mAdInterlistener != null && !this.adFailed) {
                this.mFinishListener = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                try {
                    jSONObject.putOpt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "splash_focus_start_activity");
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
                TaskScheduler.getInstance().submitWithDelay(new BaseTask(this) { // from class: com.baidu.mobads.sdk.internal.XSplashAdProd.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XSplashAdProd this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.mobads.sdk.internal.BaseTask
                    public Object doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            XSplashAdProd unused = XSplashAdProd.tempInstance = null;
                            return null;
                        }
                        return invokeV.objValue;
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
    }

    public HashMap<String, Object> getExtData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap<String, Object> extData = this.mPrimaryAdInfo.getExtData();
            return extData != null ? extData : new HashMap<>();
        }
        return (HashMap) invokeV.objValue;
    }

    public AdElementInfo getPrimaryAdInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPrimaryAdInfo : (AdElementInfo) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onADLoaded(IOAdEvent iOAdEvent) {
        List<AdElementInfo> adInstanceInfoList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iOAdEvent) == null) {
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
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onAdClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
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
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onAdClose(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iOAdEvent) == null) {
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
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onAdFailed(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            this.adFailed = true;
            SplashAdListener splashAdListener = this.mAdListener;
            if (splashAdListener != null) {
                splashAdListener.onAdFailed(str);
            }
            super.onAdFailed(str, i2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onAdPresent() {
        SplashAdListener splashAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (splashAdListener = this.mAdListener) == null) {
            return;
        }
        splashAdListener.onAdPresent();
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onFinishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onLpClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void onNoAd(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            this.adFailed = true;
            SplashAdListener splashAdListener = this.mAdListener;
            if (splashAdListener != null) {
                splashAdListener.onAdFailed("广告无填充");
            }
            super.onNoAd(i2, str);
        }
    }

    public void setFocusListener(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, splashFocusAdListener) == null) {
            this.mFocusListener = splashFocusAdListener;
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, splashAdListener) == null) {
            this.mAdListener = splashAdListener;
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, requestParameters) == null) {
            this.mRequestParameters = requestParameters;
        }
    }

    public void showAd() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (iAdInterListener = this.mAdInterlistener) == null) {
            return;
        }
        iAdInterListener.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate
    public void startAdRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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
}
