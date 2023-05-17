package com.baidu.platform.core.d;

import android.util.Log;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(poiDetailSearchOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.b();
        }
        return (String) invokeL.objValue;
    }

    private void a(PoiDetailSearchOption poiDetailSearchOption) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, poiDetailSearchOption) == null) {
            if (poiDetailSearchOption == null) {
                Log.e(e.class.getSimpleName(), "Option is null");
                return;
            }
            if (!poiDetailSearchOption.isSearchByUids()) {
                poiDetailSearchOption.poiUids(poiDetailSearchOption.getUid());
            }
            this.a.a("uids", poiDetailSearchOption.getUids());
            com.baidu.platform.util.a aVar = this.a;
            if (poiDetailSearchOption.isExtendAdcode()) {
                str = "true";
            } else {
                str = CommandUBCHelper.COMMAND_UBC_VALUE_FALSE;
            }
            aVar.a("extensions_adcode", str);
            this.a.a("output", "json");
            this.a.a("scope", "2");
        }
    }
}
