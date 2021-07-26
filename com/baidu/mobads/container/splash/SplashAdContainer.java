package com.baidu.mobads.container.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.components.utils.XAdRemoteClickHandler;
import com.baidu.mobads.container.error.XAdErrorCode;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.landingpage.AppPriActivity;
import com.baidu.mobads.container.landingpage.LpCloseController;
import com.baidu.mobads.container.template.SplashVSLogUtil;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.PackageUtils;
import com.baidu.mobads.container.widget.OnDialogListener;
import com.baidu.mobads.container.widget.VerifyPerDialog;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.f0.b.g.e;
import d.a.i0.a.b;
import d.a.i0.a.d.d;
import d.a.i0.a.g.a;
import d.a.i0.a.g.b;
import d.a.i0.a.g.c;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SplashAdContainer extends XBaseAdContainer implements c, a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DISPLAY_MODE_CENTER_CROP = 17;
    public static final int DISPLAY_MODE_FIT_XY = 16;
    public static final String TAG = "SplashAdContainer";
    public transient /* synthetic */ FieldHolder $fh;
    public IOAdEventListener lpCloseListener;
    public b mAdContainer;
    public String mAdContainerType;
    public int mBitmapDisplayMode;
    public int mBottomLogoHeight;
    public int mBottomLogoResId;
    public boolean mIsDisplayDownLoadInfo;
    public boolean mIsFullScreenAd;
    public int mLabelType;
    public boolean mLimitRegionClick;
    public String mPermissionLink;
    public boolean mPopDialogIfDl;
    public String mPrivacyLink;
    public int mSkipType;
    public int mSplashLogType;

    /* loaded from: classes2.dex */
    public class LpCloseListener implements IOAdEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplashAdContainer this$0;

        public LpCloseListener(SplashAdContainer splashAdContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAdContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = splashAdContainer;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iOAdEvent) == null) && "AdLpClosed".equals(iOAdEvent.getType())) {
                if (this.this$0.mAdContainer != null) {
                    this.this$0.mAdContainer.resume();
                }
                if (this.this$0.lpCloseListener != null) {
                    this.this$0.lpCloseListener = null;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1596277197, "Lcom/baidu/mobads/container/splash/SplashAdContainer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1596277197, "Lcom/baidu/mobads/container/splash/SplashAdContainer;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAdContainer(XAdContainerContext xAdContainerContext, Context context) {
        super(xAdContainerContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdContainerContext, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((XAdContainerContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBitmapDisplayMode = 16;
        boolean z = true;
        this.mIsDisplayDownLoadInfo = true;
        this.mIsFullScreenAd = false;
        try {
            JSONObject adReqParam = this.mAdContainerCxt.getAdReqParam();
            this.mBitmapDisplayMode = adReqParam.optInt("bitmapDisplayMode", 16);
            this.mIsDisplayDownLoadInfo = adReqParam.optBoolean("Display_Down_Info", true);
            this.mPopDialogIfDl = adReqParam.optBoolean("popDialogIfDl", true);
            this.mLimitRegionClick = adReqParam.optBoolean("limitRegionClick", true);
            JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
            this.mPrivacyLink = originJsonObject.optString(AppPriActivity.PRIVACY_LINK);
            this.mPermissionLink = originJsonObject.optString("permission_link");
            this.mIsFullScreenAd = "true".equals(adReqParam.optString(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false"));
            this.mBottomLogoResId = Integer.parseInt(adReqParam.optString(SplashAd.KEY_BOTTOM_LOGO_ID, "-1"));
            this.mBottomLogoHeight = Integer.parseInt(adReqParam.optString(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "0"));
            this.mSkipType = Integer.parseInt(adReqParam.optString(SplashAd.KEY_SKIP_TYPE, "0"));
            this.mLabelType = Integer.parseInt(adReqParam.optString(SplashAd.KEY_LABEL_TYPE, "0"));
            if (1 != originJsonObject.optInt(SplashAd.KEY_LIMIT_REGION_CLICK, this.mLimitRegionClick ? 1 : 0)) {
                z = false;
            }
            this.mLimitRegionClick = z;
        } catch (Exception e2) {
            this.mAdLogger.d(TAG, e2);
        }
        b a2 = new d.a.i0.a.a().a(context, getContainerParameter());
        this.mAdContainer = a2;
        a2.b(this);
        this.mAdContainer.d(this);
    }

    private d.a.i0.a.b getContainerParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            this.mAdContainerType = "image";
            String mainPictureUrl = this.mAdInstanceInfo.getMainPictureUrl();
            this.mSplashLogType = 1;
            JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
            String optString = originJsonObject.optString("publisher");
            String optString2 = originJsonObject.optString("app_version");
            boolean z = (!this.mIsDisplayDownLoadInfo || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(this.mPrivacyLink) || TextUtils.isEmpty(this.mPermissionLink)) ? false : true;
            int i2 = getStretchFromJson(originJsonObject) == 0 ? 17 : 16;
            if (this.mAdInstanceInfo.getCreativeType().getValue().equals("gif")) {
                this.mAdContainerType = "gif";
                this.mSplashLogType = 3;
            } else if (this.mAdInstanceInfo.getCreativeType().getValue().equals("video")) {
                this.mAdContainerType = "video";
                mainPictureUrl = this.mAdInstanceInfo.getVideoUrl();
                this.mSplashLogType = 4;
            }
            b.C0602b c0602b = new b.C0602b(this.mAdContainerType, mainPictureUrl);
            c0602b.t("rsplash");
            c0602b.l(this.mIsFullScreenAd);
            c0602b.h(this.mBottomLogoHeight);
            c0602b.m(this.mBottomLogoResId);
            c0602b.j(this.mLimitRegionClick);
            c0602b.r(getMantleActionText());
            c0602b.s(this.mIsFullScreenAd ? 47 : this.mBottomLogoHeight + 39);
            c0602b.k(this.mBitmapDisplayMode);
            c0602b.i(this.mAdInstanceInfo.getCloseType());
            c0602b.v(z);
            c0602b.f(optString);
            c0602b.g(optString2);
            c0602b.u(true);
            c0602b.k(i2);
            c0602b.z(this.mSkipType);
            tryAddExtStyle(c0602b, originJsonObject);
            return c0602b.a();
        }
        return (d.a.i0.a.b) invokeV.objValue;
    }

    private String getMantleActionText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            IXAdInstanceInfo iXAdInstanceInfo = this.mAdInstanceInfo;
            if (iXAdInstanceInfo != null) {
                try {
                    boolean isInstalled = AdDownloadApkUtils.isInstalled(this.mAppContext, iXAdInstanceInfo.getAppPackageName());
                    int optInt = TextUtils.isEmpty(this.mAdInstanceInfo.getAppOpenStrs()) ? 0 : new JSONObject(this.mAdInstanceInfo.getAppOpenStrs()).optInt("fb_act", 0);
                    if (this.mAdInstanceInfo.getActionType() != 1) {
                        if (this.mAdInstanceInfo.getActionType() == 2) {
                            if (isInstalled) {
                                return "点击跳转至第三方页面";
                            }
                        } else if (this.mAdInstanceInfo.getActionType() != 512 || isInstalled) {
                            return "点击跳转至第三方页面";
                        } else {
                            if (optInt != 2) {
                                if (optInt != 1) {
                                    return "点击跳转至第三方页面";
                                }
                            }
                        }
                        return "点击下载应用";
                    }
                    return "点击跳转至详情页";
                } catch (Throwable th) {
                    String str = TAG;
                    Log.e(str, "Action text error: " + th);
                    return "点击跳转至第三方页面";
                }
            }
            return "点击跳转至第三方页面";
        }
        return (String) invokeV.objValue;
    }

    private int getStretchFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, jSONObject)) == null) {
            if (jSONObject != null) {
                try {
                    return jSONObject.optInt("allow_stretch", 1);
                } catch (Throwable unused) {
                    return 1;
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    private void registerLpCloseReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, context) == null) {
            this.lpCloseListener = new LpCloseListener();
            LpCloseController.getInstance(context).startListener();
            LpCloseController.getInstance(context).addEventListener("AdLpClosed", this.lpCloseListener);
        }
    }

    private void tryAddExtStyle(b.C0602b c0602b, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, c0602b, jSONObject) == null) {
            try {
                if (this.mSkipType == 1) {
                    c0602b.z(1);
                    c0602b.i(5);
                    c0602b.A(72);
                    c0602b.y(30);
                }
                if (this.mLabelType == 1) {
                    c0602b.c("广告");
                    c0602b.e(25);
                    c0602b.d(13);
                    c0602b.u(false);
                }
                boolean z = this.mIsFullScreenAd;
                if (jSONObject.has("pattern")) {
                    z = jSONObject.optInt("pattern") == 1;
                    c0602b.l(z);
                    c0602b.h(e.b());
                    c0602b.m(e.c());
                    c0602b.s(z ? 47 : this.mBottomLogoHeight + 39);
                }
                String optString = jSONObject.optString("custom_ext_data");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.has("duration")) {
                    c0602b.B(jSONObject2.optInt("duration") * 1000);
                    c0602b.z(1);
                    c0602b.i(5);
                    c0602b.A(72);
                    c0602b.y(30);
                }
                if (jSONObject2.has("label_name")) {
                    c0602b.c(jSONObject2.optString("label_name"));
                    c0602b.e(25);
                    c0602b.d(13);
                    c0602b.u(false);
                }
                if (jSONObject2.has("logo_type")) {
                    c0602b.n(e.d(jSONObject2.optInt("logo_type")));
                    c0602b.D(68);
                    c0602b.C(30);
                    c0602b.o(z);
                }
                if (jSONObject2.has("style")) {
                    c0602b.E(jSONObject2.optJSONObject("style"));
                }
            } catch (JSONException e2) {
                this.mAdLogger.e(TAG, e2);
            }
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAdContainer.getAdView() : (View) invokeV.objValue;
    }

    public Bitmap getCloseBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.i0.a.g.b bVar = this.mAdContainer;
            if (bVar instanceof d) {
                return ((d) bVar).X();
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public boolean isVideoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "video".equals(this.mAdContainerType) : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mAdLogger.d(TAG, "load");
            this.mAdContainer.a();
            PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_JSON_LOG, 1);
        }
    }

    @Override // d.a.i0.a.g.a
    public void onAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_JSON_LOG, 8);
            XAdContainerContext xAdContainerContext = this.mAdContainerCxt;
            HashMap<String, Object> shouBaiLpFlag = getShouBaiLpFlag(xAdContainerContext, xAdContainerContext.getAdInstanceInfo());
            if (shouBaiLpFlag == null) {
                shouBaiLpFlag = new HashMap<>();
            }
            shouBaiLpFlag.put(XBaseAdContainer.USE_DIALOG_FRAME, Boolean.valueOf(this.mPopDialogIfDl));
            new XAdRemoteClickHandler().onAdClicked(this, this.mAdContainerCxt.getAdInstanceInfo(), Boolean.TRUE, shouBaiLpFlag);
        }
    }

    @Override // d.a.i0.a.g.c
    public void onAdError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            XAdErrorCode xAdErrorCode = XAdErrorCode.MCACHE_FETCH_FAILED;
            processAdError(xAdErrorCode, "Splash Failed: " + str);
        }
    }

    @Override // d.a.i0.a.g.c
    public void onAdLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mAdState = 1;
            PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_JSON_LOG, 5);
        }
    }

    @Override // d.a.i0.a.g.a
    public void onAdLogoClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            startWangmengPage();
        }
    }

    @Override // d.a.i0.a.g.c
    public void onAdStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.hasPlayed = true;
            if (this.mAdState != 2) {
                if ("image".equals(this.mAdContainerType)) {
                    TaskScheduler.getInstance().submit(new BaseTask<Void>(this) { // from class: com.baidu.mobads.container.splash.SplashAdContainer.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SplashAdContainer this$0;

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

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.mobads.container.executor.BaseTask
                        public Void doInBackground() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                PackageUtils.sendRsplashLog(this.this$0.mAppContext, this.this$0.mAdContainerCxt, PackageUtils.RSPLASH_JSON_LOG, 7);
                                SplashAdContainer splashAdContainer = this.this$0;
                                splashAdContainer.checkAndSendRsplashShowLog(splashAdContainer.mSplashLogType, null);
                                if (PackageUtils.checkSendInstalled(this.this$0.mAppContext)) {
                                    PackageUtils.sendInstalled(this.this$0.mAppContext, this.this$0.mAdContainerCxt);
                                    PackageUtils.sendSysInstalled(this.this$0.mAppContext, this.this$0.mAdContainerCxt);
                                    PackageUtils.sendInfo(this.this$0.mAppContext, this.this$0.mAdContainerCxt);
                                }
                                return null;
                            }
                            return (Void) invokeV.objValue;
                        }
                    }, 2);
                } else if ("gif".equals(this.mAdContainerType)) {
                    PackageUtils.sendAppInstallInfo(this.mAppContext, this.mAdContainerCxt);
                } else if ("video".equals(this.mAdContainerType)) {
                    checkAndSendRsplashShowLog(4, null);
                }
            }
        }
    }

    @Override // d.a.i0.a.g.c
    public void onAdStop(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mAdState = 2;
            if (!"video".equals(this.mAdContainerType)) {
                deleteTimeoutCachedFiles(this.mAppContext);
            }
            closeAd(str);
        }
    }

    @Override // d.a.i0.a.g.a
    public void onPermissionClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            VerifyPerDialog createVerPerDialog = VerifyPerDialog.createVerPerDialog(this.mAdContainerCxt.getActivity(), this.mPermissionLink);
            createVerPerDialog.setHideNavigation(true);
            createVerPerDialog.setOnDialogListener(new OnDialogListener(this) { // from class: com.baidu.mobads.container.splash.SplashAdContainer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SplashAdContainer this$0;

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

                @Override // com.baidu.mobads.container.widget.OnDialogListener
                public void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mAdContainer == null) {
                        return;
                    }
                    this.this$0.mAdContainer.resume();
                }

                @Override // com.baidu.mobads.container.widget.OnDialogListener
                public void onShow() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.this$0.mAdContainer == null) {
                        return;
                    }
                    this.this$0.mAdContainer.pause();
                }
            });
            createVerPerDialog.show();
        }
    }

    @Override // d.a.i0.a.g.a
    public void onPrivacyClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Intent intent = new Intent();
            intent.putExtra(AppPriActivity.PRIVACY_LINK, this.mPrivacyLink);
            ActivityUtils.startAppPriActivity(this.mAppContext, intent);
            registerLpCloseReceiver(this.mAppContext);
        }
    }

    @Override // d.a.i0.a.g.a
    public void onSkipClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            onAdStop("click_skip_button");
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void resetAdContainerName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void onAdClick(IXAdInstanceInfo iXAdInstanceInfo, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, iXAdInstanceInfo, view) == null) {
            int i2 = this.mSplashLogType;
            if (i2 == 4) {
                checkAPO(PackageUtils.SOURCE_DONWLOAD_APO_RSPLASH_VIDEO_JSON);
            } else if (i2 == 3) {
                SplashVSLogUtil.sendLog(this.mAdContainerCxt, 9, false, 3, HttpStatus.SC_FAILED_DEPENDENCY, this.showRecord);
                checkAPO(PackageUtils.SOURCE_DONWLOAD_APO_GIF_JSON);
            } else if (i2 == 1) {
                sendRsplashExpClickLog(1);
                checkAPO(PackageUtils.SOURCE_DONWLOAD_APO_RSPLASH_JSON);
            }
        }
    }
}
