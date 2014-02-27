package com.baidu.adp.framework.a;

import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public final class b extends a<com.baidu.adp.framework.message.a<?>, CustomMessageTask> {
    public b(com.baidu.adp.framework.c cVar) {
        super(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public final void a(com.baidu.adp.framework.message.a aVar, CustomMessageTask customMessageTask) {
        if (aVar != null && customMessageTask != null) {
            if (customMessageTask.c() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                try {
                    customMessageTask.a().a(aVar);
                    com.baidu.adp.framework.message.f fVar = null;
                    fVar.a(aVar);
                    this.a.a((com.baidu.adp.framework.message.f<?>) null);
                    return;
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b(e.getMessage());
                    return;
                }
            }
            new c(this, aVar, customMessageTask).execute(new String[0]);
        }
    }

    public static boolean a(int i) {
        c.removeAllTask(i);
        return true;
    }
}
