package com.baidu.adp.framework.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.client.socket.g;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends c<SocketMessage, SocketMessageTask, k, SocketResponsedMessage> {
    private g qd;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.qd = null;
        this.qd = new g(messageManager);
        this.pZ = com.baidu.adp.framework.c.c.du();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.qd.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.qd.removeMessage(i, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.qd.a(socketMessage, socketMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    /* renamed from: c */
    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.nC.getController().b(socketMessage, socketMessageTask);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return this.qd.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.qd.findMessage(i, bdUniqueId);
    }

    public g getSocketClient() {
        return this.qd;
    }
}
