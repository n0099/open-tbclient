package com.baidu.sapi2.httpwrap;

import com.baidu.pass.http.MultipartHashMap;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MultipartHashMapWrap extends MultipartHashMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MultipartHashMapWrap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        putAll(Utils.buildCommonParams());
    }

    @Override // com.baidu.pass.http.HttpHashMap
    public void doSign(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            put("sig", SapiUtils.calculateSig(getMap(), str));
        }
    }
}
