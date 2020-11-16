package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> efK;
    private ConcurrentHashMap<Class<?>, Uri> efL;

    private void baD() {
        this.efK = new ConcurrentHashMap<>();
        this.efL = new ConcurrentHashMap<>();
        this.efK.put(com.baidu.swan.pms.model.f.class, new f());
        this.efK.put(com.baidu.swan.pms.model.g.class, new g());
        this.efK.put(com.baidu.swan.pms.model.d.class, new e());
        this.efK.put(com.baidu.swan.pms.model.b.class, new d());
        this.efK.put(PMSAppInfo.class, new a());
        this.efK.put(com.baidu.swan.pms.model.h.class, new h());
        this.efK.put(com.baidu.swan.pms.model.i.class, new i());
        this.efK.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.efL.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.efQ);
        this.efL.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.efR);
        this.efL.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.efO);
        this.efL.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.efS);
        this.efL.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.efP);
        this.efL.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.efT);
        this.efL.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.efU);
        this.efL.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.efV);
    }

    public c() {
        baD();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.efK.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.efL.get(cls);
    }
}
