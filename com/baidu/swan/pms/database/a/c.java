package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> blC;
    private ConcurrentHashMap<Class<?>, Uri> blD;

    private void RC() {
        this.blC = new ConcurrentHashMap<>();
        this.blD = new ConcurrentHashMap<>();
        this.blC.put(com.baidu.swan.pms.model.g.class, new f());
        this.blC.put(i.class, new g());
        this.blC.put(com.baidu.swan.pms.model.e.class, new e());
        this.blC.put(com.baidu.swan.pms.model.c.class, new d());
        this.blC.put(com.baidu.swan.pms.model.a.class, new a());
        this.blD.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.blI);
        this.blD.put(i.class, com.baidu.swan.pms.database.provider.b.auF);
        this.blD.put(com.baidu.swan.pms.model.e.class, com.baidu.swan.pms.database.provider.b.blG);
        this.blD.put(com.baidu.swan.pms.model.c.class, com.baidu.swan.pms.database.provider.b.blJ);
        this.blD.put(com.baidu.swan.pms.model.a.class, com.baidu.swan.pms.database.provider.b.blH);
    }

    public c() {
        RC();
    }

    public <T> b<T> m(Class<T> cls) {
        return this.blC.get(cls);
    }

    public <T> Uri n(Class<T> cls) {
        return this.blD.get(cls);
    }
}
