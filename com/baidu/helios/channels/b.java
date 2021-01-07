package com.baidu.helios.channels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private a awN;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, com.baidu.helios.channels.a> f2470b = new HashMap();

    /* loaded from: classes6.dex */
    public interface a {
        List<com.baidu.helios.channels.a> yM();
    }

    public b(a aVar) {
        this.awN = aVar;
        for (com.baidu.helios.channels.a aVar2 : aVar.yM()) {
            this.f2470b.put(aVar2.getName(), aVar2);
        }
    }

    public List<com.baidu.helios.channels.a> yL() {
        return new ArrayList(this.f2470b.values());
    }
}
