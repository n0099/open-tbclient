package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> evp;
    private ConcurrentHashMap<Class<?>, Uri> evq;

    private void bcA() {
        this.evp = new ConcurrentHashMap<>();
        this.evq = new ConcurrentHashMap<>();
        this.evp.put(com.baidu.swan.pms.model.f.class, new f());
        this.evp.put(com.baidu.swan.pms.model.g.class, new g());
        this.evp.put(com.baidu.swan.pms.model.d.class, new e());
        this.evp.put(com.baidu.swan.pms.model.b.class, new d());
        this.evp.put(PMSAppInfo.class, new a());
        this.evp.put(com.baidu.swan.pms.model.h.class, new h());
        this.evp.put(com.baidu.swan.pms.model.i.class, new i());
        this.evp.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.evq.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.evv);
        this.evq.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.evw);
        this.evq.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.evt);
        this.evq.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.evx);
        this.evq.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.evu);
        this.evq.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.evy);
        this.evq.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.evz);
        this.evq.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.evA);
    }

    public c() {
        bcA();
    }

    public <T> b<T> k(Class<T> cls) {
        return this.evp.get(cls);
    }

    public <T> Uri l(Class<T> cls) {
        return this.evq.get(cls);
    }
}
