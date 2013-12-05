package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f583a = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f583a.f582a != null) {
            y.a(this.f583a.f582a);
        }
    }
}
