package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes6.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f1939a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a.b f1940b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.b bVar, Runnable runnable) {
        this.f1940b = bVar;
        this.f1939a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1939a.run();
        } finally {
            this.f1940b.a();
        }
    }
}
