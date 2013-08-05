package com.baidu.adp.lib.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f364a;
    private String b;
    private int c;
    private Map d = new HashMap();

    public f e() {
        if (this.d.isEmpty()) {
            return null;
        }
        try {
            return (f) this.d.values().iterator().next();
        } catch (Exception e) {
            return null;
        }
    }

    public e(c cVar, String str, int i, b bVar, f fVar) {
        this.f364a = cVar;
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
            bVar.a(this.b, (f) this.d.get(bVar));
            bVar.a();
            bVar.c(this.b, (f) this.d.get(bVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Object a(String... strArr) {
        g a2;
        if (c.a(this.f364a) == null || (a2 = c.a(this.f364a, this.c)) == null) {
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
        for (Map.Entry entry : this.d.entrySet()) {
            b bVar = (b) entry.getKey();
            f fVar = (f) entry.getValue();
            if (!bVar.b()) {
                bVar.a(this.b, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        for (Map.Entry entry : this.d.entrySet()) {
            b bVar = (b) entry.getKey();
            f fVar = (f) entry.getValue();
            if (!bVar.b()) {
                bVar.b(this.b, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Object obj) {
        for (Map.Entry entry : this.d.entrySet()) {
            b bVar = (b) entry.getKey();
            f fVar = (f) entry.getValue();
            if (!bVar.b()) {
                bVar.a(obj, this.b, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b(Object... objArr) {
        for (Map.Entry entry : this.d.entrySet()) {
            b bVar = (b) entry.getKey();
            f fVar = (f) entry.getValue();
            if (!bVar.b()) {
                bVar.a(objArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        for (Map.Entry entry : this.d.entrySet()) {
            b bVar = (b) entry.getKey();
            f fVar = (f) entry.getValue();
            if (!bVar.b()) {
                bVar.c(this.b, fVar);
            }
        }
    }
}
