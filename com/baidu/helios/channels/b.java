package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes14.dex */
public class b {
    private a ats;
    private Map<String, com.baidu.helios.channels.a> b = new HashMap();

    /* loaded from: classes14.dex */
    public interface a {
        List<com.baidu.helios.channels.a> uR();
    }

    public b(a aVar) {
        this.ats = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.uR()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> uQ() {
        return new ArrayList(this.b.values());
    }
}
