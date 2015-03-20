package com.baidu.adp.framework.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.client.socket.j;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends c<SocketMessage, SocketMessageTask, k, SocketResponsedMessage> {
    private j qp;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.qp = null;
        this.qp = new j(messageManager);
        this.qm = com.baidu.adp.framework.c.c.eT();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.qp.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.qp.removeMessage(i, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.qp.sendMessage(socketMessage, socketMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    public SocketMessage c(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.nY.getController().b(socketMessage, socketMessageTask);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return this.qp.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.qp.findMessage(i, bdUniqueId);
    }

    public j getSocketClient() {
        return this.qp;
    }
}
