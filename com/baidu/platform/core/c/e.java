package com.baidu.platform.core.c;

import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e(PoiDetailSearchOption poiDetailSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiDetailSearchOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(poiDetailSearchOption);
    }

    private void a(PoiDetailSearchOption poiDetailSearchOption) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, poiDetailSearchOption) == null) || poiDetailSearchOption == null) {
            return;
        }
        if (!poiDetailSearchOption.isSearchByUids()) {
            poiDetailSearchOption.poiUids(poiDetailSearchOption.getUid());
        }
        this.f42041a.a("uids", poiDetailSearchOption.getUids());
        this.f42041a.a("output", "json");
        this.f42041a.a("scope", "2");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.b() : (String) invokeL.objValue;
    }
}
