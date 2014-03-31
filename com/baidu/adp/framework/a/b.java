package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Iterator;
import java.util.LinkedList;
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
                    CustomResponsedMessage<?> a = customMessageTask.a().a(aVar);
                    if (a != null) {
                        a.a(aVar);
                    }
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

    public final LinkedList<com.baidu.adp.framework.message.a<?>> a(int i) {
        return a(c.removeAllTask(i));
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<com.baidu.adp.framework.message.a<?>> a(int i, int i2) {
        return a(c.removeAllTask(i2, String.valueOf(i)));
    }

    private static LinkedList<com.baidu.adp.framework.message.a<?>> a(LinkedList<BdAsyncTask<?, ?, ?>> linkedList) {
        com.baidu.adp.framework.message.a a;
        LinkedList<com.baidu.adp.framework.message.a<?>> linkedList2 = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = linkedList.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof c) && (a = ((c) next).a()) != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<com.baidu.adp.framework.message.a<?>> b(int i, int i2) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(i2, String.valueOf(i));
        LinkedList<com.baidu.adp.framework.message.a<?>> linkedList = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof c) {
                linkedList.add(((c) next).a());
            }
        }
        return linkedList;
    }
}
