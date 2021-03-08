package com.baidu.mobads.openad.download;

import android.content.Context;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a implements IOAdDownloaderManager {
    private static a b = null;

    /* renamed from: a  reason: collision with root package name */
    protected Context f2440a;
    private HashMap<String, IOAdDownloader> c = new HashMap<>();

    protected a(Context context) {
        this.f2440a = context;
    }

    public static a a(Context context) {
        if (b == null) {
            b = new a(context);
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
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public IOAdDownloader createSimpleFileDownloader(URL url, String str, String str2, boolean z) {
        return new b(this.f2440a, url, str, str2, z);
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public IXAdStaticImgDownloader createImgHttpDownloader(URL url, String str, String str2) {
        return null;
    }

    @Override // com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager
    public void resumeUndownloadedAfterRestartApp(long j) {
    }
}
