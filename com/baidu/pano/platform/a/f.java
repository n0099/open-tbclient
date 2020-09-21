package com.baidu.pano.platform.a;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class f implements r {
    ExecutorService a = Executors.newSingleThreadExecutor();
    private final Executor b = new g(this);

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
        this.b.execute(new a(nVar, qVar, runnable));
    }

    @Override // com.baidu.pano.platform.a.r
    public void a(n<?> nVar, v vVar) {
        nVar.a("post-error");
        this.b.execute(new a(nVar, q.a(vVar), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private final n b;
        private final q c;
        private final Runnable d;

        public a(n nVar, q qVar, Runnable runnable) {
            this.b = nVar;
            this.c = qVar;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.h()) {
                this.b.b("canceled-at-delivery");
                return;
            }
            if (this.c.a()) {
                this.b.a((n) this.c.a);
            } else {
                this.b.b(this.c.c);
            }
            if (this.c.d) {
                this.b.a("intermediate-response");
            } else {
                this.b.b(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
    }
}
