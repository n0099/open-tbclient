package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.BaiduNativeAdPlacement;
import com.baidu.mobads.sdk.api.BaiduNativeH5AdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dh extends bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public BaiduNativeAdPlacement B;
    public a a;
    public String q;
    public String r;
    public int s;
    public int t;
    public BaiduNativeH5AdView u;
    public int v;
    public int w;
    public int x;
    public BaiduNativeH5AdView.BaiduNativeH5EventListner y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh(Context context, String str, BaiduNativeH5AdView baiduNativeH5AdView) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, baiduNativeH5AdView};
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
        this.v = 1;
        this.w = 1;
        this.x = 1;
        this.z = false;
        this.a = null;
        this.A = false;
        this.u = baiduNativeH5AdView;
        this.r = baiduNativeH5AdView.getAdPlacement().getApId();
        this.q = str;
        this.g = baiduNativeH5AdView.getAdPlacement().getAdView();
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
                jSONObject3.put(IAdInterListener.AdReqParam.PROD, this.q);
                this.k.createProdHandler(jSONObject3);
                this.k.setAdContainer(this.g);
                n();
                jSONObject.put(IAdInterListener.AdReqParam.PROD, this.q);
                jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
                jSONObject.put("n", "1");
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                jSONObject.put("at", "2");
                jSONObject.put("w", "" + this.s);
                jSONObject.put("h", "" + this.t);
                jSONObject = j.a(jSONObject, b(this.m));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.k.loadAd(jSONObject, jSONObject2);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.v = i;
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.w = i;
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.x = i;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iOAdEvent) == null) {
            this.B.setWinSended(true);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iOAdEvent) == null) {
            this.B.setClicked(true);
            BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner.onAdClick();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            r();
            this.B.setRequestStarted(false);
            BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner.onAdFail(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
            this.B.setRequestStarted(false);
            BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner.onAdFail(str);
            }
        }
    }

    public void a(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, baiduNativeAdPlacement) == null) {
            this.B = baiduNativeAdPlacement;
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.z = z;
        }
    }

    public void a(BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baiduNativeH5EventListner) == null) {
            this.y = baiduNativeH5EventListner;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iOAdEvent) == null) {
            this.A = true;
            this.u.getAdPlacement().setAdResponse(b.a(iOAdEvent.getMessage()).a().get(0));
            BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner.onAdDataLoaded();
            }
        }
    }

    public void a(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, requestParameters) == null) {
            int width = requestParameters.getWidth();
            int height = requestParameters.getHeight();
            if (width > 0 && height > 0) {
                this.s = width;
                this.t = height;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.z = true;
            this.B.setRequestStarted(false);
            BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
            if (baiduNativeH5EventListner != null) {
                baiduNativeH5EventListner.onAdShow();
            }
        }
    }
}
