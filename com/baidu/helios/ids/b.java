package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    private a awJ;
    private Map<String, com.baidu.helios.ids.a> b = new HashMap();

    /* loaded from: classes10.dex */
    public interface a {
        List<com.baidu.helios.ids.a> Ac();
    }

    public b(a aVar) {
        this.awJ = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.Ac()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.ids.a> Ab() {
        return new ArrayList(this.b.values());
    }

    public com.baidu.helios.ids.a fy(String str) {
        return this.b.get(str);
    }
}
