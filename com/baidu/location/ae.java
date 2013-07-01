package com.baidu.location;
/* loaded from: classes.dex */
class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f457a;

    private ae(f fVar) {
        this.f457a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (f.a(this.f457a)) {
            f.a(this.f457a, false);
            f.b(this.f457a);
        }
    }
}
