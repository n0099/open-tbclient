package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> emL;
    private ConcurrentHashMap<Class<?>, Uri> emM;

    private void bdI() {
        this.emL = new ConcurrentHashMap<>();
        this.emM = new ConcurrentHashMap<>();
        this.emL.put(com.baidu.swan.pms.model.f.class, new f());
        this.emL.put(com.baidu.swan.pms.model.g.class, new g());
        this.emL.put(com.baidu.swan.pms.model.d.class, new e());
        this.emL.put(com.baidu.swan.pms.model.b.class, new d());
        this.emL.put(PMSAppInfo.class, new a());
        this.emL.put(com.baidu.swan.pms.model.h.class, new h());
        this.emL.put(com.baidu.swan.pms.model.i.class, new i());
        this.emL.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.emM.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.emR);
        this.emM.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.emS);
        this.emM.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.emP);
        this.emM.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.emT);
        this.emM.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.emQ);
        this.emM.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.emU);
        this.emM.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.emV);
        this.emM.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.emW);
    }

    public c() {
        bdI();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.emL.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.emM.get(cls);
    }
}
