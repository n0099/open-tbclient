package com.baidu.baiduarsdk.filter;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class e {
    private static volatile e f;
    private com.baidu.baiduarsdk.filter.a a;
    private Map<Integer, com.baidu.baiduarsdk.filter.a> b = new HashMap();
    private com.baidu.baiduarsdk.filter.configdata.c c;
    private String d;
    private String e;

    /* loaded from: classes3.dex */
    public interface a<T> {
        void a(T t);
    }

    private e() {
    }

    public static e a() {
        if (f == null) {
            synchronized (e.class) {
                if (f == null) {
                    f = new e();
                }
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.baiduarsdk.filter.a aVar, a<com.baidu.baiduarsdk.filter.a> aVar2) {
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public static void b() {
        synchronized (e.class) {
            f = null;
        }
    }

    public com.baidu.baiduarsdk.filter.a a(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(String str, final a<com.baidu.baiduarsdk.filter.a> aVar) {
        if (TextUtils.isEmpty(str)) {
            a((com.baidu.baiduarsdk.filter.a) null, aVar);
            return;
        }
        this.e = str;
        new b(new a<com.baidu.baiduarsdk.filter.configdata.c>() { // from class: com.baidu.baiduarsdk.filter.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.baiduarsdk.filter.e.a
            public void a(com.baidu.baiduarsdk.filter.configdata.c cVar) {
                if (cVar == null || cVar.equals(e.this.c)) {
                    e.this.a((com.baidu.baiduarsdk.filter.a) null, aVar);
                    return;
                }
                e.this.c = cVar;
                if (e.this.c.b() == null || e.this.c.b().size() == 0) {
                    e.this.a((com.baidu.baiduarsdk.filter.a) null, aVar);
                    return;
                }
                c cVar2 = new c(new a<Map<Integer, com.baidu.baiduarsdk.filter.a>>() { // from class: com.baidu.baiduarsdk.filter.e.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.baiduarsdk.filter.e.a
                    public void a(Map<Integer, com.baidu.baiduarsdk.filter.a> map) {
                        if (map == null || map.size() == 0) {
                            e.this.a((com.baidu.baiduarsdk.filter.a) null, aVar);
                            return;
                        }
                        e.this.b.putAll(map);
                        e.this.c.a();
                        e.this.a = (com.baidu.baiduarsdk.filter.a) e.this.b.get(Integer.valueOf(e.this.c.a()));
                        e.this.a(e.this.a, aVar);
                    }
                });
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(e.this.c.b().values());
                cVar2.execute(arrayList);
            }
        }).execute(this.d, this.e);
    }

    public void c() {
        this.a = null;
        this.b.clear();
        this.c = null;
        this.d = null;
        this.e = null;
    }
}
