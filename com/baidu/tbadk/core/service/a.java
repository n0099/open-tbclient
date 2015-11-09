package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService XY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.XY = tiebaPrepareImageService;
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
            handler = this.XY.mHandler;
            runnable = this.XY.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.XY;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.XY;
        i = this.XY.mRequestCode;
        uri = this.XY.mUri;
        str = this.XY.mFileName;
        tiebaPrepareImageService.mTask = new TiebaPrepareImageService.a(i, uri, str);
        aVar = this.XY.mTask;
        aVar.execute(new Object[0]);
    }
}
