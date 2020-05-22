package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private a apH;
    private Map<String, com.baidu.helios.channels.a> b = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        List<com.baidu.helios.channels.a> ub();
    }

    public b(a aVar) {
        this.apH = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.ub()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> ua() {
        return new ArrayList(this.b.values());
    }
}
