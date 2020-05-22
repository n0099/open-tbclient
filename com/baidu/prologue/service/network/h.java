package com.baidu.prologue.service.network;

import android.content.Context;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.protocol.HTTP;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class h implements e {
    private OkHttpClient bBB;
    private final OkHttpClient bBC;
    private final OkHttpClient bBD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        f fVar = f.bzx.get();
        if (fVar != null) {
            builder.cookieJar(fVar.cookieJar());
        }
        builder.sslSocketFactory(k.getSSLSocketFactory());
        builder.hostnameVerifier(k.getHostnameVerifier());
        this.bBD = builder.build();
        builder.readTimeout(d.READ_TIME_OUT, TimeUnit.MILLISECONDS);
        builder.writeTimeout(d.bBA, TimeUnit.MILLISECONDS);
        builder.connectTimeout(d.CONNECT_TIME_OUT, TimeUnit.MILLISECONDS);
        this.bBC = builder.build();
    }

    @Override // com.baidu.prologue.service.network.e
    public void a(Request request, l lVar) {
        try {
            cX(request.bBK);
            a(a(request), lVar);
        } catch (IllegalArgumentException e) {
            if (com.baidu.prologue.a.a.a.GLOBAL_DEBUG) {
                throw e;
            }
            lVar.o(e);
        }
    }

    private void cX(boolean z) {
        if (z) {
            this.bBB = this.bBC;
        } else {
            this.bBB = this.bBD;
        }
    }

    private okhttp3.Request a(Request request) {
        Request.Builder builder = new Request.Builder();
        builder.url(request.url);
        builder.header("Content-type", "application/x-www-form-urlencoded");
        builder.header("Charset", "UTF-8");
        builder.header(HTTP.CONN_DIRECTIVE, "close");
        builder.header(UbcStatConstant.ContentType.UBC_TYPE_PK_ACCPET, "*/*");
        if (request.headers != null) {
            for (Map.Entry<String, String> entry : request.headers.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
        if (!Arrays.asList("GET", "POST").contains(request.method)) {
            throw new IllegalArgumentException("Invalid request method " + request.method);
        }
        if ("POST".equals(request.method) && request.bBG != null) {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry2 : request.bBG.entrySet()) {
                String value = entry2.getValue();
                if (value == null) {
                    value = "";
                }
                builder2.add(entry2.getKey(), value);
            }
            builder.post(builder2.build());
        }
        return builder.build();
    }

    private void a(okhttp3.Request request, final l lVar) {
        try {
            this.bBB.newCall(request).enqueue(new Callback() { // from class: com.baidu.prologue.service.network.h.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    lVar.o(iOException);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    ResponseBody body = response.body();
                    lVar.a(body.contentLength(), body.byteStream());
                }
            });
        } catch (OutOfMemoryError e) {
            lVar.o(e);
        }
    }
}
