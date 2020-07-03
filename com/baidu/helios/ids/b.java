package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private a aso;
    private Map<String, com.baidu.helios.ids.a> b = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        List<com.baidu.helios.ids.a> uS();
    }

    public b(a aVar) {
        this.aso = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.uS()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public com.baidu.helios.ids.a ee(String str) {
        return this.b.get(str);
    }

    public List<com.baidu.helios.ids.a> uR() {
        return new ArrayList(this.b.values());
    }
}
