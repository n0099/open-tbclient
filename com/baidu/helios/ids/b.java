package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    private a auE;
    private Map<String, com.baidu.helios.ids.a> b = new HashMap();

    /* loaded from: classes4.dex */
    public interface a {
        List<com.baidu.helios.ids.a> vs();
    }

    public b(a aVar) {
        this.auE = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.vs()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public com.baidu.helios.ids.a eh(String str) {
        return this.b.get(str);
    }

    public List<com.baidu.helios.ids.a> vr() {
        return new ArrayList(this.b.values());
    }
}
