package com.baidu.swan.games.network.a;

import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.a.a;
import com.baidu.swan.apps.network.e;
import com.baidu.swan.apps.network.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes9.dex */
public class d implements Interceptor {
    final e doS = new e() { // from class: com.baidu.swan.games.network.a.d.1
        @Override // com.baidu.swan.apps.network.e
        public void c(long j, long j2, boolean z) {
            if (d.this.dpp == null) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("onProgress", "DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                d.this.dpp.d(0, j, j2);
            } else if (j2 > Config.RAVEN_LOG_LIMIT) {
                d.this.dpp.cA(j2);
                d.this.dpp = null;
            } else if (j2 <= 0 || j > j2 || j == 0) {
                d.this.dpp.p(j, j2);
                d.this.dpp = null;
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    d.this.dpp.d(floor, j, j2);
                }
            }
        }
    };
    private a.InterfaceC0438a dpp;

    public void a(a.InterfaceC0438a interfaceC0438a) {
        this.dpp = interfaceC0438a;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.doS)).build();
    }
}
