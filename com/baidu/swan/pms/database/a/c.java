package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> dTe;
    private ConcurrentHashMap<Class<?>, Uri> dTf;

    private void aWR() {
        this.dTe = new ConcurrentHashMap<>();
        this.dTf = new ConcurrentHashMap<>();
        this.dTe.put(com.baidu.swan.pms.model.f.class, new f());
        this.dTe.put(com.baidu.swan.pms.model.g.class, new g());
        this.dTe.put(com.baidu.swan.pms.model.d.class, new e());
        this.dTe.put(com.baidu.swan.pms.model.b.class, new d());
        this.dTe.put(PMSAppInfo.class, new a());
        this.dTe.put(com.baidu.swan.pms.model.h.class, new h());
        this.dTe.put(com.baidu.swan.pms.model.i.class, new i());
        this.dTe.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.dTf.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.dTk);
        this.dTf.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.dTl);
        this.dTf.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.dTi);
        this.dTf.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.dTm);
        this.dTf.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.dTj);
        this.dTf.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.dTn);
        this.dTf.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.dTo);
        this.dTf.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.dTp);
    }

    public c() {
        aWR();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.dTe.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.dTf.get(cls);
    }
}
