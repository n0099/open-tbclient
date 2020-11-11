package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> ehs;
    private ConcurrentHashMap<Class<?>, Uri> eht;

    private void bbk() {
        this.ehs = new ConcurrentHashMap<>();
        this.eht = new ConcurrentHashMap<>();
        this.ehs.put(com.baidu.swan.pms.model.f.class, new f());
        this.ehs.put(com.baidu.swan.pms.model.g.class, new g());
        this.ehs.put(com.baidu.swan.pms.model.d.class, new e());
        this.ehs.put(com.baidu.swan.pms.model.b.class, new d());
        this.ehs.put(PMSAppInfo.class, new a());
        this.ehs.put(com.baidu.swan.pms.model.h.class, new h());
        this.ehs.put(com.baidu.swan.pms.model.i.class, new i());
        this.ehs.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.eht.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.ehy);
        this.eht.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.ehz);
        this.eht.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.ehw);
        this.eht.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.ehA);
        this.eht.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.ehx);
        this.eht.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.ehB);
        this.eht.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.ehC);
        this.eht.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.ehD);
    }

    public c() {
        bbk();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.ehs.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.eht.get(cls);
    }
}
