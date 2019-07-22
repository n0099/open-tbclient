package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.h;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> bsx;
    private ConcurrentHashMap<Class<?>, Uri> bsy;

    private void Wg() {
        this.bsx = new ConcurrentHashMap<>();
        this.bsy = new ConcurrentHashMap<>();
        this.bsx.put(com.baidu.swan.pms.model.f.class, new f());
        this.bsx.put(h.class, new g());
        this.bsx.put(com.baidu.swan.pms.model.d.class, new e());
        this.bsx.put(com.baidu.swan.pms.model.b.class, new d());
        this.bsx.put(PMSAppInfo.class, new a());
        this.bsy.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.bsD);
        this.bsy.put(h.class, com.baidu.swan.pms.database.provider.b.avG);
        this.bsy.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.bsB);
        this.bsy.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.bsE);
        this.bsy.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.bsC);
    }

    public c() {
        Wg();
    }

    public <T> b<T> l(Class<T> cls) {
        return this.bsx.get(cls);
    }

    public <T> Uri m(Class<T> cls) {
        return this.bsy.get(cls);
    }
}
