package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private a aqV;
    private Map<String, com.baidu.helios.ids.a> b = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        List<com.baidu.helios.ids.a> uA();
    }

    public b(a aVar) {
        this.aqV = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.uA()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public com.baidu.helios.ids.a ec(String str) {
        return this.b.get(str);
    }

    public List<com.baidu.helios.ids.a> uz() {
        return new ArrayList(this.b.values());
    }
}
