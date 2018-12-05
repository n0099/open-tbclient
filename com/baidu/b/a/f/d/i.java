package com.baidu.b.a.f.d;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i {
    public static List<j> a(List<com.baidu.b.a.c.a.a> list, com.baidu.b.a.b.c.b bVar) {
        ArrayList arrayList = new ArrayList();
        for (com.baidu.b.a.c.a.a aVar : list) {
            j a = g.rR().a(aVar, bVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }
}
