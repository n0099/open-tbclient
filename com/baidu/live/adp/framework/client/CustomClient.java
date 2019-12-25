package com.baidu.live.adp.framework.client;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class CustomClient extends Client<CustomMessage<?>, CustomMessageTask> {
    public CustomClient(MessageManager messageManager) {
        super(messageManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.client.Client, com.baidu.live.adp.framework.IMessageProcess
    public void sendMessage(CustomMessage customMessage, CustomMessageTask customMessageTask) {
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
                    this.mMessageManager.dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                return;
            }
            new CustomAsyncTask(customMessage, customMessageTask).execute(new String[0]);
        }
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessageTask customMessageTask, Class<T> cls) {
        return runTask(null, customMessageTask, cls);
    }

    public <T> CustomResponsedMessage<T> runTask(CustomMessage customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        CustomResponsedMessage<T> customResponsedMessage = null;
        if (customMessageTask != null) {
            if (customMessageTask.getType() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                try {
                    customResponsedMessage = (CustomResponsedMessage<T>) customMessageTask.getRunnable().run(customMessage);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                if (customResponsedMessage != null) {
                    this.mMessageManager.dispatchResponsedMessage(customResponsedMessage);
                }
            } else {
                new CustomAsyncTask(customMessage, customMessageTask).execute(new String[0]);
            }
        }
        return customResponsedMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CustomAsyncTask extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
        private CustomMessageTask mMessageTask;
        private CustomMessage mRequestMsg;

        public CustomMessage getMessage() {
            return this.mRequestMsg;
        }

        public CustomAsyncTask(CustomMessage customMessage, CustomMessageTask customMessageTask) {
            this.mRequestMsg = null;
            this.mMessageTask = null;
            setPriority(customMessageTask.getPriority());
            setParallel(customMessageTask.getParallel());
            setTag(customMessage.getTag());
            setKey(String.valueOf(customMessageTask.getCmd()));
            setParallel(customMessageTask.getTaskParallel());
            if (customMessageTask.isImme()) {
                setPriority(4);
            }
            this.mRequestMsg = customMessage;
            this.mMessageTask = customMessageTask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public CustomResponsedMessage doInBackground(String... strArr) {
            if (this.mMessageTask == null) {
                return null;
            }
            if (this.mMessageTask.getRunnable() == null) {
                BdLog.e("CustomTask :" + this.mMessageTask.getClass().getName() + "did not contain a runnable!!");
                return null;
            }
            try {
                return this.mMessageTask.getRunnable().run(this.mRequestMsg);
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                customResponsedMessage.setOrginalMessage(this.mRequestMsg);
                CustomClient.this.mMessageManager.dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            BdLog.e("CustomTask :" + this.mMessageTask.getClass().getName() + "returns a NULL!!");
        }
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(BdUniqueId bdUniqueId) {
        removeMessage(0, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        String str = null;
        if (i != 0) {
            str = String.valueOf(i);
        }
        CustomAsyncTask.removeAllTask(bdUniqueId, str);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeWaitingMessage(BdUniqueId bdUniqueId) {
        removeWaitingMessage(0, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeWaitingMessage(int i, BdUniqueId bdUniqueId) {
        String str = null;
        if (i != 0) {
            str = String.valueOf(i);
        }
        CustomAsyncTask.removeAllWaitingTask(bdUniqueId, str);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<CustomMessage<?>> findMessage(BdUniqueId bdUniqueId) {
        return findMessage(0, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
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
            if (next instanceof CustomAsyncTask) {
                linkedList.add(((CustomAsyncTask) next).getMessage());
            }
        }
        return linkedList;
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public boolean haveMessage(BdUniqueId bdUniqueId) {
        return getMessageNum(bdUniqueId) > 0;
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public boolean haveMessage(int i, BdUniqueId bdUniqueId) {
        return getMessageNum(i, bdUniqueId) > 0;
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public int getMessageNum(BdUniqueId bdUniqueId) {
        return getMessageNum(0, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public int getMessageNum(int i, BdUniqueId bdUniqueId) {
        String str = null;
        if (i != 0) {
            str = String.valueOf(i);
        }
        return CustomAsyncTask.getTaskNum(str, bdUniqueId);
    }
}
