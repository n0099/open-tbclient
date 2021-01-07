package com.baidu.mobads.openad.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements IOAdEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f3442a = dVar;
    }

    @Override // com.baidu.mobads.openad.interfaces.event.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        NetworkInfo activeNetworkInfo;
        com.baidu.mobads.command.a a2;
        try {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", "网络状态已经改变");
            activeNetworkInfo = ((ConnectivityManager) this.f3442a.f3441a.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e);
            com.baidu.mobads.c.a.a().a("create apk downloader failed: " + e.toString());
            return;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            int type = activeNetworkInfo.getType();
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", "当前网络名称：" + typeName + "; 网络类型：" + type);
            ArrayList<IOAdDownloader> allAdsApkDownloaderes = this.f3442a.getAllAdsApkDownloaderes();
            if (allAdsApkDownloaderes != null) {
                for (IOAdDownloader iOAdDownloader : allAdsApkDownloaderes) {
                    if (type == 1) {
                        if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.PAUSED) {
                            try {
                                iOAdDownloader.resume();
                            } catch (Exception e2) {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e2);
                            }
                        }
                    } else if (type == 0) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", "mobile net work");
                        b a3 = b.a(iOAdDownloader.getPackageName());
                        if (a3 != null && (a2 = a3.a()) != null) {
                            if (a2.s) {
                                if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR || iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.PAUSED) {
                                    try {
                                        iOAdDownloader.resume();
                                    } catch (Exception e3) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e3);
                                    }
                                }
                            } else {
                                try {
                                    iOAdDownloader.pause();
                                } catch (Exception e4) {
                                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e4);
                                }
                            }
                        }
                    }
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e);
                    com.baidu.mobads.c.a.a().a("create apk downloader failed: " + e.toString());
                    return;
                }
                return;
            }
            return;
        }
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", "没有可用网络");
    }
}
