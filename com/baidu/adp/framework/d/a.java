package com.baidu.adp.framework.d;

import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.message.e;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public final class a extends c<com.baidu.adp.framework.message.a<?>, CustomMessageTask, CustomRule, com.baidu.adp.framework.message.b<?>> {
    private com.baidu.adp.framework.a.b c;

    @Override // com.baidu.adp.framework.a
    public final /* bridge */ /* synthetic */ void a(e eVar, com.baidu.adp.framework.task.b bVar) {
        this.c.a((com.baidu.adp.framework.message.a) eVar, (CustomMessageTask) bVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.e, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.e' to match base method */
    @Override // com.baidu.adp.framework.d.c
    public final /* synthetic */ com.baidu.adp.framework.message.a<?> b(com.baidu.adp.framework.message.a<?> aVar, CustomMessageTask customMessageTask) {
        return this.a.b().a(aVar, customMessageTask);
    }

    public a(com.baidu.adp.framework.c cVar) {
        super(cVar);
        this.c = null;
        this.c = new com.baidu.adp.framework.a.b(cVar);
        this.b = com.baidu.adp.framework.e.a.a();
    }

    public final boolean a(int i) {
        com.baidu.adp.framework.a.b bVar = this.c;
        return com.baidu.adp.framework.a.b.a(i);
    }
}
