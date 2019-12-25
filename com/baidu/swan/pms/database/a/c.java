package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> cwB;
    private ConcurrentHashMap<Class<?>, Uri> cwC;

    private void aqP() {
        this.cwB = new ConcurrentHashMap<>();
        this.cwC = new ConcurrentHashMap<>();
        this.cwB.put(com.baidu.swan.pms.model.f.class, new f());
        this.cwB.put(com.baidu.swan.pms.model.g.class, new g());
        this.cwB.put(com.baidu.swan.pms.model.d.class, new e());
        this.cwB.put(com.baidu.swan.pms.model.b.class, new d());
        this.cwB.put(PMSAppInfo.class, new a());
        this.cwB.put(com.baidu.swan.pms.model.h.class, new h());
        this.cwB.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.cwC.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.cwH);
        this.cwC.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.cwI);
        this.cwC.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.cwF);
        this.cwC.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.cwJ);
        this.cwC.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.cwG);
        this.cwC.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.cwK);
        this.cwC.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.cwL);
    }

    public c() {
        aqP();
    }

    public <T> b<T> q(Class<T> cls) {
        return this.cwB.get(cls);
    }

    public <T> Uri r(Class<T> cls) {
        return this.cwC.get(cls);
    }
}
