package com.baidu.pano.platform.a;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes15.dex */
public class f implements r {

    /* renamed from: a  reason: collision with root package name */
    ExecutorService f3909a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    private final Executor f3910b = new g(this);

    public f(Handler handler) {
    }

    @Override // com.baidu.pano.platform.a.r
    public void a(n<?> nVar, q<?> qVar) {
        a(nVar, qVar, null);
    }

    @Override // com.baidu.pano.platform.a.r
    public void a(n<?> nVar, q<?> qVar, Runnable runnable) {
        nVar.v();
        nVar.a("post-response");
        this.f3910b.execute(new a(nVar, qVar, runnable));
    }

    @Override // com.baidu.pano.platform.a.r
    public void a(n<?> nVar, v vVar) {
        nVar.a("post-error");
        this.f3910b.execute(new a(nVar, q.a(vVar), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final n f3912b;
        private final q c;
        private final Runnable d;

        public a(n nVar, q qVar, Runnable runnable) {
            this.f3912b = nVar;
            this.c = qVar;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3912b.h()) {
                this.f3912b.b("canceled-at-delivery");
                return;
            }
            if (this.c.a()) {
                this.f3912b.a((n) this.c.f3927a);
            } else {
                this.f3912b.b(this.c.c);
            }
            if (this.c.d) {
                this.f3912b.a("intermediate-response");
            } else {
                this.f3912b.b(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
    }
}
