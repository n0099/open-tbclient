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
    private a.InterfaceC0454a dfT;
    final e dfx = new e() { // from class: com.baidu.swan.games.network.a.d.1
        @Override // com.baidu.swan.apps.network.e
        public void b(long j, long j2, boolean z) {
            if (d.this.dfT == null) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.e("onProgress", "DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                d.this.dfT.c(0, j, j2);
            } else if (j2 > Config.RAVEN_LOG_LIMIT) {
                d.this.dfT.bU(j2);
                d.this.dfT = null;
            } else if (j2 <= 0 || j > j2 || j == 0) {
                d.this.dfT.i(j, j2);
                d.this.dfT = null;
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    d.this.dfT.c(floor, j, j2);
                }
            }
        }
    };

    public void a(a.InterfaceC0454a interfaceC0454a) {
        this.dfT = interfaceC0454a;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.dfx)).build();
    }
}
