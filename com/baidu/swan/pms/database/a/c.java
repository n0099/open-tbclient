package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> cwM;
    private ConcurrentHashMap<Class<?>, Uri> cwN;

    private void ari() {
        this.cwM = new ConcurrentHashMap<>();
        this.cwN = new ConcurrentHashMap<>();
        this.cwM.put(com.baidu.swan.pms.model.f.class, new f());
        this.cwM.put(com.baidu.swan.pms.model.g.class, new g());
        this.cwM.put(com.baidu.swan.pms.model.d.class, new e());
        this.cwM.put(com.baidu.swan.pms.model.b.class, new d());
        this.cwM.put(PMSAppInfo.class, new a());
        this.cwM.put(com.baidu.swan.pms.model.h.class, new h());
        this.cwM.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.cwN.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.cwS);
        this.cwN.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.cwT);
        this.cwN.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.cwQ);
        this.cwN.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.cwU);
        this.cwN.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.cwR);
        this.cwN.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.cwV);
        this.cwN.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.cwW);
    }

    public c() {
        ari();
    }

    public <T> b<T> q(Class<T> cls) {
        return this.cwM.get(cls);
    }

    public <T> Uri r(Class<T> cls) {
        return this.cwN.get(cls);
    }
}
