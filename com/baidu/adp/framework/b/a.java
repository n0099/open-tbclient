package com.baidu.adp.framework.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends c<CustomMessage<?>, CustomMessageTask, com.baidu.adp.framework.a.b, CustomResponsedMessage<?>> {
    private com.baidu.adp.framework.client.b c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // com.baidu.adp.framework.b.c
    public /* bridge */ /* synthetic */ CustomMessage<?> b(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return b2((CustomMessage) customMessage, customMessageTask);
    }

    public a(MessageManager messageManager) {
        super(messageManager);
        this.c = null;
        this.c = new com.baidu.adp.framework.client.b(messageManager);
        this.b = com.baidu.adp.framework.c.a.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        this.c.a(customMessage, customMessageTask);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public CustomMessage b2(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        return this.a.getController().a(customMessage, customMessageTask);
    }

    public void a(BdUniqueId bdUniqueId) {
        this.c.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void a(int i, BdUniqueId bdUniqueId) {
        this.c.a(i, bdUniqueId);
    }

    public LinkedList<CustomMessage<?>> b(BdUniqueId bdUniqueId) {
        return this.c.b(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<CustomMessage<?>> b(int i, BdUniqueId bdUniqueId) {
        return this.c.b(i, bdUniqueId);
    }
}
