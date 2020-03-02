package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> cAL;
    private ConcurrentHashMap<Class<?>, Uri> cAM;

    private void aty() {
        this.cAL = new ConcurrentHashMap<>();
        this.cAM = new ConcurrentHashMap<>();
        this.cAL.put(com.baidu.swan.pms.model.f.class, new f());
        this.cAL.put(com.baidu.swan.pms.model.g.class, new g());
        this.cAL.put(com.baidu.swan.pms.model.d.class, new e());
        this.cAL.put(com.baidu.swan.pms.model.b.class, new d());
        this.cAL.put(PMSAppInfo.class, new a());
        this.cAL.put(com.baidu.swan.pms.model.h.class, new h());
        this.cAL.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.cAM.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.cAR);
        this.cAM.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.cAS);
        this.cAM.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.cAP);
        this.cAM.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.cAT);
        this.cAM.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.cAQ);
        this.cAM.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.cAU);
        this.cAM.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.cAV);
    }

    public c() {
        aty();
    }

    public <T> b<T> q(Class<T> cls) {
        return this.cAL.get(cls);
    }

    public <T> Uri r(Class<T> cls) {
        return this.cAM.get(cls);
    }
}
