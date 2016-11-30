package com.baidu.adp.framework.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b extends c<HttpMessage, HttpMessageTask, com.baidu.adp.framework.a.d, HttpResponsedMessage> {
    private HttpClient je;

    public b(MessageManager messageManager) {
        super(messageManager);
        this.je = null;
        this.je = new HttpClient(messageManager);
        this.ji = com.baidu.adp.framework.c.b.cl();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask.getConnectTimeOut() == null) {
            httpMessageTask.setConnectTimeOut(((com.baidu.adp.framework.c.b) this.ji).cm());
        }
        this.je.a(httpMessage, httpMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    /* renamed from: c */
    public HttpMessage d(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return this.gQ.getController().b(httpMessage, httpMessageTask);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.je.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.je.removeMessage(i, bdUniqueId);
    }

    public LinkedList<HttpMessage> a(BdUniqueId bdUniqueId) {
        return this.je.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<HttpMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.je.findMessage(i, bdUniqueId);
    }
}
