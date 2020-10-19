package com.baidu.pano.platform.a;

import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
class g implements Executor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f2652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f2652a = fVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f2652a.f2650a.execute(runnable);
    }
}
