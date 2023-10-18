package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.ap;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.di;
import com.baidu.mobads.sdk.internal.o;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XAdNativeResponse implements NativeResponse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NativeResponse";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDownloadApp;
    public int mAdActionType;
    public NativeResponse.AdDislikeListener mAdDislikeListener;
    public a mAdInstanceInfo;
    public NativeResponse.AdInteractionListener mAdInteractionListener;
    public NativeResponse.AdPrivacyListener mAdPrivacyListener;
    public NativeResponse.AdShakeViewListener mAdShakeViewListener;
    public NativeResponse.CustomizeMediaPlayer mCustomizeMediaPlayer;
    public Context mCxt;
    public di mFeedsProd;
    public co mUriUtils;

    /* renamed from: com.baidu.mobads.sdk.api.XAdNativeResponse$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class DislikeInfo implements DislikeEvent {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String dislikeName;
        public int dislikeType;

        public DislikeInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public String getDislikeName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.dislikeName;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public int getDislikeType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.dislikeType;
            }
            return invokeV.intValue;
        }

        public /* synthetic */ DislikeInfo(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public XAdNativeResponse(Context context, di diVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, diVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isDownloadApp = false;
        this.mAdActionType = 1;
        this.mCxt = context;
        this.mAdInstanceInfo = aVar;
        this.mFeedsProd = diVar;
        if (aVar.p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = co.a();
    }

    public void handleClick(View view2, int i, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.mFeedsProd != null && (aVar = this.mAdInstanceInfo) != null) {
            JSONObject T2 = aVar.T();
            try {
                T2.put("progress", i);
                T2.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, z);
                T2.put("isDownloadApp", this.isDownloadApp);
            } catch (Throwable unused) {
            }
            this.mFeedsProd.b(view2, T2);
        }
    }

    private int getActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return this.mAdInstanceInfo.p();
        }
        return invokeV.intValue;
    }

    private IAdInterListener getAdInterListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            di diVar = this.mFeedsProd;
            if (diVar != null) {
                return diVar.k;
            }
            return null;
        }
        return (IAdInterListener) invokeV.objValue;
    }

    private String getProd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            di diVar = this.mFeedsProd;
            if (diVar != null) {
                return diVar.f();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void clearImpressionTaskWhenBack() {
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (diVar = this.mFeedsProd) != null) {
            diVar.p();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getAdActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mAdActionType;
        }
        return invokeV.intValue;
    }

    public NativeResponse.AdDislikeListener getAdDislikeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mAdDislikeListener;
        }
        return (NativeResponse.AdDislikeListener) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.h();
            }
            return "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppFunctionLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.D();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.m();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPermissionLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.E();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPrivacyLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.C();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public long getAppSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.j();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.A();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBaiduLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.i();
            }
            return "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBrandName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.g();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public List<String> getBtnStyleColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.O();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public int getBtnStyleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.N();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.s();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerSizeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.t();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.r();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.CustomizeMediaPlayer getCustomizeMediaPlayer() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.mCustomizeMediaPlayer == null && (aVar = this.mAdInstanceInfo) != null && aVar.S() == 1) {
                this.mCustomizeMediaPlayer = new o(this.mFeedsProd, this.mAdInstanceInfo);
            }
            return this.mCustomizeMediaPlayer;
        }
        return (NativeResponse.CustomizeMediaPlayer) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDownloadStatus() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.isDownloadApp && (context = this.mCxt) != null) {
                return ap.a(context.getApplicationContext()).a(this.mCxt.getApplicationContext(), getAppPackage());
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.w();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.z();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public JSONObject getExtraParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.I();
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Map<String, String> getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            HashMap hashMap = new HashMap();
            di diVar = this.mFeedsProd;
            if (diVar != null) {
                hashMap.put("appsid", diVar.o);
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getHtmlSnippet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.o();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                String c = aVar.c();
                if (TextUtils.isEmpty(c)) {
                    return this.mAdInstanceInfo.d();
                }
                return c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getImageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.d();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.f();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.e();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String getMarketingDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.K();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getMarketingICONUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.J();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getMarketingPendant() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.L();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<String> getMultiPicUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.G();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getPublisher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.B();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getStyleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.u();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.H();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.n();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            di diVar = this.mFeedsProd;
            if (diVar != null) {
                return (WebView) diVar.w();
            }
            return null;
        }
        return (WebView) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar == null || aVar.k() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNeedDownloadApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.isDownloadApp;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNonWifiAutoPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar == null || aVar.l() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int isRegionClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.Q();
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public int isShowDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                return aVar.R();
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public void onADExposed() {
        NativeResponse.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (adInteractionListener = this.mAdInteractionListener) != null) {
            adInteractionListener.onADExposed();
        }
    }

    public void onADFunctionClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && (adPrivacyListener = this.mAdPrivacyListener) != null) {
            adPrivacyListener.onADFunctionClick();
        }
    }

    public void onADPrivacyClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (adPrivacyListener = this.mAdPrivacyListener) != null) {
            adPrivacyListener.onADPrivacyClick();
        }
    }

    public void onADStatusChanged() {
        NativeResponse.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (adInteractionListener = this.mAdInteractionListener) != null) {
            adInteractionListener.onADStatusChanged();
        }
    }

    public void onAdClick() {
        NativeResponse.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (adInteractionListener = this.mAdInteractionListener) != null) {
            adInteractionListener.onAdClick();
        }
    }

    public void onAdUnionClick() {
        NativeResponse.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (adInteractionListener = this.mAdInteractionListener) != null) {
            adInteractionListener.onAdUnionClick();
        }
    }

    public void onShakeViewDismiss() {
        NativeResponse.AdShakeViewListener adShakeViewListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && (adShakeViewListener = this.mAdShakeViewListener) != null) {
            adShakeViewListener.onDismiss();
        }
    }

    public void preloadVideoMaterial() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048649, this) == null) && this.mFeedsProd != null && (aVar = this.mAdInstanceInfo) != null) {
            JSONObject T2 = aVar.T();
            try {
                T2.put("msg", "preloadVideoMaterial");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void resumeAppDownload() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && this.isDownloadApp && this.mFeedsProd != null && (aVar = this.mAdInstanceInfo) != null) {
            JSONObject T2 = aVar.T();
            try {
                T2.put("msg", ap.d);
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }

    private View renderNativeView(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, jSONObject)) == null) {
            try {
                jSONObject.put("viewId", str);
                jSONObject.put("msg", "renderNativeView");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                HashMap hashMap = new HashMap();
                this.mFeedsProd.a(jSONObject, hashMap);
                Object obj = hashMap.get(str);
                if (obj instanceof View) {
                    return (View) obj;
                }
                return null;
            } catch (Throwable th) {
                br a = br.a();
                a.c(TAG, "renderNativeView failed: " + th.getMessage());
                return null;
            }
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            biddingFail(str, null);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(String str) {
        a aVar;
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (aVar = this.mAdInstanceInfo) != null && (diVar = this.mFeedsProd) != null) {
            diVar.a(aVar.H(), true, str);
        }
    }

    public void handleClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, view2) == null) {
            handleClick(view2, -1);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAdAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, context)) == null) {
            if (this.mAdInstanceInfo == null || System.currentTimeMillis() - this.mAdInstanceInfo.y() > this.mAdInstanceInfo.F()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void onADExposureFailed(int i) {
        NativeResponse.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048638, this, i) == null) && (adInteractionListener = this.mAdInteractionListener) != null) {
            adInteractionListener.onADExposureFailed(i);
        }
    }

    public void onADPermissionShow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048640, this, z) == null) && (adPrivacyListener = this.mAdPrivacyListener) != null) {
            if (z) {
                adPrivacyListener.onADPermissionShow();
            } else {
                adPrivacyListener.onADPermissionClose();
            }
        }
    }

    public void onAdDownloadWindow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048644, this, z) == null) && (adPrivacyListener = this.mAdPrivacyListener) != null && (adPrivacyListener instanceof NativeResponse.AdDownloadWindowListener)) {
            if (z) {
                ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowShow();
            } else {
                ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void recordImpression(View view2) {
        di diVar;
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048651, this, view2) == null) && (diVar = this.mFeedsProd) != null && (aVar = this.mAdInstanceInfo) != null) {
            diVar.a(view2, aVar.T());
        }
    }

    public void setAdActionType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i) == null) {
            this.mAdActionType = i;
        }
    }

    public void setAdDislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, adDislikeListener) == null) {
            this.mAdDislikeListener = adDislikeListener;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void setAdPrivacyListener(NativeResponse.AdPrivacyListener adPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, adPrivacyListener) == null) {
            this.mAdPrivacyListener = adPrivacyListener;
        }
    }

    public void setIsDownloadApp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            this.isDownloadApp = z;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        a aVar;
        di diVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap) == null) && (aVar = this.mAdInstanceInfo) != null && (diVar = this.mFeedsProd) != null) {
            diVar.a(aVar.H(), false, str, hashMap);
        }
    }

    public void handleClick(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048628, this, view2, i) == null) {
            handleClick(view2, i, false);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void cancelAppDownload() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.mCxt != null && this.isDownloadApp && this.mFeedsProd != null) {
            JSONObject T2 = this.mAdInstanceInfo.T();
            try {
                T2.put(PushConstants.URI_PACKAGE_NAME, getAppPackage());
                T2.put("msg", "cancelDownload");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void functionClick() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (aVar = this.mAdInstanceInfo) != null && this.mFeedsProd != null) {
            String D = aVar.D();
            JSONObject T2 = this.mAdInstanceInfo.T();
            try {
                T2.put("function_link", D);
                T2.put("msg", "functionClick");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getActButtonString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar != null) {
                JSONObject T2 = aVar.T();
                try {
                    T2.put("msg", "creative_call");
                    T2.put("creative_type", "cta_get");
                } catch (Exception unused) {
                }
                this.mFeedsProd.a(T2);
                return this.mAdInstanceInfo.M();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar == null) {
                return NativeResponse.MaterialType.NORMAL;
            }
            if ("video".equals(aVar.x())) {
                return NativeResponse.MaterialType.VIDEO;
            }
            if ("html".equals(this.mAdInstanceInfo.x())) {
                return NativeResponse.MaterialType.HTML;
            }
            return NativeResponse.MaterialType.NORMAL;
        }
        return (NativeResponse.MaterialType) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void pauseAppDownload() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && this.mCxt != null && this.isDownloadApp && this.mFeedsProd != null) {
            JSONObject T2 = this.mAdInstanceInfo.T();
            try {
                T2.put(PushConstants.URI_PACKAGE_NAME, getAppPackage());
                T2.put("msg", "pauseDownload");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void permissionClick() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048648, this) == null) && (aVar = this.mAdInstanceInfo) != null && this.mFeedsProd != null) {
            String E = aVar.E();
            JSONObject T2 = this.mAdInstanceInfo.T();
            try {
                T2.put("permissionUrl", E);
                T2.put("msg", "permissionClick");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void privacyClick() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && (aVar = this.mAdInstanceInfo) != null && this.mFeedsProd != null) {
            String C = aVar.C();
            JSONObject T2 = this.mAdInstanceInfo.T();
            try {
                T2.put("privacy_link", C);
                T2.put("msg", "privacyClick");
            } catch (JSONException unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void unionLogoClick() {
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && this.mFeedsProd != null && (coVar = this.mUriUtils) != null) {
            String c = coVar.c("http://union.baidu.com/");
            JSONObject T2 = this.mAdInstanceInfo.T();
            try {
                T2.put("unionUrl", c);
                T2.put("msg", "unionLogoClick");
            } catch (Throwable unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void dislikeClick(DislikeEvent dislikeEvent) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dislikeEvent) == null) && (aVar = this.mAdInstanceInfo) != null && this.mFeedsProd != null && (dislikeEvent instanceof DislikeInfo)) {
            JSONObject T2 = aVar.T();
            try {
                T2.put("dislike_type", dislikeEvent.getDislikeType());
                T2.put("msg", "dislike_click");
            } catch (Exception unused) {
            }
            this.mFeedsProd.a(T2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Object getAdDataForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (this.mAdInstanceInfo != null) {
                if (HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID.equals(str)) {
                    return this.mAdInstanceInfo.U();
                }
                if ("dp_id".equals(str)) {
                    return this.mAdInstanceInfo.V();
                }
                return this.mAdInstanceInfo.a(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            a aVar = this.mAdInstanceInfo;
            if (aVar == null) {
                return NativeResponse.MaterialType.NORMAL.getValue();
            }
            if ("video".equals(aVar.x())) {
                return NativeResponse.MaterialType.VIDEO.getValue();
            }
            if ("html".equals(this.mAdInstanceInfo.x())) {
                return NativeResponse.MaterialType.HTML.getValue();
            }
            return NativeResponse.MaterialType.NORMAL.getValue();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<DislikeEvent> getDislikeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.mAdInstanceInfo != null && this.mFeedsProd != null) {
                try {
                    HashMap hashMap = new HashMap();
                    JSONObject T2 = this.mAdInstanceInfo.T();
                    T2.put("msg", "dislike_mapping");
                    this.mFeedsProd.a(T2, hashMap);
                    Object obj = hashMap.get("dislike_data");
                    if (obj instanceof Map) {
                        Map map = (Map) obj;
                        for (String str : map.keySet()) {
                            DislikeInfo dislikeInfo = new DislikeInfo(null);
                            dislikeInfo.dislikeName = str;
                            dislikeInfo.dislikeType = ((Integer) map.get(str)).intValue();
                            arrayList.add(dislikeInfo);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<String> getThirdTrackers(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) {
            if (this.mAdInstanceInfo == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                JSONObject P = this.mAdInstanceInfo.P();
                if (P != null) {
                    Iterator<String> keys = P.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next.equals(str)) {
                            JSONArray optJSONArray = P.optJSONArray(next);
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                arrayList.add(optJSONArray.optString(i));
                            }
                        }
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void stopNativeView(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048660, this, view2) == null) && this.mFeedsProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "stopNativeView");
                jSONObject.put("uniqueId", getUniqueId());
                HashMap hashMap = new HashMap();
                hashMap.put("native_view", view2);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                br a = br.a();
                a.c(TAG, "stopNativeView failed: " + th.getMessage());
            }
        }
    }

    public void handleClick(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048630, this, view2, z) == null) {
            handleClick(view2, -1, z);
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void registerViewForInteraction(View view2, List<View> list, List<View> list2, NativeResponse.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048652, this, view2, list, list2, adInteractionListener) == null) {
            this.mAdInteractionListener = adInteractionListener;
            if (this.mFeedsProd != null) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("adView", view2);
                    hashMap.put("clickViews", list);
                    hashMap.put("creativeViews", list2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("msg", "registerViewForInteraction");
                    jSONObject.put("uniqueId", getUniqueId());
                    jSONObject.put("isDownloadApp", this.isDownloadApp);
                    this.mFeedsProd.a(jSONObject, hashMap);
                } catch (Throwable th) {
                    br a = br.a();
                    a.c(TAG, "registerViewForInteraction failed: " + th.getMessage());
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderSlideView(int i, int i2, int i3, NativeResponse.AdShakeViewListener adShakeViewListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048654, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), adShakeViewListener})) == null) {
            if (this.mFeedsProd != null) {
                try {
                    this.mAdShakeViewListener = adShakeViewListener;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("w", i);
                    jSONObject.put("h", i2);
                    jSONObject.put("repeat", i3);
                    return renderNativeView("native_slide_view", jSONObject);
                } catch (Throwable th) {
                    br a = br.a();
                    a.c(TAG, "renderSlideView failed: " + th.getMessage());
                    return null;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public View renderShakeView(int i, int i2, NativeResponse.AdShakeViewListener adShakeViewListener) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048653, this, i, i2, adShakeViewListener)) == null) {
            if (this.mFeedsProd != null) {
                try {
                    this.mAdShakeViewListener = adShakeViewListener;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("msg", "renderShakeView");
                    jSONObject.put("uniqueId", getUniqueId());
                    jSONObject.put("w", i);
                    jSONObject.put("h", i2);
                    jSONObject.put("isDownloadApp", this.isDownloadApp);
                    HashMap hashMap = new HashMap();
                    this.mFeedsProd.a(jSONObject, hashMap);
                    Object obj = hashMap.get("shake_view");
                    if (obj instanceof View) {
                        return (View) obj;
                    }
                    return null;
                } catch (Throwable th) {
                    br a = br.a();
                    a.c(TAG, "renderShakeView failed: " + th.getMessage());
                    return null;
                }
            }
            return null;
        }
        return (View) invokeIIL.objValue;
    }
}
