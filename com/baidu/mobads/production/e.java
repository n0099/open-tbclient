package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdInstanceInfo f2456a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, IXAdInstanceInfo iXAdInstanceInfo, String str, String str2, String str3) {
        this.e = aVar;
        this.f2456a = iXAdInstanceInfo;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.CANCELLED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETE_BUT_FILE_REMOVED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.PAUSED) {
            this.e.a(this.f2456a, this.b, this.c, this.d);
        }
    }
}
