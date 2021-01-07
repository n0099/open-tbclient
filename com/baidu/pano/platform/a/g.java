package com.baidu.pano.platform.a;

import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
class g implements Executor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f3914a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f3914a = fVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f3914a.f3910a.execute(runnable);
    }
}
