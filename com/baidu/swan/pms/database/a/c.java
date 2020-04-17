package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> cZV;
    private ConcurrentHashMap<Class<?>, Uri> cZW;

    private void aBL() {
        this.cZV = new ConcurrentHashMap<>();
        this.cZW = new ConcurrentHashMap<>();
        this.cZV.put(com.baidu.swan.pms.model.f.class, new f());
        this.cZV.put(com.baidu.swan.pms.model.g.class, new g());
        this.cZV.put(com.baidu.swan.pms.model.d.class, new e());
        this.cZV.put(com.baidu.swan.pms.model.b.class, new d());
        this.cZV.put(PMSAppInfo.class, new a());
        this.cZV.put(com.baidu.swan.pms.model.h.class, new h());
        this.cZV.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.cZW.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.dab);
        this.cZW.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.dac);
        this.cZW.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.cZZ);
        this.cZW.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.dad);
        this.cZW.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.daa);
        this.cZW.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.dae);
        this.cZW.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.daf);
    }

    public c() {
        aBL();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.cZV.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.cZW.get(cls);
    }
}
