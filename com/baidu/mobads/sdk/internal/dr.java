package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dr extends bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int q;
    public String r;
    public ScreenVideoAdListener s;
    public final String t;
    public int u;
    public int v;
    public String w;
    public String x;
    public a y;
    public RequestParameters z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public dr(Context context, String str, boolean z) {
        this(context, str, z, IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr(Context context, String str, boolean z, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = 3;
        this.r = str;
        this.a = z;
        this.t = str2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener == null) {
                this.l = false;
                return;
            }
            this.l = true;
            iAdInterListener.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b_() {
        ScreenVideoAdListener screenVideoAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (screenVideoAdListener = this.s) != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void c_() {
        ScreenVideoAdListener screenVideoAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (screenVideoAdListener = this.s) != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    public void f() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.showAd();
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener != null) {
                return iAdInterListener.isAdReady();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            a aVar = this.y;
            if (aVar != null) {
                return aVar.z();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        ScreenVideoAdListener screenVideoAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (screenVideoAdListener = this.s) != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void s() {
        ScreenVideoAdListener screenVideoAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (screenVideoAdListener = this.s) != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.q = i;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(boolean z) {
        ScreenVideoAdListener screenVideoAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (screenVideoAdListener = this.s) != null && (screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(String str) {
        ScreenVideoAdListener screenVideoAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && (screenVideoAdListener = this.s) != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, iOAdEvent) == null) && (screenVideoAdListener = this.s) != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.x = str;
        }
    }

    public Object k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (this.y != null) {
                if (HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID.equals(str)) {
                    return this.y.U();
                }
                return this.y.a(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            super.a(i, str);
            ScreenVideoAdListener screenVideoAdListener = this.s;
            if (screenVideoAdListener != null) {
                screenVideoAdListener.onAdFailed(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i) == null) {
            super.b(str, i);
            ScreenVideoAdListener screenVideoAdListener = this.s;
            if (screenVideoAdListener != null) {
                screenVideoAdListener.onAdFailed(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        List<a> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iOAdEvent) == null) {
            if (iOAdEvent != null && (a = b.a(iOAdEvent.getMessage()).a()) != null && a.size() > 0) {
                this.y = a.get(0);
            }
            ScreenVideoAdListener screenVideoAdListener = this.s;
            if (screenVideoAdListener != null) {
                screenVideoAdListener.onAdLoaded();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(IOAdEvent iOAdEvent) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iOAdEvent) == null) {
            super.g(iOAdEvent);
            if (iOAdEvent != null && iOAdEvent.getData() != null) {
                f = ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
            } else {
                f = 0.0f;
            }
            ScreenVideoAdListener screenVideoAdListener = this.s;
            if (screenVideoAdListener != null) {
                screenVideoAdListener.onAdClose(f);
            }
        }
    }

    public void a(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, requestParameters) == null) {
            this.z = requestParameters;
            a(requestParameters.getExt());
        }
    }

    public void a(ScreenVideoAdListener screenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, screenVideoAdListener) == null) {
            this.s = screenVideoAdListener;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.w = str;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, map) == null) {
            try {
                this.m = j.a(map);
            } catch (Throwable unused) {
                this.m = new HashMap<>();
            }
        }
    }

    public void a(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, str) == null) {
            a(z, str, (HashMap<String, Object>) null);
        }
    }

    public void a(boolean z, String str, HashMap<String, Object> hashMap) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), str, hashMap}) == null) && (aVar = this.y) != null) {
            a(aVar.H(), z, str, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.t);
                this.k.createProdHandler(jSONObject2);
                n();
                jSONObject.put(IAdInterListener.AdReqParam.PROD, this.t);
                jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON");
                jSONObject.put("n", "1");
                jSONObject.put("at", "10");
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                Rect a = ax.a(this.h);
                this.u = a.width();
                this.v = a.height();
                if (this.h.getResources().getConfiguration().orientation == 2) {
                    this.u = a.height();
                    this.v = a.width();
                }
                jSONObject.put("w", "" + this.u);
                jSONObject.put("h", "" + this.v);
                jSONObject.put("opt", 1);
                if (IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO.equals(this.t)) {
                    jSONObject.put("msa", 5285);
                }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timeout", 8000);
                jSONObject.put("useSurfaceView", this.a);
                jSONObject.put("downloadConfirmPolicy", this.q);
                jSONObject.put(DpStatConstants.KEY_USER_ID, this.w);
                jSONObject.put("extra", this.x);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
