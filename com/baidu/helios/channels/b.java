package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes12.dex */
public class b {
    private a avT;
    private Map<String, com.baidu.helios.channels.a> b = new HashMap();

    /* loaded from: classes12.dex */
    public interface a {
        List<com.baidu.helios.channels.a> zQ();
    }

    public b(a aVar) {
        this.avT = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.zQ()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> zP() {
        return new ArrayList(this.b.values());
    }
}
