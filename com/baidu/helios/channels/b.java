package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private a asb;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, com.baidu.helios.channels.a> f2420b = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        List<com.baidu.helios.channels.a> uR();
    }

    public b(a aVar) {
        this.asb = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.uR()) {
            this.f2420b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> uQ() {
        return new ArrayList(this.f2420b.values());
    }
}
