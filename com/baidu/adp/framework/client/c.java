package com.baidu.adp.framework.client;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
    private CustomMessage nZ;
    private CustomMessageTask oa;
    final /* synthetic */ b ob;

    public CustomMessage dQ() {
        return this.nZ;
    }

    public c(b bVar, CustomMessage customMessage, CustomMessageTask customMessageTask) {
        this.ob = bVar;
        this.nZ = null;
        this.oa = null;
        setPriority(customMessageTask.getPriority());
        setParallel(customMessageTask.getParallel());
        setTag(customMessage.getTag());
        setKey(String.valueOf(customMessageTask.getCmd()));
        setParallel(customMessageTask.eZ());
        if (customMessageTask.eY()) {
            setPriority(4);
        }
        this.nZ = customMessage;
        this.oa = customMessageTask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public CustomResponsedMessage doInBackground(String... strArr) {
        if (this.oa == null) {
            return null;
        }
        if (this.oa.eW() == null) {
            BdLog.e("CustomTask :" + this.oa.getClass().getName() + "did not contain a runnable!!");
            return null;
        }
        try {
            return this.oa.eW().run(this.nZ);
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
            customResponsedMessage.setOrginalMessage(this.nZ);
            this.ob.nY.dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        BdLog.e("CustomTask :" + this.oa.getClass().getName() + "returns a NULL!!");
    }
}
