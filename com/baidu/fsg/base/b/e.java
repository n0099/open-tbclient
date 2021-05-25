package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes2.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f5097a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.b f5098b;

    public e(a.b bVar, Runnable runnable) {
        this.f5098b = bVar;
        this.f5097a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f5097a.run();
        } finally {
            this.f5098b.a();
        }
    }
}
