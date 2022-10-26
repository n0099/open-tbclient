package com.baidu.pass.ecommerce.common.request;

import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.relativeUrl = str;
        if (mapObject != null) {
            Iterator keyIterator = mapObject.keyIterator();
            while (keyIterator.hasNext()) {
                String str2 = (String) keyIterator.next();
                addParams(str2, "" + mapObject.getObjValue(str2));
            }
        }
    }

    @Override // com.baidu.pass.ecommerce.common.request.BaseRequest
    public String getRelativeUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.relativeUrl;
        }
        return (String) invokeV.objValue;
    }
}
