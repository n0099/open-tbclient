package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> cAK;
    private ConcurrentHashMap<Class<?>, Uri> cAL;

    private void atw() {
        this.cAK = new ConcurrentHashMap<>();
        this.cAL = new ConcurrentHashMap<>();
        this.cAK.put(com.baidu.swan.pms.model.f.class, new f());
        this.cAK.put(com.baidu.swan.pms.model.g.class, new g());
        this.cAK.put(com.baidu.swan.pms.model.d.class, new e());
        this.cAK.put(com.baidu.swan.pms.model.b.class, new d());
        this.cAK.put(PMSAppInfo.class, new a());
        this.cAK.put(com.baidu.swan.pms.model.h.class, new h());
        this.cAK.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.cAL.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.cAQ);
        this.cAL.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.cAR);
        this.cAL.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.cAO);
        this.cAL.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.cAS);
        this.cAL.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.cAP);
        this.cAL.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.cAT);
        this.cAL.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.cAU);
    }

    public c() {
        atw();
    }

    public <T> b<T> q(Class<T> cls) {
        return this.cAK.get(cls);
    }

    public <T> Uri r(Class<T> cls) {
        return this.cAL.get(cls);
    }
}
