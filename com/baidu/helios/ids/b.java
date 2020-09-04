package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private a axi;
    private Map<String, com.baidu.helios.ids.a> b = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        List<com.baidu.helios.ids.a> Ap();
    }

    public b(a aVar) {
        this.axi = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.Ap()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.ids.a> Ao() {
        return new ArrayList(this.b.values());
    }

    public com.baidu.helios.ids.a fx(String str) {
        return this.b.get(str);
    }
}
