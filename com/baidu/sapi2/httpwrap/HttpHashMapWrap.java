package com.baidu.sapi2.httpwrap;

import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.Map;
/* loaded from: classes2.dex */
public class HttpHashMapWrap extends HttpHashMap implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpHashMapWrap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        putAll(Utils.buildCommonParams());
    }

    @Override // com.baidu.pass.http.HttpHashMap
    public void doSign(String str) {
        Map map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (map = getMap()) != null && !map.containsKey(FunAdSdk.PLATFORM_SIG)) {
            put(FunAdSdk.PLATFORM_SIG, SapiUtils.calculateSig(getMap(), str));
        }
    }
}
