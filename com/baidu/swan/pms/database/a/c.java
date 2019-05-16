package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.h;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> brJ;
    private ConcurrentHashMap<Class<?>, Uri> brK;

    private void Vn() {
        this.brJ = new ConcurrentHashMap<>();
        this.brK = new ConcurrentHashMap<>();
        this.brJ.put(com.baidu.swan.pms.model.f.class, new f());
        this.brJ.put(h.class, new g());
        this.brJ.put(com.baidu.swan.pms.model.d.class, new e());
        this.brJ.put(com.baidu.swan.pms.model.b.class, new d());
        this.brJ.put(PMSAppInfo.class, new a());
        this.brK.put(com.baidu.swan.pms.model.f.class, com.baidu.swan.pms.database.provider.b.brP);
        this.brK.put(h.class, com.baidu.swan.pms.database.provider.b.avb);
        this.brK.put(com.baidu.swan.pms.model.d.class, com.baidu.swan.pms.database.provider.b.brN);
        this.brK.put(com.baidu.swan.pms.model.b.class, com.baidu.swan.pms.database.provider.b.brQ);
        this.brK.put(PMSAppInfo.class, com.baidu.swan.pms.database.provider.b.brO);
    }

    public c() {
        Vn();
    }

    public <T> b<T> l(Class<T> cls) {
        return this.brJ.get(cls);
    }

    public <T> Uri m(Class<T> cls) {
        return this.brK.get(cls);
    }
}
