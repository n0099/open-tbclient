package com.baidu.mobads.openad.b;

import android.app.Notification;
import android.app.NotificationManager;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdDownloader f3438a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3439b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, IOAdDownloader iOAdDownloader) {
        this.f3439b = bVar;
        this.f3438a = iOAdDownloader;
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
            aVar = this.f3439b.c;
            if (aVar.g == IOAdDownloader.DownloadStatus.CANCELLED) {
                notificationManager2 = b.f3436a;
                aVar7 = this.f3439b.c;
                notificationManager2.cancel(aVar7.f);
            } else {
                notificationManager = b.f3436a;
                aVar2 = this.f3439b.c;
                int i = aVar2.f;
                b2 = this.f3439b.b(this.f3438a);
                notificationManager.notify(i, b2);
                aVar3 = this.f3439b.c;
                if (aVar3.g != IOAdDownloader.DownloadStatus.ERROR) {
                    aVar4 = this.f3439b.c;
                    if (aVar4.g == IOAdDownloader.DownloadStatus.INITING) {
                        aVar5 = this.f3439b.c;
                        if (aVar5.r == 1) {
                            b bVar = this.f3439b;
                            StringBuilder append = new StringBuilder().append("开始下载 ");
                            aVar6 = this.f3439b.c;
                            bVar.d(append.append(aVar6.f3350a).toString());
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
