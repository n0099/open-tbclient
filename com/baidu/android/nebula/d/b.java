package com.baidu.android.nebula.d;

import com.baidu.android.nebula.c.e;
import com.baidu.android.nebula.cmd.h;
import com.baidu.browser.explorer.BdWebErrorView;
/* loaded from: classes.dex */
public class b implements e {
    @Override // com.baidu.android.nebula.c.e
    public void a(com.baidu.android.nebula.c.d dVar) {
        dVar.a(0L);
    }

    @Override // com.baidu.android.nebula.c.e
    public void a(com.baidu.android.nebula.c.d dVar, Exception exc) {
        com.baidu.android.nebula.a.a aVar = new com.baidu.android.nebula.a.a();
        aVar.a(BdWebErrorView.ERROR_CODE_500);
        ((com.baidu.android.nebula.a.b) dVar).a(aVar);
    }

    @Override // com.baidu.android.nebula.c.e
    public void b(com.baidu.android.nebula.c.d dVar) {
        com.baidu.android.nebula.a.b bVar = (com.baidu.android.nebula.a.b) dVar;
        com.baidu.android.nebula.a.a aVar = new com.baidu.android.nebula.a.a();
        com.baidu.android.nebula.a.d a = bVar.a();
        if (a == null) {
            bVar.a(aVar);
            return;
        }
        String a2 = a.a("URI");
        if (a2 == null) {
            bVar.a(aVar);
            return;
        }
        int indexOf = a2.indexOf("?");
        String substring = indexOf == -1 ? a2.substring(0, a2.length()) : a2.substring(1, indexOf);
        aVar.a("text/plain");
        new h().a(substring, a, aVar);
        if (aVar != null) {
            bVar.a(aVar);
        }
    }
}
