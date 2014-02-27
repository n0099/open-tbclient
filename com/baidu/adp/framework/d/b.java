package com.baidu.adp.framework.d;

import com.baidu.adp.framework.controller.HttpRule;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.e;
import com.baidu.adp.framework.task.HttpMessageTask;
/* loaded from: classes.dex */
public final class b extends c<HttpMessage, HttpMessageTask, HttpRule, com.baidu.adp.framework.message.c> {
    private com.baidu.adp.framework.a.d c;

    @Override // com.baidu.adp.framework.a
    public final /* synthetic */ void a(e eVar, com.baidu.adp.framework.task.b bVar) {
        HttpMessage httpMessage = (HttpMessage) eVar;
        HttpMessageTask httpMessageTask = (HttpMessageTask) bVar;
        if (httpMessageTask.g() == null) {
            httpMessageTask.a(((com.baidu.adp.framework.e.b) this.b).b());
        }
        this.c.a(httpMessage, httpMessageTask);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.e, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.e' to match base method */
    @Override // com.baidu.adp.framework.d.c
    public final /* synthetic */ HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return this.a.b().a(httpMessage, httpMessageTask);
    }

    public b(com.baidu.adp.framework.c cVar) {
        super(cVar);
        this.c = null;
        this.c = new com.baidu.adp.framework.a.d(cVar);
        this.b = com.baidu.adp.framework.e.b.a();
    }

    public final boolean a(int i) {
        if (i == 0) {
            return false;
        }
        com.baidu.adp.framework.a.d dVar = this.c;
        com.baidu.adp.framework.a.d.a(i);
        return true;
    }
}
