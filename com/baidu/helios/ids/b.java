package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes25.dex */
public class b {
    private a axK;
    private Map<String, com.baidu.helios.ids.a> b = new HashMap();

    /* loaded from: classes25.dex */
    public interface a {
        List<com.baidu.helios.ids.a> AD();
    }

    public b(a aVar) {
        this.axK = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.AD()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.ids.a> AC() {
        return new ArrayList(this.b.values());
    }

    public com.baidu.helios.ids.a fz(String str) {
        return this.b.get(str);
    }
}
