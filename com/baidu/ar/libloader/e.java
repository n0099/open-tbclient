package com.baidu.ar.libloader;

import com.baidu.ar.libloader.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class e {
    private final Map<String, List<a.c>> sB = new HashMap();

    private void g(List<a.c> list) {
        if (list != null) {
            a.c[] cVarArr = new a.c[list.size()];
            list.toArray(cVarArr);
            for (a.c cVar : cVarArr) {
                cVar.onReady();
            }
        }
    }

    public void b(String str, a.c cVar) {
        List<a.c> list = this.sB.get(str);
        if (list != null) {
            list.add(cVar);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        this.sB.put(str, arrayList);
    }

    public void clearAll() {
        this.sB.clear();
    }

    public void fj() {
        for (Map.Entry<String, List<a.c>> entry : this.sB.entrySet()) {
            g(entry.getValue());
        }
    }
}
