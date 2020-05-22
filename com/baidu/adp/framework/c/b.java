package com.baidu.adp.framework.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b extends c<HttpMessage, HttpMessageTask, com.baidu.adp.framework.b.d, HttpResponsedMessage> {
    private HttpClient HG;

    public b(MessageManager messageManager) {
        super(messageManager);
        this.HG = null;
        this.HG = new HttpClient(messageManager);
        this.HH = com.baidu.adp.framework.d.b.jJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask.getConnectTimeOut() == null) {
            httpMessageTask.setConnectTimeOut(((com.baidu.adp.framework.d.b) this.HH).jK());
        }
        this.HG.a(httpMessage, httpMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.c.c
    /* renamed from: c */
    public HttpMessage b(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return httpMessage;
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.HG.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.HG.removeMessage(i, bdUniqueId);
    }

    public LinkedList<HttpMessage> a(BdUniqueId bdUniqueId) {
        return this.HG.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<HttpMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.HG.findMessage(i, bdUniqueId);
    }
}
