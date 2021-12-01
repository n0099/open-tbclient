package com.baidu.platform.core.e;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.beans.BeanConstants;
/* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(locationShareURLOption);
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, locationShareURLOption) == null) {
            this.a.a("qt", "cs");
            Point ll2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
            com.baidu.platform.util.a aVar = this.a;
            aVar.a("geo", ll2point.x + "|" + ll2point.y);
            this.a.a("t", locationShareURLOption.mName);
            this.a.a(BeanConstants.DXM_OCR_KEY_CNT, locationShareURLOption.mSnippet);
            b(false);
            a(false);
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.q() : (String) invokeL.objValue;
    }
}
