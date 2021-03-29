package com.baidu.mobads.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes2.dex */
public class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8176a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f8177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f8178c;

    public c(a aVar, String str, ImageView imageView) {
        this.f8178c = aVar;
        this.f8176a = str;
        this.f8177b = imageView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        r3 = r2.f8178c.a(com.baidu.mobads.c.a.b(r2.f8176a), r2.f8177b, false);
     */
    @Override // java.util.Observer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Observable observable, Object obj) {
        Bitmap a2;
        Handler handler;
        if (((IOAdDownloader) observable).getState() != IOAdDownloader.DownloadStatus.COMPLETED || a2 == null) {
            return;
        }
        handler = a.f8170b;
        handler.post(new d(this, a2));
        this.f8178c.a(this.f8176a, a2);
    }
}
