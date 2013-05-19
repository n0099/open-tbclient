package com.baidu.location;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ f a;

    private ae(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (f.a(this.a)) {
            f.a(this.a, false);
            f.b(this.a);
        }
    }
}
