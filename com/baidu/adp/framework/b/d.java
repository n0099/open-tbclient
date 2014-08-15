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
    private j c;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.c = null;
        this.c = new j(messageManager);
        this.b = com.baidu.adp.framework.c.c.a();
    }

    public void a(BdUniqueId bdUniqueId) {
        this.c.a(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void a(int i, BdUniqueId bdUniqueId) {
        this.c.a(i, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        this.c.a(socketMessage, socketMessageTask);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.c
    public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return this.a.getController().a(socketMessage, socketMessageTask);
    }

    public LinkedList<SocketMessage> b(BdUniqueId bdUniqueId) {
        return this.c.b(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> b(int i, BdUniqueId bdUniqueId) {
        return this.c.b(i, bdUniqueId);
    }

    public j b() {
        return this.c;
    }
}
