package com.baidu.mobads.openad.b;

import android.app.Notification;
import android.app.NotificationManager;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdDownloader f3400a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3401b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, IOAdDownloader iOAdDownloader) {
        this.f3401b = bVar;
        this.f3400a = iOAdDownloader;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.mobads.command.a aVar;
        NotificationManager notificationManager;
        com.baidu.mobads.command.a aVar2;
        Notification b2;
        com.baidu.mobads.command.a aVar3;
        com.baidu.mobads.command.a aVar4;
        com.baidu.mobads.command.a aVar5;
        com.baidu.mobads.command.a aVar6;
        NotificationManager notificationManager2;
        com.baidu.mobads.command.a aVar7;
        try {
            aVar = this.f3401b.c;
            if (aVar.g == IOAdDownloader.DownloadStatus.CANCELLED) {
                notificationManager2 = b.f3398a;
                aVar7 = this.f3401b.c;
                notificationManager2.cancel(aVar7.f);
            } else {
                notificationManager = b.f3398a;
                aVar2 = this.f3401b.c;
                int i = aVar2.f;
                b2 = this.f3401b.b(this.f3400a);
                notificationManager.notify(i, b2);
                aVar3 = this.f3401b.c;
                if (aVar3.g != IOAdDownloader.DownloadStatus.ERROR) {
                    aVar4 = this.f3401b.c;
                    if (aVar4.g == IOAdDownloader.DownloadStatus.INITING) {
                        aVar5 = this.f3401b.c;
                        if (aVar5.r == 1) {
                            b bVar = this.f3401b;
                            StringBuilder append = new StringBuilder().append("开始下载 ");
                            aVar6 = this.f3401b.c;
                            bVar.d(append.append(aVar6.f3312a).toString());
                        }
                    }
                } else {
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", "status >> error");
                }
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdApkDownloaderObserver", e);
        }
    }
}
