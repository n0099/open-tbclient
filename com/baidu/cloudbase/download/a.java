package com.baidu.cloudbase.download;

import a.a.a.b.b.g;
import a.a.a.b.b.h;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.cloudbase.download.a.c;
import com.baidu.cloudbase.download.a.d;
import com.baidu.cloudbase.download.b;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes12.dex */
public class a implements d.a {
    public static a aod;
    public a.a.a.b.b aoe;
    public c aof;
    public ExecutorService mExecutorService;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public Map<String, d> mDownloaderMap = new LinkedHashMap();

    public a() {
        a(new a.a.a.b.b());
    }

    private void a(@NonNull a.a.a.b.b bVar) {
        if (bVar.b > bVar.f954a) {
            throw new IllegalArgumentException("thread num must < max thread num");
        }
        this.aoe = bVar;
        this.mExecutorService = Executors.newFixedThreadPool(this.aoe.f954a);
        this.aof = new h(this.mHandler);
    }

    private void a(b bVar, String str, com.baidu.cloudbase.download.a.a aVar, c cVar) {
        Log.d("RtcDownSo", "start down judge is downloading");
        String createKey = createKey(str);
        if (isDownloadRequestRunning(createKey)) {
            return;
        }
        Log.d("RtcDownSo", "real start down ...");
        g gVar = new g(bVar, new a.a.a.b.b.a(cVar, aVar), this.mExecutorService, createKey, this.aoe, this);
        this.mDownloaderMap.put(createKey, gVar);
        gVar.start();
    }

    private String createKey(String str) {
        if (str != null) {
            return String.valueOf(str.hashCode());
        }
        throw new IllegalArgumentException("Tag can't be null!");
    }

    private boolean isDownloadRequestRunning(String str) {
        d dVar;
        if (this.mDownloaderMap.containsKey(str) && (dVar = this.mDownloaderMap.get(str)) != null) {
            if (dVar.isRunning()) {
                com.baidu.cloudbase.download.b.c.w("DownloadInfo has been started!");
                return true;
            }
            com.baidu.cloudbase.download.b.c.w("DownloadInfo not started!");
        }
        return false;
    }

    public static a uH() {
        if (aod == null) {
            synchronized (a.class) {
                try {
                    if (aod == null) {
                        aod = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aod;
    }

    public void a(b bVar, String str, com.baidu.cloudbase.download.a.a aVar) {
        String createKey = createKey(str);
        if (isDownloadRequestRunning(createKey)) {
            return;
        }
        g gVar = new g(bVar, new a.a.a.b.b.a(this.aof, aVar), this.mExecutorService, createKey, this.aoe, this);
        this.mDownloaderMap.put(createKey, gVar);
        gVar.start();
    }

    @Override // com.baidu.cloudbase.download.a.d.a
    public void a(final String str, d dVar) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.cloudbase.download.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mDownloaderMap.containsKey(str)) {
                    a.this.mDownloaderMap.remove(str);
                }
            }
        });
    }

    public void a(String str, String str2, String str3, Looper looper, com.baidu.cloudbase.download.a.a aVar) {
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        a(new b.a().dy(str).k(new File(str2)).d(str3).uI(), str, aVar, new h(new Handler(looper)));
    }

    public void cancel(String str) {
        String createKey = createKey(str);
        if (this.mDownloaderMap.containsKey(createKey)) {
            d dVar = this.mDownloaderMap.get(createKey);
            if (dVar != null) {
                dVar.cancel();
            }
            this.mDownloaderMap.remove(createKey);
        }
    }

    public void cancelAll() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.cloudbase.download.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (d dVar : a.this.mDownloaderMap.values()) {
                    if (dVar != null && dVar.isRunning()) {
                        dVar.cancel();
                    }
                }
            }
        });
    }

    public boolean isRunning(String str) {
        d dVar;
        String createKey = createKey(str);
        if (!this.mDownloaderMap.containsKey(createKey) || (dVar = this.mDownloaderMap.get(createKey)) == null) {
            return false;
        }
        return dVar.isRunning();
    }

    public void pause(String str) {
        String createKey = createKey(str);
        if (this.mDownloaderMap.containsKey(createKey)) {
            d dVar = this.mDownloaderMap.get(createKey);
            if (dVar != null && dVar.isRunning()) {
                dVar.pause();
            }
            this.mDownloaderMap.remove(createKey);
        }
    }

    public void pauseAll() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.cloudbase.download.a.2
            @Override // java.lang.Runnable
            public void run() {
                for (d dVar : a.this.mDownloaderMap.values()) {
                    if (dVar != null && dVar.isRunning()) {
                        dVar.pause();
                    }
                }
            }
        });
    }
}
