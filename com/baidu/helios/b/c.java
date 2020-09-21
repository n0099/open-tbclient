package com.baidu.helios.b;

import com.baidu.helios.ids.b;
import com.baidu.helios.ids.gaid.GaidProvider;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements b.a {
    @Override // com.baidu.helios.ids.b.a
    public List<com.baidu.helios.ids.a> AD() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.helios.ids.a.a());
        arrayList.add(new com.baidu.helios.ids.c.a());
        arrayList.add(new GaidProvider());
        arrayList.add(new com.baidu.helios.ids.d.a());
        arrayList.add(new com.baidu.helios.ids.b.a());
        return arrayList;
    }
}
