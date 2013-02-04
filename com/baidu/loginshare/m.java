package com.baidu.loginshare;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.share.a {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.share.a
    public void onShareEvent(com.baidu.share.c cVar) {
        String str = cVar.a;
        if (e.a(str)) {
            if (h.c().equals(str)) {
                this.a.a(cVar);
            } else if (h.d().equals(str)) {
                this.a.b(cVar);
            } else if (h.a().equals(str)) {
                this.a.c(cVar);
            } else if (h.b().equals(str)) {
                this.a.d(cVar);
            }
        }
    }
}
