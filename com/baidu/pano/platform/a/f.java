package com.baidu.pano.platform.a;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class f implements r {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f9252a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    public final Executor f9253b = new g(this);

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final n f9255b;

        /* renamed from: c  reason: collision with root package name */
        public final q f9256c;

        /* renamed from: d  reason: collision with root package name */
        public final Runnable f9257d;

        public a(n nVar, q qVar, Runnable runnable) {
            this.f9255b = nVar;
            this.f9256c = qVar;
            this.f9257d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9255b.h()) {
                this.f9255b.b("canceled-at-delivery");
                return;
            }
            if (this.f9256c.a()) {
                this.f9255b.a((n) this.f9256c.f9296a);
            } else {
                this.f9255b.b(this.f9256c.f9298c);
            }
            if (this.f9256c.f9299d) {
                this.f9255b.a("intermediate-response");
            } else {
                this.f9255b.b(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f9257d;
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
        this.f9253b.execute(new a(nVar, qVar, runnable));
    }

    @Override // com.baidu.pano.platform.a.r
    public void a(n<?> nVar, v vVar) {
        nVar.a("post-error");
        this.f9253b.execute(new a(nVar, q.a(vVar), null));
    }
}
