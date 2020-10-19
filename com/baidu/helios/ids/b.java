package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    private a ayt;
    private Map<String, com.baidu.helios.ids.a> b = new HashMap();

    /* loaded from: classes10.dex */
    public interface a {
        List<com.baidu.helios.ids.a> AL();
    }

    public b(a aVar) {
        this.ayt = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.AL()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.ids.a> AK() {
        return new ArrayList(this.b.values());
    }

    public com.baidu.helios.ids.a fE(String str) {
        return this.b.get(str);
    }
}
