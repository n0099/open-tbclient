package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dg extends bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a A;
    public boolean B;
    public boolean C;
    public RelativeLayout a;
    public boolean q;
    public boolean r;
    public int s;
    public String t;
    public String u;
    public int v;
    public int w;
    public ExpressInterstitialListener x;
    public ExpressInterstitialAd.InterAdDownloadWindowListener y;
    public ExpressInterstitialAd.InterstitialAdDislikeListener z;

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 8000;
        this.t = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.v = 600;
        this.w = 500;
        this.B = false;
        this.a = relativeLayout;
        this.u = str;
    }

    public Object a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.A != null) {
                if (HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID.equals(str)) {
                    return this.A.U();
                }
                return this.A.a(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void c(IOAdEvent iOAdEvent) {
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, iOAdEvent) == null) && (interstitialAdDislikeListener = this.z) != null && iOAdEvent != null) {
            interstitialAdDislikeListener.interstitialAdDislikeClick();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.C = z;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, iOAdEvent) == null) {
            this.r = false;
            ExpressInterstitialListener expressInterstitialListener = this.x;
            if (expressInterstitialListener != null) {
                expressInterstitialListener.onADExposed();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, iOAdEvent) == null) && (expressInterstitialListener = this.x) != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, iOAdEvent) == null) {
            super.g(iOAdEvent);
            ExpressInterstitialListener expressInterstitialListener = this.x;
            if (expressInterstitialListener != null) {
                expressInterstitialListener.onAdClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, iOAdEvent) == null) && (expressInterstitialListener = this.x) != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener == null) {
                this.l = false;
                return;
            }
            this.r = false;
            this.l = true;
            iAdInterListener.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b_() {
        ExpressInterstitialListener expressInterstitialListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (expressInterstitialListener = this.x) != null) {
            expressInterstitialListener.onAdCacheSuccess();
            this.x.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void c_() {
        ExpressInterstitialListener expressInterstitialListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (expressInterstitialListener = this.x) != null) {
            expressInterstitialListener.onAdCacheFailed();
            this.x.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        ExpressInterstitialListener expressInterstitialListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (expressInterstitialListener = this.x) != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (interAdDownloadWindowListener = this.y) != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    public a x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.A;
        }
        return (a) invokeV.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.s = i;
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.B = z;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && (interAdDownloadWindowListener = this.y) != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            ExpressInterstitialListener expressInterstitialListener = this.x;
            if (expressInterstitialListener != null) {
                expressInterstitialListener.onNoAd(i, str);
            }
            super.a(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, str, i) == null) {
            ExpressInterstitialListener expressInterstitialListener = this.x;
            if (expressInterstitialListener != null) {
                expressInterstitialListener.onAdFailed(i, str);
            }
            super.b(str, i);
        }
    }

    public void a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interAdDownloadWindowListener) == null) {
            this.y = interAdDownloadWindowListener;
        }
    }

    public void a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interstitialAdDislikeListener) == null) {
            this.z = interstitialAdDislikeListener;
        }
    }

    public void a(ExpressInterstitialListener expressInterstitialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, expressInterstitialListener) == null) {
            this.x = expressInterstitialListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        List<a> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iOAdEvent) == null) {
            if (iOAdEvent != null && (a = b.a(iOAdEvent.getMessage()).a()) != null && a.size() > 0) {
                this.A = a.get(0);
            }
            this.r = true;
            ExpressInterstitialListener expressInterstitialListener = this.x;
            if (expressInterstitialListener != null) {
                expressInterstitialListener.onADLoaded();
            }
        }
    }

    public void a(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, requestParameters) == null) {
            int width = requestParameters.getWidth();
            int height = requestParameters.getHeight();
            if (width > 0 && height > 0) {
                this.v = width;
                this.w = height;
            }
            a(requestParameters.getExt());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) && (interAdDownloadWindowListener = this.y) != null) {
            if (z) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && (interAdDownloadWindowListener = this.y) != null) {
            if (z) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, map) == null) {
            try {
                this.m = j.a(map);
            } catch (Throwable unused) {
                this.m = new HashMap<>();
            }
        }
    }

    public void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, str) == null) {
            a(z, str, (HashMap<String, Object>) null);
        }
    }

    public void a(boolean z, String str, HashMap<String, Object> hashMap) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), str, hashMap}) == null) && (aVar = this.A) != null) {
            a(aVar.H(), z, str, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.t);
                jSONObject2.put("isNewInterstitial", true);
                this.k.createProdHandler(jSONObject2);
                this.k.setAdContainer(this.a);
                n();
                jSONObject.put(IAdInterListener.AdReqParam.PROD, this.t);
                jSONObject.put(IAdInterListener.AdReqParam.APID, this.u);
                jSONObject.put("n", "1");
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                if (co.a().b()) {
                    jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
                } else {
                    jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
                }
                jSONObject.put("at", "10");
                jSONObject.put("w", "" + ax.b(this.h));
                jSONObject.put("h", "" + ax.c(this.h));
                jSONObject.put("msa", Cea708Decoder.COMMAND_SWA);
                jSONObject.put("opt", 1);
                jSONObject = j.a(jSONObject, b(this.m));
                b(jSONObject);
                return jSONObject;
            } catch (Throwable th) {
                th.printStackTrace();
                return jSONObject;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("onlyLoadAd", this.q);
                jSONObject.put("isNewInterstitial", true);
                jSONObject.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, this.B);
                jSONObject.put("use_dialog_container", this.C);
                jSONObject.put("timeout", this.s);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
