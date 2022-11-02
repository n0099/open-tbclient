package com.baidu.platform.core.g;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b(LocationShareURLOption locationShareURLOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {locationShareURLOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(locationShareURLOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.q();
        }
        return (String) invokeL.objValue;
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, locationShareURLOption) == null) {
            this.a.a("qt", "cs");
            Point ll2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
            com.baidu.platform.util.a aVar = this.a;
            aVar.a(MapBundleKey.MapObjKey.OBJ_GEO, ll2point.x + "|" + ll2point.y);
            this.a.a("t", locationShareURLOption.mName);
            this.a.a("cnt", locationShareURLOption.mSnippet);
            b(false);
            a(false);
        }
    }
}
