package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private a aqZ;
    private Map<String, com.baidu.helios.channels.a> b = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        List<com.baidu.helios.channels.a> ut();
    }

    public b(a aVar) {
        this.aqZ = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.ut()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> us() {
        return new ArrayList(this.b.values());
    }
}
