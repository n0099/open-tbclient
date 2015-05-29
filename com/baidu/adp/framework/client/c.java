package com.baidu.adp.framework.client;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
    private CustomMessage oe;
    private CustomMessageTask of;
    final /* synthetic */ b og;

    public CustomMessage dT() {
        return this.oe;
    }

    public c(b bVar, CustomMessage customMessage, CustomMessageTask customMessageTask) {
        this.og = bVar;
        this.oe = null;
        this.of = null;
        setPriority(customMessageTask.getPriority());
        setParallel(customMessageTask.getParallel());
        setTag(customMessage.getTag());
        setKey(String.valueOf(customMessageTask.getCmd()));
        setParallel(customMessageTask.fd());
        if (customMessageTask.fc()) {
            setPriority(4);
        }
        this.oe = customMessage;
        this.of = customMessageTask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public CustomResponsedMessage doInBackground(String... strArr) {
        if (this.of == null) {
            return null;
        }
        if (this.of.fa() == null) {
            BdLog.e("CustomTask :" + this.of.getClass().getName() + "did not contain a runnable!!");
            return null;
        }
        try {
            return this.of.fa().run(this.oe);
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
            customResponsedMessage.setOrginalMessage(this.oe);
            this.og.od.dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        BdLog.e("CustomTask :" + this.of.getClass().getName() + "returns a NULL!!");
    }
}
