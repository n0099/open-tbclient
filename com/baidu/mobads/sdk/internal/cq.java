package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cq extends bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public String q;
    public boolean r;
    public AdViewListener s;
    public int t;
    public int u;
    public AdView v;
    public RequestParameters w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq(AdView adView, Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adView, context, relativeLayout, str, Boolean.valueOf(z)};
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
        this.v = adView;
        this.a = relativeLayout;
        this.q = str;
        this.r = z;
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
                jSONObject3.put(IAdInterListener.AdReqParam.PROD, "banner");
                this.k.createProdHandler(jSONObject3);
                this.k.setAdContainer(this.a);
                n();
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "banner");
                jSONObject.put(IAdInterListener.AdReqParam.APID, this.q);
                jSONObject.put("at", "2");
                jSONObject.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
                jSONObject.put("AP", this.r);
                jSONObject.put("w", "" + this.t);
                jSONObject.put("h", "" + this.u);
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                if (this.w != null) {
                    a(this.w.getExtras());
                }
                jSONObject2 = b(this.m);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.k.loadAd(jSONObject, jSONObject2);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.t = i;
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.u = i;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iOAdEvent) == null) {
            super.g(iOAdEvent);
            AdViewListener adViewListener = this.s;
            if (adViewListener != null) {
                adViewListener.onAdClose(new JSONObject());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iOAdEvent) == null) && (adViewListener = this.s) != null) {
            adViewListener.onAdClick(new JSONObject());
        }
    }

    public void a(AdViewListener adViewListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adViewListener) == null) {
            this.s = adViewListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, iOAdEvent) == null) && (adViewListener = this.s) != null) {
            adViewListener.onAdReady(this.v);
        }
    }

    public void a(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, requestParameters) == null) {
            this.w = requestParameters;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        AdViewListener adViewListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) && (adViewListener = this.s) != null) {
            adViewListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        AdViewListener adViewListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (adViewListener = this.s) != null) {
            adViewListener.onAdSwitch();
            this.s.onAdShow(new JSONObject());
        }
    }
}
