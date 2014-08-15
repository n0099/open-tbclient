package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        b bVar;
        if (TiebaPrepareImageService.IS_DECODING) {
            handler = this.a.mHandler;
            runnable = this.a.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.a;
        i = this.a.mRequestCode;
        uri = this.a.mUri;
        tiebaPrepareImageService.mTask = new b(tiebaPrepareImageService2, i, uri);
        bVar = this.a.mTask;
        bVar.execute(new Object[0]);
    }
}
