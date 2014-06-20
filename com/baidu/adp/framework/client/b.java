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

    public void a(int i) {
        a(0, i);
    }

    @Override // com.baidu.adp.framework.a
    public void a(int i, int i2) {
        String str = null;
        if (i != 0) {
            str = String.valueOf(i);
        }
        c.removeAllTask(i2, str);
    }

    public LinkedList<CustomMessage<?>> b(int i) {
        return b(0, i);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<CustomMessage<?>> b(int i, int i2) {
        String str = null;
        if (i != 0) {
            str = String.valueOf(i);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(i2, str);
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
