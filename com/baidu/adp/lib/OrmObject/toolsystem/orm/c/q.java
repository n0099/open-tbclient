package com.baidu.adp.lib.OrmObject.toolsystem.orm.c;

import java.util.Queue;
/* loaded from: classes.dex */
public class q implements h {
    private Queue<Object> aga;

    public q(Queue<Object> queue) {
        this.aga = queue;
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h
    public Object g(com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar) {
        return com.baidu.adp.lib.OrmObject.toolsystem.orm.d.b.a(this.aga, cVar);
    }
}
