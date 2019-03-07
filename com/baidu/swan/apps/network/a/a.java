package com.baidu.swan.apps.network.a;

import com.baidu.swan.apps.network.e;
import com.baidu.swan.apps.network.h;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class a implements Interceptor {
    private InterfaceC0117a aCR;
    final e aCS = new e() { // from class: com.baidu.swan.apps.network.a.a.1
        @Override // com.baidu.swan.apps.network.e
        public void a(long j, long j2, boolean z) {
            if (a.this.aCR == null) {
                if (com.baidu.swan.apps.c.DEBUG) {
                    throw new RuntimeException("DownloadProgressInterceptor.mIProgressCallback == null");
                }
            } else if (j2 == -1 && j != 0) {
                a.this.aCR.b(0, j, j2);
            } else if (j2 > 10485760) {
                a.this.aCR.y(j2);
            } else if (j2 <= 0 || j > j2 || j == 0) {
                a.this.aCR.e(j, j2);
            } else {
                int floor = (int) Math.floor((100 * j) / j2);
                if (floor != 100) {
                    a.this.aCR.b(floor, j, j2);
                }
            }
        }
    };

    /* renamed from: com.baidu.swan.apps.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0117a {
        void b(int i, long j, long j2);

        void e(long j, long j2);

        void y(long j);
    }

    public void a(InterfaceC0117a interfaceC0117a) {
        this.aCR = interfaceC0117a;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new h(proceed.body(), this.aCS)).build();
    }
}
