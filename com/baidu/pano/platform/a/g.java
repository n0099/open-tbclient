package com.baidu.pano.platform.a;

import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class g implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f9371a;

    public g(f fVar) {
        this.f9371a = fVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f9371a.f9365a.execute(runnable);
    }
}
