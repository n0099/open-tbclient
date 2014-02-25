package com.baidu.adp.lib.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends e {
    final /* synthetic */ c c;
    private final String d;
    private final int e;
    private g f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c cVar, String str, int i, b bVar, h hVar) {
        super(cVar);
        this.c = cVar;
        this.d = str;
        this.e = i;
        this.a.put(bVar, hVar);
        setTaskMaxTime(300);
        setNeedImmediatelyCancel(true);
        setParallelTag(1);
        setPriority(2);
        setType(BdAsyncTaskParallelType.SERIAL);
    }

    public void a(b bVar, h hVar) {
        this.a.put(bVar, hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
        if (bVar != null) {
            bVar.a(this.d, this.a.get(bVar));
            bVar.a();
            bVar.c(this.d, this.a.get(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        r1 = r3.c.a(r3.e);
     */
    @Override // com.baidu.adp.lib.e.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String... strArr) {
        a aVar;
        i a;
        aVar = this.c.a;
        if (aVar == null || a == null) {
            return null;
        }
        return a.a(this.d, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a() {
        for (Map.Entry<b, h> entry : this.a.entrySet()) {
            b key = entry.getKey();
            h value = entry.getValue();
            if (!key.b()) {
                key.a(this.d, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        for (Map.Entry<b, h> entry : this.a.entrySet()) {
            b key = entry.getKey();
            h value = entry.getValue();
            if (!key.b()) {
                key.b(this.d, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Object obj) {
        for (Map.Entry<b, h> entry : this.a.entrySet()) {
            b key = entry.getKey();
            h value = entry.getValue();
            if (obj == null && !key.b()) {
                b(key, value);
            } else if (!key.b()) {
                key.a(obj, this.d, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b(Object... objArr) {
        for (Map.Entry<b, h> entry : this.a.entrySet()) {
            b key = entry.getKey();
            entry.getValue();
            if (!key.b()) {
                key.a(objArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        for (Map.Entry<b, h> entry : this.a.entrySet()) {
            b key = entry.getKey();
            h value = entry.getValue();
            if (getIsTimeout()) {
                b(key, value);
            } else if (!key.b()) {
                key.c(this.d, value);
            } else {
                f();
            }
        }
    }

    private void f() {
        if (this.f != null) {
            this.f.cancel();
        }
    }

    private void b(b bVar, h hVar) {
        if (this.f == null) {
            this.f = new g(this.c, this.d, this.e, bVar, hVar);
            this.f.execute(new String[0]);
        }
    }
}
