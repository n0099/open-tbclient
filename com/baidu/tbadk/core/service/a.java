package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService Sl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.Sl = tiebaPrepareImageService;
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
            handler = this.Sl.mHandler;
            runnable = this.Sl.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.Sl;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.Sl;
        i = this.Sl.mRequestCode;
        uri = this.Sl.mUri;
        str = this.Sl.mFileName;
        tiebaPrepareImageService.mTask = new b(tiebaPrepareImageService2, i, uri, str);
        bVar = this.Sl.mTask;
        bVar.execute(new Object[0]);
    }
}
