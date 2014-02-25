package com.baidu.adp.framework.d;

import com.baidu.adp.framework.controller.HttpRule;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
/* loaded from: classes.dex */
public class b extends c<HttpMessage, HttpMessageTask, HttpRule, com.baidu.adp.framework.message.c> {
    private com.baidu.adp.framework.a.d c;

    public b(com.baidu.adp.framework.c cVar) {
        super(cVar);
        this.c = null;
        this.c = new com.baidu.adp.framework.a.d(cVar);
        this.b = com.baidu.adp.framework.e.b.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask.g() == null) {
            httpMessageTask.a(((com.baidu.adp.framework.e.b) this.b).b());
        }
        this.c.a(httpMessage, httpMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.d.c
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return this.a.b().a(httpMessage, httpMessageTask);
    }

    public boolean a(int i) {
        if (i == 0) {
            return false;
        }
        this.c.a(i);
        return true;
    }
}
