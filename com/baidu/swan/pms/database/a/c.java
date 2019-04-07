package com.baidu.swan.pms.database.a;

import android.net.Uri;
import com.baidu.swan.pms.model.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {
    private ConcurrentHashMap<Class<?>, b> blG;
    private ConcurrentHashMap<Class<?>, Uri> blH;

    private void RA() {
        this.blG = new ConcurrentHashMap<>();
        this.blH = new ConcurrentHashMap<>();
        this.blG.put(com.baidu.swan.pms.model.g.class, new f());
        this.blG.put(i.class, new g());
        this.blG.put(com.baidu.swan.pms.model.e.class, new e());
        this.blG.put(com.baidu.swan.pms.model.c.class, new d());
        this.blG.put(com.baidu.swan.pms.model.a.class, new a());
        this.blH.put(com.baidu.swan.pms.model.g.class, com.baidu.swan.pms.database.provider.b.blM);
        this.blH.put(i.class, com.baidu.swan.pms.database.provider.b.auJ);
        this.blH.put(com.baidu.swan.pms.model.e.class, com.baidu.swan.pms.database.provider.b.blK);
        this.blH.put(com.baidu.swan.pms.model.c.class, com.baidu.swan.pms.database.provider.b.blN);
        this.blH.put(com.baidu.swan.pms.model.a.class, com.baidu.swan.pms.database.provider.b.blL);
    }

    public c() {
        RA();
    }

    public <T> b<T> m(Class<T> cls) {
        return this.blG.get(cls);
    }

    public <T> Uri n(Class<T> cls) {
        return this.blH.get(cls);
    }
}
