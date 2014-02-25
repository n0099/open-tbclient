package com.baidu.adp.lib.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class e extends BdAsyncTask<String, Object, Object> {
    protected final Map<b, h> a = new HashMap();
    final /* synthetic */ c b;

    public e(c cVar) {
        this.b = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Object a(String... strArr) {
        return null;
    }

    public void d(Object... objArr) {
        c(objArr);
    }

    public h e() {
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
