package com.baidu.adp.framework.a;

import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<String, String, com.baidu.adp.framework.message.b<?>> {
    final /* synthetic */ b a;
    private com.baidu.adp.framework.message.a b;
    private CustomMessageTask c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.adp.framework.message.b<?> a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.adp.framework.message.b<?> bVar) {
        com.baidu.adp.framework.message.b<?> bVar2 = bVar;
        if (bVar2 == null) {
            com.baidu.adp.lib.util.e.b("CustomTask :" + this.c.getClass().getName() + "returns a NULL!!");
            return;
        }
        bVar2.a(this.b);
        this.a.a.a(bVar2);
    }

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

    private com.baidu.adp.framework.message.b d() {
        if (this.c == null || this.b == null) {
            return null;
        }
        if (this.c.a() == null) {
            com.baidu.adp.lib.util.e.b("CustomTask :" + this.c.getClass().getName() + "did not contain a runnable!!");
            return null;
        }
        try {
            return this.c.a().a(this.b);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(e.getMessage());
            return null;
        }
    }
}
