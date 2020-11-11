package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes16.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f1461a;
    final /* synthetic */ a.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.b bVar, Runnable runnable) {
        this.b = bVar;
        this.f1461a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1461a.run();
        } finally {
            this.b.a();
        }
    }
}
