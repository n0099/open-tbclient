package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService adb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.adb = tiebaPrepareImageService;
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
            handler = this.adb.mHandler;
            runnable = this.adb.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.adb;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.adb;
        i = this.adb.mRequestCode;
        uri = this.adb.mUri;
        str = this.adb.mFileName;
        tiebaPrepareImageService.mTask = new TiebaPrepareImageService.a(i, uri, str);
        aVar = this.adb.mTask;
        aVar.execute(new Object[0]);
    }
}
