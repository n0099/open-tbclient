package com.baidu.swan.games.network.a;

import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.a.a;
import com.baidu.swan.apps.network.e;
import com.baidu.swan.apps.network.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class d implements Interceptor {
    final e cwK = new e() { // from class: com.baidu.swan.games.network.a.d.1
        @Override // com.baidu.swan.apps.network.e
        public void a(long j, long j2, boolean z) {
            if (d.this.cxf == null) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("onProgress", "DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                d.this.cxf.b(0, j, j2);
            } else if (j2 > Config.RAVEN_LOG_LIMIT) {
                d.this.cxf.bi(j2);
                d.this.cxf = null;
            } else if (j2 <= 0 || j > j2 || j == 0) {
                d.this.cxf.l(j, j2);
                d.this.cxf = null;
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    d.this.cxf.b(floor, j, j2);
                }
            }
        }
    };
    private a.InterfaceC0368a cxf;

    public void a(a.InterfaceC0368a interfaceC0368a) {
        this.cxf = interfaceC0368a;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.cwK)).build();
    }
}
