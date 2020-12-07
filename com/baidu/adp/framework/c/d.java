package com.baidu.adp.framework.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.k;
import com.baidu.adp.framework.client.socket.g;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends c<SocketMessage, SocketMessageTask, k, SocketResponsedMessage> {
    private g Kj;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.Kj = null;
        this.Kj = new g(messageManager);
        this.Kh = com.baidu.adp.framework.d.c.lF();
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        this.Kj.removeMessage(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        this.Kj.removeMessage(i, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.Kj.a(socketMessage, socketMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.c.c
    /* renamed from: c */
    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.Jn.getController().b(socketMessage, socketMessageTask);
    }

    public LinkedList<SocketMessage> a(BdUniqueId bdUniqueId) {
        return this.Kj.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<SocketMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return this.Kj.findMessage(i, bdUniqueId);
    }

    public g getSocketClient() {
        return this.Kj;
    }
}
