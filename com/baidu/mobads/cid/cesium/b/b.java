package com.baidu.mobads.cid.cesium.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f8364a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, com.baidu.mobads.cid.cesium.b.a> f8365b = new HashMap();

    /* loaded from: classes2.dex */
    public interface a {
        List<com.baidu.mobads.cid.cesium.b.a> a();
    }

    public b(a aVar) {
        this.f8364a = aVar;
        for (com.baidu.mobads.cid.cesium.b.a aVar2 : aVar.a()) {
            this.f8365b.put(aVar2.a(), aVar2);
        }
    }

    public List<com.baidu.mobads.cid.cesium.b.a> a() {
        return new ArrayList(this.f8365b.values());
    }
}
