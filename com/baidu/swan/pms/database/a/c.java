package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> cAM;
    private ConcurrentHashMap<Class<?>, Uri> cAN;

    private void aty() {
        this.cAM = new ConcurrentHashMap<>();
        this.cAN = new ConcurrentHashMap<>();
        this.cAM.put(com.baidu.swan.pms.model.f.class, new f());
        this.cAM.put(com.baidu.swan.pms.model.g.class, new g());
        this.cAM.put(com.baidu.swan.pms.model.d.class, new e());
        this.cAM.put(com.baidu.swan.pms.model.b.class, new d());
        this.cAM.put(PMSAppInfo.class, new a());
        this.cAM.put(com.baidu.swan.pms.model.h.class, new h());
        this.cAM.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.cAN.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.cAS);
        this.cAN.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.cAT);
        this.cAN.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.cAQ);
        this.cAN.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.cAU);
        this.cAN.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.cAR);
        this.cAN.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.cAV);
        this.cAN.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.cAW);
    }

    public c() {
        aty();
    }

    public <T> b<T> q(Class<T> cls) {
        return this.cAM.get(cls);
    }

    public <T> Uri r(Class<T> cls) {
        return this.cAN.get(cls);
    }
}
