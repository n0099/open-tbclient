package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> blH;
    private ConcurrentHashMap<Class<?>, Uri> blI;

    private void RA() {
        this.blH = new ConcurrentHashMap<>();
        this.blI = new ConcurrentHashMap<>();
        this.blH.put(com.baidu.swan.pms.model.g.class, new f());
        this.blH.put(i.class, new g());
        this.blH.put(com.baidu.swan.pms.model.e.class, new e());
        this.blH.put(com.baidu.swan.pms.model.c.class, new d());
        this.blH.put(com.baidu.swan.pms.model.a.class, new a());
        this.blI.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.blN);
        this.blI.put(i.class, com.baidu.swan.pms.database.provider.b.auK);
        this.blI.put(com.baidu.swan.pms.model.e.class, com.baidu.swan.pms.database.provider.b.blL);
        this.blI.put(com.baidu.swan.pms.model.c.class, com.baidu.swan.pms.database.provider.b.blO);
        this.blI.put(com.baidu.swan.pms.model.a.class, com.baidu.swan.pms.database.provider.b.blM);
    }

    public c() {
        RA();
    }

    public <T> b<T> m(Class<T> cls) {
        return this.blH.get(cls);
    }

    public <T> Uri n(Class<T> cls) {
        return this.blI.get(cls);
    }
}
