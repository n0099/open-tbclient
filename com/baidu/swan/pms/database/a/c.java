package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes14.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> dEZ;
    private ConcurrentHashMap<Class<?>, Uri> dFa;

    private void aTw() {
        this.dEZ = new ConcurrentHashMap<>();
        this.dFa = new ConcurrentHashMap<>();
        this.dEZ.put(com.baidu.swan.pms.model.f.class, new f());
        this.dEZ.put(com.baidu.swan.pms.model.g.class, new g());
        this.dEZ.put(com.baidu.swan.pms.model.d.class, new e());
        this.dEZ.put(com.baidu.swan.pms.model.b.class, new d());
        this.dEZ.put(PMSAppInfo.class, new a());
        this.dEZ.put(com.baidu.swan.pms.model.h.class, new h());
        this.dEZ.put(com.baidu.swan.pms.model.i.class, new i());
        this.dEZ.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.dFa.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.dFf);
        this.dFa.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.dFg);
        this.dFa.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.dFd);
        this.dFa.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.dFh);
        this.dFa.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.dFe);
        this.dFa.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.dFi);
        this.dFa.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.dFj);
        this.dFa.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.dFk);
    }

    public c() {
        aTw();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.dEZ.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.dFa.get(cls);
    }
}
