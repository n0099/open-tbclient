package com.baidu.adp.framework.d;

import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class a extends c<com.baidu.adp.framework.message.a<?>, CustomMessageTask, CustomRule, com.baidu.adp.framework.message.b<?>> {
    private com.baidu.adp.framework.a.b c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.e, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.e' to match base method */
    @Override // com.baidu.adp.framework.d.c
    public /* bridge */ /* synthetic */ com.baidu.adp.framework.message.a<?> b(com.baidu.adp.framework.message.a<?> aVar, CustomMessageTask customMessageTask) {
        return b2((com.baidu.adp.framework.message.a) aVar, customMessageTask);
    }

    public a(com.baidu.adp.framework.c cVar) {
        super(cVar);
        this.c = null;
        this.c = new com.baidu.adp.framework.a.b(cVar);
        this.b = com.baidu.adp.framework.e.a.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(com.baidu.adp.framework.message.a aVar, CustomMessageTask customMessageTask) {
        this.c.a(aVar, customMessageTask);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public com.baidu.adp.framework.message.a b2(com.baidu.adp.framework.message.a aVar, CustomMessageTask customMessageTask) {
        return this.a.b().a(aVar, customMessageTask);
    }

    public boolean a(int i) {
        return this.c.a(i);
    }
}
