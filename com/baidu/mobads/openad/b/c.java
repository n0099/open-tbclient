package com.baidu.mobads.openad.b;

import android.app.Notification;
import android.app.NotificationManager;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements Runnable {
    final /* synthetic */ IOAdDownloader a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, IOAdDownloader iOAdDownloader) {
        this.b = bVar;
        this.a = iOAdDownloader;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.mobads.command.a aVar;
        NotificationManager notificationManager;
        com.baidu.mobads.command.a aVar2;
        Notification b;
        com.baidu.mobads.command.a aVar3;
        com.baidu.mobads.command.a aVar4;
        com.baidu.mobads.command.a aVar5;
        com.baidu.mobads.command.a aVar6;
        NotificationManager notificationManager2;
        com.baidu.mobads.command.a aVar7;
        try {
            aVar = this.b.c;
            if (aVar.g == IOAdDownloader.DownloadStatus.CANCELLED) {
                notificationManager2 = b.a;
                aVar7 = this.b.c;
                notificationManager2.cancel(aVar7.f);
            } else {
                notificationManager = b.a;
                aVar2 = this.b.c;
                int i = aVar2.f;
                b = this.b.b(this.a);
                notificationManager.notify(i, b);
                aVar3 = this.b.c;
                if (aVar3.g != IOAdDownloader.DownloadStatus.ERROR) {
                    aVar4 = this.b.c;
                    if (aVar4.g == IOAdDownloader.DownloadStatus.INITING) {
                        aVar5 = this.b.c;
                        if (aVar5.r == 1) {
                            b bVar = this.b;
                            StringBuilder append = new StringBuilder().append("开始下载 ");
                            aVar6 = this.b.c;
                            bVar.d(append.append(aVar6.a).toString());
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
