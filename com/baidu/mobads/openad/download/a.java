package com.baidu.mobads.openad.download;

import android.content.Context;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a implements IOAdDownloaderManager {

    /* renamed from: b  reason: collision with root package name */
    public static a f8418b;

    /* renamed from: a  reason: collision with root package name */
    public Context f8419a;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, IOAdDownloader> f8420c = new HashMap<>();

    public a(Context context) {
        this.f8419a = context;
    }

    public static a a(Context context) {
        if (f8418b == null) {
            f8418b = new a(context);
        }
        return f8418b;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public synchronized IOAdDownloader createAdsApkDownloader(URL url, String str, String str2, int i, String str3, String str4) {
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public IXAdStaticImgDownloader createImgHttpDownloader(URL url, String str, String str2) {
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public IOAdDownloader createSimpleFileDownloader(URL url, String str, String str2, boolean z) {
        return new b(this.f8419a, url, str, str2, z);
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public IOAdDownloader getAdsApkDownloader(String str) {
        IOAdDownloader iOAdDownloader;
        synchronized (this.f8420c) {
            iOAdDownloader = this.f8420c.get(str);
        }
        return iOAdDownloader;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public ArrayList<IOAdDownloader> getAllAdsApkDownloaderes() {
        ArrayList<IOAdDownloader> arrayList;
        synchronized (this.f8420c) {
            Collection<IOAdDownloader> values = this.f8420c.values();
            if (values.size() > 0) {
                arrayList = new ArrayList<>();
                for (IOAdDownloader iOAdDownloader : values) {
                    arrayList.add(iOAdDownloader);
                }
            } else {
                arrayList = null;
            }
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public Boolean removeAdsApkDownloader(String str) {
        synchronized (this.f8420c) {
            this.f8420c.remove(str);
        }
        return Boolean.TRUE;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public void removeAllAdsApkDownloaderes() {
        synchronized (this.f8420c) {
            this.f8420c.clear();
        }
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public void resumeUndownloadedAfterRestartApp(long j) {
    }
}
