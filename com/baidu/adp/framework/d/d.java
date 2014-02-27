package com.baidu.adp.framework.d;

import com.baidu.adp.framework.controller.SocketRule;
import com.baidu.adp.framework.message.e;
import com.baidu.adp.framework.message.g;
import com.baidu.adp.framework.message.h;
/* loaded from: classes.dex */
public final class d extends c<g, com.baidu.adp.framework.task.c, SocketRule, h> {
    private com.baidu.adp.framework.a.g c;

    @Override // com.baidu.adp.framework.a
    public final /* bridge */ /* synthetic */ void a(e eVar, com.baidu.adp.framework.task.b bVar) {
        this.c.a((g) eVar, (com.baidu.adp.framework.task.c) bVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.e, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.e' to match base method */
    @Override // com.baidu.adp.framework.d.c
    public final /* synthetic */ g b(g gVar, com.baidu.adp.framework.task.c cVar) {
        return this.a.b().a(gVar, cVar);
    }

    public d(com.baidu.adp.framework.c cVar) {
        super(cVar);
        this.c = null;
        this.c = new com.baidu.adp.framework.a.g(cVar);
        this.b = com.baidu.adp.framework.e.c.a();
    }

    public final boolean a(int i) {
        return this.c.a(i);
    }
}
