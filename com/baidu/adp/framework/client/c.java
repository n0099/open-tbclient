package com.baidu.adp.framework.client;

import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpProgressResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements i {
    final /* synthetic */ HttpClient.a ek;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HttpClient.a aVar) {
        this.ek = aVar;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void d(int i, int i2) {
        HttpMessageTask httpMessageTask;
        httpMessageTask = this.ek.eg;
        HttpMessageTask.a downloadTask = httpMessageTask.getDownloadTask();
        if (downloadTask != null && downloadTask.getCmd() > 0) {
            HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
            httpProgressResponsedMessage.setProgress(i / i2);
            this.ek.publishProgress(httpProgressResponsedMessage);
        }
    }
}
