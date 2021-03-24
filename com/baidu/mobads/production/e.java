package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes2.dex */
public class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdInstanceInfo f8459a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8460b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8461c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f8462d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f8463e;

    public e(a aVar, IXAdInstanceInfo iXAdInstanceInfo, String str, String str2, String str3) {
        this.f8463e = aVar;
        this.f8459a = iXAdInstanceInfo;
        this.f8460b = str;
        this.f8461c = str2;
        this.f8462d = str3;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.CANCELLED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETE_BUT_FILE_REMOVED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.PAUSED) {
            this.f8463e.a(this.f8459a, this.f8460b, this.f8461c, this.f8462d);
        }
    }
}
