package com.baidu.pano.platform.a;

import java.util.concurrent.Executor;
/* loaded from: classes15.dex */
class g implements Executor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f3913a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f3913a = fVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f3913a.f3909a.execute(runnable);
    }
}
