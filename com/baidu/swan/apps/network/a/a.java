package com.baidu.swan.apps.network.a;

import com.baidu.mobstat.Config;
import com.baidu.swan.apps.network.e;
import com.baidu.swan.apps.network.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes10.dex */
public class a implements Interceptor {
    private InterfaceC0456a dhA;
    final e dhB = new e() { // from class: com.baidu.swan.apps.network.a.a.1
        @Override // com.baidu.swan.apps.network.e
        public void b(long j, long j2, boolean z) {
            if (a.this.dhA == null) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                a.this.dhA.c(0, j, j2);
            } else if (j2 > Config.RAVEN_LOG_LIMIT) {
                a.this.dhA.bU(j2);
            } else if (j2 <= 0 || j > j2 || j == 0) {
                a.this.dhA.i(j, j2);
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor <= 100) {
                    a.this.dhA.c(floor, j, j2);
                }
            }
        }
    };

    /* renamed from: com.baidu.swan.apps.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0456a {
        void bU(long j);

        void c(int i, long j, long j2);

        void i(long j, long j2);
    }

    public void a(InterfaceC0456a interfaceC0456a) {
        this.dhA = interfaceC0456a;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.dhB)).build();
    }
}
