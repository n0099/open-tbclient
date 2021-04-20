package com.baidu.pano.platform.a;

import android.os.Handler;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class f implements r {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f8924a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    public final Executor f8925b = new g(this);

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final n f8927b;

        /* renamed from: c  reason: collision with root package name */
        public final q f8928c;

        /* renamed from: d  reason: collision with root package name */
        public final Runnable f8929d;

        public a(n nVar, q qVar, Runnable runnable) {
            this.f8927b = nVar;
            this.f8928c = qVar;
            this.f8929d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8927b.h()) {
                this.f8927b.b("canceled-at-delivery");
                return;
            }
            if (this.f8928c.a()) {
                this.f8927b.a((n) this.f8928c.f8966a);
            } else {
                this.f8927b.b(this.f8928c.f8968c);
            }
            if (this.f8928c.f8969d) {
                this.f8927b.a("intermediate-response");
            } else {
                this.f8927b.b(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
            Runnable runnable = this.f8929d;
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
        this.f8925b.execute(new a(nVar, qVar, runnable));
    }

    @Override // com.baidu.pano.platform.a.r
    public void a(n<?> nVar, v vVar) {
        nVar.a("post-error");
        this.f8925b.execute(new a(nVar, q.a(vVar), null));
    }
}
