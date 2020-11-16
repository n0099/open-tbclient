package com.baidu.android.pushservice.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.upload.action.IMPushUploadConstants;
import com.baidu.android.pushservice.h.b.a.a;
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
/* loaded from: classes7.dex */
public class b {
    private static b b;

    /* renamed from: a  reason: collision with root package name */
    private OkHttpClient f1138a = a();
    private Context c;

    /* loaded from: classes7.dex */
    public class a implements Interceptor {
        public a() {
        }

        private RequestBody a(final RequestBody requestBody) {
            return new RequestBody() { // from class: com.baidu.android.pushservice.h.b.a.1
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
                    } catch (IOException e) {
                    }
                }
            };
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            try {
                Request request = chain.request();
                return (request.body() == null || request.header("Content-Encoding") != null) ? chain.proceed(request) : chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), a(request.body())).build());
            } catch (Exception e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    private b(Context context) {
        this.c = context;
    }

    public static b a(Context context) {
        if (b == null) {
            b = new b(context);
        }
        return b;
    }

    private OkHttpClient a() {
        return new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).addInterceptor(new a()).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build();
    }

    private Request a(byte[] bArr, String str, String str2) {
        return new Request.Builder().addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE).addHeader("Content-Type", "application/proto").addHeader(IMPushUploadConstants.BIM_LOG_ID, str2).url(IMPushUploadConstants.ONLINE_URL).post(a(bArr, str)).build();
    }

    private RequestBody a(byte[] bArr, String str) {
        return RequestBody.create(MediaType.parse("application/proto"), b(bArr, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] a(byte[] bArr) {
        try {
            a.c a2 = a.c.a(bArr);
            if (this.f1138a.pingIntervalMillis() != a2.i()) {
                this.f1138a.newBuilder().pingInterval(a2.i(), TimeUnit.MILLISECONDS);
                this.f1138a = this.f1138a.newBuilder().pingInterval(a2.i(), TimeUnit.MILLISECONDS).build();
            }
            return new String[]{String.valueOf(a2.d()), a2.f()};
        } catch (InvalidProtocolBufferException e) {
            return new String[]{String.valueOf(-1), "parseResponse exception"};
        }
    }

    private byte[] b(byte[] bArr, String str) {
        a.C0065a.C0066a.C0067a e = a.C0065a.C0066a.e();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        a.C0065a.C0066a build = e.a(str).build();
        long currentTimeMillis = System.currentTimeMillis();
        return a.C0065a.o().a(1L).a(IMPushUploadConstants.Service.BAIDU_APP).a(build).b(currentTimeMillis).b(com.baidu.android.pushservice.h.a.a(this.c, IMPushUploadConstants.Service.BAIDU_APP, currentTimeMillis)).a(ByteString.copyFrom(bArr)).build().toByteArray();
    }

    public void a(Map<String, String> map, byte[] bArr, String str, final c cVar) {
        Request a2 = a(bArr, str, "" + ((int) ((Math.random() * 100000.0d) + 1000.0d)));
        if (this.f1138a == null) {
            this.f1138a = a();
        }
        this.f1138a.newCall(a2).enqueue(new Callback() { // from class: com.baidu.android.pushservice.h.b.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                String str2 = "Request error :" + iOException.toString();
                if (iOException instanceof SocketException) {
                    str2 = "Request SocketException :" + iOException.toString();
                }
                cVar.a(-1, str2);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                int i = 0;
                String str2 = "ok";
                try {
                    if (response.body() != null) {
                        String[] a3 = b.this.a(response.body().bytes());
                        i = Integer.valueOf(a3[0]).intValue();
                        str2 = a3[1];
                    }
                    cVar.a(i, str2);
                } catch (IOException e) {
                    cVar.a(i, "ok");
                } catch (Throwable th) {
                    cVar.a(i, "ok");
                    throw th;
                }
            }
        });
    }
}
