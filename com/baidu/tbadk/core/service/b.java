package com.baidu.tbadk.core.service;

import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
final class b implements Runnable {
    final /* synthetic */ TiebaPrepareImageService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(TiebaPrepareImageService tiebaPrepareImageService) {
        this.a = tiebaPrepareImageService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Runnable runnable;
        int i;
        Uri uri;
        c cVar;
        if (TiebaPrepareImageService.a) {
            handler = this.a.e;
            runnable = this.a.h;
            handler.postDelayed(runnable, 1000L);
            return;
        }
        TiebaPrepareImageService tiebaPrepareImageService = this.a;
        TiebaPrepareImageService tiebaPrepareImageService2 = this.a;
        i = this.a.b;
        uri = this.a.c;
        tiebaPrepareImageService.d = new c(tiebaPrepareImageService2, i, uri);
        cVar = this.a.d;
        cVar.execute(new Object[0]);
    }
}
