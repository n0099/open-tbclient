package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService Go;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.Go = tiebaPrepareImageService;
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
            handler = this.Go.mHandler;
            runnable = this.Go.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.Go;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.Go;
        i = this.Go.mRequestCode;
        uri = this.Go.mUri;
        str = this.Go.mFileName;
        tiebaPrepareImageService.mTask = new b(tiebaPrepareImageService2, i, uri, str);
        bVar = this.Go.mTask;
        bVar.execute(new Object[0]);
    }
}
