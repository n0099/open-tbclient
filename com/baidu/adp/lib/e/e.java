package com.baidu.adp.lib.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class e extends BdAsyncTask<String, Object, Object> {
    protected final Map<b, h> a = new HashMap();
    final /* synthetic */ c b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Object a(String... strArr) {
        return d();
    }

    public e(c cVar) {
        this.b = cVar;
    }

    protected Object d() {
        return null;
    }

    public final void d(Object... objArr) {
        c(objArr);
    }

    public final h e() {
        if (this.a.isEmpty()) {
            return null;
        }
        try {
            return this.a.values().iterator().next();
        } catch (Exception e) {
            return null;
        }
    }
}
