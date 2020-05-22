package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> dlk;
    private ConcurrentHashMap<Class<?>, Uri> dll;

    private void aFY() {
        this.dlk = new ConcurrentHashMap<>();
        this.dll = new ConcurrentHashMap<>();
        this.dlk.put(com.baidu.swan.pms.model.f.class, new f());
        this.dlk.put(com.baidu.swan.pms.model.g.class, new g());
        this.dlk.put(com.baidu.swan.pms.model.d.class, new e());
        this.dlk.put(com.baidu.swan.pms.model.b.class, new d());
        this.dlk.put(PMSAppInfo.class, new a());
        this.dlk.put(com.baidu.swan.pms.model.h.class, new h());
        this.dlk.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.dll.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.dlq);
        this.dll.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.dlr);
        this.dll.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.dlo);
        this.dll.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.dls);
        this.dll.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.dlp);
        this.dll.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.dlt);
        this.dll.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.dlu);
    }

    public c() {
        aFY();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.dlk.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.dll.get(cls);
    }
}
