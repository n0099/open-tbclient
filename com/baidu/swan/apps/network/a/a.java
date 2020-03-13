package com.baidu.swan.apps.network.a;

import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.e;
import com.baidu.swan.apps.network.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes11.dex */
public class a implements Interceptor {
    private InterfaceC0267a bGG;
    final e bGH = new e() { // from class: com.baidu.swan.apps.network.a.a.1
        @Override // com.baidu.swan.apps.network.e
        public void a(long j, long j2, boolean z) {
            if (a.this.bGG == null) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                a.this.bGG.b(0, j, j2);
            } else {
                long j3 = 10485760;
                com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
                if (acF != null && acF.acW()) {
                    j3 = Config.RAVEN_LOG_LIMIT;
                }
                if (j2 > j3) {
                    a.this.bGG.as(j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    a.this.bGG.j(j, j2);
                } else {
                    int floor = (int) Math.floor((100 * j) / j2);
                    if (floor <= 100) {
                        a.this.bGG.b(floor, j, j2);
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.swan.apps.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0267a {
        void as(long j);

        void b(int i, long j, long j2);

        void j(long j, long j2);
    }

    public void a(InterfaceC0267a interfaceC0267a) {
        this.bGG = interfaceC0267a;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.bGH)).build();
    }
}
