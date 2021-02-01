package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private a ate;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, com.baidu.helios.ids.a> f2444b = new HashMap();

    /* loaded from: classes3.dex */
    public interface a {
        List<com.baidu.helios.ids.a> vp();
    }

    public b(a aVar) {
        this.ate = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.vp()) {
            this.f2444b.put(aVar2.getName(), aVar2);
        }
    }

    public com.baidu.helios.ids.a eb(String str) {
        return this.f2444b.get(str);
    }

    public List<com.baidu.helios.ids.a> vo() {
        return new ArrayList(this.f2444b.values());
    }
}
