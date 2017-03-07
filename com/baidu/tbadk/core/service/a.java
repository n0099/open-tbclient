package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService acH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.acH = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        String str;
        TiebaPrepareImageService.a aVar;
        if (TiebaPrepareImageService.IS_DECODING) {
            handler = this.acH.mHandler;
            runnable = this.acH.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.acH;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.acH;
        i = this.acH.mRequestCode;
        uri = this.acH.mUri;
        str = this.acH.mFileName;
        tiebaPrepareImageService.mTask = new TiebaPrepareImageService.a(i, uri, str);
        aVar = this.acH.mTask;
        aVar.execute(new Object[0]);
    }
}
