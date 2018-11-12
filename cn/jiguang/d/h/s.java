package cn.jiguang.d.h;

import java.util.concurrent.ExecutorService;
/* loaded from: classes3.dex */
abstract class s {
    private ExecutorService a;

    abstract ExecutorService a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ExecutorService x(boolean z) {
        if (this.a == null || this.a.isShutdown()) {
            this.a = a();
        }
        return this.a;
    }
}
