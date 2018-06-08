package com.baidu.adp.framework.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends c<CustomMessage<?>, CustomMessageTask, com.baidu.adp.framework.a.b, CustomResponsedMessage<?>> {
    private com.baidu.adp.framework.client.b vf;

    public a(MessageManager messageManager) {
        super(messageManager);
        this.vf = null;
        this.vf = new com.baidu.adp.framework.client.b(messageManager);
        this.vk = com.baidu.adp.framework.c.a.fO();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        this.vf.a((CustomMessage) customMessage, customMessageTask);
    }

    public <T> CustomResponsedMessage<T> a(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        return this.vf.a(customMessage, customMessageTask, cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    /* renamed from: c */
    public CustomMessage<?> b(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return this.sQ.getController().b(customMessage, customMessageTask);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.vf.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.vf.removeMessage(i, bdUniqueId);
    }

    public LinkedList<CustomMessage<?>> a(BdUniqueId bdUniqueId) {
        return this.vf.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<CustomMessage<?>> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.vf.findMessage(i, bdUniqueId);
    }
}
