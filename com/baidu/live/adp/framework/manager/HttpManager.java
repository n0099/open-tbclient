package com.baidu.live.adp.framework.manager;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.HttpClient;
import com.baidu.live.adp.framework.controller.HttpRule;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.settings.HttpTaskSetting;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class HttpManager extends Manager<HttpMessage, HttpMessageTask, HttpRule, HttpResponsedMessage> {
    private HttpClient mClient;

    public HttpManager(MessageManager messageManager) {
        super(messageManager);
        this.mClient = null;
        this.mClient = new HttpClient(messageManager);
        this.mMessageSetting = HttpTaskSetting.getInstance();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void sendMessage(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask.getConnectTimeOut() == null) {
            httpMessageTask.setConnectTimeOut(((HttpTaskSetting) this.mMessageSetting).getConnectTimeOutData());
        }
        this.mClient.sendMessage(httpMessage, httpMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.manager.Manager
    public HttpMessage processRule(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return this.mMessageManager.getController().rule(httpMessage, httpMessageTask);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(BdUniqueId bdUniqueId) {
        this.mClient.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.mClient.removeMessage(i, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<HttpMessage> findMessage(BdUniqueId bdUniqueId) {
        return this.mClient.findMessage(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<HttpMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.mClient.findMessage(i, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeWaitingMessage(BdUniqueId bdUniqueId) {
        this.mClient.removeWaitingMessage(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeWaitingMessage(int i, BdUniqueId bdUniqueId) {
        this.mClient.removeWaitingMessage(i, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public boolean haveMessage(BdUniqueId bdUniqueId) {
        return this.mClient.haveMessage(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public boolean haveMessage(int i, BdUniqueId bdUniqueId) {
        return this.mClient.haveMessage(i, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public int getMessageNum(BdUniqueId bdUniqueId) {
        return this.mClient.getMessageNum(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public int getMessageNum(int i, BdUniqueId bdUniqueId) {
        return this.mClient.getMessageNum(i, bdUniqueId);
    }
}
