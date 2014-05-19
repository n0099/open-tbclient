package com.baidu.adp.framework.client;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b extends a<CustomMessage<?>, CustomMessageTask> {
    public b(MessageManager messageManager) {
        super(messageManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        if (customMessage != null && customMessageTask != null) {
            if (customMessageTask.b() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                try {
                    CustomResponsedMessage<?> run = customMessageTask.a().run(customMessage);
                    if (run != null) {
                        run.setOrginalMessage(customMessage);
                    }
                    if (run != null) {
                        this.a.dispatchResponsedMessage(run);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return;
                }
            }
            new c(this, customMessage, customMessageTask).execute(new String[0]);
        }
    }

    public LinkedList<CustomMessage<?>> a(int i) {
        return a(c.removeAllTask(i));
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<CustomMessage<?>> a(int i, int i2) {
        return a(c.removeAllTask(i2, String.valueOf(i)));
    }

    public LinkedList<CustomMessage<?>> a(LinkedList<BdAsyncTask<?, ?, ?>> linkedList) {
        CustomMessage a;
        LinkedList<CustomMessage<?>> linkedList2 = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = linkedList.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof c) && (a = ((c) next).a()) != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    public LinkedList<CustomMessage<?>> b(int i) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(i);
        LinkedList<CustomMessage<?>> linkedList = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof c) {
                linkedList.add(((c) next).a());
            }
        }
        return linkedList;
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<CustomMessage<?>> b(int i, int i2) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(i2, String.valueOf(i));
        LinkedList<CustomMessage<?>> linkedList = new LinkedList<>();
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
