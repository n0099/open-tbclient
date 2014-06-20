package com.baidu.android.nebula.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class r implements Iterable {
    final /* synthetic */ h a;
    private HashMap b = new HashMap();
    private ArrayList c = new ArrayList();

    public r(h hVar, Map map) {
        this.a = hVar;
        String str = (String) map.get("cookie");
        if (str != null) {
            String[] split = str.split(";");
            for (String str2 : split) {
                String[] split2 = str2.trim().split("=");
                if (split2.length == 2) {
                    this.b.put(split2[0], split2[1]);
                }
            }
        }
    }

    public void a(c cVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            cVar.a("Set-Cookie", ((j) it.next()).a());
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.b.keySet().iterator();
    }
}
