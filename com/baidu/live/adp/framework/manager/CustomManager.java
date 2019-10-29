package com.baidu.live.adp.framework.manager;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.CustomClient;
import com.baidu.live.adp.framework.controller.CustomRule;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.settings.CustomTaskSetting;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class CustomManager extends Manager<CustomMessage<?>, CustomMessageTask, CustomRule, CustomResponsedMessage<?>> {
    private CustomClient mClient;

    public CustomManager(MessageManager messageManager) {
        super(messageManager);
        this.mClient = null;
        this.mClient = new CustomClient(messageManager);
        this.mMessageSetting = CustomTaskSetting.getInstance();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void sendMessage(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        this.mClient.sendMessage((CustomMessage) customMessage, customMessageTask);
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        return this.mClient.runTask(customMessage, customMessageTask, cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.manager.Manager
    public CustomMessage<?> processRule(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return this.mMessageManager.getController().rule(customMessage, customMessageTask);
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
    public LinkedList<CustomMessage<?>> findMessage(BdUniqueId bdUniqueId) {
        return this.mClient.findMessage(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<CustomMessage<?>> findMessage(int i, BdUniqueId bdUniqueId) {
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
