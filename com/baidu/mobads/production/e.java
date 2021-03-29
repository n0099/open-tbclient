package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes2.dex */
public class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdInstanceInfo f8460a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8461b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8462c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f8463d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f8464e;

    public e(a aVar, IXAdInstanceInfo iXAdInstanceInfo, String str, String str2, String str3) {
        this.f8464e = aVar;
        this.f8460a = iXAdInstanceInfo;
        this.f8461b = str;
        this.f8462c = str2;
        this.f8463d = str3;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IOAdDownloader iOAdDownloader = (IOAdDownloader) observable;
        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.CANCELLED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETE_BUT_FILE_REMOVED || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.PAUSED) {
            this.f8464e.a(this.f8460a, this.f8461b, this.f8462c, this.f8463d);
        }
    }
}
