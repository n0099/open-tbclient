package com.baidu.pano.platform.a;

import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
class g implements Executor {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.a.execute(runnable);
    }
}
