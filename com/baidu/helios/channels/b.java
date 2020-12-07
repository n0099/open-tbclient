package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes14.dex */
public class b {
    private a aws;
    private Map<String, com.baidu.helios.channels.a> b = new HashMap();

    /* loaded from: classes14.dex */
    public interface a {
        List<com.baidu.helios.channels.a> zv();
    }

    public b(a aVar) {
        this.aws = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.zv()) {
            this.b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> zu() {
        return new ArrayList(this.b.values());
    }
}
