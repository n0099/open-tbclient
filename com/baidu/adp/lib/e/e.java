package com.baidu.adp.lib.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class e extends BdAsyncTask<String, Object, Object> {
    final /* synthetic */ c a;
    private final String b;
    private final int c;
    private final Map<b, f> d = new HashMap();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Object a(String... strArr) {
        g a;
        if (c.a(this.a) == null || (a = c.a(this.a, this.c)) == null) {
            return null;
        }
        Object a2 = a.a(this.b, this);
        return a2 == null ? a.b(this.b, this) : a2;
    }

    public final f d() {
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

    public final void a(b bVar, f fVar) {
        this.d.put(bVar, fVar);
    }

    public final void d(Object... objArr) {
        c(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(b bVar) {
        if (bVar != null) {
            bVar.a(this.b, this.d.get(bVar));
            bVar.a();
            bVar.b(this.b, this.d.get(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void a() {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            b key = entry.getKey();
            f value = entry.getValue();
            if (!key.b()) {
                key.a(this.b, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            entry.getValue();
            if (!entry.getKey().b()) {
                String str = this.b;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void a(Object obj) {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            b key = entry.getKey();
            f value = entry.getValue();
            if (!key.b()) {
                key.a(obj, this.b, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b(Object... objArr) {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            b key = entry.getKey();
            entry.getValue();
            if (!key.b()) {
                key.a(objArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        for (Map.Entry<b, f> entry : this.d.entrySet()) {
            b key = entry.getKey();
            f value = entry.getValue();
            if (!key.b()) {
                key.b(this.b, value);
            }
        }
    }
}
