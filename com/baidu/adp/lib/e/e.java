package com.baidu.adp.lib.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends BdAsyncTask<String, Object, Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f481a;
    private String b;
    private int c;
    private Map<b, f> d = new HashMap();

    public f d() {
        if (this.d.isEmpty()) {
            return null;
        }
        try {
            return this.d.values().iterator().next();
        } catch (Exception e) {
            return null;
        }
    }

    public e(c cVar, String str, int i, b bVar, f fVar) {
        this.f481a = cVar;
        this.b = str;
        this.c = i;
        this.d.put(bVar, fVar);
    }

    public void a(b bVar, f fVar) {
        this.d.put(bVar, fVar);
    }

    public void d(Object... objArr) {
        c(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
        if (bVar != null) {
            bVar.a(this.b, this.d.get(bVar));
            bVar.a();
            bVar.c(this.b, this.d.get(bVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Object a(String... strArr) {
        g a2;
        if (c.a(this.f481a) == null || (a2 = c.a(this.f481a, this.c)) == null) {
            return null;
        }
        Object a3 = a2.a(this.b, this);
        if (a3 == null) {
            return a2.b(this.b, this);
        }
        return a3;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    protected void a() {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            b key = entry.getKey();
            f value = entry.getValue();
            if (!key.b()) {
                key.a(this.b, value);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    protected void b() {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            b key = entry.getKey();
            f value = entry.getValue();
            if (!key.b()) {
                key.b(this.b, value);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    protected void a(Object obj) {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            b key = entry.getKey();
            f value = entry.getValue();
            if (!key.b()) {
                key.a(obj, this.b, value);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    protected void b(Object... objArr) {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            b key = entry.getKey();
            entry.getValue();
            if (!key.b()) {
                key.a(objArr);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    protected void c() {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            b key = entry.getKey();
            f value = entry.getValue();
            if (!key.b()) {
                key.c(this.b, value);
            }
        }
    }
}
