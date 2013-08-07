package com.baidu.android.nebula.c;

import com.baidu.browser.explorer.BdWebErrorView;
/* loaded from: classes.dex */
public class d implements com.baidu.android.nebula.d.a {
    @Override // com.baidu.android.nebula.d.a
    public void a(com.baidu.android.nebula.d.c cVar) {
        cVar.a(0L);
    }

    @Override // com.baidu.android.nebula.d.a
    public void a(com.baidu.android.nebula.d.c cVar, Exception exc) {
        com.baidu.android.nebula.b.b bVar = new com.baidu.android.nebula.b.b();
        bVar.a(BdWebErrorView.ERROR_CODE_500);
        ((com.baidu.android.nebula.b.c) cVar).a(bVar);
    }

    @Override // com.baidu.android.nebula.d.a
    public void b(com.baidu.android.nebula.d.c cVar) {
        com.baidu.android.nebula.b.c cVar2 = (com.baidu.android.nebula.b.c) cVar;
        com.baidu.android.nebula.b.b bVar = new com.baidu.android.nebula.b.b();
        com.baidu.android.nebula.b.a a2 = cVar2.a();
        if (a2 == null) {
            cVar2.a(bVar);
            return;
        }
        String a3 = a2.a("URI");
        if (a3 == null) {
            cVar2.a(bVar);
            return;
        }
        int indexOf = a3.indexOf("?");
        String substring = indexOf == -1 ? a3.substring(0, a3.length()) : a3.substring(1, indexOf);
        bVar.a("text/plain");
        new com.baidu.android.nebula.cmd.a().a(substring, a2, bVar);
        if (bVar != null) {
            cVar2.a(bVar);
        }
    }
}
