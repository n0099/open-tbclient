package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
    final /* synthetic */ b a;
    private com.baidu.adp.framework.message.a b;
    private CustomMessageTask c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ CustomResponsedMessage<?> a(String... strArr) {
        return e();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null) {
            com.baidu.adp.lib.util.f.b("CustomTask :" + this.c.getClass().getName() + "returns a NULL!!");
            return;
        }
        customResponsedMessage2.a(this.b);
        this.a.a.a(customResponsedMessage2);
    }

    public final com.baidu.adp.framework.message.a a() {
        return this.b;
    }

    public c(b bVar, com.baidu.adp.framework.message.a aVar, CustomMessageTask customMessageTask) {
        this.a = bVar;
        this.b = null;
        this.c = null;
        setPriority(customMessageTask.l());
        setTag(aVar.f());
        setKey(String.valueOf(customMessageTask.i()));
        setImmediatelyExecut(customMessageTask.d());
        this.b = aVar;
        this.c = customMessageTask;
    }

    private CustomResponsedMessage e() {
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
}
