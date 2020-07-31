package com.baidu.cesium.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private a ajX;
    private Map<String, com.baidu.cesium.b.a> f = new HashMap();

    /* loaded from: classes3.dex */
    public interface a {
        List<com.baidu.cesium.b.a> a();
    }

    public b(a aVar) {
        this.ajX = aVar;
        for (com.baidu.cesium.b.a aVar2 : aVar.a()) {
            this.f.put(aVar2.a(), aVar2);
        }
    }

    public List<com.baidu.cesium.b.a> a() {
        return new ArrayList(this.f.values());
    }
}
