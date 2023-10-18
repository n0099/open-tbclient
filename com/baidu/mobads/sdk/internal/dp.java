package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.mobads.sdk.api.AdSize;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dp extends bf implements y {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "preload_end";
    public transient /* synthetic */ FieldHolder $fh;
    public AdSize q;
    public String r;
    public boolean s;
    public boolean t;
    public RelativeLayout u;
    public InterstitialAd v;
    public InterstitialAdListener w;

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, AdSize adSize, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout, interstitialAd, adSize, str};
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
        this.s = false;
        this.t = false;
        this.v = interstitialAd;
        this.u = relativeLayout;
        this.q = adSize;
        this.r = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public dp(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, String str) {
        this(context, relativeLayout, interstitialAd, AdSize.InterstitialGame, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout, interstitialAd, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (RelativeLayout) objArr2[1], (InterstitialAd) objArr2[2], (AdSize) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.k == null) {
                this.l = false;
                return;
            }
            this.l = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                this.k.createProdHandler(jSONObject3);
                this.k.setAdContainer(this.u);
                n();
                jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
                jSONObject.put("at", "2");
                jSONObject.put("w", "0");
                jSONObject.put("h", "0");
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                if (AdSize.InterstitialGame.equals(this.q)) {
                    jSONObject2.put("ABILITY", "PAUSE,");
                }
                jSONObject2.put("APT", this.q.getValue());
                jSONObject2.put("onlyLoadAd", true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.k.loadAd(jSONObject, jSONObject2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) && this.k != null && !this.s && !this.t) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("w", i);
                jSONObject.put("h", i2);
            } catch (JSONException unused) {
            }
            a(jSONObject);
            this.k.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, relativeLayout) == null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.putOpt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "interstitial_set_video_parent");
                hashMap.put("interstitial_video_parent", relativeLayout);
            } catch (JSONException e) {
                br.a().a(e);
            }
            a(jSONObject, hashMap);
            a_();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, iOAdEvent) == null) && a.equals(iOAdEvent.getMessage())) {
            this.s = true;
            InterstitialAdListener interstitialAdListener = this.w;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdReady();
            }
        }
    }

    @Deprecated
    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            a_();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iOAdEvent) == null) {
            this.t = false;
            InterstitialAdListener interstitialAdListener = this.w;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdDismissed();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        InterstitialAdListener interstitialAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, iOAdEvent) == null) && (interstitialAdListener = this.w) != null) {
            interstitialAdListener.onAdClick(this.v);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(InterstitialAdListener interstitialAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interstitialAdListener) == null) {
            this.w = interstitialAdListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.h(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.s && !this.t) {
                this.t = true;
                this.s = false;
                IAdInterListener iAdInterListener = this.k;
                if (iAdInterListener != null) {
                    iAdInterListener.showAd();
                }
            } else if (this.t) {
                this.i.b("interstitial ad is showing now");
            } else if (!this.s) {
                this.i.b("interstitial ad is not ready");
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void b() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.internal.y
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            a();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        InterstitialAdListener interstitialAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (interstitialAdListener = this.w) != null) {
            interstitialAdListener.onAdPresent();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        InterstitialAdListener interstitialAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, str, i) == null) && (interstitialAdListener = this.w) != null) {
            interstitialAdListener.onAdFailed(str);
        }
    }
}
