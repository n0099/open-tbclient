package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMPushUploadConstants;
import com.baidu.android.pushservice.h.b.a.a;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b b;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;
    public Context c;

    /* loaded from: classes.dex */
    public class a implements Interceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        private RequestBody a(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, requestBody)) == null) ? new RequestBody(this, requestBody) { // from class: com.baidu.android.pushservice.h.b.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RequestBody a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, requestBody};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = requestBody;
                }

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return -1L;
                    }
                    return invokeV.longValue;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.contentType() : (MediaType) invokeV.objValue;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                        BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                        try {
                            this.a.writeTo(buffer);
                            buffer.close();
                        } catch (IOException unused) {
                        }
                    }
                }
            } : (RequestBody) invokeL.objValue;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
                try {
                    Request request = chain.request();
                    if (request.body() != null && request.header("Content-Encoding") == null) {
                        return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), a(request.body())).build());
                    }
                    return chain.proceed(request);
                } catch (Exception e) {
                    throw new IOException(e.getMessage());
                }
            }
            return (Response) invokeL.objValue;
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = a();
        this.c = context;
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (b == null) {
                b = new b(context);
            }
            return b;
        }
        return (b) invokeL.objValue;
    }

    private OkHttpClient a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).addInterceptor(new a(this)).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build() : (OkHttpClient) invokeV.objValue;
    }

    private Request a(byte[] bArr, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, bArr, str, str2)) == null) ? new Request.Builder().addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE).addHeader("Content-Type", "application/proto").addHeader(IMPushUploadConstants.BIM_LOG_ID, str2).url(IMPushUploadConstants.ONLINE_URL).post(a(bArr, str)).build() : (Request) invokeLLL.objValue;
    }

    private RequestBody a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bArr, str)) == null) ? RequestBody.create(MediaType.parse("application/proto"), b(bArr, str)) : (RequestBody) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, bArr)) == null) {
            try {
                a.c a2 = a.c.a(bArr);
                if (this.a.pingIntervalMillis() != a2.i()) {
                    this.a.newBuilder().pingInterval(a2.i(), TimeUnit.MILLISECONDS);
                    this.a = this.a.newBuilder().pingInterval(a2.i(), TimeUnit.MILLISECONDS).build();
                }
                return new String[]{String.valueOf(a2.d()), a2.f()};
            } catch (InvalidProtocolBufferException unused) {
                return new String[]{String.valueOf(-1), "parseResponse exception"};
            }
        }
        return (String[]) invokeL.objValue;
    }

    private byte[] b(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, bArr, str)) == null) {
            a.C0054a.C0055a.C0056a e = a.C0054a.C0055a.e();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            a.C0054a.C0055a build = e.a(str).build();
            long currentTimeMillis = System.currentTimeMillis();
            return a.C0054a.o().a(1L).a(IMPushUploadConstants.Service.BAIDU_APP).a(build).b(currentTimeMillis).b(com.baidu.android.pushservice.h.a.a(this.c, IMPushUploadConstants.Service.BAIDU_APP, currentTimeMillis)).a(ByteString.copyFrom(bArr)).build().toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }

    public void a(Map<String, String> map, byte[] bArr, String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, map, bArr, str, cVar) == null) {
            Request a2 = a(bArr, str, "" + ((int) ((Math.random() * 100000.0d) + 1000.0d)));
            if (this.a == null) {
                this.a = a();
            }
            this.a.newCall(a2).enqueue(new Callback(this, cVar) { // from class: com.baidu.android.pushservice.h.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;
                public final /* synthetic */ b b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = cVar;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                        String str2 = "Request error :" + iOException.toString();
                        if (iOException instanceof SocketException) {
                            str2 = "Request SocketException :" + iOException.toString();
                        }
                        this.a.a(-1, str2);
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                        String str2 = DnsModel.MSG_OK;
                        int i = 0;
                        try {
                            if (response.body() != null) {
                                String[] a3 = this.b.a(response.body().bytes());
                                i = Integer.valueOf(a3[0]).intValue();
                                str2 = a3[1];
                            }
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            this.a.a(i, DnsModel.MSG_OK);
                            throw th;
                        }
                        this.a.a(i, str2);
                    }
                }
            });
        }
    }
}
