package com.baidu.adp.framework.a;

import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, com.baidu.adp.framework.message.b<?>> {
    final /* synthetic */ b a;
    private com.baidu.adp.framework.message.a b;
    private CustomMessageTask c;

    public c(b bVar, com.baidu.adp.framework.message.a aVar, CustomMessageTask customMessageTask) {
        this.a = bVar;
        this.b = null;
        this.c = null;
        setPriority(customMessageTask.l());
        setTag(aVar.e());
        setKey(String.valueOf(customMessageTask.i()));
        setImmediatelyExecut(customMessageTask.d());
        this.b = aVar;
        this.c = customMessageTask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.adp.framework.message.b a(String... strArr) {
        if (this.c == null || this.b == null) {
            return null;
        }
        if (this.c.a() == null) {
            com.baidu.adp.lib.util.f.b("CustomTask :" + this.c.getClass().getName() + "did not contain a runnable!!");
            return null;
        }
        try {
            return this.c.a().a(this.b);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.adp.framework.message.b<?> bVar) {
        if (bVar != null) {
            bVar.a(this.b);
            this.a.a.a(bVar);
            return;
        }
        com.baidu.adp.lib.util.f.b("CustomTask :" + this.c.getClass().getName() + "returns a NULL!!");
    }
}
