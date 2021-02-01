package com.baidu.mobads.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3300a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ImageView f3301b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, ImageView imageView) {
        this.c = aVar;
        this.f3300a = str;
        this.f3301b = imageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r4.c.a(com.baidu.mobads.c.a.b(r4.f3300a), r4.f3301b, false);
     */
    @Override // java.util.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Observable observable, Object obj) {
        Bitmap a2;
        Handler handler;
        if (((IOAdDownloader) observable).getState() == IOAdDownloader.DownloadStatus.COMPLETED && a2 != null) {
            handler = a.f3295b;
            handler.post(new d(this, a2));
            this.c.a(this.f3300a, a2);
        }
    }
}
