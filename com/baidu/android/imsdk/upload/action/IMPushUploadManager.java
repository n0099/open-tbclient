package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMPushUploadConstants;
import com.baidu.android.imsdk.upload.action.logpb.BIMLogPb;
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
public class IMPushUploadManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long PING_INTERVAL_MS = 1000;
    public static final int TIME_OUT_S = 30;
    public static IMPushUploadManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public OkHttpClient mOkHttpClient;

    /* loaded from: classes.dex */
    public class GzipRequestInterceptor implements Interceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMPushUploadManager this$0;

        public GzipRequestInterceptor(IMPushUploadManager iMPushUploadManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMPushUploadManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = iMPushUploadManager;
        }

        private RequestBody gzip(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, requestBody)) == null) ? new RequestBody(this, requestBody) { // from class: com.baidu.android.imsdk.upload.action.IMPushUploadManager.GzipRequestInterceptor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GzipRequestInterceptor this$1;
                public final /* synthetic */ RequestBody val$body;

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
                    this.this$1 = this;
                    this.val$body = requestBody;
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
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$body.contentType() : (MediaType) invokeV.objValue;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                        BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                        try {
                            this.val$body.writeTo(buffer);
                            buffer.close();
                        } catch (IOException e) {
                            Log.e(IMPushUploadConstants.TAG, "RequestBody gzip exception ", e);
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
                        return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), gzip(request.body())).build());
                    }
                    return chain.proceed(request);
                } catch (Exception e) {
                    throw new IOException(e.getMessage());
                }
            }
            return (Response) invokeL.objValue;
        }
    }

    public IMPushUploadManager(Context context) {
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
        this.mOkHttpClient = createOkHttpClient();
        this.mContext = context;
    }

    private RequestBody convertRequestBody(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, bArr, str)) == null) ? RequestBody.create(MediaType.parse("application/proto"), createLogRequestContent(bArr, str)) : (RequestBody) invokeLL.objValue;
    }

    private byte[] createLogRequestContent(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, bArr, str)) == null) {
            BIMLogPb.LogRequest.AuthInfo.Builder newBuilder = BIMLogPb.LogRequest.AuthInfo.newBuilder();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            BIMLogPb.LogRequest.AuthInfo build = newBuilder.setToken(str).build();
            long currentTimeMillis = System.currentTimeMillis();
            return BIMLogPb.LogRequest.newBuilder().setVersion(1L).setServiceName(IMPushUploadConstants.Service.BAIDU_APP).setAuthInfo(build).setRequestTimestampMs(currentTimeMillis).setSign(IMPushUploadConstants.sign(this.mContext, IMPushUploadConstants.Service.BAIDU_APP, currentTimeMillis)).setPayload(ByteString.copyFrom(bArr)).build().toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }

    private OkHttpClient createOkHttpClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).addInterceptor(new GzipRequestInterceptor(this)).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build() : (OkHttpClient) invokeV.objValue;
    }

    public static IMPushUploadManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (sInstance == null) {
                sInstance = new IMPushUploadManager(context);
            }
            return sInstance;
        }
        return (IMPushUploadManager) invokeL.objValue;
    }

    private Request getOkHttpRequest(byte[] bArr, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, bArr, str, str2)) == null) ? new Request.Builder().addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE).addHeader("Content-Type", "application/proto").addHeader(IMPushUploadConstants.BIM_LOG_ID, str2).url(IMPushUploadConstants.ONLINE_URL).post(convertRequestBody(bArr, str)).build() : (Request) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] parseResponse(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, bArr)) == null) {
            try {
                BIMLogPb.LogResponse parseFrom = BIMLogPb.LogResponse.parseFrom(bArr);
                if (this.mOkHttpClient.pingIntervalMillis() != parseFrom.getPingIntervalMs()) {
                    this.mOkHttpClient.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS);
                    this.mOkHttpClient = this.mOkHttpClient.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS).build();
                }
                Log.d(IMPushUploadConstants.TAG, "parseResponse errorCode :" + parseFrom.getErrorCode() + ", errorMsg ：" + parseFrom.getErrorMsg());
                return new String[]{String.valueOf(parseFrom.getErrorCode()), parseFrom.getErrorMsg()};
            } catch (InvalidProtocolBufferException e) {
                Log.e(IMPushUploadConstants.TAG, "parseResponse has exception ", e);
                return new String[]{String.valueOf(-1), "parseResponse exception"};
            }
        }
        return (String[]) invokeL.objValue;
    }

    public void requestUpload(Map<String, String> map, byte[] bArr, String str, IMPushUploadResponseListener iMPushUploadResponseListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, map, bArr, str, iMPushUploadResponseListener) == null) {
            String str2 = "" + ((int) ((Math.random() * 100000.0d) + 1000.0d));
            Request okHttpRequest = getOkHttpRequest(bArr, str, str2);
            if (this.mOkHttpClient == null) {
                this.mOkHttpClient = createOkHttpClient();
            }
            this.mOkHttpClient.newCall(okHttpRequest).enqueue(new Callback(this, iMPushUploadResponseListener, str2) { // from class: com.baidu.android.imsdk.upload.action.IMPushUploadManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IMPushUploadManager this$0;
                public final /* synthetic */ String val$logId;
                public final /* synthetic */ IMPushUploadResponseListener val$responseListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iMPushUploadResponseListener, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$responseListener = iMPushUploadResponseListener;
                    this.val$logId = str2;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                        String str3 = "Request error :" + iOException.toString();
                        if (iOException instanceof SocketException) {
                            str3 = "Request SocketException :" + iOException.toString();
                        }
                        IMPushUploadResponseListener iMPushUploadResponseListener2 = this.val$responseListener;
                        if (iMPushUploadResponseListener2 != null) {
                            iMPushUploadResponseListener2.uploadResponse(-1, str3);
                        }
                    }
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    IMPushUploadResponseListener iMPushUploadResponseListener2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                        String str3 = "ok";
                        int i = 0;
                        try {
                            try {
                                if (response.body() != null) {
                                    String[] parseResponse = this.this$0.parseResponse(response.body().bytes());
                                    i = Integer.valueOf(parseResponse[0]).intValue();
                                    str3 = parseResponse[1];
                                }
                                Log.d(IMPushUploadConstants.TAG, "onResponse response = " + i + " body = " + str3 + ", logId :" + this.val$logId);
                                iMPushUploadResponseListener2 = this.val$responseListener;
                                if (iMPushUploadResponseListener2 == null) {
                                    return;
                                }
                            } catch (IOException e) {
                                Log.e(IMPushUploadConstants.TAG, "onResponse exception ", e);
                                iMPushUploadResponseListener2 = this.val$responseListener;
                                if (iMPushUploadResponseListener2 == null) {
                                    return;
                                }
                            }
                            iMPushUploadResponseListener2.uploadResponse(i, str3);
                        } catch (Throwable th) {
                            IMPushUploadResponseListener iMPushUploadResponseListener3 = this.val$responseListener;
                            if (iMPushUploadResponseListener3 != null) {
                                iMPushUploadResponseListener3.uploadResponse(i, str3);
                            }
                            throw th;
                        }
                    }
                }
            });
        }
    }
}
