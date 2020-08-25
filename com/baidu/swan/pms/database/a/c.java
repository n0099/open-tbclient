package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes14.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> dEV;
    private ConcurrentHashMap<Class<?>, Uri> dEW;

    private void aTw() {
        this.dEV = new ConcurrentHashMap<>();
        this.dEW = new ConcurrentHashMap<>();
        this.dEV.put(com.baidu.swan.pms.model.f.class, new f());
        this.dEV.put(com.baidu.swan.pms.model.g.class, new g());
        this.dEV.put(com.baidu.swan.pms.model.d.class, new e());
        this.dEV.put(com.baidu.swan.pms.model.b.class, new d());
        this.dEV.put(PMSAppInfo.class, new a());
        this.dEV.put(com.baidu.swan.pms.model.h.class, new h());
        this.dEV.put(com.baidu.swan.pms.model.i.class, new i());
        this.dEV.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.dEW.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.dFb);
        this.dEW.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.dFc);
        this.dEW.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.dEZ);
        this.dEW.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.dFd);
        this.dEW.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.dFa);
        this.dEW.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.dFe);
        this.dEW.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.dFf);
        this.dEW.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.dFg);
    }

    public c() {
        aTw();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.dEV.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.dEW.get(cls);
    }
}
