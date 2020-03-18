package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> cAX;
    private ConcurrentHashMap<Class<?>, Uri> cAY;

    private void atB() {
        this.cAX = new ConcurrentHashMap<>();
        this.cAY = new ConcurrentHashMap<>();
        this.cAX.put(com.baidu.swan.pms.model.f.class, new f());
        this.cAX.put(com.baidu.swan.pms.model.g.class, new g());
        this.cAX.put(com.baidu.swan.pms.model.d.class, new e());
        this.cAX.put(com.baidu.swan.pms.model.b.class, new d());
        this.cAX.put(PMSAppInfo.class, new a());
        this.cAX.put(com.baidu.swan.pms.model.h.class, new h());
        this.cAX.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.b());
        this.cAY.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.cBd);
        this.cAY.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.cBe);
        this.cAY.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.cBb);
        this.cAY.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.cBf);
        this.cAY.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.cBc);
        this.cAY.put(com.baidu.swan.pms.model.h.class, com.baidu.swan.pms.database.provider.b.cBg);
        this.cAY.put(com.baidu.swan.pms.b.a.class, com.baidu.swan.pms.database.provider.b.cBh);
    }

    public c() {
        atB();
    }

    public <T> b<T> q(Class<T> cls) {
        return this.cAX.get(cls);
    }

    public <T> Uri r(Class<T> cls) {
        return this.cAY.get(cls);
    }
}
