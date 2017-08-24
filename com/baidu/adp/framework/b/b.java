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
    private HttpClient sd;

    public b(MessageManager messageManager) {
        super(messageManager);
        this.sd = null;
        this.sd = new HttpClient(messageManager);
        this.sh = com.baidu.adp.framework.c.b.dC();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask.getConnectTimeOut() == null) {
            httpMessageTask.setConnectTimeOut(((com.baidu.adp.framework.c.b) this.sh).dD());
        }
        this.sd.a(httpMessage, httpMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    /* renamed from: c */
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return this.pT.getController().b(httpMessage, httpMessageTask);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.sd.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.sd.removeMessage(i, bdUniqueId);
    }

    public LinkedList<HttpMessage> a(BdUniqueId bdUniqueId) {
        return this.sd.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<HttpMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.sd.findMessage(i, bdUniqueId);
    }
}
