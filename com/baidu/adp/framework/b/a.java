package com.baidu.adp.framework.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends c<CustomMessage<?>, CustomMessageTask, com.baidu.adp.framework.a.b, CustomResponsedMessage<?>> {
    private com.baidu.adp.framework.client.b eN;

    public a(MessageManager messageManager) {
        super(messageManager);
        this.eN = null;
        this.eN = new com.baidu.adp.framework.client.b(messageManager);
        this.eS = com.baidu.adp.framework.c.a.bv();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    /* renamed from: a */
    public void sendMessage(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        this.eN.sendMessage(customMessage, customMessageTask);
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessageTask customMessageTask, Class<T> cls) {
        return this.eN.runTask(customMessageTask, cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    public CustomMessage<?> c(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return this.cN.getController().b(customMessage, customMessageTask);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.eN.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.eN.removeMessage(i, bdUniqueId);
    }

    public LinkedList<CustomMessage<?>> a(BdUniqueId bdUniqueId) {
        return this.eN.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<CustomMessage<?>> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.eN.findMessage(i, bdUniqueId);
    }
}
