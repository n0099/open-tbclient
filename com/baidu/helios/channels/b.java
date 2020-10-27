package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private a axf;
    private Map<String, com.baidu.helios.channels.a> b = new HashMap();

    /* loaded from: classes8.dex */
    public interface a {
        List<com.baidu.helios.channels.a> Am();
    }

    public b(a aVar) {
        this.axf = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.Am()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> Al() {
        return new ArrayList(this.b.values());
    }
}
