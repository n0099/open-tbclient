package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes24.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> dHd;
    private ConcurrentHashMap<Class<?>, Uri> dHe;

    private void aUi() {
        this.dHd = new ConcurrentHashMap<>();
        this.dHe = new ConcurrentHashMap<>();
        this.dHd.put(com.baidu.swan.pms.model.f.class, new f());
        this.dHd.put(com.baidu.swan.pms.model.g.class, new g());
        this.dHd.put(com.baidu.swan.pms.model.d.class, new e());
        this.dHd.put(com.baidu.swan.pms.model.b.class, new d());
        this.dHd.put(PMSAppInfo.class, new a());
        this.dHd.put(com.baidu.swan.pms.model.h.class, new h());
        this.dHd.put(com.baidu.swan.pms.model.i.class, new i());
        this.dHd.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.dHe.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.dHj);
        this.dHe.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.dHk);
        this.dHe.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.dHh);
        this.dHe.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.dHl);
        this.dHe.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.dHi);
        this.dHe.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.dHm);
        this.dHe.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.dHn);
        this.dHe.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.dHo);
    }

    public c() {
        aUi();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.dHd.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.dHe.get(cls);
    }
}
