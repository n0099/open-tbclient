package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> erH;
    private ConcurrentHashMap<Class<?>, Uri> erI;

    private void bcl() {
        this.erH = new ConcurrentHashMap<>();
        this.erI = new ConcurrentHashMap<>();
        this.erH.put(com.baidu.swan.pms.model.f.class, new f());
        this.erH.put(com.baidu.swan.pms.model.g.class, new g());
        this.erH.put(com.baidu.swan.pms.model.d.class, new e());
        this.erH.put(com.baidu.swan.pms.model.b.class, new d());
        this.erH.put(PMSAppInfo.class, new a());
        this.erH.put(com.baidu.swan.pms.model.h.class, new h());
        this.erH.put(com.baidu.swan.pms.model.i.class, new i());
        this.erH.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.erI.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.erN);
        this.erI.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.erO);
        this.erI.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.erL);
        this.erI.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.erP);
        this.erI.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.erM);
        this.erI.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.erQ);
        this.erI.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.erR);
        this.erI.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.erS);
    }

    public c() {
        bcl();
    }

    public <T> b<T> k(Class<T> cls) {
        return this.erH.get(cls);
    }

    public <T> Uri l(Class<T> cls) {
        return this.erI.get(cls);
    }
}
