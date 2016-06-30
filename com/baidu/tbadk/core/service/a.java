package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService UD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.UD = tiebaPrepareImageService;
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
            handler = this.UD.mHandler;
            runnable = this.UD.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.UD;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.UD;
        i = this.UD.mRequestCode;
        uri = this.UD.mUri;
        str = this.UD.mFileName;
        tiebaPrepareImageService.mTask = new TiebaPrepareImageService.a(i, uri, str);
        aVar = this.UD.mTask;
        aVar.execute(new Object[0]);
    }
}
