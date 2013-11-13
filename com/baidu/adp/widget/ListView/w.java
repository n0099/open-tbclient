package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f579a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f579a = vVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f579a.f578a != null) {
            x.a(this.f579a.f578a);
        }
    }
}
