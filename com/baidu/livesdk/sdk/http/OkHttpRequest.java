package com.baidu.livesdk.sdk.http;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.http.HttpRequest;
import com.baidu.livesdk.api.http.HttpRequestEntity;
import com.baidu.livesdk.api.http.HttpResponse;
import com.baidu.livesdk.api.http.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class OkHttpRequest implements HttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ResponseCallback mCallback;
    public OkHttpClient mClient;
    public HttpRequestEntity mEntity;
    public Call mRequestCall;

    public OkHttpRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private Call requestBuild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mClient != null && this.mEntity != null) {
                Request.Builder url = new Request.Builder().url(this.mEntity.getUrl());
                if (this.mEntity.getHeader() != null) {
                    for (Map.Entry<String, String> entry : this.mEntity.getHeader().entrySet()) {
                        url.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                int method = this.mEntity.getMethod();
                if (method == 0) {
                    url.get();
                } else if (method != 1) {
                    url.get();
                } else {
                    RequestBody requestBody = null;
                    if (this.mEntity.getPostParams() != null) {
                        if (TextUtils.isEmpty(this.mEntity.getMediaType())) {
                            FormBody.Builder builder = new FormBody.Builder();
                            for (Map.Entry<String, String> entry2 : this.mEntity.getPostParams().entrySet()) {
                                builder.add(entry2.getKey(), entry2.getValue());
                            }
                            requestBody = builder.build();
                        } else {
                            String str = "";
                            for (Map.Entry<String, String> entry3 : this.mEntity.getPostParams().entrySet()) {
                                str = (str + entry3.getKey() + "=" + entry3.getValue()) + "&";
                            }
                            requestBody = RequestBody.create(MediaType.parse(this.mEntity.getMediaType()), str.substring(0, str.length() - 1));
                        }
                    }
                    if (requestBody != null) {
                        url.post(requestBody);
                    }
                }
                return this.mClient.newCall(url.build());
            }
            throw new NullPointerException("params is null");
        }
        return (Call) invokeV.objValue;
    }

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public void cancel() {
        Call call;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (call = this.mRequestCall) == null) {
            return;
        }
        call.cancel();
    }

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public HttpRequestEntity getHttpRequestEntity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mEntity : (HttpRequestEntity) invokeV.objValue;
    }

    public HttpResponse getHttpResponse(Response response) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, response)) == null) {
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setResponseCode(response.code());
            httpResponse.setHeaders(response.headers().toMultimap());
            if (response.body() != null) {
                httpResponse.setContent(response.body().string());
            }
            return httpResponse;
        }
        return (HttpResponse) invokeL.objValue;
    }

    public void onFailureCallback(Call call, IOException iOException) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, call, iOException) == null) || this.mCallback == null) {
            return;
        }
        if (iOException instanceof SocketTimeoutException) {
            i2 = 1;
        } else {
            i2 = iOException instanceof ConnectException ? 2 : 3;
        }
        this.mCallback.onFail(i2, iOException);
    }

    public void onResponseCallback(Call call, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, call, response) == null) {
            try {
                if (this.mCallback != null) {
                    this.mCallback.onSuccess(getHttpResponse(response));
                }
            } catch (Exception e2) {
                ResponseCallback responseCallback = this.mCallback;
                if (responseCallback != null) {
                    responseCallback.onFail(-1, e2);
                }
            }
        }
    }

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public HttpRequest request(ResponseCallback responseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, responseCallback)) == null) {
            this.mCallback = responseCallback;
            Call requestBuild = requestBuild();
            this.mRequestCall = requestBuild;
            requestBuild.enqueue(new Callback(this) { // from class: com.baidu.livesdk.sdk.http.OkHttpRequest.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OkHttpRequest this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                        this.this$0.onFailureCallback(call, iOException);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                        this.this$0.onResponseCallback(call, response);
                    }
                }
            });
            return this;
        }
        return (HttpRequest) invokeL.objValue;
    }

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public HttpResponse requestSync() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Call requestBuild = requestBuild();
            this.mRequestCall = requestBuild;
            return getHttpResponse(requestBuild.execute());
        }
        return (HttpResponse) invokeV.objValue;
    }

    @Override // com.baidu.livesdk.api.http.HttpRequest
    public void setHttpRequestEntity(HttpRequestEntity httpRequestEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, httpRequestEntity) == null) {
            this.mEntity = httpRequestEntity;
        }
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, okHttpClient) == null) {
            this.mClient = okHttpClient;
        }
    }
}
