package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    private a awv;
    private Map<String, com.baidu.helios.channels.a> b = new HashMap();

    /* loaded from: classes10.dex */
    public interface a {
        List<com.baidu.helios.channels.a> Ae();
    }

    public b(a aVar) {
        this.awv = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.Ae()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> Ad() {
        return new ArrayList(this.b.values());
    }
}
