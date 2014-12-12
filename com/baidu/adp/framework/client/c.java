package com.baidu.adp.framework.client;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
    private CustomMessage cO;
    private CustomMessageTask cP;
    final /* synthetic */ b cQ;

    public CustomMessage as() {
        return this.cO;
    }

    public c(b bVar, CustomMessage customMessage, CustomMessageTask customMessageTask) {
        this.cQ = bVar;
        this.cO = null;
        this.cP = null;
        setPriority(customMessageTask.getPriority());
        setParallel(customMessageTask.getParallel());
        setTag(customMessage.getTag());
        setKey(String.valueOf(customMessageTask.getCmd()));
        setParallel(customMessageTask.bE());
        if (customMessageTask.bD()) {
            setPriority(4);
        }
        this.cO = customMessage;
        this.cP = customMessageTask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public CustomResponsedMessage doInBackground(String... strArr) {
        if (this.cP == null) {
            return null;
        }
        if (this.cP.bB() == null) {
            BdLog.e("CustomTask :" + this.cP.getClass().getName() + "did not contain a runnable!!");
            return null;
        }
        try {
            return this.cP.bB().run(this.cO);
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
            customResponsedMessage.setOrginalMessage(this.cO);
            this.cQ.cN.dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        BdLog.e("CustomTask :" + this.cP.getClass().getName() + "returns a NULL!!");
    }
}
