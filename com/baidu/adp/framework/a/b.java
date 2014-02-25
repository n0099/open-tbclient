package com.baidu.adp.framework.a;

import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class b extends a<com.baidu.adp.framework.message.a<?>, CustomMessageTask> {
    public b(com.baidu.adp.framework.c cVar) {
        super(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(com.baidu.adp.framework.message.a aVar, CustomMessageTask customMessageTask) {
        if (aVar != null && customMessageTask != null) {
            if (customMessageTask.c() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                try {
                    com.baidu.adp.framework.message.b<?> a = customMessageTask.a().a(aVar);
                    a.a(aVar);
                    this.a.a(a);
                    return;
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b(e.getMessage());
                    return;
                }
            }
            new c(this, aVar, customMessageTask).execute(new String[0]);
        }
    }

    public boolean a(int i) {
        c.removeAllTask(i);
        return true;
    }
}
