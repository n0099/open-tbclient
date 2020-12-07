package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes19.dex */
public class b {
    private a axH;
    private Map<String, com.baidu.helios.ids.a> b = new HashMap();

    /* loaded from: classes19.dex */
    public interface a {
        List<com.baidu.helios.ids.a> zW();
    }

    public b(a aVar) {
        this.axH = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.zW()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public com.baidu.helios.ids.a fC(String str) {
        return this.b.get(str);
    }

    public List<com.baidu.helios.ids.a> zV() {
        return new ArrayList(this.b.values());
    }
}
