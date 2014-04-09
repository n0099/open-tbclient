package com.baidu.adp.framework.d;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class a extends c<com.baidu.adp.framework.message.a<?>, CustomMessageTask, com.baidu.adp.framework.b.c, CustomResponsedMessage<?>> {
    private com.baidu.adp.framework.a.b c;

    @Override // com.baidu.adp.framework.a
    public final /* bridge */ /* synthetic */ void a(com.baidu.adp.framework.message.d dVar, com.baidu.adp.framework.task.b bVar) {
        this.c.a((com.baidu.adp.framework.message.a) dVar, (CustomMessageTask) bVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.d, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.d' to match base method */
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

    public final LinkedList<com.baidu.adp.framework.message.a<?>> a(int i) {
        return this.c.a(i);
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<com.baidu.adp.framework.message.a<?>> a(int i, int i2) {
        return this.c.a(i, i2);
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<com.baidu.adp.framework.message.a<?>> b(int i, int i2) {
        return this.c.b(i, i2);
    }
}
