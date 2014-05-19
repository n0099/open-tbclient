package com.baidu.adp.framework.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.n;
import com.baidu.adp.framework.client.e;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends c<SocketMessage, SocketMessageTask, n, SocketResponsedMessage> {
    private e c;

    public d(MessageManager messageManager) {
        super(messageManager);
        this.c = null;
        this.c = new e(messageManager);
        this.b = com.baidu.adp.framework.c.c.a();
    }

    public LinkedList<SocketMessage> a(int i) {
        return this.c.a(i);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> a(int i, int i2) {
        return this.c.a(i, i2);
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

    public LinkedList<SocketMessage> b(int i) {
        return this.c.b(i);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<SocketMessage> b(int i, int i2) {
        return this.c.b(i, i2);
    }

    public void a(com.baidu.adp.framework.c.d dVar) {
        this.c.a(dVar);
    }

    public void a(com.baidu.adp.lib.network.websocket.c cVar) {
        this.c.a(cVar);
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public boolean b() {
        return this.c.b();
    }

    public boolean c() {
        return this.c.c();
    }
}
