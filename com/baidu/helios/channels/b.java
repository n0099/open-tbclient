package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes14.dex */
public class b {
    private a avu;
    private Map<String, com.baidu.helios.channels.a> b = new HashMap();

    /* loaded from: classes14.dex */
    public interface a {
        List<com.baidu.helios.channels.a> zD();
    }

    public b(a aVar) {
        this.avu = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.zD()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> zC() {
        return new ArrayList(this.b.values());
    }
}
