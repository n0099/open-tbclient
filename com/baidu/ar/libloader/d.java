package com.baidu.ar.libloader;

import com.baidu.ar.libloader.ILibLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class d {
    private final Map<String, List<ILibLoader.c>> sS = new HashMap();

    private void g(List<ILibLoader.c> list) {
        if (list != null) {
            ILibLoader.c[] cVarArr = new ILibLoader.c[list.size()];
            list.toArray(cVarArr);
            for (ILibLoader.c cVar : cVarArr) {
                cVar.onReady();
            }
        }
    }

    public void a(String str, ILibLoader.c cVar) {
        List<ILibLoader.c> list = this.sS.get(str);
        if (list != null) {
            list.add(cVar);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        this.sS.put(str, arrayList);
    }

    public void clearAll() {
        this.sS.clear();
    }

    public void fi() {
        for (Map.Entry<String, List<ILibLoader.c>> entry : this.sS.entrySet()) {
            g(entry.getValue());
        }
    }
}
