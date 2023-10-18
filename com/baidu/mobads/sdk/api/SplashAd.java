package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.ax;
import com.baidu.mobads.sdk.internal.bn;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.cp;
import com.baidu.mobads.sdk.internal.df;
import com.baidu.mobads.sdk.internal.ds;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SplashAd {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOTTOM_VIEW_ID = 4097;
    public static final String KEY_BIDFAIL_ADN = "adn";
    public static final String KEY_BIDFAIL_ECPM = "ecpm";
    public static final String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final String KEY_FETCHAD = "fetchAd";
    public static final String KEY_LOAD_AFTER_CACHE_END = "loadAfterCacheEnd";
    public static final String KEY_POPDIALOG_DOWNLOAD = "use_dialog_frame";
    public static final String KEY_PREFER_FULLSCREEN = "prefer_fullscreen";
    public static final String KEY_SHAKE_LOGO_SIZE = "shake_logo_size";
    public static final String KEY_TIMEOUT = "timeout";
    public static final String KEY_TWIST_BG_COLOR = "twist_bg_color";
    public static final String KEY_TWIST_LOGO_HEIGHT_DP = "twist_logo_height_dp";
    public static final String KEY_USE_ADAPTIVE_AD = "adaptive_ad";
    public static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    public transient /* synthetic */ FieldHolder $fh;
    public String mAdPlaceId;
    public ds mAdProd;
    public String mAppSid;
    public int mBidFloor;
    public Context mContext;
    public Boolean mDisplayClickRegion;
    public boolean mDisplayDownInfo;
    public SplashAdDownloadDialogListener mDownloadDialogListener;
    public boolean mFetchAd;
    public boolean mFetchNotShow;
    public boolean mIsAdaptiveSplashAd;
    public Boolean mLimitRegionClick;
    public SplashAdListener mListener;
    public RequestParameters mParameter;
    public Boolean mPopDialogIfDL;
    public int mShakeLogoSize;
    public int mTimeout;
    public int mTipStyle;
    public int mTwistBgColor;
    public int mTwistLogoHeightDp;
    public ViewGroup mViewParent;

    /* loaded from: classes3.dex */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* loaded from: classes3.dex */
    public interface SplashAdDownloadDialogListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADFunctionLpClose();

        void onADFunctionLpShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyLpClose();

        void onADPrivacyLpShow();
    }

    /* loaded from: classes3.dex */
    public interface SplashCardAdListener {
        void onCardClick();

        void onCardClose();

        void onCardShow();
    }

    /* loaded from: classes3.dex */
    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onAdIconShow();

        void onLpClosed();
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, requestParameters, splashAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTipStyle = 4;
        this.mFetchAd = true;
        this.mFetchNotShow = false;
        this.mDisplayDownInfo = true;
        this.mPopDialogIfDL = Boolean.FALSE;
        Boolean bool = Boolean.TRUE;
        this.mLimitRegionClick = bool;
        this.mDisplayClickRegion = bool;
        this.mTimeout = RT_SPLASH_LOAD_AD_TIMEOUT;
        this.mShakeLogoSize = 60;
        this.mTwistLogoHeightDp = 67;
        this.mTwistBgColor = -16777216;
        this.mIsAdaptiveSplashAd = false;
        this.mBidFloor = -1;
        this.mListener = new SplashInteractionListener(this) { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SplashAd this$0;

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048581, this, str2) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }
        };
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (TextUtils.isEmpty(str)) {
            sendSplashFailedLog("请您输入正确的广告位ID");
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters != null && requestParameters.getExtras() != null) {
            String str2 = this.mParameter.getExtras().get(KEY_FETCHAD);
            if (!TextUtils.isEmpty(str2)) {
                this.mFetchAd = Boolean.parseBoolean(str2);
            }
            String str3 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
            if (!TextUtils.isEmpty(str3)) {
                this.mDisplayDownInfo = Boolean.parseBoolean(str3);
            }
            String str4 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
            if (!TextUtils.isEmpty(str4)) {
                this.mPopDialogIfDL = Boolean.valueOf(str4);
            }
            String str5 = this.mParameter.getExtras().get(KEY_SHAKE_LOGO_SIZE);
            if (!TextUtils.isEmpty(str5)) {
                this.mShakeLogoSize = Integer.parseInt(str5);
            }
            String str6 = this.mParameter.getExtras().get(KEY_TWIST_LOGO_HEIGHT_DP);
            if (!TextUtils.isEmpty(str6)) {
                this.mTwistLogoHeightDp = Integer.parseInt(str6);
            }
            String str7 = this.mParameter.getExtras().get(KEY_TWIST_BG_COLOR);
            if (!TextUtils.isEmpty(str7)) {
                this.mTwistBgColor = Integer.parseInt(str7);
            }
            String str8 = this.mParameter.getExtras().get("timeout");
            if (!TextUtils.isEmpty(str8)) {
                this.mTimeout = Integer.parseInt(str8);
            }
            String str9 = this.mParameter.getExtras().get(KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(str9)) {
                this.mIsAdaptiveSplashAd = Boolean.parseBoolean(str9);
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (RequestParameters) objArr2[2], (SplashAdListener) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdFailed(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, this, str) == null) && this.mListener != null) {
            sendSplashFailedLog(str);
            this.mListener.onAdFailed(str);
        }
    }

    private void sendSplashFailedLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, str) == null) {
            try {
                if (this.mAdProd != null) {
                    this.mAdProd.a(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final void setAppLogoData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, bArr) == null) {
            setAppLogo(bArr);
        }
    }

    private final void setAppLogoId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65567, this, i) == null) {
            setAppLogo(Integer.valueOf(i));
        }
    }

    public void biddingFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            biddingFail(str, null);
        }
    }

    public void biddingSuccess(String str) {
        ds dsVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (dsVar = this.mAdProd) != null) {
            dsVar.a(true, str);
        }
    }

    public void finishAndJump(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            finishAndJump(intent, null);
        }
    }

    public Object getAdDataForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            ds dsVar = this.mAdProd;
            if (dsVar != null) {
                return dsVar.j(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    public void loadBiddingAd(String str) {
        ds dsVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (dsVar = this.mAdProd) != null) {
            dsVar.c(str);
        }
    }

    public void setAppSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mAppSid = str;
        }
    }

    public void setBidFloor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mBidFloor = i;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        ds dsVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && (dsVar = this.mAdProd) != null) {
            dsVar.b(str);
        }
    }

    public void setDownloadDialogListener(SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, splashAdDownloadDialogListener) == null) {
            this.mDownloadDialogListener = splashAdDownloadDialogListener;
            ds dsVar = this.mAdProd;
            if (dsVar != null) {
                dsVar.a(splashAdDownloadDialogListener);
            }
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, splashAdListener) == null) {
            this.mListener = splashAdListener;
            ds dsVar = this.mAdProd;
            if (dsVar != null) {
                dsVar.a(splashAdListener);
            }
        }
    }

    public final void show(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, viewGroup) == null) {
            showWithBottomView(viewGroup, null);
        }
    }

    private void addZeroPxSurfaceViewAvoidBlink(ViewGroup viewGroup, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, this, viewGroup, context) == null) {
            try {
                viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
            } catch (Exception e) {
                br.a().a(e);
            }
        }
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, activity, splashFocusAdListener) == null) {
            ds.a(activity, (JSONObject) null, splashFocusAdListener);
        }
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        ds dsVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap) == null) && (dsVar = this.mAdProd) != null) {
            dsVar.a(false, str, hashMap);
        }
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        ds dsVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, intent, onFinishListener) == null) && (dsVar = this.mAdProd) != null) {
            dsVar.a(intent, onFinishListener);
        }
    }

    public final boolean showSplashCardView(Activity activity, SplashCardAdListener splashCardAdListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, activity, splashCardAdListener)) == null) {
            ds dsVar = this.mAdProd;
            if (dsVar != null) {
                dsVar.a(splashCardAdListener);
                return this.mAdProd.b(activity);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public static void registerEnterTransition(Activity activity, int i, int i2, int i3, SplashFocusAdListener splashFocusAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), splashFocusAdListener}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("right_margin", i);
                jSONObject.put("bottom_margin", i2);
                jSONObject.put("anim_offset_y", i3);
            } catch (JSONException e) {
                br.a().a(e);
            }
            ds.a(activity, jSONObject, splashFocusAdListener);
        }
    }

    public static void registerEnterTransition(Activity activity, int i, int i2, SplashFocusAdListener splashFocusAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), splashFocusAdListener}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("right_margin", i);
                jSONObject.put("bottom_margin", i2);
            } catch (JSONException e) {
                br.a().a(e);
            }
            ds.a(activity, jSONObject, splashFocusAdListener);
        }
    }

    public static void registerEnterTransition(Activity activity, SplashFocusParams splashFocusParams, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65562, null, activity, splashFocusParams, splashFocusAdListener) == null) {
            if (splashFocusParams != null) {
                jSONObject = splashFocusParams.getFocusParams();
            } else {
                jSONObject = null;
            }
            ds.a(activity, jSONObject, splashFocusAdListener);
        }
    }

    private void sendSplashLog(ViewGroup viewGroup, View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, this, viewGroup, view2) == null) {
            try {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                boolean z2 = true;
                if (viewGroup == null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                sb.append("");
                hashMap.put("adContainer", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                if (!this.mIsAdaptiveSplashAd || view2 != null) {
                    z2 = false;
                }
                sb2.append(z2);
                sb2.append("");
                hashMap.put("isAdaptive", sb2.toString());
                hashMap.put("mFetchNotShow", this.mFetchNotShow + "");
                if (this.mAdProd != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("msg", "sendSplashLog");
                    } catch (JSONException e) {
                        br.a().a(e);
                    }
                    this.mAdProd.a(jSONObject, hashMap);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private final void showWithBottomView(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, this, viewGroup, view2) == null) {
            sendSplashLog(viewGroup, view2);
            this.mViewParent = viewGroup;
            if (viewGroup == null) {
                if (this.mListener != null) {
                    sendSplashFailedLog("传入容器不可以为空");
                    this.mListener.onAdFailed("传入容器不可以为空");
                }
            } else if (this.mIsAdaptiveSplashAd && view2 == null) {
                if (this.mListener != null) {
                    sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                    this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                }
            } else {
                ds dsVar = this.mAdProd;
                if (dsVar != null) {
                    cp cpVar = new cp(this.mContext);
                    cpVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    if (view2 != null) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.addRule(12);
                        view2.setId(4097);
                        cpVar.addView(view2, layoutParams);
                    }
                    cpVar.a(new cp.a(this, cpVar) { // from class: com.baidu.mobads.sdk.api.SplashAd.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SplashAd this$0;
                        public final /* synthetic */ cp val$splashAdView;

                        @Override // com.baidu.mobads.sdk.internal.cp.a
                        public boolean onKeyDown(int i, KeyEvent keyEvent) {
                            InterceptResult invokeIL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, keyEvent)) == null) {
                                return false;
                            }
                            return invokeIL.booleanValue;
                        }

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cpVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$splashAdView = cpVar;
                        }

                        @Override // com.baidu.mobads.sdk.internal.cp.a
                        public void onAttachedToWindow() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mAdProd != null) {
                                this.this$0.mAdProd.o();
                            }
                        }

                        @Override // com.baidu.mobads.sdk.internal.cp.a
                        public void onDetachedFromWindow() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.this$0.mAdProd != null) {
                                this.this$0.mAdProd.p();
                            }
                        }

                        @Override // com.baidu.mobads.sdk.internal.cp.a
                        public void onLayoutComplete(int i, int i2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeII(1048579, this, i, i2) == null) {
                                if (!this.this$0.mFetchNotShow) {
                                    if (this.this$0.mAdProd != null) {
                                        this.this$0.mAdProd.r();
                                    }
                                    this.this$0.callAdFailed("展现失败，请重新load");
                                } else if (this.this$0.mAdProd != null) {
                                    this.this$0.mAdProd.r = false;
                                    this.this$0.mFetchNotShow = false;
                                    this.this$0.mAdProd.a(this.val$splashAdView);
                                    this.this$0.mAdProd.f();
                                } else {
                                    this.this$0.callAdFailed("展现失败，请检查splashAd参数是否正确");
                                }
                            }
                        }

                        @Override // com.baidu.mobads.sdk.internal.cp.a
                        public void onWindowFocusChanged(boolean z) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeZ(1048580, this, z) == null) && this.this$0.mAdProd != null) {
                                this.this$0.mAdProd.a(z);
                            }
                        }

                        @Override // com.baidu.mobads.sdk.internal.cp.a
                        public void onWindowVisibilityChanged(int i) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) && this.this$0.mAdProd != null) {
                                this.this$0.mAdProd.b(i);
                            }
                        }
                    });
                    this.mViewParent.addView(cpVar);
                    return;
                }
                if (dsVar != null) {
                    dsVar.r();
                }
                callAdFailed("展现失败，请检查splashAd参数是否正确");
            }
        }
    }

    private void setAppLogo(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65565, this, obj) == null) && this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "splash_logo");
                HashMap hashMap = new HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                br.a().d(th);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ds dsVar = this.mAdProd;
            if (dsVar != null) {
                dsVar.e();
            }
            this.mListener = null;
        }
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        a h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ds dsVar = this.mAdProd;
            if (dsVar != null && (h = dsVar.h()) != null) {
                return h.z();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final boolean hasSplashCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ds dsVar = this.mAdProd;
            if (dsVar != null) {
                return dsVar.g();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ds dsVar = this.mAdProd;
            if (dsVar != null && (iAdInterListener = dsVar.k) != null) {
                return iAdInterListener.isAdReady();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getBiddingToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ds dsVar = this.mAdProd;
            if (dsVar != null) {
                dsVar.r();
                this.mAdProd = null;
            }
            float e = ax.e(this.mContext);
            Rect a = ax.a(this.mContext);
            int width = a.width();
            int height = a.height();
            RequestParameters requestParameters = this.mParameter;
            if (requestParameters != null && requestParameters.isCustomSize()) {
                if (this.mParameter.getWidth() > 0) {
                    width = (int) (this.mParameter.getWidth() * e);
                }
                if (this.mParameter.getHeight() > 0) {
                    height = (int) (this.mParameter.getHeight() * e);
                }
            }
            int i = height;
            int i2 = width;
            if (i2 >= 200.0f * e && i >= e * 150.0f) {
                ds dsVar2 = new ds(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
                this.mAdProd = dsVar2;
                dsVar2.d(this.mShakeLogoSize);
                this.mAdProd.a(this.mTwistLogoHeightDp);
                this.mAdProd.c(this.mTwistBgColor);
                this.mAdProd.h(this.mAppSid);
                ds dsVar3 = this.mAdProd;
                dsVar3.p = this.mBidFloor;
                dsVar3.r = true;
                RequestParameters requestParameters2 = this.mParameter;
                if (requestParameters2 != null) {
                    dsVar3.a(requestParameters2);
                }
                this.mAdProd.a(this.mListener);
                this.mFetchNotShow = true;
                this.mAdProd.a(this.mDownloadDialogListener);
                return this.mAdProd.m();
            }
            br.a().c(df.a().a(bn.b, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdDismissed();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ds dsVar = this.mAdProd;
            if (dsVar != null) {
                dsVar.r();
                this.mAdProd = null;
            }
            float e = ax.e(this.mContext);
            Rect a = ax.a(this.mContext);
            int width = a.width();
            int height = a.height();
            RequestParameters requestParameters = this.mParameter;
            if (requestParameters != null && requestParameters.isCustomSize()) {
                if (this.mParameter.getWidth() > 0) {
                    width = (int) (this.mParameter.getWidth() * e);
                }
                if (this.mParameter.getHeight() > 0) {
                    height = (int) (this.mParameter.getHeight() * e);
                }
            }
            int i = height;
            int i2 = width;
            if (i2 >= 200.0f * e && i >= e * 150.0f) {
                ds dsVar2 = new ds(this.mContext, this.mAdPlaceId, i2, i, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
                this.mAdProd = dsVar2;
                dsVar2.d(this.mShakeLogoSize);
                this.mAdProd.a(this.mTwistLogoHeightDp);
                this.mAdProd.c(this.mTwistBgColor);
                this.mAdProd.h(this.mAppSid);
                ds dsVar3 = this.mAdProd;
                dsVar3.p = this.mBidFloor;
                dsVar3.r = true;
                RequestParameters requestParameters2 = this.mParameter;
                if (requestParameters2 != null) {
                    dsVar3.a(requestParameters2);
                }
                this.mAdProd.a(this.mListener);
                this.mFetchNotShow = true;
                this.mAdProd.a(this.mDownloadDialogListener);
                this.mAdProd.a();
                return;
            }
            br.a().c(df.a().a(bn.b, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdDismissed();
            }
        }
    }

    public void loadAndShow(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, viewGroup) == null) {
            if (viewGroup == null) {
                if (this.mListener != null) {
                    sendSplashFailedLog("传入容器不可以为空");
                    this.mListener.onAdFailed("传入容器不可以为空");
                }
            } else if (this.mIsAdaptiveSplashAd) {
                if (this.mListener != null) {
                    sendSplashFailedLog("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                    this.mListener.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
                }
            } else {
                addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
                cp cpVar = new cp(this.mContext);
                cpVar.a(new cp.a(this, cpVar) { // from class: com.baidu.mobads.sdk.api.SplashAd.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SplashAd this$0;
                    public final /* synthetic */ cp val$prodContainer;

                    @Override // com.baidu.mobads.sdk.internal.cp.a
                    public boolean onKeyDown(int i, KeyEvent keyEvent) {
                        InterceptResult invokeIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, keyEvent)) == null) {
                            return false;
                        }
                        return invokeIL.booleanValue;
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cpVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$prodContainer = cpVar;
                    }

                    @Override // com.baidu.mobads.sdk.internal.cp.a
                    public void onAttachedToWindow() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mAdProd != null) {
                            this.this$0.mAdProd.o();
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.cp.a
                    public void onDetachedFromWindow() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.this$0.mAdProd != null) {
                            this.this$0.mAdProd.p();
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.cp.a
                    public void onLayoutComplete(int i, int i2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 != null && interceptable2.invokeII(1048579, this, i, i2) != null) || this.this$0.mAdProd != null) {
                            return;
                        }
                        float e = ax.e(this.this$0.mContext);
                        if (this.this$0.mParameter != null && this.this$0.mParameter.isCustomSize()) {
                            if (this.this$0.mParameter.getWidth() > 0) {
                                i = (int) (this.this$0.mParameter.getWidth() * e);
                            }
                            if (this.this$0.mParameter.getHeight() > 0) {
                                i2 = (int) (this.this$0.mParameter.getHeight() * e);
                            }
                        }
                        int i3 = i;
                        int i4 = i2;
                        if (i3 >= 200.0f * e && i4 >= e * 150.0f) {
                            this.this$0.mAdProd = new ds(this.this$0.mContext, this.this$0.mAdPlaceId, i3, i4, this.this$0.mTipStyle, this.this$0.mTimeout, this.this$0.mDisplayDownInfo, this.this$0.mPopDialogIfDL.booleanValue(), this.this$0.mDisplayClickRegion.booleanValue(), this.this$0.mLimitRegionClick.booleanValue());
                            this.this$0.mAdProd.a(this.val$prodContainer);
                            this.this$0.mAdProd.d(this.this$0.mShakeLogoSize);
                            this.this$0.mAdProd.a(this.this$0.mTwistLogoHeightDp);
                            this.this$0.mAdProd.c(this.this$0.mTwistBgColor);
                            this.this$0.mAdProd.h(this.this$0.mAppSid);
                            this.this$0.mAdProd.p = this.this$0.mBidFloor;
                            this.this$0.mAdProd.a(this.this$0.mListener);
                            if (this.this$0.mParameter != null) {
                                this.this$0.mAdProd.a(this.this$0.mParameter);
                            }
                            this.this$0.mAdProd.r = false;
                            this.this$0.mAdProd.a(this.this$0.mDownloadDialogListener);
                            this.this$0.mAdProd.a();
                            return;
                        }
                        br.a().c(df.a().a(bn.b, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                        if (this.this$0.mListener != null && (this.this$0.mListener instanceof SplashInteractionListener)) {
                            ((SplashInteractionListener) this.this$0.mListener).onAdDismissed();
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.cp.a
                    public void onWindowFocusChanged(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeZ(1048580, this, z) == null) && this.this$0.mAdProd != null) {
                            this.this$0.mAdProd.a(z);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.cp.a
                    public void onWindowVisibilityChanged(int i) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) && this.this$0.mAdProd != null) {
                            this.this$0.mAdProd.b(i);
                        }
                    }
                });
                cpVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                viewGroup.addView(cpVar);
            }
        }
    }
}
