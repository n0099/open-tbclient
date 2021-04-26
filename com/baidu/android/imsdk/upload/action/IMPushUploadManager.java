package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMPushUploadConstants;
import com.baidu.android.imsdk.upload.action.logpb.BIMLogPb;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
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
    public static final long PING_INTERVAL_MS = 1000;
    public static final int TIME_OUT_S = 30;
    public static IMPushUploadManager sInstance;
    public Context mContext;
    public OkHttpClient mOkHttpClient = createOkHttpClient();

    /* loaded from: classes.dex */
    public class GzipRequestInterceptor implements Interceptor {
        public GzipRequestInterceptor() {
        }

        private RequestBody gzip(final RequestBody requestBody) {
            return new RequestBody() { // from class: com.baidu.android.imsdk.upload.action.IMPushUploadManager.GzipRequestInterceptor.1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return requestBody.contentType();
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink bufferedSink) {
                    BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                    try {
                        requestBody.writeTo(buffer);
                        buffer.close();
                    } catch (IOException e2) {
                        Log.e(IMPushUploadConstants.TAG, "RequestBody gzip exception ", e2);
                    }
                }
            };
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            try {
                Request request = chain.request();
                if (request.body() != null && request.header("Content-Encoding") == null) {
                    return chain.proceed(request.newBuilder().header("Content-Encoding", AsyncHttpClient.ENCODING_GZIP).method(request.method(), gzip(request.body())).build());
                }
                return chain.proceed(request);
            } catch (Exception e2) {
                throw new IOException(e2.getMessage());
            }
        }
    }

    public IMPushUploadManager(Context context) {
        this.mContext = context;
    }

    private RequestBody convertRequestBody(byte[] bArr, String str) {
        return RequestBody.create(MediaType.parse("application/proto"), createLogRequestContent(bArr, str));
    }

    private byte[] createLogRequestContent(byte[] bArr, String str) {
        BIMLogPb.LogRequest.AuthInfo.Builder newBuilder = BIMLogPb.LogRequest.AuthInfo.newBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        BIMLogPb.LogRequest.AuthInfo build = newBuilder.setToken(str).build();
        long currentTimeMillis = System.currentTimeMillis();
        return BIMLogPb.LogRequest.newBuilder().setVersion(1L).setServiceName(IMPushUploadConstants.Service.BAIDU_APP).setAuthInfo(build).setRequestTimestampMs(currentTimeMillis).setSign(IMPushUploadConstants.sign(this.mContext, IMPushUploadConstants.Service.BAIDU_APP, currentTimeMillis)).setPayload(ByteString.copyFrom(bArr)).build().toByteArray();
    }

    private OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).addInterceptor(new GzipRequestInterceptor()).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build();
    }

    public static IMPushUploadManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new IMPushUploadManager(context);
        }
        return sInstance;
    }

    private Request getOkHttpRequest(byte[] bArr, String str, String str2) {
        return new Request.Builder().addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE).addHeader("Content-Type", "application/proto").addHeader(IMPushUploadConstants.BIM_LOG_ID, str2).url(IMPushUploadConstants.ONLINE_URL).post(convertRequestBody(bArr, str)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] parseResponse(byte[] bArr) {
        try {
            BIMLogPb.LogResponse parseFrom = BIMLogPb.LogResponse.parseFrom(bArr);
            if (this.mOkHttpClient.pingIntervalMillis() != parseFrom.getPingIntervalMs()) {
                this.mOkHttpClient.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS);
                this.mOkHttpClient = this.mOkHttpClient.newBuilder().pingInterval(parseFrom.getPingIntervalMs(), TimeUnit.MILLISECONDS).build();
            }
            Log.d(IMPushUploadConstants.TAG, "parseResponse errorCode :" + parseFrom.getErrorCode() + ", errorMsg ：" + parseFrom.getErrorMsg());
            return new String[]{String.valueOf(parseFrom.getErrorCode()), parseFrom.getErrorMsg()};
        } catch (InvalidProtocolBufferException e2) {
            Log.e(IMPushUploadConstants.TAG, "parseResponse has exception ", e2);
            return new String[]{String.valueOf(-1), "parseResponse exception"};
        }
    }

    public void requestUpload(Map<String, String> map, byte[] bArr, String str, final IMPushUploadResponseListener iMPushUploadResponseListener) {
        final String str2 = "" + ((int) ((Math.random() * 100000.0d) + 1000.0d));
        Request okHttpRequest = getOkHttpRequest(bArr, str, str2);
        if (this.mOkHttpClient == null) {
            this.mOkHttpClient = createOkHttpClient();
        }
        this.mOkHttpClient.newCall(okHttpRequest).enqueue(new Callback() { // from class: com.baidu.android.imsdk.upload.action.IMPushUploadManager.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                String str3 = "Request error :" + iOException.toString();
                if (iOException instanceof SocketException) {
                    str3 = "Request SocketException :" + iOException.toString();
                }
                IMPushUploadResponseListener iMPushUploadResponseListener2 = iMPushUploadResponseListener;
                if (iMPushUploadResponseListener2 != null) {
                    iMPushUploadResponseListener2.uploadResponse(-1, str3);
                }
            }

            /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                IMPushUploadResponseListener iMPushUploadResponseListener2;
                String str3 = "ok";
                int i2 = 0;
                try {
                    try {
                        if (response.body() != null) {
                            String[] parseResponse = IMPushUploadManager.this.parseResponse(response.body().bytes());
                            i2 = Integer.valueOf(parseResponse[0]).intValue();
                            str3 = parseResponse[1];
                        }
                        Log.d(IMPushUploadConstants.TAG, "onResponse response = " + i2 + " body = " + str3 + ", logId :" + str2);
                        iMPushUploadResponseListener2 = iMPushUploadResponseListener;
                        if (iMPushUploadResponseListener2 == null) {
                            return;
                        }
                    } catch (IOException e2) {
                        Log.e(IMPushUploadConstants.TAG, "onResponse exception ", e2);
                        iMPushUploadResponseListener2 = iMPushUploadResponseListener;
                        if (iMPushUploadResponseListener2 == null) {
                            return;
                        }
                    }
                    iMPushUploadResponseListener2.uploadResponse(i2, str3);
                } catch (Throwable th) {
                    IMPushUploadResponseListener iMPushUploadResponseListener3 = iMPushUploadResponseListener;
                    if (iMPushUploadResponseListener3 != null) {
                        iMPushUploadResponseListener3.uploadResponse(i2, str3);
                    }
                    throw th;
                }
            }
        });
    }
}
