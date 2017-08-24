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
public class b extends com.baidu.adp.framework.client.a<CustomMessage<?>, CustomMessageTask> {
    public b(MessageManager messageManager) {
        super(messageManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        if (customMessage != null && customMessageTask != null) {
            if (customMessageTask.getType() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                CustomResponsedMessage<?> customResponsedMessage = null;
                try {
                    customResponsedMessage = customMessageTask.getRunnable().run(customMessage);
                    if (customResponsedMessage != null) {
                        customResponsedMessage.setOrginalMessage(customMessage);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                if (customResponsedMessage != null) {
                    this.pT.dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                return;
            }
            new a(customMessage, customMessageTask).execute(new String[0]);
        }
    }

    public <T> CustomResponsedMessage<T> a(CustomMessage customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        CustomResponsedMessage<T> customResponsedMessage = null;
        if (customMessageTask != null) {
            if (customMessageTask.getType() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                try {
                    customResponsedMessage = (CustomResponsedMessage<T>) customMessageTask.getRunnable().run(customMessage);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                if (customResponsedMessage != null) {
                    this.pT.dispatchResponsedMessage(customResponsedMessage);
                }
            } else {
                new a(customMessage, customMessageTask).execute(new String[0]);
            }
        }
        return customResponsedMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
        private CustomMessage pU;
        private CustomMessageTask pV;

        public CustomMessage cB() {
            return this.pU;
        }

        public a(CustomMessage customMessage, CustomMessageTask customMessageTask) {
            this.pU = null;
            this.pV = null;
            setPriority(customMessageTask.getPriority());
            setParallel(customMessageTask.getParallel());
            setTag(customMessage.getTag());
            setKey(String.valueOf(customMessageTask.getCmd()));
            setParallel(customMessageTask.getTaskParallel());
            if (customMessageTask.isImme()) {
                setPriority(4);
            }
            this.pU = customMessage;
            this.pV = customMessageTask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public CustomResponsedMessage doInBackground(String... strArr) {
            if (this.pV == null) {
                return null;
            }
            if (this.pV.getRunnable() == null) {
                BdLog.e("CustomTask :" + this.pV.getClass().getName() + "did not contain a runnable!!");
                return null;
            }
            try {
                return this.pV.getRunnable().run(this.pU);
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                customResponsedMessage.setOrginalMessage(this.pU);
                b.this.pT.dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            BdLog.e("CustomTask :" + this.pV.getClass().getName() + "returns a NULL!!");
        }
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        String str = null;
        if (i != 0) {
            str = String.valueOf(i);
        }
        a.removeAllTask(bdUniqueId, str);
    }

    public LinkedList<CustomMessage<?>> a(BdUniqueId bdUniqueId) {
        return findMessage(0, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
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
            if (next instanceof a) {
                linkedList.add(((a) next).cB());
            }
        }
        return linkedList;
    }
}
