package com.baidu.platform.core.c;

import com.baidu.down.request.task.ProgressInfo;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
/* loaded from: classes4.dex */
public class c extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c(PoiIndoorOption poiIndoorOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiIndoorOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(poiIndoorOption);
    }

    private void a(PoiIndoorOption poiIndoorOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, poiIndoorOption) == null) {
            this.a.a("qt", "indoor_s");
            this.a.a("x", "0");
            this.a.a("y", "0");
            this.a.a("from", "android_map_sdk");
            String str = poiIndoorOption.bid;
            if (str != null && !str.equals("")) {
                this.a.a("bid", str);
            }
            String str2 = poiIndoorOption.wd;
            if (str2 != null && !str2.equals("")) {
                this.a.a(ActVideoSetting.WIFI_DISPLAY, str2);
            }
            String str3 = poiIndoorOption.floor;
            if (str3 != null && !str3.equals("")) {
                this.a.a("floor", str3);
            }
            com.baidu.platform.util.a aVar = this.a;
            aVar.a(ProgressInfo.JSON_KEY_CURRENT, poiIndoorOption.currentPage + "");
            com.baidu.platform.util.a aVar2 = this.a;
            aVar2.a("pageSize", poiIndoorOption.pageSize + "");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.c() : (String) invokeL.objValue;
    }
}
