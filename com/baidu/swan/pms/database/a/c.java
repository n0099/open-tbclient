package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> etO;
    private ConcurrentHashMap<Class<?>, Uri> etP;

    private void bcy() {
        this.etO = new ConcurrentHashMap<>();
        this.etP = new ConcurrentHashMap<>();
        this.etO.put(com.baidu.swan.pms.model.f.class, new f());
        this.etO.put(com.baidu.swan.pms.model.g.class, new g());
        this.etO.put(com.baidu.swan.pms.model.d.class, new e());
        this.etO.put(com.baidu.swan.pms.model.b.class, new d());
        this.etO.put(PMSAppInfo.class, new a());
        this.etO.put(com.baidu.swan.pms.model.h.class, new h());
        this.etO.put(com.baidu.swan.pms.model.i.class, new i());
        this.etO.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.etP.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.etU);
        this.etP.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.etV);
        this.etP.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.etS);
        this.etP.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.etW);
        this.etP.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.etT);
        this.etP.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.etX);
        this.etP.put(com.baidu.swan.pms.model.i.class, com.baidu.swan.pms.database.provider.b.etY);
        this.etP.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.etZ);
    }

    public c() {
        bcy();
    }

    public <T> b<T> k(Class<T> cls) {
        return this.etO.get(cls);
    }

    public <T> Uri l(Class<T> cls) {
        return this.etP.get(cls);
    }
}
