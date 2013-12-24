package com.baidu.adp.lib.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends BdAsyncTask<String, Object, Object> {
    final /* synthetic */ c a;
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
        this.a = cVar;
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
        g a;
        if (c.a(this.a) == null || (a = c.a(this.a, this.c)) == null) {
            return null;
        }
        Object a2 = a.a(this.b, this);
        if (a2 == null) {
            return a.b(this.b, this);
        }
        return a2;
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
