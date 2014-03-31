package com.baidu.adp.lib.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class d extends BdAsyncTask<String, Object, Object> {
    protected final Map<a, e> a = new HashMap();
    final /* synthetic */ b b;
    private final String c;
    private final int d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Object a(String... strArr) {
        f a;
        a = this.b.a(this.d);
        if (a == null) {
            return null;
        }
        Object fromLocal = a.getFromLocal(this.c, this);
        return fromLocal == null ? a.getFromRemote(this.c, this) : fromLocal;
    }

    public d(b bVar, String str, int i, a aVar, e eVar) {
        this.b = bVar;
        this.c = str;
        this.d = i;
        this.a.put(aVar, eVar);
    }

    public final void d(Object... objArr) {
        c(objArr);
    }

    public final e a() {
        if (this.a.isEmpty()) {
            return null;
        }
        try {
            return this.a.values().iterator().next();
        } catch (Exception e) {
            return null;
        }
    }

    public final void a(a aVar, e eVar) {
        this.a.put(aVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(a aVar) {
        if (aVar != null) {
            aVar.a(this.c, this.a.get(aVar));
            aVar.a();
            aVar.b(this.c, this.a.get(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        for (Map.Entry<a, e> entry : this.a.entrySet()) {
            a key = entry.getKey();
            e value = entry.getValue();
            if (!key.b()) {
                key.a(this.c, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        for (Map.Entry<a, e> entry : this.a.entrySet()) {
            entry.getValue();
            if (!entry.getKey().b()) {
                String str = this.c;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void a(Object obj) {
        for (Map.Entry<a, e> entry : this.a.entrySet()) {
            a key = entry.getKey();
            e value = entry.getValue();
            if (!key.b()) {
                key.a(obj, this.c, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b(Object... objArr) {
        for (Map.Entry<a, e> entry : this.a.entrySet()) {
            a key = entry.getKey();
            if (!key.b()) {
                key.a(objArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        for (Map.Entry<a, e> entry : this.a.entrySet()) {
            a key = entry.getKey();
            e value = entry.getValue();
            if (!key.b()) {
                key.b(this.c, value);
            }
        }
    }
}
