package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes5.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f1888a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a.b f1889b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.b bVar, Runnable runnable) {
        this.f1889b = bVar;
        this.f1888a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1888a.run();
        } finally {
            this.f1889b.a();
        }
    }
}
