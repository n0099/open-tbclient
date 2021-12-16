package com.baidu.searchbox.bddownload.core.connection;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.RedirectUtil;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes10.dex */
public class DownloadOkHttp3Connection implements DownloadConnection, DownloadConnection.Connected {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DownloadOkHttp3Connection";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final OkHttpClient client;
    public Request request;
    @NonNull
    public final Request.Builder requestBuilder;
    public Response response;

    /* loaded from: classes10.dex */
    public static class Factory implements DownloadConnection.Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile OkHttpClient client;
        public OkHttpClient.Builder clientBuilder;

        public Factory() {
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

        @NonNull
        public OkHttpClient.Builder builder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.clientBuilder == null) {
                    this.clientBuilder = new OkHttpClient.Builder();
                }
                return this.clientBuilder;
            }
            return (OkHttpClient.Builder) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Factory
        public DownloadConnection create(String str) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.client == null) {
                    synchronized (Factory.class) {
                        if (this.client == null) {
                            this.client = this.clientBuilder != null ? this.clientBuilder.build() : new OkHttpClient();
                            this.clientBuilder = null;
                        }
                    }
                }
                Util.d(DownloadOkHttp3Connection.TAG, " create url = " + str);
                return new DownloadOkHttp3Connection(this.client, str);
            }
            return (DownloadConnection) invokeL.objValue;
        }

        public Factory setBuilder(@NonNull OkHttpClient.Builder builder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder)) == null) {
                this.clientBuilder = builder;
                return this;
            }
            return (Factory) invokeL.objValue;
        }
    }

    public DownloadOkHttp3Connection(@NonNull OkHttpClient okHttpClient, @NonNull Request.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient, builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.client = okHttpClient;
        this.requestBuilder = builder;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            Util.d(TAG, " addHeader name = " + str + "  value = " + str2);
            this.requestBuilder.addHeader(str, str2);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public DownloadConnection.Connected execute() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Request build = this.requestBuilder.build();
            this.request = build;
            this.response = this.client.newCall(build).execute();
            Util.d(TAG, "execute ");
            return this;
        }
        return (DownloadConnection.Connected) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Response response = this.response;
            if (response != null) {
                ResponseBody body = response.body();
                if (body != null) {
                    return body.byteStream();
                }
                throw new IOException("no body found on response!");
            }
            throw new IOException("Please invoke execute first!");
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public String getRedirectLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Response priorResponse = this.response.priorResponse();
            if (priorResponse != null && this.response.isSuccessful() && RedirectUtil.isRedirect(priorResponse.code())) {
                return this.response.request().url().toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public Map<String, List<String>> getRequestProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Request request = this.request;
            if (request != null) {
                return request.headers().toMultimap();
            }
            return this.requestBuilder.build().headers().toMultimap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public String getRequestProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Request request = this.request;
            if (request != null) {
                return request.header(str);
            }
            return this.requestBuilder.build().header(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.response != null) {
                Util.d(TAG, "getResponseCode " + this.response.code());
                return this.response.code();
            }
            throw new IOException("Please invoke execute first!");
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public String getResponseHeaderField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Response response = this.response;
            if (response == null) {
                return null;
            }
            return response.header(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection.Connected
    public Map<String, List<String>> getResponseHeaderFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Response response = this.response;
            if (response == null) {
                return null;
            }
            return response.headers().toMultimap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.request = null;
            Response response = this.response;
            if (response != null) {
                try {
                    response.close();
                } catch (Throwable th) {
                    Util.d(TAG, "DownloadOkHttp3Connection connection release exception " + th.toString());
                }
            }
            this.response = null;
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.connection.DownloadConnection
    public boolean setRequestMethod(@NonNull String str) throws ProtocolException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.requestBuilder.method(str, null);
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadOkHttp3Connection(@NonNull OkHttpClient okHttpClient, @NonNull String str) {
        this(okHttpClient, new Request.Builder().url(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {okHttpClient, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((OkHttpClient) objArr2[0], (Request.Builder) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
