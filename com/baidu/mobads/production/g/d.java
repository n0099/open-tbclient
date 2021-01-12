package com.baidu.mobads.production.g;
/* loaded from: classes14.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3450a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f3450a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        a aVar = this.f3450a.f3449a;
        StringBuilder sb = new StringBuilder();
        str = this.f3450a.f3449a.A;
        StringBuilder append = sb.append(str);
        str2 = this.f3450a.f3449a.B;
        aVar.f(append.append(str2).toString());
    }
}
