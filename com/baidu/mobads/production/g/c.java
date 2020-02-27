package com.baidu.mobads.production.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class c implements Observer {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Context context;
        String str;
        String str2;
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED) {
            Log.e("XAbstractAdProdTemplate", "download complete");
            if (Looper.myLooper() != Looper.getMainLooper()) {
                context = this.a.y;
                new Handler(context.getMainLooper()).post(new d(this));
                return;
            }
            a aVar = this.a;
            StringBuilder sb = new StringBuilder();
            str = this.a.A;
            StringBuilder append = sb.append(str);
            str2 = this.a.B;
            aVar.f(append.append(str2).toString());
        } else if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR) {
            Log.e("XAbstractAdProdTemplate", "download error");
            this.a.a("开屏因为3d背景图片下载失败跳过");
        }
    }
}
