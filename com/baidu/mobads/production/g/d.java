package com.baidu.mobads.production.g;
/* loaded from: classes7.dex */
class d implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        a aVar = this.a.a;
        StringBuilder sb = new StringBuilder();
        str = this.a.a.A;
        StringBuilder append = sb.append(str);
        str2 = this.a.a.B;
        aVar.f(append.append(str2).toString());
    }
}
