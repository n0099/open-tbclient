package com.baidu.android.nebula.d;

import com.baidu.android.nebula.c.e;
import com.baidu.android.nebula.cmd.g;
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
        com.baidu.android.nebula.a.d a2 = bVar.a();
        if (a2 == null) {
            bVar.a(aVar);
            return;
        }
        String a3 = a2.a("URI");
        if (a3 == null) {
            bVar.a(aVar);
            return;
        }
        int indexOf = a3.indexOf("?");
        String substring = indexOf == -1 ? a3.substring(0, a3.length()) : a3.substring(1, indexOf);
        aVar.a("text/plain");
        new g().a(substring, a2, aVar);
        if (aVar != null) {
            bVar.a(aVar);
        }
    }
}
