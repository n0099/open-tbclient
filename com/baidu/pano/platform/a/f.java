package com.baidu.pano.platform.a;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class f implements r {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f9366a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    public final Executor f9367b = new g(this);

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final n f9369b;

        /* renamed from: c  reason: collision with root package name */
        public final q f9370c;

        /* renamed from: d  reason: collision with root package name */
        public final Runnable f9371d;

        public a(n nVar, q qVar, Runnable runnable) {
            this.f9369b = nVar;
            this.f9370c = qVar;
            this.f9371d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9369b.h()) {
                this.f9369b.b("canceled-at-delivery");
                return;
            }
            if (this.f9370c.a()) {
                this.f9369b.a((n) this.f9370c.f9408a);
            } else {
                this.f9369b.b(this.f9370c.f9410c);
            }
            if (this.f9370c.f9411d) {
                this.f9369b.a("intermediate-response");
            } else {
                this.f9369b.b(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f9371d;
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
        this.f9367b.execute(new a(nVar, qVar, runnable));
    }

    @Override // com.baidu.pano.platform.a.r
    public void a(n<?> nVar, v vVar) {
        nVar.a("post-error");
        this.f9367b.execute(new a(nVar, q.a(vVar), null));
    }
}
