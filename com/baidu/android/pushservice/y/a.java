package com.baidu.android.pushservice.y;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.w.h;
import com.baidu.android.pushservice.y.e.f;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    public static a c;
    public Context a;
    public OkHttpClient b = a();

    /* renamed from: com.baidu.android.pushservice.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0042a implements Callback {
        public final /* synthetic */ ClientEventInfo a;

        public C0042a(ClientEventInfo clientEventInfo) {
            this.a = clientEventInfo;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            String str = "Request error :" + iOException.getMessage();
            Utility.a(a.this.a, this.a, false);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                if (response.body() != null) {
                    a.this.a(response.body().bytes(), this.a);
                } else {
                    Utility.a(a.this.a, this.a, false);
                }
            } catch (Exception unused) {
                Utility.a(a.this.a, this.a, false);
            }
        }
    }

    public a(Context context) {
        this.a = context;
    }

    public static a a(Context context) {
        if (c == null) {
            c = new a(context);
        }
        return c;
    }

    public final Headers a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        hashMap.put("Content-Type", "application/proto");
        String c2 = i.c(this.a, "com.baidu.android.pushservice.USER_ACCESS_TOKEN");
        if (z && !TextUtils.isEmpty(c2)) {
            hashMap.put("cookie", "BDUSS=" + c2);
        }
        return com.baidu.android.pushservice.q.a.a(hashMap);
    }

    public final OkHttpClient a() {
        return new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build();
    }

    public final Request a(byte[] bArr, String str, boolean z) {
        return new Request.Builder().url(str).post(a(bArr)).headers(a(z)).build();
    }

    public final RequestBody a(byte[] bArr) {
        return RequestBody.create(MediaType.parse("application/proto"), bArr);
    }

    public final void a(byte[] bArr, ClientEventInfo clientEventInfo) {
        try {
            f a = f.a(bArr);
            c.a(this.a, a.j());
            c.a(this.a, a.a());
            c.a(this.a, a.j().a());
            if (a.h() == h.MSG_ID_ASYNC_PULL_MSG.a() && a.k() == 3 && a.g().size() > 0) {
                new b(this.a).a(com.baidu.android.pushservice.y.e.i.a(a.g()));
            }
            if (a.n() && a.d().d() && a.d().c() == 1) {
                Utility.a(this.a, clientEventInfo, false);
            }
            if (clientEventInfo.getHasConfirmDialog() == -1 || c.g(this.a) != 3) {
                return;
            }
            Intent j = e.j(this.a);
            j.putExtra("push_start_source", clientEventInfo.getSource());
            this.a.sendBroadcast(j);
        } catch (Exception unused) {
            Utility.a(this.a, clientEventInfo, false);
        }
    }

    public void a(byte[] bArr, String str, ClientEventInfo clientEventInfo) {
        this.b.newCall(a(bArr, str, true)).enqueue(new C0042a(clientEventInfo));
    }

    public void a(byte[] bArr, String str, Callback callback) {
        this.b.newCall(a(bArr, str, false)).enqueue(callback);
    }
}
