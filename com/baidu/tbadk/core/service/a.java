package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ TiebaPrepareImageService Gl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TiebaPrepareImageService tiebaPrepareImageService) {
        this.Gl = tiebaPrepareImageService;
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
            handler = this.Gl.mHandler;
            runnable = this.Gl.mStartRun;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.Gl;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.Gl;
        i = this.Gl.mRequestCode;
        uri = this.Gl.mUri;
        str = this.Gl.mFileName;
        tiebaPrepareImageService.mTask = new b(tiebaPrepareImageService2, i, uri, str);
        bVar = this.Gl.mTask;
        bVar.execute(new Object[0]);
    }
}
