package com.baidu.searchbox.network.support.cookie;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.UrlWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new CookieJar() { // from class: com.baidu.searchbox.network.support.cookie.CookieJar.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.network.support.cookie.CookieJar
        public List<Cookie> loadForRequest(UrlWrapper urlWrapper) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, urlWrapper)) == null) ? Collections.emptyList() : (List) invokeL.objValue;
        }

        @Override // com.baidu.searchbox.network.support.cookie.CookieJar
        public void saveFromResponse(UrlWrapper urlWrapper, List<Cookie> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlWrapper, list) == null) {
            }
        }
    };

    List<Cookie> loadForRequest(UrlWrapper urlWrapper);

    void saveFromResponse(UrlWrapper urlWrapper, List<Cookie> list);
}
