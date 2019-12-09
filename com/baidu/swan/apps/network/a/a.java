package com.baidu.swan.apps.network.a;

import com.baidu.swan.apps.network.e;
import com.baidu.swan.apps.network.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class a implements Interceptor {
    private InterfaceC0189a aYL;
    final e aYM = new e() { // from class: com.baidu.swan.apps.network.a.a.1
        @Override // com.baidu.swan.apps.network.e
        public void a(long j, long j2, boolean z) {
            if (a.this.aYL == null) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                a.this.aYL.b(0, j, j2);
            } else {
                long j3 = 10485760;
                com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
                if (Ra != null && Ra.Rn()) {
                    j3 = 26214400;
                }
                if (j2 > j3) {
                    a.this.aYL.ac(j2);
                } else if (j2 <= 0 || j > j2 || j == 0) {
                    a.this.aYL.k(j, j2);
                } else {
                    int floor = (int) Math.floor((100 * j) / j2);
                    if (floor <= 100) {
                        a.this.aYL.b(floor, j, j2);
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.swan.apps.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0189a {
        void ac(long j);

        void b(int i, long j, long j2);

        void k(long j, long j2);
    }

    public void a(InterfaceC0189a interfaceC0189a) {
        this.aYL = interfaceC0189a;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.aYM)).build();
    }
}
