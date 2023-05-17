package com.baidu.platform.core.b;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
/* loaded from: classes3.dex */
public class a extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a(DistrictSearchOption districtSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {districtSearchOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(districtSearchOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.n();
        }
        return (String) invokeL.objValue;
    }

    private void a(DistrictSearchOption districtSearchOption) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, districtSearchOption) != null) || districtSearchOption == null) {
            return;
        }
        this.a.a("qt", "con");
        this.a.a("rp_format", "json");
        this.a.a("rp_filter", "mobile");
        this.a.a("area_res", "true");
        this.a.a("addr_identify", "1");
        this.a.a("ie", IMAudioTransRequest.CHARSET);
        this.a.a("pn", "0");
        this.a.a("rn", "10");
        this.a.a("c", districtSearchOption.mCityName);
        String str = districtSearchOption.mDistrictName;
        if (str != null && !str.equals("")) {
            this.a.a(ActVideoSetting.WIFI_DISPLAY, districtSearchOption.mDistrictName);
        } else {
            this.a.a(ActVideoSetting.WIFI_DISPLAY, districtSearchOption.mCityName);
        }
    }
}
