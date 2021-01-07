package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes6.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f1940a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a.b f1941b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.b bVar, Runnable runnable) {
        this.f1941b = bVar;
        this.f1940a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1940a.run();
        } finally {
            this.f1941b.a();
        }
    }
}
