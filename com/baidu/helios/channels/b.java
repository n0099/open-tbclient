package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private a arR;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, com.baidu.helios.channels.a> f2418b = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        List<com.baidu.helios.channels.a> uO();
    }

    public b(a aVar) {
        this.arR = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.uO()) {
            this.f2418b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> uN() {
        return new ArrayList(this.f2418b.values());
    }
}
