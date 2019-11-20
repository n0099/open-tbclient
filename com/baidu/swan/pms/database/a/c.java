package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.h;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> bKP;
    private ConcurrentHashMap<Class<?>, Uri> bKQ;

    private void aaX() {
        this.bKP = new ConcurrentHashMap<>();
        this.bKQ = new ConcurrentHashMap<>();
        this.bKP.put(com.baidu.swan.pms.model.f.class, new f());
        this.bKP.put(h.class, new g());
        this.bKP.put(com.baidu.swan.pms.model.d.class, new e());
        this.bKP.put(com.baidu.swan.pms.model.b.class, new d());
        this.bKP.put(PMSAppInfo.class, new a());
        this.bKQ.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.bKV);
        this.bKQ.put(h.class, com.baidu.swan.pms.database.provider.b.aPb);
        this.bKQ.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.bKT);
        this.bKQ.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.bKW);
        this.bKQ.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.bKU);
    }

    public c() {
        aaX();
    }

    public <T> b<T> j(Class<T> cls) {
        return this.bKP.get(cls);
    }

    public <T> Uri k(Class<T> cls) {
        return this.bKQ.get(cls);
    }
}
