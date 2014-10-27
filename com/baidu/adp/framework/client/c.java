package com.baidu.adp.framework.client;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
    private CustomMessage aI;
    private CustomMessageTask aJ;
    final /* synthetic */ b aK;

    public CustomMessage S() {
        return this.aI;
    }

    public c(b bVar, CustomMessage customMessage, CustomMessageTask customMessageTask) {
        this.aK = bVar;
        this.aI = null;
        this.aJ = null;
        setPriority(customMessageTask.getPriority());
        setParallel(customMessageTask.getParallel());
        setTag(customMessage.getTag());
        setKey(String.valueOf(customMessageTask.getCmd()));
        setParallel(customMessageTask.bd());
        if (customMessageTask.bc()) {
            setPriority(4);
        }
        this.aI = customMessage;
        this.aJ = customMessageTask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public CustomResponsedMessage doInBackground(String... strArr) {
        if (this.aJ == null || this.aI == null) {
            return null;
        }
        if (this.aJ.ba() == null) {
            BdLog.e("CustomTask :" + this.aJ.getClass().getName() + "did not contain a runnable!!");
            return null;
        }
        try {
            return this.aJ.ba().run(this.aI);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            customResponsedMessage.setOrginalMessage(this.aI);
            this.aK.aH.dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        BdLog.e("CustomTask :" + this.aJ.getClass().getName() + "returns a NULL!!");
    }
}
