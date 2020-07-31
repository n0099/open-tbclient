package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes18.dex */
public class b {
    private a asj;
    private Map<String, com.baidu.helios.ids.a> b = new HashMap();

    /* loaded from: classes18.dex */
    public interface a {
        List<com.baidu.helios.ids.a> uS();
    }

    public b(a aVar) {
        this.asj = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.uS()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public com.baidu.helios.ids.a ed(String str) {
        return this.b.get(str);
    }

    public List<com.baidu.helios.ids.a> uR() {
        return new ArrayList(this.b.values());
    }
}
