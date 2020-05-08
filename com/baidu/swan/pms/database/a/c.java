package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> daa;
    private ConcurrentHashMap<Class<?>, Uri> dab;

    private void aBL() {
        this.daa = new ConcurrentHashMap<>();
        this.dab = new ConcurrentHashMap<>();
        this.daa.put(com.baidu.swan.pms.model.f.class, new f());
        this.daa.put(com.baidu.swan.pms.model.g.class, new g());
        this.daa.put(com.baidu.swan.pms.model.d.class, new e());
        this.daa.put(com.baidu.swan.pms.model.b.class, new d());
        this.daa.put(PMSAppInfo.class, new a());
        this.daa.put(com.baidu.swan.pms.model.h.class, new h());
        this.daa.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.dab.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.dag);
        this.dab.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.dah);
        this.dab.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.dae);
        this.dab.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.dai);
        this.dab.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.daf);
        this.dab.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.daj);
        this.dab.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.dak);
    }

    public c() {
        aBL();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.daa.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.dab.get(cls);
    }
}
