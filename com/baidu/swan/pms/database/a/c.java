package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes19.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> dvM;
    private ConcurrentHashMap<Class<?>, Uri> dvN;

    private void aKV() {
        this.dvM = new ConcurrentHashMap<>();
        this.dvN = new ConcurrentHashMap<>();
        this.dvM.put(com.baidu.swan.pms.model.f.class, new f());
        this.dvM.put(com.baidu.swan.pms.model.g.class, new g());
        this.dvM.put(com.baidu.swan.pms.model.d.class, new e());
        this.dvM.put(com.baidu.swan.pms.model.b.class, new d());
        this.dvM.put(PMSAppInfo.class, new a());
        this.dvM.put(com.baidu.swan.pms.model.h.class, new h());
        this.dvM.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.dvN.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.dvS);
        this.dvN.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.dvT);
        this.dvN.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.dvQ);
        this.dvN.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.dvU);
        this.dvN.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.dvR);
        this.dvN.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.dvV);
        this.dvN.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.dvW);
    }

    public c() {
        aKV();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.dvM.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.dvN.get(cls);
    }
}
