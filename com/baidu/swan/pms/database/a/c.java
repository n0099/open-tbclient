package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> ewu;
    private ConcurrentHashMap<Class<?>, Uri> ewv;

    private void bgf() {
        this.ewu = new ConcurrentHashMap<>();
        this.ewv = new ConcurrentHashMap<>();
        this.ewu.put(com.baidu.swan.pms.model.f.class, new f());
        this.ewu.put(com.baidu.swan.pms.model.g.class, new g());
        this.ewu.put(com.baidu.swan.pms.model.d.class, new e());
        this.ewu.put(com.baidu.swan.pms.model.b.class, new d());
        this.ewu.put(PMSAppInfo.class, new a());
        this.ewu.put(com.baidu.swan.pms.model.h.class, new h());
        this.ewu.put(com.baidu.swan.pms.model.i.class, new i());
        this.ewu.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.ewv.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.ewA);
        this.ewv.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.ewB);
        this.ewv.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.ewy);
        this.ewv.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.ewC);
        this.ewv.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.ewz);
        this.ewv.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.ewD);
        this.ewv.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.ewE);
        this.ewv.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.ewF);
    }

    public c() {
        bgf();
    }

    public <T> b<T> k(Class<T> cls) {
        return this.ewu.get(cls);
    }

    public <T> Uri l(Class<T> cls) {
        return this.ewv.get(cls);
    }
}
