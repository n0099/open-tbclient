package com.baidu.adp.framework.client;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
    final /* synthetic */ b a;
    private CustomMessage b;
    private CustomMessageTask c;

    public CustomMessage a() {
        return this.b;
    }

    public c(b bVar, CustomMessage customMessage, CustomMessageTask customMessageTask) {
        this.a = bVar;
        this.b = null;
        this.c = null;
        setPriority(customMessageTask.getPriority());
        setTag(customMessage.getTag());
        setKey(String.valueOf(customMessageTask.getCmd()));
        if (customMessageTask.c()) {
            setPriority(4);
        }
        this.b = customMessage;
        this.c = customMessageTask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public CustomResponsedMessage doInBackground(String... strArr) {
        if (this.c == null || this.b == null) {
            return null;
        }
        if (this.c.a() == null) {
            BdLog.e("CustomTask :" + this.c.getClass().getName() + "did not contain a runnable!!");
            return null;
        }
        try {
            return this.c.a().run(this.b);
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
            customResponsedMessage.setOrginalMessage(this.b);
            this.a.a.dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        BdLog.e("CustomTask :" + this.c.getClass().getName() + "returns a NULL!!");
    }
}
