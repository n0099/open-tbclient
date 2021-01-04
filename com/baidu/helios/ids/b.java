package com.baidu.helios.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private a aya;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, com.baidu.helios.ids.a> f2495b = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        List<com.baidu.helios.ids.a> zn();
    }

    public b(a aVar) {
        this.aya = aVar;
        for (com.baidu.helios.ids.a aVar2 : aVar.zn()) {
            this.f2495b.put(aVar2.getName(), aVar2);
        }
    }

    public com.baidu.helios.ids.a fn(String str) {
        return this.f2495b.get(str);
    }

    public List<com.baidu.helios.ids.a> zm() {
        return new ArrayList(this.f2495b.values());
    }
}
