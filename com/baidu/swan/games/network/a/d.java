package com.baidu.swan.games.network.a;

import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.a.a;
import com.baidu.swan.apps.network.e;
import com.baidu.swan.apps.network.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes8.dex */
public class d implements Interceptor {
    private a.InterfaceC0444a dqQ;
    final e dqu = new e() { // from class: com.baidu.swan.games.network.a.d.1
        @Override // com.baidu.swan.apps.network.e
        public void c(long j, long j2, boolean z) {
            if (d.this.dqQ == null) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("onProgress", "DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                d.this.dqQ.d(0, j, j2);
            } else if (j2 > Config.RAVEN_LOG_LIMIT) {
                d.this.dqQ.cA(j2);
                d.this.dqQ = null;
            } else if (j2 <= 0 || j > j2 || j == 0) {
                d.this.dqQ.p(j, j2);
                d.this.dqQ = null;
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    d.this.dqQ.d(floor, j, j2);
                }
            }
        }
    };

    public void a(a.InterfaceC0444a interfaceC0444a) {
        this.dqQ = interfaceC0444a;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.dqu)).build();
    }
}
