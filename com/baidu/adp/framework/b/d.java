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
    private j eV;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.eV = null;
        this.eV = new j(messageManager);
        this.eS = com.baidu.adp.framework.c.c.by();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.eV.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.eV.removeMessage(i, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    /* renamed from: a */
    public void sendMessage(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.eV.sendMessage(socketMessage, socketMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    public SocketMessage c(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.cN.getController().b(socketMessage, socketMessageTask);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return this.eV.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.eV.findMessage(i, bdUniqueId);
    }

    public j getSocketClient() {
        return this.eV;
    }
}
