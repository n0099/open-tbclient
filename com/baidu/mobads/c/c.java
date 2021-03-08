package com.baidu.mobads.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2363a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, ImageView imageView) {
        this.c = aVar;
        this.f2363a = str;
        this.b = imageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r4.c.a(com.baidu.mobads.c.a.b(r4.f2363a), r4.b, false);
     */
    @Override // java.util.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Observable observable, Object obj) {
        Bitmap a2;
        Handler handler;
        if (((IOAdDownloader) observable).getState() == IOAdDownloader.DownloadStatus.COMPLETED && a2 != null) {
            handler = a.b;
            handler.post(new d(this, a2));
            this.c.a(this.f2363a, a2);
        }
    }
}
