package com.baidu.live.tbadk.util;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.asynctask.BdAsyncTaskParallel;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.TiebaIMConfig;
/* loaded from: classes7.dex */
public class TbSingleExecutor {
    private static final BdUniqueId TASK_UNIQUEID = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, TASK_UNIQUEID);

    public static <T> void execute(SingleRunnable<T> singleRunnable, ISingleRunnableCallback<T> iSingleRunnableCallback) {
        if (singleRunnable != null) {
            SerialAsyncTask serialAsyncTask = new SerialAsyncTask(singleRunnable, iSingleRunnableCallback);
            serialAsyncTask.setParallel(sBdAsyncTaskParallel);
            serialAsyncTask.setTag(TASK_UNIQUEID);
            serialAsyncTask.setPriority(4);
            serialAsyncTask.execute(new String[0]);
        }
    }

    public static <T> void executeIM(SingleRunnable<T> singleRunnable, ISingleRunnableCallback<T> iSingleRunnableCallback) {
        if (singleRunnable != null) {
            SerialAsyncTask serialAsyncTask = new SerialAsyncTask(singleRunnable, iSingleRunnableCallback);
            serialAsyncTask.setParallel(TiebaIMConfig.getParallel());
            serialAsyncTask.setTag(TASK_UNIQUEID);
            serialAsyncTask.setPriority(4);
            serialAsyncTask.execute(new String[0]);
        }
    }

    /* loaded from: classes7.dex */
    private static class SerialAsyncTask<T> extends BdAsyncTask<String, Object, T> {
        private ISingleRunnableCallback<T> callback;
        private SingleRunnable<T> runnable;

        public SerialAsyncTask(SingleRunnable<T> singleRunnable, ISingleRunnableCallback<T> iSingleRunnableCallback) {
            this.runnable = null;
            this.callback = null;
            this.runnable = singleRunnable;
            this.callback = iSingleRunnableCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public T doInBackground(String... strArr) {
            try {
                if (this.runnable == null) {
                    return null;
                }
                return this.runnable.doInBackground();
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(T t) {
            if (this.callback != null) {
                this.callback.onReturnDataInUI(t);
            }
        }
    }

    public static void clearQueue() {
        BdAsyncTask.removeAllTask(TASK_UNIQUEID);
    }
}
