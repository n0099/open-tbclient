package com.baidu.searchbox.http.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class HttpRequestParasBuilder extends HttpRequestBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap params;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestParasBuilder(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {abstractHttpManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((AbstractHttpManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.params = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestParasBuilder(HttpParaRequest httpParaRequest, AbstractHttpManager abstractHttpManager) {
        super(httpParaRequest, abstractHttpManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpParaRequest, abstractHttpManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((HttpRequest) objArr2[0], (AbstractHttpManager) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (httpParaRequest.params != null) {
            this.params = new LinkedHashMap(httpParaRequest.params);
        } else {
            this.params = new LinkedHashMap();
        }
    }

    public HttpRequestParasBuilder addParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            this.params.put(str, str2);
            return this;
        }
        return (HttpRequestParasBuilder) invokeLL.objValue;
    }

    public HttpRequestParasBuilder addParams(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            this.params.putAll(map);
            return this;
        }
        return (HttpRequestParasBuilder) invokeL.objValue;
    }

    public HttpRequestParasBuilder params(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            this.params = new LinkedHashMap(map);
            return this;
        }
        return (HttpRequestParasBuilder) invokeL.objValue;
    }

    public HttpRequestParasBuilder removeParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.params.remove(str);
            return this;
        }
        return (HttpRequestParasBuilder) invokeL.objValue;
    }

    public HttpRequestParasBuilder removeParams(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.params.remove((String) it.next());
                }
            }
            return this;
        }
        return (HttpRequestParasBuilder) invokeL.objValue;
    }
}
