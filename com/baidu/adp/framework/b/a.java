package com.baidu.adp.framework.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends c<CustomMessage<?>, CustomMessageTask, com.baidu.adp.framework.a.b, CustomResponsedMessage<?>> {
    private com.baidu.adp.framework.client.b qq;

    public a(MessageManager messageManager) {
        super(messageManager);
        this.qq = null;
        this.qq = new com.baidu.adp.framework.client.b(messageManager);
        this.qv = com.baidu.adp.framework.c.a.eY();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    /* renamed from: a */
    public void sendMessage(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        this.qq.sendMessage(customMessage, customMessageTask);
    }

    public <T> CustomResponsedMessage<T> a(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        return this.qq.a(customMessage, customMessageTask, cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    public CustomMessage<?> c(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return this.og.getController().b(customMessage, customMessageTask);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.qq.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.qq.removeMessage(i, bdUniqueId);
    }

    public LinkedList<CustomMessage<?>> a(BdUniqueId bdUniqueId) {
        return this.qq.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<CustomMessage<?>> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.qq.findMessage(i, bdUniqueId);
    }
}
