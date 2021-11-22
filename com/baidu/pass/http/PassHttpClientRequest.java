package com.baidu.pass.http;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.common.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PassHttpClientRequest implements com.baidu.pass.a, Runnable, Comparable<PassHttpClientRequest> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f42801a = "PassHttpClientRequest";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f42802b;
    public volatile boolean cancelRequest;
    public Context context;
    public Method method;
    public PassHttpParamDTO paramDTO;
    public HttpResponseHandler responseHandler;

    public PassHttpClientRequest(Method method, Context context, PassHttpParamDTO passHttpParamDTO, int i2, HttpResponseHandler httpResponseHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {method, context, passHttpParamDTO, Integer.valueOf(i2), httpResponseHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cancelRequest = false;
        this.f42802b = i2;
        this.method = method;
        this.context = context;
        this.paramDTO = passHttpParamDTO;
        this.responseHandler = httpResponseHandler;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.cancelRequest = true;
            this.responseHandler = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HttpResponseHandler httpResponseHandler = this.responseHandler;
            if (httpResponseHandler != null) {
                httpResponseHandler.b();
            }
            try {
                new b().a(this);
            } catch (Exception e2) {
                Log.e(f42801a, "PassHttpClientRequestrun " + e2.getMessage());
                HttpResponseHandler httpResponseHandler2 = this.responseHandler;
                if (httpResponseHandler2 != null) {
                    httpResponseHandler2.b(e2, e2.getMessage());
                }
            }
            HttpResponseHandler httpResponseHandler3 = this.responseHandler;
            if (httpResponseHandler3 != null) {
                httpResponseHandler3.a();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(PassHttpClientRequest passHttpClientRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passHttpClientRequest)) == null) {
            ReqPriority reqPriority = this.paramDTO.priority;
            ReqPriority reqPriority2 = passHttpClientRequest.paramDTO.priority;
            return reqPriority == reqPriority2 ? this.f42802b - passHttpClientRequest.f42802b : reqPriority2.ordinal() - reqPriority.ordinal();
        }
        return invokeL.intValue;
    }
}
