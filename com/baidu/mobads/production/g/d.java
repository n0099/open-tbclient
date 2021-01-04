package com.baidu.mobads.production.g;
/* loaded from: classes3.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3487a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f3487a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        a aVar = this.f3487a.f3486a;
        StringBuilder sb = new StringBuilder();
        str = this.f3487a.f3486a.A;
        StringBuilder append = sb.append(str);
        str2 = this.f3487a.f3486a.B;
        aVar.f(append.append(str2).toString());
    }
}
