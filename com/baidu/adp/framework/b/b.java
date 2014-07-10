package com.baidu.adp.framework.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b extends c<HttpMessage, HttpMessageTask, com.baidu.adp.framework.a.d, HttpResponsedMessage> {
    private HttpClient c;

    public b(MessageManager messageManager) {
        super(messageManager);
        this.c = null;
        this.c = new HttpClient(messageManager);
        this.b = com.baidu.adp.framework.c.b.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask.getConnectTimeOut() == null) {
            httpMessageTask.setConnectTimeOut(((com.baidu.adp.framework.c.b) this.b).b());
        }
        this.c.a(httpMessage, httpMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return this.a.getController().a(httpMessage, httpMessageTask);
    }

    public void a(int i) {
        this.c.a(i);
    }

    @Override // com.baidu.adp.framework.a
    public void a(int i, int i2) {
        this.c.a(i, i2);
    }

    public LinkedList<HttpMessage> b(int i) {
        return this.c.b(i);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<HttpMessage> b(int i, int i2) {
        return this.c.b(i, i2);
    }
}
