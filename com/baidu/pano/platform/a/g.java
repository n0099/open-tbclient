package com.baidu.pano.platform.a;

import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class g implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f8930a;

    public g(f fVar) {
        this.f8930a = fVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f8930a.f8924a.execute(runnable);
    }
}
