package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.h;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> bLG;
    private ConcurrentHashMap<Class<?>, Uri> bLH;

    private void aaZ() {
        this.bLG = new ConcurrentHashMap<>();
        this.bLH = new ConcurrentHashMap<>();
        this.bLG.put(com.baidu.swan.pms.model.f.class, new f());
        this.bLG.put(h.class, new g());
        this.bLG.put(com.baidu.swan.pms.model.d.class, new e());
        this.bLG.put(com.baidu.swan.pms.model.b.class, new d());
        this.bLG.put(PMSAppInfo.class, new a());
        this.bLH.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.bLM);
        this.bLH.put(h.class, com.baidu.swan.pms.database.provider.b.aPt);
        this.bLH.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.bLK);
        this.bLH.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.bLN);
        this.bLH.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.bLL);
    }

    public c() {
        aaZ();
    }

    public <T> b<T> j(Class<T> cls) {
        return this.bLG.get(cls);
    }

    public <T> Uri k(Class<T> cls) {
        return this.bLH.get(cls);
    }
}
