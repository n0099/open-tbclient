package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> blD;
    private ConcurrentHashMap<Class<?>, Uri> blE;

    private void RC() {
        this.blD = new ConcurrentHashMap<>();
        this.blE = new ConcurrentHashMap<>();
        this.blD.put(com.baidu.swan.pms.model.g.class, new f());
        this.blD.put(i.class, new g());
        this.blD.put(com.baidu.swan.pms.model.e.class, new e());
        this.blD.put(com.baidu.swan.pms.model.c.class, new d());
        this.blD.put(com.baidu.swan.pms.model.a.class, new a());
        this.blE.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.blJ);
        this.blE.put(i.class, com.baidu.swan.pms.database.provider.b.auG);
        this.blE.put(com.baidu.swan.pms.model.e.class, com.baidu.swan.pms.database.provider.b.blH);
        this.blE.put(com.baidu.swan.pms.model.c.class, com.baidu.swan.pms.database.provider.b.blK);
        this.blE.put(com.baidu.swan.pms.model.a.class, com.baidu.swan.pms.database.provider.b.blI);
    }

    public c() {
        RC();
    }

    public <T> b<T> m(Class<T> cls) {
        return this.blD.get(cls);
    }

    public <T> Uri n(Class<T> cls) {
        return this.blE.get(cls);
    }
}
