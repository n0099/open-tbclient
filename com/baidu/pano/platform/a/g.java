package com.baidu.pano.platform.a;

import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
class g implements Executor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f2705a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f2705a = fVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f2705a.f2703a.execute(runnable);
    }
}
