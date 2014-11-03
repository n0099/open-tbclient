package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService Ca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.Ca = tiebaPrepareImageService;
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
            handler = this.Ca.mHandler;
            runnable = this.Ca.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.Ca;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.Ca;
        i = this.Ca.mRequestCode;
        uri = this.Ca.mUri;
        str = this.Ca.mFileName;
        tiebaPrepareImageService.mTask = new b(tiebaPrepareImageService2, i, uri, str);
        bVar = this.Ca.mTask;
        bVar.execute(new Object[0]);
    }
}
