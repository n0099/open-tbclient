package com.baidu.adp.framework.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends c<CustomMessage<?>, CustomMessageTask, com.baidu.adp.framework.b.b, CustomResponsedMessage<?>> {
    private com.baidu.adp.framework.client.b Ig;

    public a(MessageManager messageManager) {
        super(messageManager);
        this.Ig = null;
        this.Ig = new com.baidu.adp.framework.client.b(messageManager);
        this.Ii = com.baidu.adp.framework.d.a.jY();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        this.Ig.a((CustomMessage) customMessage, customMessageTask);
    }

    public <T> CustomResponsedMessage<T> a(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        return this.Ig.a(customMessage, customMessageTask, cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.c.c
    /* renamed from: c */
    public CustomMessage<?> b(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return this.Hm.getController().b(customMessage, customMessageTask);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.Ig.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.Ig.removeMessage(i, bdUniqueId);
    }

    public LinkedList<CustomMessage<?>> a(BdUniqueId bdUniqueId) {
        return this.Ig.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<CustomMessage<?>> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.Ig.findMessage(i, bdUniqueId);
    }
}
