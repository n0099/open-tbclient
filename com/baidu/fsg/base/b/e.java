package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f5177a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.b f5178b;

    public e(a.b bVar, Runnable runnable) {
        this.f5178b = bVar;
        this.f5177a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f5177a.run();
        } finally {
            this.f5178b.a();
        }
    }
}
