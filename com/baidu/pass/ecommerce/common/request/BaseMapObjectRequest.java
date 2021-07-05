package com.baidu.pass.ecommerce.common.request;

import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class BaseMapObjectRequest extends BaseRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String relativeUrl;

    public BaseMapObjectRequest(String str, MapObject mapObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, mapObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.relativeUrl = str;
        if (mapObject != null) {
            Iterator<String> keyIterator = mapObject.keyIterator();
            while (keyIterator.hasNext()) {
                String next = keyIterator.next();
                addParams(next, "" + mapObject.getObjValue(next));
            }
        }
    }

    @Override // com.baidu.pass.ecommerce.common.request.BaseRequest
    public String getRelativeUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.relativeUrl : (String) invokeV.objValue;
    }
}
