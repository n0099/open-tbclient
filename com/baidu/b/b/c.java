package com.baidu.b.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {
    private a acJ;
    private Map<String, com.baidu.b.b.a> b = new HashMap();

    /* loaded from: classes3.dex */
    public interface a {
        List<com.baidu.b.b.a> a();
    }

    public c(a aVar) {
        this.acJ = aVar;
        for (com.baidu.b.b.a aVar2 : aVar.a()) {
            this.b.put(aVar2.a(), aVar2);
        }
    }

    public List<com.baidu.b.b.a> a() {
        return new ArrayList(this.b.values());
    }
}
