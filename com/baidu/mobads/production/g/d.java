package com.baidu.mobads.production.g;
/* loaded from: classes7.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2412a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f2412a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        a aVar = this.f2412a.f2411a;
        StringBuilder sb = new StringBuilder();
        str = this.f2412a.f2411a.A;
        StringBuilder append = sb.append(str);
        str2 = this.f2412a.f2411a.B;
        aVar.f(append.append(str2).toString());
    }
}
