package com.baidu.pano.platform.a;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class f implements r {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f9365a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    public final Executor f9366b = new g(this);

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final n f9368b;

        /* renamed from: c  reason: collision with root package name */
        public final q f9369c;

        /* renamed from: d  reason: collision with root package name */
        public final Runnable f9370d;

        public a(n nVar, q qVar, Runnable runnable) {
            this.f9368b = nVar;
            this.f9369c = qVar;
            this.f9370d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9368b.h()) {
                this.f9368b.b("canceled-at-delivery");
                return;
            }
            if (this.f9369c.a()) {
                this.f9368b.a((n) this.f9369c.f9407a);
            } else {
                this.f9368b.b(this.f9369c.f9409c);
            }
            if (this.f9369c.f9410d) {
                this.f9368b.a("intermediate-response");
            } else {
                this.f9368b.b(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f9370d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

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
        this.f9366b.execute(new a(nVar, qVar, runnable));
    }

    @Override // com.baidu.pano.platform.a.r
    public void a(n<?> nVar, v vVar) {
        nVar.a("post-error");
        this.f9366b.execute(new a(nVar, q.a(vVar), null));
    }
}
