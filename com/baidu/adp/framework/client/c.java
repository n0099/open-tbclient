package com.baidu.adp.framework.client;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
    private CustomMessage cP;
    private CustomMessageTask cQ;
    final /* synthetic */ b cR;

    public CustomMessage as() {
        return this.cP;
    }

    public c(b bVar, CustomMessage customMessage, CustomMessageTask customMessageTask) {
        this.cR = bVar;
        this.cP = null;
        this.cQ = null;
        setPriority(customMessageTask.getPriority());
        setParallel(customMessageTask.getParallel());
        setTag(customMessage.getTag());
        setKey(String.valueOf(customMessageTask.getCmd()));
        setParallel(customMessageTask.bC());
        if (customMessageTask.bB()) {
            setPriority(4);
        }
        this.cP = customMessage;
        this.cQ = customMessageTask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public CustomResponsedMessage doInBackground(String... strArr) {
        if (this.cQ == null) {
            return null;
        }
        if (this.cQ.bz() == null) {
            BdLog.e("CustomTask :" + this.cQ.getClass().getName() + "did not contain a runnable!!");
            return null;
        }
        try {
            return this.cQ.bz().run(this.cP);
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
            customResponsedMessage.setOrginalMessage(this.cP);
            this.cR.cO.dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        BdLog.e("CustomTask :" + this.cQ.getClass().getName() + "returns a NULL!!");
    }
}
