package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.h;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> bsV;
    private ConcurrentHashMap<Class<?>, Uri> bsW;

    private void Wk() {
        this.bsV = new ConcurrentHashMap<>();
        this.bsW = new ConcurrentHashMap<>();
        this.bsV.put(com.baidu.swan.pms.model.f.class, new f());
        this.bsV.put(h.class, new g());
        this.bsV.put(com.baidu.swan.pms.model.d.class, new e());
        this.bsV.put(com.baidu.swan.pms.model.b.class, new d());
        this.bsV.put(PMSAppInfo.class, new a());
        this.bsW.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.btb);
        this.bsW.put(h.class, com.baidu.swan.pms.database.provider.b.awe);
        this.bsW.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.bsZ);
        this.bsW.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.btc);
        this.bsW.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.bta);
    }

    public c() {
        Wk();
    }

    public <T> b<T> l(Class<T> cls) {
        return this.bsV.get(cls);
    }

    public <T> Uri m(Class<T> cls) {
        return this.bsW.get(cls);
    }
}
