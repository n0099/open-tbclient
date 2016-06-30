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
    private HttpClient gi;

    public b(MessageManager messageManager) {
        super(messageManager);
        this.gi = null;
        this.gi = new HttpClient(messageManager);
        this.gm = com.baidu.adp.framework.c.b.br();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask.getConnectTimeOut() == null) {
            httpMessageTask.setConnectTimeOut(((com.baidu.adp.framework.c.b) this.gm).bs());
        }
        this.gi.a(httpMessage, httpMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    /* renamed from: c */
    public HttpMessage d(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return this.ea.getController().b(httpMessage, httpMessageTask);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.gi.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.gi.removeMessage(i, bdUniqueId);
    }

    public LinkedList<HttpMessage> a(BdUniqueId bdUniqueId) {
        return this.gi.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<HttpMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.gi.findMessage(i, bdUniqueId);
    }
}
