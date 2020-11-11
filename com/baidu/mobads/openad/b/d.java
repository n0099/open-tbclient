package com.baidu.mobads.openad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class d implements IOAdDownloaderManager {
    private static d b = null;

    /* renamed from: a  reason: collision with root package name */
    protected Context f2377a;
    private com.baidu.mobads.openad.a.c d;
    private HashMap<String, IOAdDownloader> c = new HashMap<>();
    private AtomicBoolean e = new AtomicBoolean(false);

    protected d(Context context) {
        this.f2377a = context;
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public Boolean removeAdsApkDownloader(String str) {
        synchronized (this.c) {
            this.c.remove(str);
        }
        return true;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public IOAdDownloader getAdsApkDownloader(String str) {
        IOAdDownloader iOAdDownloader;
        synchronized (this.c) {
            iOAdDownloader = this.c.get(str);
        }
        return iOAdDownloader;
    }

    public void a(String str, IOAdDownloader iOAdDownloader) {
        synchronized (this.c) {
            this.c.put(str, iOAdDownloader);
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public void removeAllAdsApkDownloaderes() {
        synchronized (this.c) {
            this.c.clear();
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public ArrayList<IOAdDownloader> getAllAdsApkDownloaderes() {
        ArrayList<IOAdDownloader> arrayList = null;
        synchronized (this.c) {
            Collection<IOAdDownloader> values = this.c.values();
            if (values.size() > 0) {
                ArrayList<IOAdDownloader> arrayList2 = new ArrayList<>();
                for (IOAdDownloader iOAdDownloader : values) {
                    arrayList2.add(iOAdDownloader);
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public synchronized IOAdDownloader createAdsApkDownloader(URL url, String str, String str2, int i, String str3, String str4) {
        a aVar;
        aVar = new a(this.f2377a, url, str, str2, i, str3, str4);
        a(str4, aVar);
        try {
            if (this.d == null) {
                this.d = new com.baidu.mobads.openad.a.c(this.f2377a);
                this.d.a(new com.baidu.mobads.openad.a.b(this.d));
                this.d.addEventListener("network_changed", new e(this));
                this.d.a();
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e);
        }
        return aVar;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public IOAdDownloader createSimpleFileDownloader(URL url, String str, String str2, boolean z) {
        return new f(this.f2377a, url, str, str2, z);
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public IXAdStaticImgDownloader createImgHttpDownloader(URL url, String str, String str2) {
        return new com.baidu.mobads.d.a(this.f2377a, url, str, str2);
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public void resumeUndownloadedAfterRestartApp(long j) {
        List<String> a2;
        if (!this.e.getAndSet(true) && (a2 = com.baidu.mobads.command.a.a(this.f2377a, j)) != null && a2.size() > 0) {
            for (int i = 0; i < a2.size(); i++) {
                try {
                    String str = a2.get(i);
                    if (b.a(str) != null || getAdsApkDownloader(str) != null) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", "pack[" + str + "] has been stated before, continue");
                    } else {
                        com.baidu.mobads.command.a a3 = com.baidu.mobads.command.a.a(this.f2377a, str);
                        if (a3 == null) {
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", "pack[" + str + "] has no local data, continue");
                        } else {
                            IOAdDownloader createAdsApkDownloader = createAdsApkDownloader(new URL(a3.j), a3.c, a3.b, 1, a3.f2324a, a3.i);
                            createAdsApkDownloader.addObserver(new b(this.f2377a, a3));
                            createAdsApkDownloader.start();
                        }
                    }
                } catch (Exception e) {
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", e);
                    return;
                }
            }
        }
    }
}
