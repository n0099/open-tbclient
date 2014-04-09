package com.baidu.adp.framework.d;

import com.baidu.adp.framework.b.f;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class b extends c<HttpMessage, HttpMessageTask, f, HttpResponsedMessage> {
    private com.baidu.adp.framework.a.d c;

    @Override // com.baidu.adp.framework.a
    public final /* synthetic */ void a(com.baidu.adp.framework.message.d dVar, com.baidu.adp.framework.task.b bVar) {
        HttpMessage httpMessage = (HttpMessage) dVar;
        HttpMessageTask httpMessageTask = (HttpMessageTask) bVar;
        if (httpMessageTask.g() == null) {
            httpMessageTask.a(((com.baidu.adp.framework.e.b) this.b).b());
        }
        this.c.a(httpMessage, httpMessageTask);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.d, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.d' to match base method */
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

    public final LinkedList<HttpMessage> a(int i) {
        if (i == 0) {
            return null;
        }
        return this.c.a(i);
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<HttpMessage> a(int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        return this.c.a(i, i2);
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<HttpMessage> b(int i, int i2) {
        return this.c.b(i, i2);
    }
}
