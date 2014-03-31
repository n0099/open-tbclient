package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends BdAsyncTask<HttpMessage, HttpResponsedMessage, HttpResponsedMessage> {
    final /* synthetic */ d a;
    private HttpMessage b;
    private HttpMessageTask c;
    private com.baidu.adp.lib.network.http.e d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ HttpResponsedMessage a(HttpMessage... httpMessageArr) {
        return e();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        this.a.a.a(httpResponsedMessage);
    }

    public final HttpMessage a() {
        return this.b;
    }

    public f(d dVar, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        this.a = dVar;
        this.b = null;
        this.c = null;
        setPriority(httpMessageTask.l());
        setImmediatelyExecut(httpMessageTask.e());
        setTag(httpMessage.f());
        setParallelTag(httpMessageTask.i());
        setKey(String.valueOf(httpMessageTask.i()));
        setType(httpMessageTask.h());
        this.b = httpMessage;
        this.c = httpMessageTask;
        this.d = new com.baidu.adp.lib.network.http.e();
    }

    private HttpResponsedMessage e() {
        List<Map.Entry<String, Object>> d = this.b.d();
        this.d.a().a(this.c.a());
        this.d.a().a(this.c.c());
        this.d.a().a(this.b.b());
        this.d.a().a(d);
        int a = this.c.j().a();
        int a2 = this.c.g().a();
        int k = this.c.k();
        try {
            com.baidu.adp.lib.network.http.c cVar = new com.baidu.adp.lib.network.http.c(this.d);
            if (this.c.c() == HttpMessageTask.HTTP_METHOD.GET) {
                cVar.a(k, a, a2);
            } else if (this.c.c() == HttpMessageTask.HTTP_METHOD.POST) {
                cVar.b(k, a, a2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.adp.lib.util.f.b(e.toString());
        }
        try {
            HttpResponsedMessage newInstance = this.c.f().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.b.e()));
            newInstance.a(this.b);
            String str = "";
            if (this.d.c().size() > 0) {
                str = this.d.c().get(this.d.c().size() - 1).h;
            }
            newInstance.a(this.d.b().b, str);
            newInstance.a(this.d.b().f);
            newInstance.a(this.d.b().c);
            newInstance.c(this.d.b().e);
            newInstance.b(this.d.b().d);
            newInstance.a(this.b.e(), this.d);
            if (newInstance.c()) {
                try {
                    newInstance.a(this.b.e(), (int) this.d.b().g);
                    newInstance.b(this.b.e(), this.d.b().g);
                    return newInstance;
                } catch (Exception e2) {
                    newInstance.a(-1003);
                    e2.printStackTrace();
                    com.baidu.adp.lib.util.f.b(e2.toString());
                    return newInstance;
                }
            }
            return newInstance;
        } catch (Exception e3) {
            e3.printStackTrace();
            com.baidu.adp.lib.util.f.b("responsedMessage create error reason = " + e3.toString());
            return new e(this.b.e(), this.b);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.d != null) {
            this.d.b().a = true;
        }
    }
}
