package com.baidu.live.adp.framework.manager;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.socket.SocketClient;
import com.baidu.live.adp.framework.controller.SocketRule;
import com.baidu.live.adp.framework.message.SocketMessage;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.adp.framework.settings.SocketTaskSetting;
import com.baidu.live.adp.framework.task.SocketMessageTask;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class SocketManager extends Manager<SocketMessage, SocketMessageTask, SocketRule, SocketResponsedMessage> {
    private SocketClient mClient;

    public SocketManager(MessageManager messageManager) {
        super(messageManager);
        this.mClient = null;
        this.mClient = new SocketClient(messageManager);
        this.mMessageSetting = SocketTaskSetting.getInstance();
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(BdUniqueId bdUniqueId) {
        this.mClient.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.mClient.removeMessage(i, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.mClient.sendMessage(socketMessage, socketMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.manager.Manager
    public SocketMessage processRule(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.mMessageManager.getController().rule(socketMessage, socketMessageTask);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<SocketMessage> findMessage(BdUniqueId bdUniqueId) {
        return this.mClient.findMessage(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
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

    public SocketClient getSocketClient() {
        return this.mClient;
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
