package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes14.dex */
public class b {
    private a ato;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, com.baidu.helios.ids.a> f2446b = new HashMap();

    /* loaded from: classes14.dex */
    public interface a {
        List<com.baidu.helios.ids.a> vs();
    }

    public b(a aVar) {
        this.ato = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.vs()) {
            this.f2446b.put(aVar2.getName(), aVar2);
        }
    }

    public com.baidu.helios.ids.a eb(String str) {
        return this.f2446b.get(str);
    }

    public List<com.baidu.helios.ids.a> vr() {
        return new ArrayList(this.f2446b.values());
    }
}
