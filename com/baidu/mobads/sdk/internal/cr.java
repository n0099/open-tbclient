package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cr extends bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Object> a;
    public int q;
    public RelativeLayout r;
    public CpuAdView.CpuAdViewInternalStatusListener s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(Context context, RelativeLayout relativeLayout, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout, str, Integer.valueOf(i), cPUWebAdRequestParam};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = str;
        this.r = relativeLayout;
        this.q = i;
        if (cPUWebAdRequestParam == null) {
            av.c().e("内容联盟模板需要传入 CPUWebAdRequestParam配置信息");
        } else {
            this.a = (HashMap) cPUWebAdRequestParam.getParameters();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str, int i3, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2}) == null) {
            an.a(i);
            an.b(i2);
            an.a(new cv(this, i3, i4, str2));
            an.a(this.h, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, iOAdEvent) == null) && this.s != null && iOAdEvent != null) {
            this.s.onLpContentStatus(iOAdEvent.getData());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) && (cpuAdViewInternalStatusListener = this.s) != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, map) == null) && map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                an.a(((Integer) obj).intValue());
                an.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                an.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                if (((Integer) obj5).intValue() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                an.a(z);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                an.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            an.b();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (cpuAdViewInternalStatusListener = this.s) != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    public Activity f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return an.c();
        }
        return (Activity) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return an.d();
        }
        return invokeV.booleanValue;
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
            if (this.k != null) {
                try {
                    jSONObject.put("channel", this.q);
                    jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                    jSONObject.put("timeout", 10000);
                    if (!TextUtils.isEmpty(this.o)) {
                        jSONObject.put("appid", this.o);
                    }
                    if (this.r != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                        this.k.createProdHandler(jSONObject2);
                        this.k.setAdContainer(this.r);
                        n();
                        this.k.addEventListener("Update_fbReader_Setting", new cs(this));
                        this.k.addEventListener("closeInterstitialAd", new ct(this));
                        this.k.addEventListener("feOpenFbReader", new cu(this));
                        JSONObject a = j.a(this.a);
                        a.put("isInitNovelSDK", an.f());
                        this.k.loadAd(jSONObject, a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cpuAdViewInternalStatusListener) == null) {
            this.s = cpuAdViewInternalStatusListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iOAdEvent) == null) {
            Map<String, Object> data = iOAdEvent.getData();
            Boolean bool = (Boolean) data.get("isImpressionFeAd");
            String str = (String) data.get("nums");
            if (this.s != null && bool != null && bool.booleanValue()) {
                this.s.onAdImpression(str);
                return;
            }
            CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.s;
            if (cpuAdViewInternalStatusListener != null && bool != null) {
                cpuAdViewInternalStatusListener.onContentImpression(str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iOAdEvent) == null) {
            Boolean bool = (Boolean) iOAdEvent.getData().get("isClickFeAd");
            if (this.s != null && bool != null && bool.booleanValue()) {
                this.s.onAdClick();
                return;
            }
            CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.s;
            if (cpuAdViewInternalStatusListener != null && bool != null) {
                cpuAdViewInternalStatusListener.onContentClick();
            }
        }
    }
}
