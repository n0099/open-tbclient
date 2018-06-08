package com.baidu.ar.load.downloader;

import com.baidu.ar.task.ActionResponseListener;
/* loaded from: classes3.dex */
public class b implements ActionResponseListener<String> {
    DownloadController a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DownloadController downloadController) {
        this.a = downloadController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.task.HttpResponseListener
    /* renamed from: a */
    public void onResponse(String str) {
        try {
            this.a.c(str);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.task.HttpResponseListener
    public void onErrorResponse(String str) {
    }

    @Override // com.baidu.ar.task.ActionResponseListener
    public void onProgress(int i) {
        try {
            this.a.b(i);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.task.ActionResponseListener
    public void onUpdate(boolean z, float f) {
    }
}
