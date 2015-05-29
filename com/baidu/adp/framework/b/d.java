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
    private j qt;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.qt = null;
        this.qt = new j(messageManager);
        this.qq = com.baidu.adp.framework.c.c.eX();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.qt.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.qt.removeMessage(i, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.qt.sendMessage(socketMessage, socketMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    public SocketMessage c(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.od.getController().b(socketMessage, socketMessageTask);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return this.qt.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.qt.findMessage(i, bdUniqueId);
    }

    public j getSocketClient() {
        return this.qt;
    }
}
