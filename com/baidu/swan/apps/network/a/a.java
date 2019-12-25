package com.baidu.swan.apps.network.a;

import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.e;
import com.baidu.swan.apps.network.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes9.dex */
public class a implements Interceptor {
    private InterfaceC0255a bBM;
    final e bBN = new e() { // from class: com.baidu.swan.apps.network.a.a.1
        @Override // com.baidu.swan.apps.network.e
        public void a(long j, long j2, boolean z) {
            if (a.this.bBM == null) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                a.this.bBM.b(0, j, j2);
            } else {
                long j3 = 10485760;
                com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
                if (ZS != null && ZS.aaj()) {
                    j3 = Config.RAVEN_LOG_LIMIT;
                }
                if (j2 > j3) {
                    a.this.bBM.al(j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    a.this.bBM.j(j, j2);
                } else {
                    int floor = (int) Math.floor((100 * j) / j2);
                    if (floor <= 100) {
                        a.this.bBM.b(floor, j, j2);
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.swan.apps.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0255a {
        void al(long j);

        void b(int i, long j, long j2);

        void j(long j, long j2);
    }

    public void a(InterfaceC0255a interfaceC0255a) {
        this.bBM = interfaceC0255a;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.bBN)).build();
    }
}
