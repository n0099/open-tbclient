package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService Zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.Zn = tiebaPrepareImageService;
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
            handler = this.Zn.mHandler;
            runnable = this.Zn.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.Zn;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.Zn;
        i = this.Zn.mRequestCode;
        uri = this.Zn.mUri;
        str = this.Zn.mFileName;
        tiebaPrepareImageService.mTask = new TiebaPrepareImageService.a(i, uri, str);
        aVar = this.Zn.mTask;
        aVar.execute(new Object[0]);
    }
}
