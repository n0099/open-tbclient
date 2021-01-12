package com.baidu.pano.platform.a;

import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
class g implements Executor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f3876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f3876a = fVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f3876a.f3872a.execute(runnable);
    }
}
