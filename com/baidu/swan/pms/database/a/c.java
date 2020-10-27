package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> ebA;
    private ConcurrentHashMap<Class<?>, Uri> ebB;

    private void aYK() {
        this.ebA = new ConcurrentHashMap<>();
        this.ebB = new ConcurrentHashMap<>();
        this.ebA.put(com.baidu.swan.pms.model.f.class, new f());
        this.ebA.put(com.baidu.swan.pms.model.g.class, new g());
        this.ebA.put(com.baidu.swan.pms.model.d.class, new e());
        this.ebA.put(com.baidu.swan.pms.model.b.class, new d());
        this.ebA.put(PMSAppInfo.class, new a());
        this.ebA.put(com.baidu.swan.pms.model.h.class, new h());
        this.ebA.put(com.baidu.swan.pms.model.i.class, new i());
        this.ebA.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.ebB.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.ebG);
        this.ebB.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.ebH);
        this.ebB.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.ebE);
        this.ebB.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.ebI);
        this.ebB.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.ebF);
        this.ebB.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.ebJ);
        this.ebB.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.ebK);
        this.ebB.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.ebL);
    }

    public c() {
        aYK();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.ebA.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.ebB.get(cls);
    }
}
