package com.baidu.adp.framework.client;

import com.baidu.adp.BdUniqueId;
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
    /* renamed from: a */
    public void sendMessage(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        if (customMessage != null && customMessageTask != null) {
            if (customMessageTask.eX() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                CustomResponsedMessage<?> customResponsedMessage = null;
                try {
                    customResponsedMessage = customMessageTask.eW().run(customMessage);
                    if (customResponsedMessage != null) {
                        customResponsedMessage.setOrginalMessage(customMessage);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                if (customResponsedMessage != null) {
                    this.nY.dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                return;
            }
            new c(this, customMessage, customMessageTask).execute(new String[0]);
        }
    }

    public <T> CustomResponsedMessage<T> a(CustomMessage customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        CustomResponsedMessage<T> customResponsedMessage = null;
        if (customMessageTask != null) {
            if (customMessageTask.eX() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                try {
                    customResponsedMessage = (CustomResponsedMessage<T>) customMessageTask.eW().run(customMessage);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                if (customResponsedMessage != null) {
                    this.nY.dispatchResponsedMessage(customResponsedMessage);
                }
            } else {
                new c(this, customMessage, customMessageTask).execute(new String[0]);
            }
        }
        return customResponsedMessage;
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        String str = null;
        if (i != 0) {
            str = String.valueOf(i);
        }
        c.removeAllTask(bdUniqueId, str);
    }

    public LinkedList<CustomMessage<?>> a(BdUniqueId bdUniqueId) {
        return findMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<CustomMessage<?>> findMessage(int i, BdUniqueId bdUniqueId) {
        String str = null;
        if (i != 0) {
            str = String.valueOf(i);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId, str);
        LinkedList<CustomMessage<?>> linkedList = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof c) {
                linkedList.add(((c) next).dQ());
            }
        }
        return linkedList;
    }
}
