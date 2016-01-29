package com.baidu.adp.framework.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.client.socket.h;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends c<SocketMessage, SocketMessageTask, k, SocketResponsedMessage> {
    private h qz;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.qz = null;
        this.qz = new h(messageManager);
        this.qv = com.baidu.adp.framework.c.c.fb();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.qz.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.qz.removeMessage(i, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.qz.sendMessage(socketMessage, socketMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    public SocketMessage c(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.og.getController().b(socketMessage, socketMessageTask);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return this.qz.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.qz.findMessage(i, bdUniqueId);
    }

    public h getSocketClient() {
        return this.qz;
    }
}
