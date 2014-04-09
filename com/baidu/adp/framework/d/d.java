package com.baidu.adp.framework.d;

import com.baidu.adp.framework.b.n;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.message.g;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class d extends c<g, SocketMessageTask, n, SocketResponsedMessage> {
    private com.baidu.adp.framework.a.g c;

    @Override // com.baidu.adp.framework.a
    public final /* bridge */ /* synthetic */ void a(com.baidu.adp.framework.message.d dVar, com.baidu.adp.framework.task.b bVar) {
        this.c.a((g) dVar, (SocketMessageTask) bVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.d, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.d' to match base method */
    @Override // com.baidu.adp.framework.d.c
    public final /* synthetic */ g b(g gVar, SocketMessageTask socketMessageTask) {
        return this.a.b().a(gVar, socketMessageTask);
    }

    public d(com.baidu.adp.framework.c cVar) {
        super(cVar);
        this.c = null;
        this.c = new com.baidu.adp.framework.a.g(cVar);
        this.b = com.baidu.adp.framework.e.c.a();
    }

    public final LinkedList<g> a(int i) {
        return this.c.a(i);
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<g> a(int i, int i2) {
        return this.c.a(i, i2);
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<g> b(int i, int i2) {
        return this.c.b(i, i2);
    }

    public final void a(com.baidu.adp.lib.network.websocket.c cVar) {
        this.c.a(cVar);
    }

    public final void a(boolean z) {
        this.c.a(z);
    }

    public final boolean a() {
        return this.c.b();
    }
}
