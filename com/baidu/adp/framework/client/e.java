package com.baidu.adp.framework.client;

import com.baidu.adp.framework.message.HttpProgressResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.network.http.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements h {
    final /* synthetic */ d oo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.oo = dVar;
    }

    @Override // com.baidu.adp.lib.network.http.h
    public void onProgress(int i, int i2) {
        HttpMessageTask httpMessageTask;
        httpMessageTask = this.oo.oi;
        com.baidu.adp.framework.task.a downloadTask = httpMessageTask.getDownloadTask();
        if (downloadTask != null && downloadTask.getCmd() > 0) {
            HttpProgressResponsedMessage httpProgressResponsedMessage = new HttpProgressResponsedMessage(downloadTask.getCmd());
            httpProgressResponsedMessage.setProgress(i / i2);
            this.oo.publishProgress(httpProgressResponsedMessage);
        }
    }
}
