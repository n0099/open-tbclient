package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> dpV;
    private ConcurrentHashMap<Class<?>, Uri> dpW;

    private void aHe() {
        this.dpV = new ConcurrentHashMap<>();
        this.dpW = new ConcurrentHashMap<>();
        this.dpV.put(com.baidu.swan.pms.model.f.class, new f());
        this.dpV.put(com.baidu.swan.pms.model.g.class, new g());
        this.dpV.put(com.baidu.swan.pms.model.d.class, new e());
        this.dpV.put(com.baidu.swan.pms.model.b.class, new d());
        this.dpV.put(PMSAppInfo.class, new a());
        this.dpV.put(com.baidu.swan.pms.model.h.class, new h());
        this.dpV.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.dpW.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.dqb);
        this.dpW.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.dqc);
        this.dpW.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.dpZ);
        this.dpW.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.dqd);
        this.dpW.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.dqa);
        this.dpW.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.dqe);
        this.dpW.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.dqf);
    }

    public c() {
        aHe();
    }

    public <T> b<T> r(Class<T> cls) {
        return this.dpV.get(cls);
    }

    public <T> Uri s(Class<T> cls) {
        return this.dpW.get(cls);
    }
}
