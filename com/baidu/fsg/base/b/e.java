package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes5.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f1890a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a.b f1891b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.b bVar, Runnable runnable) {
        this.f1891b = bVar;
        this.f1890a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1890a.run();
        } finally {
            this.f1891b.a();
        }
    }
}
