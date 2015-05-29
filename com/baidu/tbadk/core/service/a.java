package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService SX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.SX = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        String str;
        b bVar;
        if (TiebaPrepareImageService.IS_DECODING) {
            handler = this.SX.mHandler;
            runnable = this.SX.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.SX;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.SX;
        i = this.SX.mRequestCode;
        uri = this.SX.mUri;
        str = this.SX.mFileName;
        tiebaPrepareImageService.mTask = new b(tiebaPrepareImageService2, i, uri, str);
        bVar = this.SX.mTask;
        bVar.execute(new Object[0]);
    }
}
