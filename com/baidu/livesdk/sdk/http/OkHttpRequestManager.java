package com.baidu.livesdk.sdk.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.http.HttpRequestEntity;
import com.baidu.livesdk.api.http.HttpRequestManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
/* loaded from: classes4.dex */
public class OkHttpRequestManager implements HttpRequestManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient mClient;

    public OkHttpRequestManager() {
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

    public OkHttpRequest createRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new OkHttpRequest() : (OkHttpRequest) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.livesdk.api.http.HttpRequestManager
    public OkHttpRequest getRequest(HttpRequestEntity httpRequestEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpRequestEntity)) == null) {
            OkHttpRequest createRequest = createRequest();
            if (this.mClient == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.connectionPool(new ConnectionPool(5, 10L, TimeUnit.MINUTES));
                if (httpRequestEntity.getConnectTimeout() > 0) {
                    builder.connectTimeout(httpRequestEntity.getConnectTimeout(), TimeUnit.MILLISECONDS);
                }
                if (httpRequestEntity.getReadTimeout() > 0) {
                    builder.readTimeout(httpRequestEntity.getReadTimeout(), TimeUnit.MILLISECONDS);
                }
                OkHttpClient build = builder.build();
                this.mClient = build;
                build.dispatcher().setMaxRequestsPerHost(5);
            }
            createRequest.setOkHttpClient(this.mClient);
            createRequest.setHttpRequestEntity(httpRequestEntity);
            return createRequest;
        }
        return (OkHttpRequest) invokeL.objValue;
    }
}
