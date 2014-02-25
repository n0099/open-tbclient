package com.baidu.adp.framework.d;

import com.baidu.adp.framework.controller.SocketRule;
import com.baidu.adp.framework.message.g;
import com.baidu.adp.framework.message.h;
/* loaded from: classes.dex */
public class d extends c<g, com.baidu.adp.framework.task.c, SocketRule, h> {
    private com.baidu.adp.framework.a.g c;

    public d(com.baidu.adp.framework.c cVar) {
        super(cVar);
        this.c = null;
        this.c = new com.baidu.adp.framework.a.g(cVar);
        this.b = com.baidu.adp.framework.e.c.a();
    }

    public boolean a(int i) {
        return this.c.a(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(g gVar, com.baidu.adp.framework.task.c cVar) {
        this.c.a(gVar, cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.d.c
    public g b(g gVar, com.baidu.adp.framework.task.c cVar) {
        return this.a.b().a(gVar, cVar);
    }
}
