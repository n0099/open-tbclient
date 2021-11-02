package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.j0.a.g.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.AdElementInfo;
import com.baidu.mobads.sdk.internal.ScreenUtils;
import com.baidu.mobads.sdk.internal.XAdErrorCode;
import com.baidu.mobads.sdk.internal.XAdLogger;
import com.baidu.mobads.sdk.internal.XErrorCode;
import com.baidu.mobads.sdk.internal.XSplashAdProd;
import com.baidu.sdk.container.interfaces.LoadState;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SplashAd implements d {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public String mAdPlaceId;
    public XSplashAdProd mAdProd;
    public String mAppSid;
    public Context mContext;
    public boolean mDisplayDownInfo;
    public Boolean mLimitRegionClick;
    public SplashAdListener mListener;
    public LoadState mLoadState;
    public RequestParameters mParameter;
    public Boolean mPopDialogIfDL;
    public int mTimeout;
    public int mTipStyle;

    /* loaded from: classes7.dex */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* loaded from: classes7.dex */
    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onLpClosed();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, splashAdListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (RequestParameters) objArr2[2], (SplashAdListener) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void callAdFailed(String str) {
        SplashAdListener splashAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, str) == null) || (splashAdListener = this.mListener) == null) {
            return;
        }
        splashAdListener.onAdFailed(str);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, splashFocusAdListener) == null) {
            XSplashAdProd.registerEnterTransition(activity, null, splashFocusAdListener);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            XSplashAdProd xSplashAdProd = this.mAdProd;
            if (xSplashAdProd != null) {
                xSplashAdProd.destroy();
            }
            this.mListener = null;
        }
    }

    public void finishAndJump(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            finishAndJump(intent, null);
        }
    }

    public JSONObject getAdInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("place_id", this.mAdPlaceId);
                jSONObject.put("source", 3);
                jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        AdElementInfo primaryAdInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            XSplashAdProd xSplashAdProd = this.mAdProd;
            return (xSplashAdProd == null || (primaryAdInfo = xSplashAdProd.getPrimaryAdInfo()) == null) ? "" : primaryAdInfo.getECPMLevel();
        }
        return (String) invokeV.objValue;
    }

    public HashMap<String, Object> getExtData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashMap<String, Object> extData = this.mAdProd.getExtData();
            return extData != null ? extData : new HashMap<>();
        }
        return (HashMap) invokeV.objValue;
    }

    public LoadState getLoadState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mLoadState : (LoadState) invokeV.objValue;
    }

    public final void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
    }

    public void setAppSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mAppSid = str;
        }
    }

    public final void show(ViewGroup viewGroup) {
        XSplashAdProd xSplashAdProd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewGroup) == null) {
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
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, requestParameters, splashAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTipStyle = 4;
        this.mDisplayDownInfo = true;
        Boolean bool = Boolean.FALSE;
        this.mPopDialogIfDL = bool;
        this.mLimitRegionClick = bool;
        this.mTimeout = RT_SPLASH_LOAD_AD_TIMEOUT;
        this.mLoadState = LoadState.INIT;
        this.mListener = new SplashLpCloseListener(this) { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SplashAd this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded(RsplashType rsplashType, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, rsplashType, i4) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdClick() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdDismissed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, str2) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdPresent() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashLpCloseListener
            public void onLpClosed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{activity, Integer.valueOf(i2), Integer.valueOf(i3), splashFocusAdListener}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("right_margin", i2);
                jSONObject.put("bottom_margin", i3);
            } catch (JSONException e2) {
                XAdLogger.getInstance().d(e2);
            }
            XSplashAdProd.registerEnterTransition(activity, jSONObject, splashFocusAdListener);
        }
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        XSplashAdProd xSplashAdProd;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, intent, onFinishListener) == null) || (xSplashAdProd = this.mAdProd) == null) {
            return;
        }
        xSplashAdProd.finishAndJump(intent, onFinishListener);
    }
}
